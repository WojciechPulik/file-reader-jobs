package pl.wpulik.jobs.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.wpulik.jobs.model.Employee;

@Service
public class EmployeeJsonService {
	
	private EmployeeJsonParser jsonParser;
	private List<Employee> employees = new ArrayList<>();
	
	public EmployeeJsonService(EmployeeJsonParser jsonParser) {
		this.jsonParser = jsonParser;
	}

	private double salarySum (String job) {
		BigDecimal sum = BigDecimal.valueOf(0.0);
		employees = jsonParser.getEmployeeData();
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
		return jsonParser.getEmployeeData();
	}

}
