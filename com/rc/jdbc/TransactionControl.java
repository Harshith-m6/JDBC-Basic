package com.rc.jdbc;

import java.sql.DriverManager;
import java.sql.*;

public class TransactionControl {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String pass = "Harshithm@6";
		Connection con = null;
		Statement st = null;
		try {

			con = DriverManager.getConnection(url,user,pass);
			st = con.createStatement();
			con.setAutoCommit(false);
			st.executeUpdate("insert into demo.student values(1,'Harshith')");
			st.executeUpdate("insert into demo.student values(2,'pavan')");
			
			con.commit();
			System.out.println("Transaction successfull");
			
		}catch(Exception e)
		{
			try {
				if(con!=null)
				{
					con.rollback();
					System.out.println("transaction rollback due to "+e.getMessage());
				}
			}catch(SQLException s)
			{
				s.printStackTrace();
			}
		}finally {
			try {
				st.close();
				con.close();
			}catch(SQLException q)
			{
				q.printStackTrace();
			}
		}
		
		
	}

}
