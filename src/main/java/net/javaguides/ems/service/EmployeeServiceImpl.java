package net.javaguides.ems.service;

import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.model.dto.request.EmployeeRequest;
import net.javaguides.ems.model.dto.response.EmployeeResponse;
import net.javaguides.ems.model.entity.Employee;
import net.javaguides.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    @Transactional
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.employeeRequestDtoToEmployee(employeeRequest);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeResponseDto(savedEmployee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employeeMapper::employeeToEmployeeResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return employeeMapper.employeeToEmployeeResponseDto(employee);
    }

    @Override
    @Transactional
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        employeeMapper.updateEmployeeFromRequestDto(employeeRequest, employee);
        Employee updatedEmployee = employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeResponseDto(updatedEmployee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}