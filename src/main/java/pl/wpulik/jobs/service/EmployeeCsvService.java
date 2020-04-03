package pl.wpulik.jobs.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.wpulik.jobs.model.Employee;

@Service
public class EmployeeCsvService {
	
	private EmployeeCsvParser csvParser;
	private List<Employee> employees = new ArrayList<>();
	
	public EmployeeCsvService(EmployeeCsvParser csvParser) {
		this.csvParser = csvParser;
	}

	private double salarySum (String job) {
		BigDecimal sum = BigDecimal.valueOf(0.0);
		employees = csvParser.getEmployeeData();
		for(Employee e: employees) {
			if(e.getJob().equals(job)) {
				sum = sum.add(BigDecimal.valueOf(e.getSalary())) ;
			};
		}
		double result = sum.doubleValue();
		return result;
	}
	
	public double teacherSummary() {
		return salarySum("Teacher");
	}
	
	public double janitorSummary() {
		return salarySum("Janitor");
	}
	
	public double priestSummary() {
		return salarySum("Priest");
	}
	
	
	public List <Employee> getAllEmployees(){
		return csvParser.getEmployeeData();
	}

}
