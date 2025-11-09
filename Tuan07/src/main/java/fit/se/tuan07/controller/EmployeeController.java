package fit.se.tuan07.controller;

import fit.se.tuan07.entity.Employee;
import fit.se.tuan07.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public String viewEmployees(Model model) {
        List<Employee> list = employeeRepository.findAll();
        model.addAttribute("employees", list);
        return "employees";
    }
}