package com.rc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDDL {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost/orcl";
		String username = "scott";
		String password = "tiger";
		String ddlQuery = "create table Vehicle(brand varchar(20) , model integer primary key , price number)";
		try(Connection connection = DriverManager.getConnection(url , username , password) ; Statement statement = connection.createStatement())
		{
			boolean result = statement.execute(ddlQuery);
			if(result==false)
			{
				System.out.println("Table created");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
				
		
	}

}
