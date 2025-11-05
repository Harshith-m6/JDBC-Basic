package com.rc.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	
	public int addEmployee(Employee emp)
	{
		int rows = 0;
		String sql = "insert into emps(id , name , salary) values(?,?,?)";
		try(Connection conn = EmployeeConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
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
		try(Connection conn = EmployeeConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				emp = new Employee(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"));
			}
		}catch(SQLException e)
		{
			e.getMessage();
		}
		return emp;
	}
	
	public List<Employee> getAllEmployee(){
		List<Employee> list = new ArrayList<>();
		String sql = "Select * from employee";
		try(Connection conn = EmployeeConnection.getConnection(); Statement st = conn.createStatement();ResultSet rs = st.executeQuery(sql))
		{
			while(rs.next())
			{
				Employee emp = new Employee(rs.getInt("id"),
				rs.getString("name") , rs.getDouble("salary"));
						list.add(emp);
			}
		}catch(SQLException e)
		{
			e.getMessage();
		}
		return list;
	}
	
	public int updateEmployee(Employee emp)
	{
		int rows =0;
		String sql = "update employee set name =? , salary = ? where id=?";
		try(Connection conn = EmployeeConnection.getConnection();PreparedStatement ps = conn.prepareStatement(sql))
		{
			ps.setString(1, emp.getName());
			ps.setDouble(2,emp.getSalary());
			ps.setInt(3, emp.getId());
			rows = ps.executeUpdate();
		}catch(SQLException e)
		{
			e.getMessage();
		}
		return rows;
	}
	
	public int deleteEmployee(int id)
	{
		int rows =0;
		String sql = "delete from employee where id=?";
		try(Connection con = EmployeeConnection.getConnection();PreparedStatement ps = con.prepareStatement(sql))
		{
			ps.setInt(1, id);
		}catch(SQLException e)
		{
			e.getMessage();
		}
		return rows;
	}

}
