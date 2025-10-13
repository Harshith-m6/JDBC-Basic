package com.rc.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDQL {
	public static void main(String[] args) {
		String selectQuery = "select * from vehicle";
		Connection connection = MyConnection.myConnection();
		try(Statement statement = connection.createStatement(); )
		{
			ResultSet result = statement.executeQuery(selectQuery);
			while(result.next())
			{
				System.out.println("brand :"+result.getString(1)+" model :"+result.getString(2)+" price :"+result.getString(3));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
