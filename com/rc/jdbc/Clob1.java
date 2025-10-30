package com.rc.jdbc;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class Clob1 {
	public static void main(String[] args) throws Exception {
		Connection conn = MyConnection.myConnection();
		String sql = "insert into filedb values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		File f = new File("letter.docx");
		FileReader fr = new FileReader(f);
		ps.setInt(1, 01);
		ps.setString(2, "resume");
		ps.setCharacterStream(3, fr,(int)f.length());
		ps.executeUpdate();
		System.out.println("document stored in the db successfully");
		fr.close();
		conn.close();	
	}
}
