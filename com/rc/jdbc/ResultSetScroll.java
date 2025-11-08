package com.rc.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class ResultSetScroll {
	public static void main(String[] args) throws SQLException {
		
		Connection conn = MyConnection.myConnection();
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		boolean  rs =st.execute("select * from stu");
		
		ResultSet rt =st.getResultSet();
		while(rt.next())
		{
			
			
			System.out.println(rt.getInt("age")+"|"+
					rt.getString("name")+"|"+
					rt.getString("address")+"|");
		}
		
		
		
		
		
	}

}
