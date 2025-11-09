package iuh.fit.se.controllers;

import iuh.fit.se.dtos.EmployeeDTO;
import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

//@RepositoryRestController
@RestController
//@RepositoryRestController
public class EmployeeController {

	private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees/{id}")
	public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable int id) {

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("status", HttpStatus.OK.value());
		response.put("data", employeeService.findById(id));

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
//	@PostMapping("/employees")
//	public ResponseEntity<Map<String, Object>> saveEmployee(@Valid @RequestBody Employee employee,
//			BindingResult bindingResult) {
//		Map<String, Object> response = new LinkedHashMap<String, Object>();
//
//		if (bindingResult.hasErrors()) {
//			Map<String, Object> errors = new LinkedHashMap<String, Object>();
//			bindingResult.getFieldErrors().stream().forEach(result -> {
//				errors.put(result.getField(), result.getDefaultMessage());
//			});
//
//			response.put("status", HttpStatus.BAD_REQUEST.value());
//			response.put("errors", errors);
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//		}
//		else {
//			response.put("status", HttpStatus.OK.value());
//			response.put("data", employeeService.save(employee));
//			return ResponseEntity.status(HttpStatus.OK).body(response);
//		}
//
//	}

    @PostMapping("/employees")
    public ResponseEntity<Map<String, Object>> saveEmployee(
            @RequestBody EmployeeDTO employeeDTO) {
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("status", HttpStatus.OK.value());
        response.put("data", employeeService.save(employeeDTO));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Map<String, Object>> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("status", HttpStatus.OK.value());
        response.put("data", employeeService.update(id, employee));
        return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable int id) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("status", HttpStatus.OK.value());
		response.put("data", employeeService.delete(id));
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<Map<String, Object>> getEmployees(
			@RequestParam(required = false) String keyword) {
		
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("status", HttpStatus.OK.value());
		
		if (keyword == null || keyword.isEmpty()) {
			response.put("data", employeeService.findAll());
		}
		else {
			response.put("data", employeeService.search(keyword));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	// GET http://localhost:8081/api/employeesHasPage?page=0&size=3&sort=firstName,asc
	@GetMapping("/employeesHasPage")
	public ResponseEntity<Page<EmployeeDTO>> getEmployees(@ParameterObject Pageable pageable) {
		Page<EmployeeDTO> response = employeeService.findAllWithPaging(pageable);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}
}
