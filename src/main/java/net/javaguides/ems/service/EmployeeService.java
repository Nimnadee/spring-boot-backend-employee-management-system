package net.javaguides.ems.service;


import net.javaguides.ems.model.dto.request.EmployeeRequest;
import  net.javaguides.ems.model.dto.response.EmployeeResponse;
import java.util.List;

public interface EmployeeService {

    // Create a new employee
    EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

    // Get all employees
    List<EmployeeResponse> getAllEmployees();

    // Get employee by ID
    EmployeeResponse getEmployeeById(Long id);

    // Update employee
    EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest);

    // Delete employee
    void deleteEmployee(Long id);
}
