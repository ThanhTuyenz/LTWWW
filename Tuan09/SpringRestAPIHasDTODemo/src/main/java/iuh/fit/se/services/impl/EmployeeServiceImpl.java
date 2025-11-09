package iuh.fit.se.services.impl;

import iuh.fit.se.dtos.EmployeeDTO;
import iuh.fit.se.entities.Employee;
import iuh.fit.se.exceptions.ItemNotFoundException;
import iuh.fit.se.exceptions.ValidationException;
import iuh.fit.se.repositories.EmployeeRepository;
import iuh.fit.se.services.EmployeeService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.modelmapper.ModelMapper;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	EmployeeRepository employeeRepository;
	ModelMapper modelMapper;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
		this.employeeRepository = employeeRepository;
		this.modelMapper = modelMapper;
	}

	private EmployeeDTO convertToDTO(Employee employee) {
		EmployeeDTO employeeDTO= modelMapper.map(employee, EmployeeDTO.class);
		return employeeDTO;
	}

	private Employee convertToEntity(EmployeeDTO employeeDTO) {
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		return employee;
	}

	@Override
	public EmployeeDTO findById(int id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(()-> new ItemNotFoundException("Can not find Employee with id: " + id));

		return this.convertToDTO(employee);
	}

	@Override
	public List<EmployeeDTO> findAll() {
		return employeeRepository.findAll().stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
	
	@Override
	public Page<EmployeeDTO> findAllWithPaging(@ParameterObject Pageable pageable) {
		return employeeRepository.findAll(pageable).map(this::convertToDTO);
	}

	@Transactional
	@Override
	public EmployeeDTO save(EmployeeDTO employeeDTO) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<EmployeeDTO>> violations = validator.validate(employeeDTO);

		if(!violations.isEmpty()) {
			Map<String, Object> errors = new LinkedHashMap<>();
			violations.forEach(violation -> {
				errors.put(violation.getPropertyPath().toString(), violation.getMessage());
			});

			throw new ValidationException("An error occurred while adding the employee", errors);
		}
		else {
			employeeRepository.save(convertToEntity(employeeDTO));
		}

		return employeeDTO;
	}

	@Override
	public EmployeeDTO update(int id, Employee employee) {
		this.findById(id);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Employee>> violations = validator.validate(employee);

		if(!violations.isEmpty()) {
			Map<String, Object> errors = new LinkedHashMap<String, Object>();
			violations.forEach(violation -> {
				errors.put(violation.getPropertyPath().toString(), violation.getMessage());
			});

			throw new ValidationException("An error occurred while adding the employee", errors);
		}
		else {
			employee.setId(id);
			employeeRepository.save(employee);
		}

		return this.convertToDTO(employee);
	}

	@Override
	public boolean delete(int id) {
		EmployeeDTO employee = this.findById(id);
		employeeRepository.deleteById(employee.getId());
		return true;
	}
	
	@Override
	public List<EmployeeDTO> search(String keyword) {
		return employeeRepository.search(keyword).stream()
				.map(this::convertToDTO)
				.collect(Collectors.toList());
	}
}
