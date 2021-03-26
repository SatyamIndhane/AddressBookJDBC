package com.bridgelabz.AddressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBconnection 
{
	static Connection conn;
	
    public static Connection connect() throws ClassNotFoundException
    {  	
    try
    	{
			// db parameters
		   String jdbc_url = "jdbc:mysql://localhost:3306/emp_payroll";
		   String user = "root";
		   String password = "root";
		   
		   // load Drivers
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   System.out.println("Loaded");
		   
		   // creating connection
		   conn = DriverManager.getConnection(jdbc_url, user, password);
		   System.out.println("Connected");
		   
    	}
    catch(SQLException e) 
    	{
    		e.printStackTrace();
    	}
    return conn;	
    }
    
}
