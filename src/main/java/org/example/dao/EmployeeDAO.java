package org.example.dao;

import org.example.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.example.db.DBConnection;

import java.sql.ResultSet;

public class EmployeeDAO {
    public void addEmployee(Employee employee) {
        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO employees VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);
            ps.setInt(1, employee.getEmpId());
            ps.setString(2, employee.getName());
            ps.setInt(3, employee.getAge());
            ps.setString(4, employee.getEmail());
            ps.setString(5, employee.getMobile());
            ps.setString(6, employee.getDepartment());
            ps.setString(7, employee.getDesignation());
            ps.setDouble(8, employee.getBasicSalary());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Added Successfully");
            } else {
                System.out.println("Failed To Add Employee");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void viewAllEmployees() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM employees";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("------------------------------");
                System.out.println("Employee ID : " + rs.getInt("emp_id"));
                System.out.println("Name        : " + rs.getString("name"));
                System.out.println("Age         : " + rs.getInt("age"));
                System.out.println("Email       : " + rs.getString("email"));
                System.out.println("Mobile      : " + rs.getString("mobile"));
                System.out.println("Department  : " + rs.getString("department"));
                System.out.println("Designation : " + rs.getString("designation"));
                System.out.println("Basic Salary: " + rs.getDouble("basic_salary"));
                System.out.println("------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void searchEmployee(int empId) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM employees WHERE emp_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, empId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Employee ID : " + rs.getInt("emp_id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Age : " + rs.getInt("age"));
                System.out.println("Email : " + rs.getString("email"));
                System.out.println("Mobile : " + rs.getString("mobile"));
                System.out.println("Department : " + rs.getString("department"));
                System.out.println("Designation : " + rs.getString("designation"));
                System.out.println("Basic Salary : " + rs.getDouble("basic_salary"));

            } else {

                System.out.println("Employee Not Found.");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "UPDATE employees SET name=?, age=?, email=?, mobile=?, department=?, designation=?, basic_salary=? WHERE emp_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getAge());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getMobile());
            ps.setString(5, employee.getDepartment());
            ps.setString(6, employee.getDesignation());
            ps.setDouble(7, employee.getBasicSalary());
            ps.setInt(8, employee.getEmpId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Updated Successfully");
            } else {
                System.out.println("Employee Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int empId) {

        try {

            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM employees WHERE emp_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, empId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Deleted Successfully");
            } else {
                System.out.println("Employee Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showReport() {
        String sql = "SELECT COUNT(*) AS totalEmployees, " +
                "SUM(basic_salary) AS totalSalary, " +
                "AVG(basic_salary) AS averageSalary, " +
                "MAX(basic_salary) AS highestSalary, " +
                "MIN(basic_salary) AS lowestSalary " +
                "FROM employees";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {
                System.out.println("\n========== REPORT ==========");
                System.out.println("Total Employees : " + rs.getInt("totalEmployees"));
                System.out.println("Total Salary    : " + rs.getDouble("totalSalary"));
                System.out.println("Average Salary  : " + rs.getDouble("averageSalary"));
                System.out.println("Highest Salary  : " + rs.getDouble("highestSalary"));
                System.out.println("Lowest Salary   : " + rs.getDouble("lowestSalary"));
                System.out.println("============================");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateSalarySlip(int id) {

        String sql = "SELECT * FROM employees WHERE emp_id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String name = rs.getString("name");
                String department = rs.getString("department");
                String designation = rs.getString("designation");
                double basicSalary = rs.getDouble("basic_salary");

                double hra = basicSalary * 0.20;
                double da = basicSalary * 0.10;
                double pf = basicSalary * 0.12;
                double netSalary = basicSalary + hra + da - pf;

                System.out.println("\n======================================");
                System.out.println("        EMPLOYEE SALARY SLIP");
                System.out.println("======================================");
                System.out.println("Employee ID   : " + id);
                System.out.println("Name          : " + name);
                System.out.println("Department    : " + department);
                System.out.println("Designation   : " + designation);
                System.out.println("--------------------------------------");
                System.out.println("Basic Salary  : " + basicSalary);
                System.out.println("HRA (20%)     : " + hra);
                System.out.println("DA (10%)      : " + da);
                System.out.println("PF (12%)      : " + pf);
                System.out.println("--------------------------------------");
                System.out.println("Net Salary    : " + netSalary);
                System.out.println("======================================");

            } else {

                System.out.println("Employee Not Found!");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void showEmployeesByDepartment(String department) {

        String sql = "SELECT * FROM employees WHERE department = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, department);

            ResultSet rs = ps.executeQuery();

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("----------------------------------------");
                System.out.println("Employee ID   : " + rs.getInt("emp_id"));
                System.out.println("Name          : " + rs.getString("name"));
                System.out.println("Age           : " + rs.getInt("age"));
                System.out.println("Email         : " + rs.getString("email"));
                System.out.println("Mobile        : " + rs.getString("mobile"));
                System.out.println("Department    : " + rs.getString("department"));
                System.out.println("Designation   : " + rs.getString("designation"));
                System.out.println("Basic Salary  : " + rs.getDouble("basic_salary"));
                System.out.println("----------------------------------------");
            }

            if (!found) {
                System.out.println("No Employee Found in " + department + " Department.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void countEmployeesByDepartment(String department) {

        String sql = "SELECT COUNT(*) AS total FROM employees WHERE department = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, department);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("--------------------------------");
                System.out.println("Department : " + department);
                System.out.println("Total Employees : " + rs.getInt("total"));
                System.out.println("--------------------------------");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

