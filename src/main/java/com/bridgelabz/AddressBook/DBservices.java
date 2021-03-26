package com.bridgelabz.AddressBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBservices 
{
	 Connection connect;
	
	public void readData() throws ClassNotFoundException, SQLException 
	{
		connect = DBconnection.connect();
		Statement statement = connect.createStatement();
		
		ResultSet result = statement.executeQuery("SELECT * FROM emp_payroll");
		
		while (result.next())
		   {
			   System.out.println("First Name: " + result.getString("first_name"));
		       System.out.println("Last Name: " + result.getString("last_name"));
		       System.out.println("Address: " + result.getString("address"));
		       System.out.println("State: " + result.getString("state"));
		       System.out.println("City: " + result.getString("city"));
		       System.out.println("zip: " + result.getString("zip"));
		       System.out.println("phone: " + result.getString("phone"));
		       System.out.println("email: " + result.getString("email"));
		   }
		
		connect.close();
		System.exit(1);
	}
	
	public void writeData() throws ClassNotFoundException, SQLException, IOException
	{
		PreparedStatement output;
		int rows = 0;
		
		boolean response = true;
		
		connect = DBconnection.connect();
		
		output = connect.prepareStatement("insert into emp_payroll"
				+ "(first_name,"
				+ "last_name,"
				+ "address,"
				+ "state,"
				+ "city,"
				+ "zip"
				+ ",phone"
				+ ",email)"
		 		+ "value(?,?,?,?,?,?,?,?)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (response != false)
		{
			   System.out.println("enter the first name");
			   String fs= br.readLine();
			   output.setString(1, fs);
			   
			   System.out.println("enter the last name ");
			   String ls =br.readLine();
			   output.setString(2, ls);
			   
			   System.out.println("enter the address ");
			   String add =br.readLine();
			   output.setString(3, add);
			   
			   System.out.println("enter the state");
			   String state= br.readLine();
			   output.setString(4, state);
			   
			   System.out.println("enter the city");
			   String city = br.readLine();
			   output.setString(5, city);
			   
			   System.out.println("enter zip");
			   String zip=br.readLine();
			   output.setString(6, zip);
			   
			   System.out.println("enter phone");
			   String phone= br.readLine();
			   output.setString(7, phone);
			   
			   System.out.println("enter email ");
			   String email= br.readLine();
			   output.setString(8, email);
			  
			   rows = output.executeUpdate();
			   
			   System.out.println();
			   System.out.println(rows+ "  rows affected\n");
			   
			   System.out.println("Press 1 to add more or -1 to exit");
			   Scanner sc = new Scanner(System.in);
			   int redo = sc.nextInt();
			   if (redo == -1)
			   {
				   response = false; 
			   }
		}  
		connect.close();
	}
	
	public void deleteData() throws ClassNotFoundException, SQLException, IOException
	{
		PreparedStatement output;
		int rows = 0;
		
		connect = DBconnection.connect();
		System.out.println("Input First Name of Person");
		
		output = connect.prepareStatement("DELETE from emp_payroll where first_name=?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String fs = br.readLine();
		output.setString(1, fs);
		
		rows = output.executeUpdate();
		   
	    System.out.println();
	    System.out.println(rows+ "  rows affected\n");
	

		connect.close();
		
	}
	
	public void editData() throws ClassNotFoundException, SQLException, IOException
	{
		PreparedStatement output;
		int rows = 0;
		
		connect = DBconnection.connect();
		System.out.println("Updating ZIP-CODE of Person\n");
		
		output = connect.prepareStatement("UPDATE emp_payroll SET zip=? where first_name=?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the New ZIP-CODE\n");
		
		String zip = br.readLine();
		output.setString(1, zip);
		
		System.out.println("Enter the First Name whose zip code is needed to be updated to this\n"); 
		
		String fs = br.readLine();
		output.setString(2, fs);
		
		rows = output.executeUpdate();
		   
	    System.out.println();
	    System.out.println(rows+ "  rows affected\n");
	

		connect.close();
		
	}
}
