package iuh.fit.se.services;

import iuh.fit.se.dtos.EmployeeDTO;
import iuh.fit.se.entities.Employee;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

	public EmployeeDTO findById(int id);
	public List<EmployeeDTO> findAll();
	public Page<EmployeeDTO> findAllWithPaging(@ParameterObject Pageable pageable);

    public EmployeeDTO save(EmployeeDTO employeeDTO);

    public EmployeeDTO update(int id, Employee employee);
	public boolean delete(int id);
	public List<EmployeeDTO> search(String keyword);
}
