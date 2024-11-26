package com.project.employeeManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeManagement {
    
    // Database connection details
    private static String url = "jdbc:mysql://localhost:3306/employeedata";
    private static String user = "root";
    private static String password = "root";
    
    // Database connection and statement instances
    public static Connection connection;
    public static Statement statement;
    
    // Scanner instance for user input
    static Scanner scanner = new Scanner(System.in);

    // Static block to initialize the database connection
    static {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection to the database
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Print error details if connection fails
        }
    }

    public static void main(String[] args) {
        
        System.out.println("---WELCOME TO EMPLOYEE MANAGEMENT DATA---");
        boolean flag = true;
        
        // Main loop to display and handle menu options
        while (flag) {
            System.out.println();
            System.out.println("List the given Operations::");
            System.out.println("      1. Data Inserting \n      2. Data UpDating \n      3. Data Fetching \n      4. "
                    + "Data Deletion \n      5. Exit From Application ");
            System.out.println("Enter the Numbers(1, 2, 3, 4, 5)..,which Operation, you want");
        
            int choice = scanner.nextInt(); // Get user choice
            
            // Switch-case to handle different operations based on user choice
            switch(choice) {
                case 1: // Data Insertion
                    {
                        boolean employeeData = InsertEmployeeData.addEmployeeData();
                        if(!employeeData) {
                            System.out.println("Data inserted Successfully \n");
                        } else {
                            System.out.println("Data is not inserted Successfully");            
                        }
                        break;
                    }
                case 2: // Data Updating
                    {
                        boolean employeedata = UpdateEmployeeData.updateEmployeeData();
                        if(!employeedata) {
                            System.out.println("Data updated Successfully");
                        } else {
                            System.out.println("Data is not updated Successfully");
                        }
                        break;
                    }
                case 3: // Data Fetching
                    {
                        boolean employee = FetchEmployeeData.fetchEmployeeData();
                        if(!employee) {
                            System.out.println("Data Fetched Successfully");
                        } else {
                            System.out.println("Data is not Fetched Successfully");
                        }
                        break;
                    }
                case 4: // Data Deletion
                    {
                         boolean delete =  DeleteEmployeeData.deleteEmployeeData();
                         if(delete) {
                             System.out.println("Data was deleted successfully.");
                         } else {
                             System.out.println("Data deletion failed.");
                         }
                    }
                    break;
                case 5: // Exit
                    {
                        System.out.println("You Successfully..! Exit the Application");
                        flag = false; // Set flag to false to exit the loop
                        break;
                    }
                default:
                    System.out.println("Invalid choice, please select from 1 to 5.");
            }
        }   
    }
}
