package com.rc.jdbc;
import java.sql.*;

public class ResultSetForExecute {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String pass = "Harshithm@6";
		String sql = "select * from demo.students";
		
		try(Connection conn = DriverManager.getConnection(url,user,pass); Statement st = conn.createStatement();)
		{
			boolean rs = st.execute(sql);
			while()
		}catch(SQLException e)
		{
			
		}
	}

}
