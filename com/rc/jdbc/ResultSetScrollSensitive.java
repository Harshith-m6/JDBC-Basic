package com.rc.jdbc;
import java.sql.*;
import java.util.*;

public class ResultSetScrollSensitive {
	public static void main(String[] args) throws SQLException {
		Connection con = MyConnection.myConnection();
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		int count = st.executeUpdate("insert into stu values('abhi',12,'dbpur')");
		
		ResultSet rs = st.executeQuery("select * from stu");
		
		while(rs.next())
		{
			System.out.println(rs.getInt("age")+"|"+
					rs.getString("name")+"|"+
					rs.getString("address")+"|");
		}
		
	}

}
