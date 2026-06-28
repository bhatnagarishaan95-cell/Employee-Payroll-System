package org.example.validation;

public class EmployeeValidation {

    public boolean isValidName(String name) {

        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        return name.matches("[A-Za-z ]{3,}");
    }

    public boolean isValidAge(int age) {

        return age >= 18 && age <= 60;

    }

    public boolean isValidEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public boolean isValidMobile(String mobile) {

        if (mobile == null || mobile.trim().isEmpty()) {
            return false;
        }

        return mobile.matches("[6-9][0-9]{9}");
    }

    public boolean isValidDepartment(String department) {

        if (department == null || department.trim().isEmpty()) {
            return false;
        }

        return department.matches("[A-Za-z ]{2,30}");
    }

    public boolean isValidDesignation(String designation) {

        if (designation == null || designation.trim().isEmpty()) {
            return false;
        }

        return designation.matches("[A-Za-z ]{2,30}");
    }

    public boolean isValidSalary(double salary) {

        return salary >= 10000 && salary <= 1000000;
    }
}