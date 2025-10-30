package com.rc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentDB2 {
	public static void main(String[] args) {
	String url = "jdbc:mysql://localhost:3306/demo";
	String name = "root";
	String pass = "Harshithm@6";
	String sql =  "insert into demo.students values(101 ,'Harshith' , 100)";
	
	try {
		Connection con = DriverManager.getConnection(url,name,pass);
		Statement st = con.createStatement();
		st.executeUpdate(sql);
		System.out.println("values inserted sucessfully");
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	}
}
