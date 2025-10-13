package com.rc.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCDML {
	public static void main(String[] args) {
		String insertQuery = "insert into Vehicle values('suzuki',1991,10000.00)";
		Connection connection = MyConnection.myConnection();
		try(Statement statement = connection.createStatement();)
		{
			int result = statement.executeUpdate(insertQuery);
			if(result>0)
			{
				System.out.println("number of rows affected is "+result);
			}else {
				System.out.println("no update done");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
