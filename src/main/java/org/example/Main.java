package org.example;

import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.example.validation.EmployeeValidation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeValidation validation = new EmployeeValidation();
        EmployeeService service = new EmployeeService();
        while (true) {
            System.out.println("\n===== Employee Payroll System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Report & Analytics");
            System.out.println("7. Generate Salary Slip");
            System.out.println("8. Show Employees by Department");
            System.out.println("9. Count Employees by Department");
            System.out.println("10. Exit");
            try {
                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1: {
                        // Paste your complete Add Employee code here
                        System.out.print("Enter Employee ID : ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Employee Name : ");
                        String name = sc.nextLine();

                        if (!validation.isValidName(name)) {
                            System.out.println("Invalid Name!");
                            return;
                        }

                        System.out.print("Enter Employee Age : ");
                        int age = sc.nextInt();
                        sc.nextLine();

                        if (!validation.isValidAge(age)) {
                            System.out.println("Invalid Age!");
                            return;
                        }

                        System.out.print("Enter Employee Email : ");
                        String email = sc.nextLine();

                        if (!validation.isValidEmail(email)) {
                            System.out.println("Invalid Email!");
                            return;
                        }

                        System.out.print("Enter Employee Mobile : ");
                        String mobile = sc.nextLine();

                        if (!validation.isValidMobile(mobile)) {
                            System.out.println("Invalid Mobile Number!");
                            return;
                        }

                        System.out.print("Enter Employee Department : ");
                        String department = sc.nextLine();

                        if (!validation.isValidDepartment(department)) {
                            System.out.println("Invalid Department!");
                            return;
                        }

                        System.out.print("Enter Employee Designation : ");
                        String designation = sc.nextLine();

                        if (!validation.isValidDesignation(designation)) {
                            System.out.println("Invalid Designation!");
                            return;
                        }

                        System.out.print("Enter Basic Salary : ");
                        double salary = sc.nextDouble();

                        if (!validation.isValidSalary(salary)) {
                            System.out.println("Invalid Salary!");
                            return;
                        }

                        Employee employee = new Employee(
                                id,
                                name,
                                age,
                                email,
                                mobile,
                                department,
                                designation,
                                salary
                        );

                        service.addEmployee(employee);
                        break;
                    }
                    case 2: {

                        System.out.println("========== All Employees ==========");

                        service.viewAllEmployees();
                        break;
                    }
                    case 3: {

                        System.out.print("Enter Employee ID : ");
                        int id = sc.nextInt();

                        service.searchEmployee(id);
                        break;
                    }
                    case 4: {

                        System.out.print("Enter Employee ID to Update : ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Employee Name : ");
                        String name = sc.nextLine();
                        if (!validation.isValidName(name)) {
                            System.out.println("Invalid Name!");
                            return;
                        }

                        System.out.print("Enter Employee Age : ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        if (!validation.isValidAge(age)) {
                            System.out.println("Invalid Age!");
                            return;
                        }

                        System.out.print("Enter Employee Email : ");
                        String email = sc.nextLine();
                        if (!validation.isValidEmail(email)) {
                            System.out.println("Invalid Email!");
                            return;
                        }

                        System.out.print("Enter Employee Mobile : ");
                        String mobile = sc.nextLine();
                        if (!validation.isValidMobile(mobile)) {
                            System.out.println("Invalid Mobile Number!");
                            return;
                        }

                        System.out.print("Enter Employee Department : ");
                        String department = sc.nextLine();
                        if (!validation.isValidDepartment(department)) {
                            System.out.println("Invalid Department!");
                            return;
                        }

                        System.out.print("Enter Employee Designation : ");
                        String designation = sc.nextLine();
                        if (!validation.isValidDesignation(designation)) {
                            System.out.println("Invalid Designation!");
                            return;
                        }

                        System.out.print("Enter Basic Salary : ");
                        double salary = sc.nextDouble();
                        if (!validation.isValidSalary(salary)) {
                            System.out.println("Invalid Salary!");
                            return;
                        }

                        Employee employee = new Employee(
                                id,
                                name,
                                age,
                                email,
                                mobile,
                                department,
                                designation,
                                salary
                        );

                        service.updateEmployee(employee);

                        System.out.println("Employee Updated Successfully!");
                        break;
                    }
                    case 5: {

                        System.out.print("Enter Employee ID to Delete : ");
                        int id = sc.nextInt();

                        service.deleteEmployee(id);
                        break;
                    }
                    case 6: {
                        service.showReport();
                        break;
                    }
                    case 7: {
                        System.out.print("Enter Employee ID : ");
                        int id = sc.nextInt();

                        service.generateSalarySlip(id);
                        break;
                    }
                    case 8: {
                        System.out.print("Enter Department: ");
                        String department = sc.nextLine();

                        service.showEmployeesByDepartment(department);
                        break;
                    }
                    case 9: {

                        System.out.print("Enter Department : ");
                        String department = sc.nextLine();

                        service.countEmployeesByDepartment(department);

                        break;
                    }
                    case 10: {
                        System.out.println("Thank You!");
                        sc.close();
                        return;
                    }
                    default: {
                        System.out.println("Invalid Choice!");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("please enter a valid number.");
                sc.nextLine();
            }

        }

    }
}

