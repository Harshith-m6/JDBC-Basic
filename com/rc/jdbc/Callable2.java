package com.rc.jdbc;
import java.sql.*;

import oracle.jdbc.OracleTypes;

public class Callable2 {
	public static void main(String[] args) throws Exception {
		Connection con = MyConnection.myConnection();
		CallableStatement cs = con.prepareCall("{call get_all_emp(?)}");
		cs.registerOutParameter(1,OracleTypes.CURSOR);
		cs.execute();
		ResultSet rs = (ResultSet) cs.getObject(1);
		while(rs.next())
		{
			String name =rs.getString("ename");
			System.out.println("Employee name is "+name);
		}
	}

}
