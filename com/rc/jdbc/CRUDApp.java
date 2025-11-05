package com.rc.jdbc;
import java.util.*;

public class CRUDApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeService service = new EmployeeService();
		
		while(true)
		{
			System.out.println("Employee CRUD application");
			System.out.println("1 . Add Employee");
			System.out.println("2 . view wmployee");
			System.out.println("3. view All Employee");
			System.out.println("4. update employee");
			System.out.println("5. delete Employee");
			System.out.println("6. exit");
			System.out.println("enter choice");
			int choice = sc.nextInt();
			
			switch(choice)
			{
			case 1: 
				System.out.println("Enter Id");
				int id = sc.nextInt();
				System.out.println("Enter the name");
				String name = sc.next();
				System.out.println("enter the salary");
				double salary = sc.nextDouble();
				service.addEmployee(new Employee(id,name,salary));
				break;
				
			case 2:
				System.out.println("Enter the ID");
				service.viewEmployee(sc.nextInt());
				
			case 3:
				service.viewAllEmployee();
				
			case 4:
				System.out.println("Enter ID to update");
				int nid= sc.nextInt();
				System.out.println("Enter new Name");
				String newName = sc.next();
				System.out.println("New salary");
				Double newSal =sc.nextDouble();
				service.updateEmployee(new Employee(nid , newName , newSal));
				break;
				
			case 5:
				System.out.println("Enter the ID to delete :");
				service.deleteEmployee(sc.nextInt());
				break;
				
			case 6:
				System.out.println("Exiting...");
				System.out.println(0);
				break;
				
			default:
				
			}
		}
		
	}

}
