package pl.wpulik.jobs.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.wpulik.jobs.model.Employee;
import pl.wpulik.jobs.service.EmployeeCsvService;

@Controller
public class EmployeeCsvController {
	
	private EmployeeCsvService csvService;
	private List<Employee> allEmpl;

	
	public EmployeeCsvController(EmployeeCsvService csvService) {
		this.csvService = csvService;
	}

	@GetMapping("/csvsalary")
	public String csvTeachersSalary(Model model) {
		double teachers = csvService.teacherSummary();
		double janitors = csvService.janitorSummary();
		double priests = csvService.priestSummary();
		model.addAttribute("teachers", teachers);
		model.addAttribute("janitors", janitors);
		model.addAttribute("priests", priests);
		model.addAttribute("file", "CSV");
		return "salary";
	}
	
	@GetMapping("/allcsv")
	public String allCsvEmployees(Model model){
		allEmpl = new ArrayList<>();
		allEmpl = csvService.getAllEmployees();
		model.addAttribute("employees", allEmpl);
		model.addAttribute("file", "CSV");
		return "allemployee";
	}

}
