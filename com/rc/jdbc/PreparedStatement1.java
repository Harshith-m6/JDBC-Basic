package com.rc.jdbc;
import java.sql.*;
public class PreparedStatement1 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = MyConnection.myConnection();
			pst = conn.prepareStatement("insert into stu values(?,?,?)");
			pst.setString(1,"Harshith" );
			pst.setInt(2,22);
			pst.setString(3,"Banglore");
			int rs =pst.executeUpdate();
			
			System.out.println("number of rows updated "+rs);
			
		}catch(SQLException ex) {
			ex.getMessage();
		}
			
		
	}

}
