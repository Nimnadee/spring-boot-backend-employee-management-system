package net.javaguides.ems.repository;


import net.javaguides.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Spring Data JPA will automatically implement basic CRUD operations
    // We can add custom query methods here if needed
}