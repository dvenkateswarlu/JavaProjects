package com.project.employeeManagement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEmployeeData {

	static boolean execute=true;
	public static boolean updateEmployeeData()
	{
		boolean flag = true;
		while(flag)
		{
			System.out.println("List the given Operations::");
			System.out.println("\t1. Update Id \n\t2. Update Name \n\t3. Update Age \n\t4. Update Salary "
					+ "\n\t5. Update More than One");
			System.out.println("Enter which Column Data You what to Update");
	
			int choice = EmployeeManagement.scanner.nextInt();
			
			switch(choice)
			{
				case 1:
				{	
					try {
						display(); // It display method display's the Employee Table Data
						System.out.println("Enter the Update ID Number");
						int updateid = EmployeeManagement.scanner.nextInt();
						System.out.println("Enter the Given ID Number");
						int exstingid = EmployeeManagement.scanner.nextInt();
						
						String sql1 = "Update employee Set ID = ? where ID=?";
						PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
						statement.setInt(1, updateid);
						statement.setInt(2, exstingid);
						
						execute = statement.execute();// Execute the PreparedStatement
						flag = false;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
					break;
				case 2:
				{	
					try {
						display(); // It display method display's the Employee Table Data
						System.out.println("Enter the Update Name");
						String updateName = EmployeeManagement.scanner.next();
						System.out.println("Enter the Given ID Number");
						int exstingID = EmployeeManagement.scanner.nextInt();
						
						String sql1 = "Update employee Set Name = ? where ID=?";
						PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
						statement.setString(1, updateName);
						statement.setInt(2, exstingID);
						
						execute = statement.execute(); // Execute the PreparedStatement
						flag = false;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
					break;
				case 3:
				{	
					try {
						display(); // It display method display's the Employee Table Data
						System.out.println("Enter the Update Age value");
						int updateAge = EmployeeManagement.scanner.nextInt();
						System.out.println("Enter the Given ID Number");
						int exstingid = EmployeeManagement.scanner.nextInt();
						
						String sql1 = "Update employee Set Age = ? where ID=?";
						PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
						statement.setInt(1, updateAge);
						statement.setInt(2, exstingid);
						
						execute = statement.execute();// Execute the PreparedStatement
						flag = false;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
					break;
				case 4:
				{	
					try {
						display(); // It display method display's the Employee Table Data
						System.out.println("Enter the Update Salary");
						double updateSal = EmployeeManagement.scanner.nextDouble();
						System.out.println("Enter the Update ID Number");
						int exstingid = EmployeeManagement.scanner.nextInt();
						
						String sql1 = "Update employee Set SALARY = ? where ID=?";
						PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
						statement.setDouble(1, updateSal);
						statement.setInt(2, exstingid);
						
						execute = statement.execute(); // Execute the PreparedStatement
						flag = false;
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
					break;
				case 5:
				{
					System.out.println("<---------How many columns you want to Update--------->");
					System.out.println("<----------Avaible to Columns [2,3,4]---------->");
					int nextInt = EmployeeManagement.scanner.nextInt();
					if(nextInt <= 1)
					{
						System.out.println("You can Select more than one Column");
						break;
					}
					
					if(nextInt==2)
					{
						System.out.println("<--:: Enter Columns [ID, NAME, AGE, SALARY] ::-->");
						
						String col1=EmployeeManagement.scanner.next();
						String col2=EmployeeManagement.scanner.next();
						if((col1.equalsIgnoreCase("ID") && col2.equalsIgnoreCase("NAME"))||(col2.equalsIgnoreCase("ID") && col1.equalsIgnoreCase("NAME")))
						{
							try {
								display(); // It display method display's the Employee Table Data
								System.out.println("Enter the Update ID Number");
								int updateid = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Update Name");
								String updatename = EmployeeManagement.scanner.next();
								System.out.println("Enter the Given ID Number");
								int exstingid = EmployeeManagement.scanner.nextInt();
								
								String sql1 = "Update employee Set ID = ?,NAME=? where ID=?";
								PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
								statement.setInt(1, updateid);
								statement.setString(2,updatename);
								statement.setInt(3, exstingid);
								
								execute = statement.execute(); // Execute the PreparedStatement
								flag = false;
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}else if((col1.equalsIgnoreCase("ID") && col2.equalsIgnoreCase("AGE"))||(col2.equalsIgnoreCase("ID") && col1.equalsIgnoreCase("AGE")))
						{
							try {
								display(); // It display method display's the Employee Table Data
								System.out.println("Enter the Update ID Number");
								int updateid = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Update Age");
								int updateAge = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Given ID Number");
								int exstingid = EmployeeManagement.scanner.nextInt();
								
								String sql1 = "Update employee Set ID = ?,AGE=? where ID=?";
								PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
								statement.setInt(1, updateid);
								statement.setInt(2,updateAge);
								statement.setInt(3, exstingid);
								
								execute = statement.execute(); // Execute the PreparedStatement	
								flag = false;
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}else if((col1.equalsIgnoreCase("ID") && col2.equalsIgnoreCase("SALARY"))||(col2.equalsIgnoreCase("ID") && col1.equalsIgnoreCase("SALARY")))
						{
							try {
								display(); // It display method display's the Employee Table Data
								System.out.println("Enter the Update ID Number");
								int updateid = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Update Salary");
								double updateSal = EmployeeManagement.scanner.nextDouble();
								System.out.println("Enter the Given ID Number");
								int exstingid = EmployeeManagement.scanner.nextInt();
								
								String sql1 = "Update employee Set ID = ?,AGE=? where ID=?";
								PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
								statement.setInt(1, updateid);
								statement.setDouble(2,updateSal);
								statement.setInt(3, exstingid);
								
								execute = statement.execute(); // Execute the PreparedStatement	
								flag = false;
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}else if((col1.equalsIgnoreCase("NAME") && col2.equalsIgnoreCase("AGE"))||(col2.equalsIgnoreCase("NAME") && col1.equalsIgnoreCase("AGE")))
						{
							try {
								display(); // It display method display's the Employee Table Data
								System.out.println("Enter the Update Name");
								String updateName = EmployeeManagement.scanner.next();
								System.out.println("Enter the Update Age");
								int updateAge = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Given ID Number");
								int exstingid = EmployeeManagement.scanner.nextInt();
								
								String sql1 = "Update employee Set NAME = ?,AGE=? where ID=?";
								PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
								statement.setString(1, updateName);
								statement.setInt(2,updateAge);
								statement.setInt(3, exstingid);
								
								execute = statement.execute(); // Execute the PreparedStatement	
								flag = false;
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}else if((col1.equalsIgnoreCase("NAME") && col2.equalsIgnoreCase("SALARY"))||(col2.equalsIgnoreCase("NAME") && col1.equalsIgnoreCase("SALARY")))
						{
							try {
								display(); // It display method display's the Employee Table Data
								System.out.println("Enter the Update Name");
								String updateName = EmployeeManagement.scanner.next();
								System.out.println("Enter the Update Salary");
								double updateSal = EmployeeManagement.scanner.nextDouble();
								System.out.println("Enter the Given ID Number");
								int exstingid = EmployeeManagement.scanner.nextInt();
								
								String sql1 = "Update employee Set NAME = ?,SALARY=? where ID=?";
								PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
								statement.setString(1, updateName);
								statement.setDouble(2,updateSal);
								statement.setInt(3, exstingid);
								
								execute = statement.execute(); // Execute the PreparedStatement		
								flag = false;
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}else if((col1.equalsIgnoreCase("AGE") && col2.equalsIgnoreCase("SALARY"))||(col2.equalsIgnoreCase("AGE") && col1.equalsIgnoreCase("SALARY")))
						{
							try {
								display(); // It display method display's the Employee Table Data
								System.out.println("Enter the Update Age");
								int updateAge = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Update Salary");
								double updateSal = EmployeeManagement.scanner.nextDouble();
								System.out.println("Enter the Given ID Number");
								int exstingid = EmployeeManagement.scanner.nextInt();
								
								String sql1 = "Update employee Set AGE = ?,SALARY=? where ID=?";
								PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
								statement.setInt(1, updateAge);
								statement.setDouble(2,updateSal);
								statement.setInt(3, exstingid);
								
								execute = statement.execute(); // Execute the PreparedStatement	
								flag = false;
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}			
						
					}else if(nextInt==3)
					{
						System.out.println("<--:: Enter Columns [ID, NAME, AGE, SALARY] ::-->");
						
						String col1=EmployeeManagement.scanner.next();
						String col2=EmployeeManagement.scanner.next();
						String col3=EmployeeManagement.scanner.next();
						if((col1.equalsIgnoreCase("ID") && col2.equalsIgnoreCase("NAME") && col3.equalsIgnoreCase("AGE"))||(col1.equalsIgnoreCase("NAME") && col2.equalsIgnoreCase("AGE") &&col3.equalsIgnoreCase("ID"))
								||(col1.equalsIgnoreCase("AGE")&& col2.equalsIgnoreCase("ID")&& col3.equalsIgnoreCase("NAME")))
						{
							try {
								display(); // It display method display's the Employee Table Data
								System.out.println("Enter the Update ID Number");
								int updateId = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Update Name");
								String updateName = EmployeeManagement.scanner.next();
								System.out.println("Enter the Update Age");
								int updateAge = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Given ID Number");
								int exstingid = EmployeeManagement.scanner.nextInt();
								
								String sql1 = "Update employee Set ID =?, NAME =?, AGE = ? where ID=?";
								PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
								statement.setInt(1, updateId);
								statement.setString(2,updateName);
								statement.setInt(3, updateAge);
								statement.setInt(4, exstingid);
								
								execute = statement.execute(); // Execute the PreparedStatement	
								flag = false;
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}else if((col1.equalsIgnoreCase("NAME") && col2.equalsIgnoreCase("AGE") && col3.equalsIgnoreCase("SALARY"))||(col1.equals("AGE") && col2.equals("SALARY") &&col3.equals("NAME"))
								||(col1.equalsIgnoreCase("SALARY")&& col2.equalsIgnoreCase("NAME")&& col3.equalsIgnoreCase("AGE")))
						{
							try {
								display(); // It display method display's the Employee Table Data
								System.out.println("Enter the Update Name");
								String updateName = EmployeeManagement.scanner.next();
								System.out.println("Enter the Update Age");
								int updateAge = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Update Salary");
								double updateSal = EmployeeManagement.scanner.nextDouble();
								System.out.println("Enter the Given ID Number");
								int exstingid = EmployeeManagement.scanner.nextInt();
								
								String sql1 = "Update employee Set NAME =?, AGE =?, SALARY = ? where ID=?";
								PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
								statement.setString(1, updateName);
								statement.setInt(2,updateAge);
								statement.setDouble(3, updateSal);
								statement.setInt(4, exstingid);
								
								execute = statement.execute(); // Execute the PreparedStatement	
								flag = false;
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}else if((col1.equalsIgnoreCase("AGE") && col2.equalsIgnoreCase("SALARY") && col3.equals("ID"))||(col1.equalsIgnoreCase("SALARY") && col2.equalsIgnoreCase("ID") &&col3.equalsIgnoreCase("AGE"))
								||(col1.equalsIgnoreCase("ID")&& col2.equalsIgnoreCase("AGE")&& col3.equalsIgnoreCase("SALARY")))
						{
							try {
								display(); // It display method display's the Employee Table Data
								System.out.println("Enter the Update Age");
								int updateAge = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Update Salary");
								double updateSal = EmployeeManagement.scanner.nextDouble();
								System.out.println("Enter the Given ID Number");
								int exstingid = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Update ID Number");
								int updateId = EmployeeManagement.scanner.nextInt();
								
								String sql1 = "Update employee Set AGE =?, SALARY =?, ID = ? where ID=?";
								PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
								statement.setInt(1, updateAge);
								statement.setDouble(2,updateSal);
								statement.setInt(3, updateId);
								statement.setInt(4, exstingid);
								
								execute = statement.execute(); // Execute the PreparedStatement	
								flag = false;
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}else if((col1.equalsIgnoreCase("NAME") && col2.equalsIgnoreCase("AGE") && col3.equalsIgnoreCase("SALARY"))||(col1.equals("AGE") && col2.equals("SALARY") &&col3.equals("NAME"))
								||(col1.equalsIgnoreCase("SALARY")&& col2.equalsIgnoreCase("NAME")&& col3.equalsIgnoreCase("AGE")))
						{
							try {
								display(); // It display method display's the Employee Table Data
								System.out.println("Enter the Update Name");
								String updateName = EmployeeManagement.scanner.next();
								System.out.println("Enter the Update Age");
								int updateAge = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Update Salary");
								double updateSal = EmployeeManagement.scanner.nextDouble();
								System.out.println("Enter the Given ID Number");
								int exstingid = EmployeeManagement.scanner.nextInt();
								
								String sql1 = "Update employee Set NAME =?, AGE =?, SALARY = ? where ID=?";
								PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
								statement.setString(1, updateName);
								statement.setInt(2,updateAge);
								statement.setDouble(3, updateSal);
								statement.setInt(4, exstingid);
								
								execute = statement.execute(); // Execute the PreparedStatement	
								flag = false;
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}else if((col1.equalsIgnoreCase("SALARY") && col2.equalsIgnoreCase("ID") && col3.equals("NAME"))||(col1.equalsIgnoreCase("ID") && col2.equalsIgnoreCase("NAME") &&col3.equalsIgnoreCase("SALARY"))
								||(col1.equalsIgnoreCase("NAME")&& col2.equalsIgnoreCase("SALARY")&& col3.equalsIgnoreCase("ID")))
						{
							try {
								display(); // It display method display's the Employee Table Data
								System.out.println("Enter the Update Salary");
								double updateSal = EmployeeManagement.scanner.nextDouble();
								System.out.println("Enter the Update ID Number");
								int updateId = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Update Name");
								String updateName = EmployeeManagement.scanner.next();
								System.out.println("Enter the Given ID Number");
								int exstingid = EmployeeManagement.scanner.nextInt();
								
								String sql1 = "Update employee Set SALARY =?, ID =?, NAME = ? where ID=?";
								PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
								statement.setDouble(1, updateSal);
								statement.setInt(2,updateId);
								statement.setString(3, updateName);
								statement.setInt(4, exstingid);
								
								execute = statement.execute(); // Execute the PreparedStatement	
								flag = false;
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						
					}else if(nextInt==4)
					{
						System.out.println("<--:: Enter Columns [ID, NAME, AGE, SALARY] ::-->");
						
						String col1=EmployeeManagement.scanner.next();
						String col2=EmployeeManagement.scanner.next();
						String col3=EmployeeManagement.scanner.next();
						String col4=EmployeeManagement.scanner.next();
						if((col1.equalsIgnoreCase("SALARY") && col2.equalsIgnoreCase("ID") && col3.equals("NAME")&&col4.equalsIgnoreCase("AGE"))||(col1.equalsIgnoreCase("ID") && col2.equalsIgnoreCase("NAME") &&col3.equalsIgnoreCase("AGE")&&col4.equalsIgnoreCase("SALARY"))
						||(col1.equalsIgnoreCase("NAME")&& col2.equalsIgnoreCase("AGE")&& col3.equalsIgnoreCase("SALARY")&& col4.equalsIgnoreCase("ID"))||(col1.equalsIgnoreCase("AGE")&& col2.equalsIgnoreCase("SALARY")&& col3.equalsIgnoreCase("ID")&& col4.equalsIgnoreCase("NAME")))
						{
							try {
								display(); // It display method display's the Employee Table Data
								System.out.println("Enter the Update ID Number");
								int updateId = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Update Name");
								String updateName = EmployeeManagement.scanner.next();
								System.out.println("Enter the Update Age");
								int updateAge = EmployeeManagement.scanner.nextInt();
								System.out.println("Enter the Update Salary");
								double updateSal = EmployeeManagement.scanner.nextDouble();
								System.out.println("Enter the Update ID Number");
								int exstingid = EmployeeManagement.scanner.nextInt();
								
								String sql1 = "Update employee Set ID =?, NAME =?, AGE = ?, SALARY=? where ID=?";
								PreparedStatement statement = EmployeeManagement.connection.prepareStatement(sql1);
								statement.setInt(1, updateId);
								statement.setString(2,updateName);
								statement.setInt(3, updateAge);
								statement.setDouble(4, updateSal);
								statement.setInt(5, exstingid);
								
								execute = statement.execute(); // Execute the PreparedStatement	
								flag = false;
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}			
				}
					break;
			}		
		}
		return execute;
	}
	
	private static void display()
	{
		try
		{
			String sql = "Select * from employee";
			Statement statement2 = EmployeeManagement.connection.createStatement();
			ResultSet executeQuery = statement2.executeQuery(sql);
			System.out.println("<---::Employee Table All Details::--->");
			System.out.println("ID\t"+"NAME\t"+"AGE\t"+"SALARY");
			while (executeQuery.next()) {   
		        int ID = executeQuery.getInt(1);
		        String NAME =executeQuery.getString(2);
		        int AGE = executeQuery.getInt(3);
		        double SALARY =executeQuery.getDouble(4);
		        System.out.println(ID+"\t"+NAME+"\t"+AGE+"\t"+SALARY);
			}
			statement2.close();
			executeQuery.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}		
	}

}