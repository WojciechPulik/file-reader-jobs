package pl.wpulik.jobs.service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeCsvServiceTest {
	
	@Autowired
	EmployeeCsvService csvService;
	
	@Test
	public void ServiceTeacherSummary() {
		assertNotNull(csvService.teacherSummary());
	}
	
	@Test
	public void ServiceJanitorSummary() {
		assertNotNull(csvService.janitorSummary());
	}
	
	@Test
	public void ServicePriestSummary() {
		assertNotNull(csvService.priestSummary());
	}
	
	@Test
	public void GetAllEmployee() {
		assertNotNull(csvService.getAllEmployees());
	}

}
