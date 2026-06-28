# Employee Payroll System

## Description
A Java-based Employee Payroll Management System built using Core Java, JDBC, Maven, and MySQL. The application allows users to manage employee records, perform CRUD operations, generate salary slips, view reports and analytics, and manage employees department-wise.

## Features
- Add Employee
- View All Employees
- Search Employee by ID
- Update Employee
- Delete Employee
- Report & Analytics
- Generate Salary Slip
- Show Employees by Department
- Count Employees by Department
- Input Validation
- Exception Handling

## Technologies Used
- Java
- JDBC
- MySQL
- Maven
- IntelliJ IDEA

## Project Structure
```
src/
 ├── dao
 ├── db
 ├── model
 ├── service
 ├── validation
 └── Main.java

database/
 └── employee_payroll.sql
```

## How to Run
1. Import the project into IntelliJ IDEA.
2. Create the MySQL database using `employee_payroll.sql`.
3. Update database credentials in `DBConnection.java`.
4. Run `Main.java`.

## Future Enhancements
- Login Authentication
- GUI using JavaFX/Swing
- Export Reports to PDF/Excel
- Attendance & Leave Management
