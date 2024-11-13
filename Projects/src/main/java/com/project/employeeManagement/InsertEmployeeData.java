package com.project.employeeManagement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployeeData {
	
	public static boolean addEmployeeData()
	{
		System.out.println("Enter the ID Number");
		int id = EmployeeManagement.scanner.nextInt();
		System.out.println("Enter the Name of Employee");
		String name = EmployeeManagement.scanner.next();
		System.out.println("Enter the Age of Employee");
		int age = EmployeeManagement.scanner.nextInt();
		System.out.println("Enter the Salary of Employee");
		double sal = EmployeeManagement.scanner.nextDouble();
		
		boolean execute=true;
	
		try
		{
			String sql = "Insert into employee(ID, NAME, AGE, SALARY) values(?, ?, ?, ?)";
			PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql);

			statement.setInt(1,id);
			statement.setString(2,name);
			statement.setInt(3, age);
			statement.setDouble(4, sal);
			
			execute = statement.execute(); // Execute the PreparedStatement
			
		
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return execute;
		
	}

}
