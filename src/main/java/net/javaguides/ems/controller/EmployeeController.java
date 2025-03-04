package net.javaguides.ems.controller;
import net.javaguides.ems.model.dto.request.EmployeeRequest;
import net.javaguides.ems.model.dto.response.EmployeeResponse;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000") // For React frontend
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Create a new employee
    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        EmployeeResponse newEmployee = employeeService.createEmployee(employeeRequest);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    // Get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        List<EmployeeResponse> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id) {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Update employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
        EmployeeResponse updatedEmployee = employeeService.updateEmployee(id, employeeRequest);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
