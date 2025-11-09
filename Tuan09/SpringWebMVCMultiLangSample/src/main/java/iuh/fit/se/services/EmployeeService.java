package iuh.fit.se.services;

import iuh.fit.se.entities.Employee;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

	public Optional<Employee> findById(int id);

	public List<Employee> findAll();

	public Employee save(Employee employee);

	public Employee update(int id, Employee employee);

	public int delete(int id);
	
	public List<Employee> search(String keyword);

	public Page<Employee> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection);
}
