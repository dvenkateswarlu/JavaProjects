package com.project.employeeManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchEmployeeData {
	
	// Flag to indicate if data fetching was successful or not
	static boolean flag = true;
	
	// Method to fetch employee data based on user choice
	public static boolean fetchEmployeeData() {
		display();  // Display all current employee data
		
		System.out.println();
		System.out.println("Which Data you want to Fetch-->Enter the Options[1,2,3,4]"
				+ "\n\t1. Employee Id \n\t2. Employee Name \n\t3. Employee Age \n\t4. Employee Salary \n\t5. Employee Fulldata \n\t6. Exit from EmployeeTable");
		int choice = EmployeeManagement.scanner.nextInt();  // Get user choice
		
		// Switch-case to handle each fetch operation based on user choice
		switch(choice) {
			case 1: // Fetch Employee IDs
			{
				try {
					System.out.println("<----Employee Management ID Numbers---->");
					String sql = "SELECT ID FROM EMPLOYEE";
					Statement statement1 = EmployeeManagement.connection.createStatement();
					ResultSet executeQuery = statement1.executeQuery(sql);
					
					// Loop through and display each Employee ID
					while(executeQuery.next()) {
						int id = executeQuery.getInt(1);
						System.out.println("\t\t" + id);
					}
					flag = false;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
			
			case 2: // Fetch Employee Names
			{
				try {
					System.out.println("<----Employee Management Names---->");
					String sql = "SELECT NAME FROM EMPLOYEE";
					Statement statement1 = EmployeeManagement.connection.createStatement();
					ResultSet executeQuery = statement1.executeQuery(sql);
					
					// Loop through and display each Employee Name
					while(executeQuery.next()) {
						String name = executeQuery.getString(1);
						System.out.println("\t\t" + name);
					}
					flag = false;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
			
			case 3: // Fetch Employee Ages
			{
				try {
					System.out.println("<----Employee Management Ages---->");
					String sql = "SELECT AGE FROM EMPLOYEE";
					Statement statement1 = EmployeeManagement.connection.createStatement();
					ResultSet executeQuery = statement1.executeQuery(sql);
					
					// Loop through and display each Employee Age
					while(executeQuery.next()) {
						int age = executeQuery.getInt(1);
						System.out.println("\t\t" + age);
					}
					flag = false;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
			
			case 4: // Fetch Employee Salaries
			{
				try {
					System.out.println("<----Employee Management Salaries---->");
					String sql = "SELECT SALARY FROM EMPLOYEE";
					Statement statement1 = EmployeeManagement.connection.createStatement();
					ResultSet executeQuery = statement1.executeQuery(sql);
					
					// Loop through and display each Employee Salary
					while(executeQuery.next()) {
						double salary = executeQuery.getDouble(1);
						System.out.println("\t\t" + salary);
					}
					flag = false;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
			
			case 5: // Fetch Full Employee Data (all fields)
			{
				try {
					System.out.println("<----Employee Management Full Data---->");
					System.out.println();
					String sql = "SELECT * FROM EMPLOYEE";
					Statement statement1 = EmployeeManagement.connection.createStatement();
					ResultSet executeQuery = statement1.executeQuery(sql);
					System.out.println("\tNAME\tID\tAGE\tSALARY");
					
					// Loop through and display each Employee's full details
					while(executeQuery.next()) {
						int id = executeQuery.getInt(1);
						String name = executeQuery.getString(2);
						int age = executeQuery.getInt(3);
						double salary = executeQuery.getDouble(4);
						
						System.out.println("\t" + id + "\t" + name + "\t" + age + "\t" + salary);
					}
					flag = false;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
			
			case 6: // Exit
			{
				System.out.println("Exiting Employee Table Operations.");
				flag = false;
				break;
			}
			
			default:
				System.out.println("Invalid choice, please select from 1 to 6.");
		}
		return flag;
	}

	// Method to display all current data in the employee table
	private static void display() {
		try {
			String sql = "SELECT * FROM employee";
			Statement statement2 = EmployeeManagement.connection.createStatement();
			ResultSet executeQuery = statement2.executeQuery(sql);
			
			System.out.println("<---::Employee Table All Details::--->");
			System.out.println("ID\t" + "NAME\t" + "AGE\t" + "SALARY");
			
			// Loop through and display each Employee's details
			while (executeQuery.next()) {   
				int ID = executeQuery.getInt(1);
				String NAME = executeQuery.getString(2);
				int AGE = executeQuery.getInt(3);
				double SALARY = executeQuery.getDouble(4);
				System.out.println(ID + "\t" + NAME + "\t" + AGE + "\t" + SALARY);
			}
			statement2.close();
			executeQuery.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
