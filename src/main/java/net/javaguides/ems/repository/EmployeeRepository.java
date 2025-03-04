package net.javaguides.ems.repository;
import net.javaguides.ems.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // JpaRepository provides basic CRUD operations
    // You can add custom query methods here if needed
}