package org.example.model;

public class Employee {


    private int empId;
    private String name;
    private int age;
    private String email;
    private String mobile;
    private String department;
    private String designation;
    private double basicSalary;

    public Employee(int empId, String name, int age, String email, String mobile, String department, String designation, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.mobile = mobile;
        this.department = department;
        this.designation = designation;
        this.basicSalary = basicSalary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

}
