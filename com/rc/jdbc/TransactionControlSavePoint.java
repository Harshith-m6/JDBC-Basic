package com.rc.jdbc;
import java.sql.*;
public class TransactionControlSavePoint {
	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String pass = "Harshithm@6";
		
		Savepoint s2 = null;
		Savepoint s1 = null;
		Savepoint s3 = null;
		Connection conn = null;
		Statement st = null;
		try {
			conn = DriverManager.getConnection(url,user,pass);
			st = conn.createStatement();
			st.executeUpdate("insert into demo.student values(14 , 'newton')");
			s1 = conn.setSavepoint("Afternewton");
			st.executeUpdate("insert into demo.student values(15,'bezoz')");
			s2 = conn.setSavepoint("Afterbezoz");
			st.executeUpdate("insert into demo.student values(16,'mark')");
			s3 = conn.setSavepoint("Aftermark");
			st.executeUpdate("insert into demo.students values(17,'pichai')");
			
			conn.commit();
			
		}catch(SQLException e)
		{
			try {
				System.out.println("error "+e.getMessage());
				conn.rollback(s1);
			}catch(SQLException s)
			{
				s.printStackTrace();
			}
		}
	}

}
