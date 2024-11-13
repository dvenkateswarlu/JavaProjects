package com.project.employeeManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeleteEmployeeData {
	boolean flag = true;

    public static boolean deleteEmployeeData() {
        display();
       
       System.out.println("Enter the ID, Name, Age, or Salary of the employee to delete:");
       String value = EmployeeManagement.scanner.next();
        
        // Check if the input is an ID (numeric), Name, Age (numeric), or Salary (numeric)
        if (isNumeric(value)) {
            // Delete by ID or Age or Salary (numeric inputs)
            if (getnameById(value)) {
                return deleteById(value);
            } else if (getEmployeeByAge(value)) {
                return deleteByAge(value);
            } else if (getEmployeeBySalary(value)) {
                return deleteBySalary(value);
            }
        } else {
            // Delete by Name
            if (getnameByName(value)) {
                return deleteByName(value);
            }
        }      
        return false;
    }

    private static boolean deleteById(String value) {
        try {
            String sql = "DELETE FROM employee WHERE ID = ?";
            java.sql.PreparedStatement preparedStatement = EmployeeManagement.connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(value));
            
            int rowsDeleted = preparedStatement.executeUpdate();
            
            if (rowsDeleted > 0)  return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean deleteByName(String name) {
        try {
            String sql = "DELETE FROM employee WHERE NAME = ?";
            java.sql.PreparedStatement preparedStatement = EmployeeManagement.connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            
            int rowsDeleted = preparedStatement.executeUpdate();
            
            if (rowsDeleted > 0)  return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean deleteByAge(String value) {
        try {
            int age = Integer.parseInt(value);
            String sql = "DELETE FROM employee WHERE AGE = ?";
            java.sql.PreparedStatement preparedStatement = EmployeeManagement.connection.prepareStatement(sql);
            preparedStatement.setInt(1, age);
            
            int rowsDeleted = preparedStatement.executeUpdate();
            
            if (rowsDeleted > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean deleteBySalary(String value) {
        try {
            double salary = Double.parseDouble(value);
            String sql = "DELETE FROM employee WHERE SALARY = ?";
            java.sql.PreparedStatement preparedStatement = EmployeeManagement.connection.prepareStatement(sql);
            preparedStatement.setDouble(1, salary);
            
            int rowsDeleted = preparedStatement.executeUpdate();
            
            if (rowsDeleted > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void display() {
        try {
            String sql = "SELECT * FROM employee";
            Statement statement2 = EmployeeManagement.connection.createStatement();
            ResultSet executeQuery = statement2.executeQuery(sql);

            System.out.println("<---::Employee Table All Details::--->");
            System.out.println("ID\t" + "NAME\t" + "AGE\t" + "SALARY");

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

    private static boolean getnameById(String str) {
        try {
            String sql = "SELECT ID FROM employee";
            Statement statement1 = EmployeeManagement.connection.createStatement();
            ResultSet executeQuery = statement1.executeQuery(sql);

            List<Integer> idList = new ArrayList<>();  // List to store IDs

            while (executeQuery.next()) {
                int id = executeQuery.getInt("ID");  // Get ID from the result set
                idList.add(id);  // Add ID to the list
            }

            statement1.close();
            executeQuery.close();

            // Check if the given ID (converted to integer) is in the list
            return idList.contains(Integer.parseInt(str));
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean getnameByName(String name) {
        try {
            String sql = "SELECT NAME FROM employee";
            Statement statement1 = EmployeeManagement.connection.createStatement();
            ResultSet executeQuery = statement1.executeQuery(sql);

            List<String> nameList = new ArrayList<>();  // List to store names

            while (executeQuery.next()) {
                String employeeName = executeQuery.getString("NAME");  // Get Name from the result set
                nameList.add(employeeName);  // Add Name to the list
            }

            statement1.close();
            executeQuery.close();

            // Check if the given Name is in the list
            return nameList.contains(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean getEmployeeByAge(String age) {
        try {
            String sql = "SELECT AGE FROM employee";
            Statement statement1 = EmployeeManagement.connection.createStatement();
            ResultSet executeQuery = statement1.executeQuery(sql);

            List<Integer> ageList = new ArrayList<>();  // List to store ages

            while (executeQuery.next()) {
                int employeeAge = executeQuery.getInt("AGE");  // Get Age from the result set
                ageList.add(employeeAge);  // Add Age to the list
            }

            statement1.close();
            executeQuery.close();

            // Check if the given Age (converted to integer) is in the list
            return ageList.contains(Integer.parseInt(age));
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean getEmployeeBySalary(String salary) {
        try {
            String sql = "SELECT SALARY FROM employee";
            Statement statement1 = EmployeeManagement.connection.createStatement();
            ResultSet executeQuery = statement1.executeQuery(sql);

            List<Double> salaryList = new ArrayList<>();  // List to store salaries

            while (executeQuery.next()) {
                double employeeSalary = executeQuery.getDouble("SALARY");  // Get Salary from the result set
                salaryList.add(employeeSalary);  // Add Salary to the list
            }

            statement1.close();
            executeQuery.close();

            // Check if the given Salary (converted to double) is in the list
            return salaryList.contains(Double.parseDouble(salary));
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Helper method to check if a string is numeric (used to check if input is ID, Age, or Salary)
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);  // Check if the string can be parsed as an integer (for ID, Age)
            return true;
        } catch (NumberFormatException e) {
            try {
                Double.parseDouble(str);  // Check if the string can be parsed as a double (for Salary)
                return true;
            } catch (NumberFormatException e1) {
                return false;
            }
        }
    }
}
