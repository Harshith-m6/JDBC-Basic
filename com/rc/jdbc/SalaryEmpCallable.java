package com.rc.jdbc;
import java.sql.*;
public class SalaryEmpCallable {
	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cs = null;
		try {
			con =  MyConnection.myConnection();
			cs = con.prepareCall("{?= call get_sal(?)}");
			cs.setInt(2, 7566);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			int salary = cs.getInt(1);
			System.out.println("salary of the employee is  "+salary);
		}catch(Exception e )
		{
			e.printStackTrace();
		}
		finally {
			try {
				
				if(con!=null)
				{
					con.close();
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			try {
				if(cs!=null)
				{
					cs.close();
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
