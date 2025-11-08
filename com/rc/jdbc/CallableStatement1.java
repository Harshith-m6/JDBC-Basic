package com.rc.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatement1 {
	
	public static void main(String[] args) {
		try(Connection con = MyConnection.myConnection() ; CallableStatement cs = con.prepareCall("{call getStu}"))
		{
			ResultSet rs = cs.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString("name")+
				rs.getInt("age")+
				rs.getString("address"));
			}
			
			
		}catch(SQLException e)
		{
			e.getMessage();
		}
	}

}
