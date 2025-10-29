package com.rc.jdbc;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;

public class ReadingWritingBlob {
	public static void main(String[] args) throws Exception {
		Connection conn = MyConnection.myConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from myphoto");
		rs.next();
		System.out.println("image name "+rs.getString(1));
		InputStream ip = rs.getBinaryStream(2);
		FileOutputStream op = new FileOutputStream("picture.jpg"); //if path is not given image will be in same project
		int i = ip.read();
		while(i!=-1)
		{
			op.write(i);
			i = ip.read();
		}
		System.out.println("image created succesfully");
		ip.close();
		op.flush();
		op.close();
		conn.close();
	}

}
