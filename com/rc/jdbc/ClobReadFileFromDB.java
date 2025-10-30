package com.rc.jdbc;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClobReadFileFromDB {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl" , "scott" , "tiger");
			Statement st = conn.createStatement();
			String sql = "select * from filedb";
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			System.out.println("File name is "+rs.getString(2));
			FileWriter fw = new FileWriter("copy.docx");
			Reader r = rs.getCharacterStream(3);
			int i = r.read();
			while(i!=-1)
			{
				fw.write(i);
				i = r.read();
			}
			fw.flush();
			fw.close();
			conn.close();
			System.out.println("the file is copied succcessfully");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
