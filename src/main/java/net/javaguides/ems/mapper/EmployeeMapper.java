package net.javaguides.ems.mapper;
import net.javaguides.ems.model.dto.request.EmployeeRequest;
import net.javaguides.ems.model.dto.response.EmployeeResponse;
import net.javaguides.ems.model.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    // Convert Entity to DTO
    public EmployeeResponse employeeToEmployeeResponseDto(Employee employee) {
        return new EmployeeResponse(
                employee.getEmployeeId(),
                employee.getEmployeeName(),
                employee.getSalary(),
                employee.getDob()
        );
    }

    // Convert DTO to Entity
    public Employee employeeRequestDtoToEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setEmployeeName(employeeRequest.getEmployeeName());
        employee.setSalary(employeeRequest.getSalary());
        employee.setDob(employeeRequest.getDob());
        return employee;
    }

    // Update Entity from DTO
    public void updateEmployeeFromRequestDto(EmployeeRequest employeeRequest, Employee employee) {
        employee.setEmployeeName(employeeRequest.getEmployeeName());
        employee.setSalary(employeeRequest.getSalary());
        employee.setDob(employeeRequest.getDob());
    }
}

