
# Employee Management Data Information

This project is a Java-based application designed to manage employee data efficiently. It provides functionalities to store, retrieve, update, and delete employee information using a MySQL database. The system demonstrates the integration of Java with databases and follows Object-Oriented Programming (OOP) principles.

---

## Features

- Add new employee records.
- Retrieve and display employee details.
- Update existing employee information.
- Delete employee records.
- Ensure data integrity through robust exception handling.

---

## Technologies Used

- **Programming Language**: Java
- **Database**: MySQL
- **Tools**: JDBC, Git for version control

---

## Prerequisites

Before running the project, ensure you have:

1. Java Development Kit (JDK) 8 or later installed.
2. MySQL installed and running.
3. A database named `employeedata` with a table `employee` created. Use the following SQL script to set up the database:

```sql
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employee (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL,
    AGE NUMBER(100),
    SALARY DECIMAL(10, 2)
);
```

## How to Run
1. Clone the repository:
   git clone [https://github.com/your-username/employee-management-data.git](https://github.com/dvenkateswarlu/JavaProjects.git)
   cd employee-management-data
2. Compile the application
   javac *.java
3. Run the main application:
   java EmployeeManagement
4. Follow the on-screen menu to:
   > Add new employees.
   > Update employee records.
   > Delete employee data.
   > Fetch and view employee details.
   
## Project Structure

- **EmployeeManagement.java**: Entry point of the application.
- **InsertEmployeeData.java**: Used to insert data into the employee table. 
- **DeleteEmployeeData.java**: Handles deletion of employee records.
- **FetchEmployeeData.java**: Fetches and displays employee data from the database.
- **UpdateEmployeeData.java**: Updates existing employee records.
---

## What I Learned

This project deepened my knowledge of:
- Writing and optimizing SQL queries.
- Integrating Java with relational databases using JDBC.
- Applying OOP principles to build scalable and maintainable software.
- Handling errors and ensuring system reliability.

---

## Future Improvements

- Implementing a user-friendly GUI for better interaction.
- Adding search and filter functionalities.
- Enhancing security with authentication and authorization mechanisms.

---

