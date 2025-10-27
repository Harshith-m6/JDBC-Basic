package com.rc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {
	
	public int addEmployee(Employee emp)
	{
		int rows = 0;
		String sql = "insert into emps(id , name , salary) values(?,?,?)";
		try(Connection connection = EmployeeConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql))
		{
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setDouble(3, 10000.0);
			rows = ps.executeUpdate();	
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return rows;
	}
	
	public Employee getEmployeeById(int id)
	{
		Employee emp = null;
		String sql = "select * from emps where id=102";
		try(Connection connection = EmployeeConnection.getConnection(); PreparedStatement)
	}

}
