package com.rc.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;

public class BufferReaderJDBC {
	public static void main(String[] args) throws Exception{
		//set up connection
		Connection connection = MyConnection.myConnection();
		Statement statement = connection.createStatement();
		//bufferedReader takes the large chunk of characters and and stores them
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//take user input
		while(true)
		{
			System.out.println("enter the vehicle brand");
			String brand = br.readLine();
			System.out.println("enter the vehicle modle");
			int modle = Integer.parseInt(br.readLine());
			System.out.println("enter the vehicle price");
			double price = Double.parseDouble(br.readLine());
			//execute update method for enter the data into database
			statement.executeUpdate("insert into vehicle values('" + brand+ "',"+modle+","+price+")");
			System.out.println("vehicle details updated succefully");
			System.out.println("one more row needs to update? [YES?NO]");
			String s = br.readLine();
			if(s.equalsIgnoreCase("no"))
			{
				System.out.println("updated the entered rows");
				break;
			}
		}
		connection.close();
		
		
		
	}

}
