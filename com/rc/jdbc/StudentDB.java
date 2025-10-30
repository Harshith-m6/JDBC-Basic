package com.rc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDB {
	public static void main(String[] args) throws Exception{
		 final String JDBC_URL = "jdbc:mysql://localhost:3306/demo";
		 final String USER = "root";
		 final String PASS = "Harshithm@6";
		 String sql = "select * from students";
		 
		 Connection conn = DriverManager.getConnection(JDBC_URL,USER,PASS);
		 Statement st = conn.createStatement();
		 ResultSet rs = st.executeQuery(sql);
		 while(rs.next())
		 {
			 System.out.println("id :"+rs.getInt(1));
			 System.out.println("name : "+rs.getString(2));
			 System.out.println("grade :"+rs.getInt(3));
		 }
		 System.out.println("data retreived");

	}

}
