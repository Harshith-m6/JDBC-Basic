package com.rc.jdbc;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class BlobJdbc {
	public static void main(String[] args) {
		Connection conn = null;
		String sql = "insert into myphoto values(?,?)";
		try{
			conn = MyConnection.myConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			File f1 = new File("C:\\Users\\harsh\\eclipse-workspace\\JDBC\\mypic.jpg");
			FileInputStream fin = new FileInputStream(f1);
			
			ps.setString(1, "rama");
			ps.setBinaryStream(2, fin, (int)f1.length());
			ps.executeUpdate();
			System.out.println("success");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				if(conn!=null)
				{
					conn.close();
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
