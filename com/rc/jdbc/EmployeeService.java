package com.rc.jdbc;

import java.util.List;

public class EmployeeService 
{
	private EmployeeDAO dao = new EmployeeDAO();
	
	public void addEmployee(Employee emp)
	{
		int rows = dao.addEmployee(emp);
		if(rows > 0)
		{
			System.out.println("employee added successfully");
		}else {
			System.out.println("Failed to add Employee");
		}
	}
	
	public void viewEmployee(int id)
	{
		Employee emp = dao.getEmployeeById(id);
		if(emp!=null)
		{
			System.out.println(emp);
		}else {
			System.out.println("Employee not found");
		}
	}
	
	public void viewAllEmployee() {
		List<Employee> list = dao.getAllEmployee();
		for(Employee e : list)
		{
			System.out.println(e);
		}
	}
	public void updateEmployee(Employee emp)
	{
		int rows = dao.updateEmployee(emp);
		if(rows>0)
		{
			System.out.println("Employee updated successfully");
		}else
		{
			System.out.println("update failed");
		}
	}
	
	public void deleteEmployee(int id)
	{
		int rows = dao.deleteEmployee(id);
		if(rows>0)
		{
			System.out.println("Employee deleted successfully");
		}else
		{
			System.out.println("Delete failed");
		}
	}
	

}
