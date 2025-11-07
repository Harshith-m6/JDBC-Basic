package com.rc.jdbc;
import java.sql.*;
public class PreparedStatement2 {
	public static void main(String[] args) {
		try(Connection conn = MyConnection.myConnection() ; PreparedStatement ps = conn.prepareStatement("insert into stu values(?,?,?)")){
			ps.setString(1,"Pavan" );
			ps.setInt(2, 20);
			ps.setString(3, "banglore");
			ps.execute();
			int n =ps.getUpdateCount();
			
			System.out.println("Number of rows inserted :"+n);
			
		}catch(SQLException e)
		{
			
		}
	}
}
