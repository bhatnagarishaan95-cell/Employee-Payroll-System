package org.example.service;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;

public class EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    public void viewAllEmployees() {
        employeeDAO.viewAllEmployees();
    }

    public void searchEmployee(int empId) {
        employeeDAO.searchEmployee(empId);
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(int empId) {
        employeeDAO.deleteEmployee(empId);
    }

    public void showReport() {
        employeeDAO.showReport();
    }

    public void generateSalarySlip(int id) {
        employeeDAO.generateSalarySlip(id);
    }

    public void showEmployeesByDepartment(String department) {
        employeeDAO.showEmployeesByDepartment(department);
    }

    public void countEmployeesByDepartment(String department) {
        employeeDAO.countEmployeesByDepartment(department);
    }
}
