package com.rc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MenuBasedJdbc {
	public static void main(String[] args) {
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521/orcl";
		//		String table = "create table studentts(name varchar(20) , id number primary key)";


		try {
			Connection connection = DriverManager.getConnection(url , user , password);
			Statement statement = connection.createStatement();
			//			statement.execute(table);

			System.out.println("Enter the choice to make operations on DB  1 to insert  2 to display 3 to update  4 to delete 5 to exit" );
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();



			while(true)
			{
				switch(choice)
				{
				case 1 :
					while(true)
					{
						System.out.println("Insert Student details");
						System.out.println("enter student name :");
						String sname = sc.next();
						System.out.println("enter student id :");
						int sid = sc.nextInt();
						String insert = "insert into studentts values('"+sname+"',"+sid+")";
						int rs = statement.executeUpdate(insert);
						System.out.println("want insert another student? yes/no");
						String s = sc.next();
						System.out.println("number of rows updated :"+rs);
						rs+=rs;
						if(s.equalsIgnoreCase("no"))
						{
							break;
						}
					}
					break;


				case 2 : System.out.println("display student details");
				ResultSet result = statement.executeQuery("select * from Studentts");
				while(result.next())
				{
					System.out.println("student name :"+result.getString("name")+"  student id :"+result.getInt("id"));

				}
				break;
				case 3:  System.out.println("upadate the records");
				while(true)
				{
					System.out.println("enter the id where to update");
					int id = sc.nextInt();
					System.out.println("Enter the name that has to be change");
					String updateName = sc.next();
					String update = "update studentts set name="+updateName+", where id= "+id+";";
					int res = statement.executeUpdate(update);
					if(res!=0)
					{
						System.out.println("number of rows updated :"+res);
					}res+=res;

					System.out.println("wnat to update any record? yes/no");
					String ss = sc.nextLine();
					if(ss.equalsIgnoreCase("no"))
					{
						break;
					}
				}
				break;



				case 4: System.out.println("delete the record");
				while(true)
				{
					System.out.println("eneter the id that need to be deleted");
					int did = sc.nextInt();
					String delete = "delete from studentts where id = "+did+"";
					int res1 = statement.executeUpdate(delete);
					System.out.println("want to delete more? yes/no");
					String sss = sc.nextLine();
					if(sss.equalsIgnoreCase("no"))
					{
						break;
					}

				}
				break;

				case 5 : System.out.println("exit from the menu");
				connection.close();
				statement.close();
				System.exit(0);
				break;

				default : System.out.println("invalid choice  re-enter the choice ");

				}
			}


		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}



