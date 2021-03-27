package com.bridgelabz.AddressBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBconnection 
{
	static Connection conn;
	static PropertiesDB p = new PropertiesDB();
	
    public static Connection connect() throws ClassNotFoundException
    {  	
    try
    	{
			// db parameters
		   String jdbc_url = p.jdbc_url;
		   String user = p.user;
		   String password = p.password;
		   
		   // load Drivers
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   System.out.println("Loaded");
		   
		   // creating connection
		   conn = DriverManager.getConnection(jdbc_url, user, password);
		   System.out.println("Connected");
		   
    	}
    catch(ClassNotFoundException | SQLException e) 
    	{
    		e.printStackTrace();
    	}
    return conn;	
    }
    
}
