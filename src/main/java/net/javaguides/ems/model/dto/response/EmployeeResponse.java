package net.javaguides.ems.model.dto.response;

import java.time.LocalDate;

public class EmployeeResponse {

    private Long employeeId;
    private String employeeName;
    private Double salary;
    private LocalDate dob;

    // Default constructor
    public EmployeeResponse() {
    }

    // Parameterized constructor
    public EmployeeResponse(Long employeeId, String employeeName, Double salary, LocalDate dob) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.dob = dob;
    }

    // Getters and Setters
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

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
