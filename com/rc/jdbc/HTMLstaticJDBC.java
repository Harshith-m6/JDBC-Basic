package com.rc.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.io.FileOutputStream;

public class HTMLstaticJDBC {
	public static void main(String[] args) {
		try(Connection connection = MyConnection.myConnection();
				Statement statement = connection.createStatement();){
			
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
