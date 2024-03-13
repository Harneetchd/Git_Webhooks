package com.jdbc.databasetesting;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*1.create connection
  2.write a statement
  3.execute a statement  (if its select cmnd: we need to use ResultSet to store the data)
  4.close the connection*/

public class JDBCExample 
{
	static Connection con;
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		//Load JDBC DriverClass. DriverRegisters Itself to DRiverManager.JDBC 4.0 (included in Java 6), this is no longer needed.
		
		Class.forName("com.jdbc.databasetesting.JDBCExample");
		//Step1
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB","root","root1234");
		
		//insert();
		 //select();
		 countEmployeeEachDept();
		 
		//Step 4
		con.close();
		System.out.println("Program is exited");
	}
	
	public static void insert() throws SQLException
	{
		//Step 2
		Statement stmt = con.createStatement();
		String s ="insert into Employee(emp_id,emp_name,dept_id)values(110,'Hinu',4)";
		//Step 3
		stmt.execute(s);
	}
	
	public static void select() throws SQLException
	{
		//Step 2
		Statement stmt = con.createStatement();
		String selectStmt = "select * from Employee"; 
		
		//Step 3  incase there is Select command:which is biDirectional and will return the result. we need another Class:ResultSet
		 ResultSet result =stmt.executeQuery(selectStmt); 
		 
		 
		 while(result.next())
		 {
			 String empName =result.getString("emp_name");
			 String empId = result.getString("emp_id");
			 String deptId = result.getString("dept_id");
			 
			 System.out.println(empName+" "+empId+" "+deptId); 
			 System.out.println();
		 }
		
	}
	
	public static void countEmployeeEachDept() throws SQLException
	{
		Statement stmt = con.createStatement();
		
		String empInDept = "select count(*),dept_id from Employee group by dept_id";
		//String empInDept = "select count(*),dept_id from Employee group by dept_id order by dept_id";
		
		ResultSet empEachDept = stmt.executeQuery(empInDept);
		
		while(empEachDept.next())
		{
			String count = empEachDept.getString("count(*)");
			String deptID = empEachDept.getString("dept_id");
			
			System.out.println(deptID+" "+count);
			System.out.println();
		}
	}
	
	
}
