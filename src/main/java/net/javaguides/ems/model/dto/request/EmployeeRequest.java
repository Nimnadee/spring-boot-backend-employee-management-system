package net.javaguides.ems.model.dto.request;

import java.time.LocalDate;

public class EmployeeRequest {

    private String employeeName;
    private Double salary;
    private LocalDate dob;

    // Default constructor
    public EmployeeRequest() {
    }

    // Parameterized constructor
    public EmployeeRequest(String employeeName, Double salary, LocalDate dob) {
        this.employeeName = employeeName;
        this.salary = salary;
        this.dob = dob;
    }

    // Getters and Setters
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
