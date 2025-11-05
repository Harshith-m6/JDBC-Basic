package com.rc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeConnection {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/orcl";
	private static final String USER = "scott";
	private static final String password = "tiger";
	
	public static Connection getConnection()
	{
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(URL , USER , password);
			
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
	}


}
