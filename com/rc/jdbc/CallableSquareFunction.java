package com.rc.jdbc;
import java.sql.*;

public class CallableSquareFunction {
	public static void main(String[] args) {
		Connection con = MyConnection.myConnection();
		CallableStatement cs = null;
		try {
			cs = con.prepareCall("{?= call get_sq(?)}");
			cs.setInt(2, 2);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			int a = cs.getInt(1);
			System.out.println("square is "+a);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try
			{
				if(con!=null) con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			try
			{
				if(cs!=null) con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
