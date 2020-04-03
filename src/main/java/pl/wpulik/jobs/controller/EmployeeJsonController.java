package pl.wpulik.jobs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.wpulik.jobs.model.Employee;
import pl.wpulik.jobs.service.EmployeeJsonService;

@Controller
public class EmployeeJsonController {
	
	private EmployeeJsonService jsonService;
	private List<Employee> allEmpl;
	

	public EmployeeJsonController(EmployeeJsonService jsonService) {
		this.jsonService = jsonService;
	}

	@GetMapping("/alljson")
	public String test(Model model) {
		allEmpl = new ArrayList<>();
		allEmpl = jsonService.getAllEmployees();
		model.addAttribute("employees", allEmpl);
		model.addAttribute("file", "JSON");
		return "allemployee";
	}
	
	@GetMapping("/jsonsalary")
	public String jsonTeachersSalary(Model model) {
		double teachers = jsonService.teacherSummary();
		double janitors = jsonService.janitorSummary();
		double priests = jsonService.priestSummary();
		model.addAttribute("teachers", teachers);
		model.addAttribute("janitors", janitors);
		model.addAttribute("priests", priests);
		model.addAttribute("file", "JSON");
		return "salary";
	}
}
