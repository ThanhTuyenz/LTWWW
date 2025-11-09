package iuh.fit.se.repositories;

import iuh.fit.se.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "SELECT * FROM employee e WHERE e.first_name LIKE  %:keyword%"
            + " OR e.last_name LIKE %:keyword%"
            + " OR e.email LIKE  %:keyword%"
            + " OR e.phone_number LIKE  %:keyword%", nativeQuery = true)
    List<Employee> search(@Param("keyword") String keyword);
}
