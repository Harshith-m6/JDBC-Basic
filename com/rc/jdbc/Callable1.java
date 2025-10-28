package com.rc.jdbc;

import java.sql.*;

public class Callable1 {
	public static void main(String[] args) throws Exception{
		Connection con = MyConnection.myConnection();
		CallableStatement cs = con.prepareCall("{call get_emp(?,?)}");
		cs.setInt(1, 7369);
		cs.registerOutParameter(2, Types.VARCHAR);
		cs.execute();
		String name =cs.getString(2);
		System.out.println("Name is "+name);
	}

}
