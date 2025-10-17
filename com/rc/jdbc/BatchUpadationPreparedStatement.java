package com.rc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchUpadationPreparedStatement {
	public static void main(String[] args) throws Exception {
		Connection connection = MyConnection.myConnection();
		PreparedStatement ps = connection.prepareStatement(("insert into emps values(?,?,?,?)"));
		
		ps.setInt(1, 102);
		ps.setString(2, "Pavan");
		ps.setInt(3, 200000);
		ps.setString(4, "manglore");
		ps.addBatch();
		
		ps.setInt(1, 101);
		ps.setString(2, "Harshith");
		ps.setInt(3, 100000);
		ps.setString(4, "banglore");
		ps.addBatch();
		
		ps.setInt(1, 103);
		ps.setString(2, "aadi");
		ps.setInt(3, 50000);
		ps.setString(4, "mysore");
		ps.addBatch();
		
		int[] rowCounts = ps.executeBatch();
		for(int i =0 ; i<rowCounts.length ; i++)
		{
			System.out.println(" records manipulated : "+rowCounts[i]);
		}
		connection.close();
	}

}
