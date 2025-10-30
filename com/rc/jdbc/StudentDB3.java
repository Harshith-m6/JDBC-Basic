package com.rc.jdbc;
import java.sql.*;

public class StudentDB3 {
	public static void main(String[] args) {
		 String url = "jdbc:mysql://localhost:3306/demo";
		 String user = "root";
		 String pass = "Harshithm@6";
		 String sql = "insert into demo.students values(?,?,?)";
		 Connection conn = null;
		 PreparedStatement ps = null;
		 
		 
		 try {
			 conn = DriverManager.getConnection(url,user,pass);
			  ps = conn.prepareStatement(sql);
			 ps.setInt(1, 4);
			 ps.setString(2, "pavan");
			 ps.setInt(3, 99);
			 ps.addBatch();
			 
			 ps.executeBatch();
			 
			 System.out.println("entered the record");
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }finally {
			
			 try {
				 ps.close();
				 conn.close();
				 
			 }catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 
		 }
	}

}
