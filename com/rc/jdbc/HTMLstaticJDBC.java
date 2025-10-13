package com.rc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.FileOutputStream;

public class HTMLstaticJDBC {
		public static void main(String[] args) {
			String username = "scott";
			String password = "tiger";
			String url ="jdbc:oracle:thin:@localhost:1521/orcl";
			String query = "select * from vehicle";
			
			try {
				Connection connection = DriverManager.getConnection(url ,username , password);
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(query);
				
				String data = "<table><tr>" + "<th>Brand</th>" + "<th>Model</th>" + "<th>Price</th>" + "</tr>";
				
				while(result.next())
				{
					data = data+ "<tr><td>" + result.getString(1) + "</td><td>" + result.getInt(2) + "</td><td>"+ result.getDouble(3) + "</td></tr>";
				}
				data = data + "</table>";
				data = "<html><body><h2> Employee details </h2>"+data+"</body></html>";
				
				FileOutputStream fout = new FileOutputStream("employee.html");
				fout.write(data.getBytes());
				fout.flush();
				fout.close();
				
				statement.close();
				connection.close();
				}catch(Exception e)
			        {
					e.printStackTrace();
					}
			}
		}

	


