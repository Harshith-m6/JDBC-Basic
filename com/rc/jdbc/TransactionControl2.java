package com.rc.jdbc;
import java.sql.*;

public class TransactionControl2 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String pass = "Harshithm@6";
		Connection conn = null;
		Statement st = null;
		try {
			conn = DriverManager.getConnection(url, user , pass);
			st = conn.createStatement();
			conn.setAutoCommit(false);
			
			st.executeUpdate("insert into demo.student(id , name) values(9,'abhi');");
			st.executeUpdate("insert into demo.student(no , name) values(8,'abhi');");
			
			conn.commit();
		}catch(SQLException e)
		{
			System.out.println("error transcation not commited"+e.getMessage());
			try(Connection con2 = DriverManager.getConnection(url,user,pass))
			{
				con2.rollback();
				System.out.println("transaction rollback successfully");
			}catch(SQLException r)
			{
				r.getMessage();
			}
		}
		
	}

}
