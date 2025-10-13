package com.rc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {

	public static Connection myConnection()
	{
		String username = "scott";
		String password ="tiger";
		String url ="jdbc:oracle:thin:@localhost:1521/orcl";

		try {
			Connection connection = DriverManager.getConnection(url , username , password);
			return connection;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}

}
