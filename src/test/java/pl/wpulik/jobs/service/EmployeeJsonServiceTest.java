package pl.wpulik.jobs.service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeJsonServiceTest {
	
	@Autowired
	EmployeeJsonService jsonService;
	
	@Test
	public void ServiceTeacherSummary() {
		assertNotNull(jsonService.teacherSummary());
	}
	
	@Test
	public void ServiceJanitorSummary() {
		assertNotNull(jsonService.janitorSummary());
	}
	
	@Test
	public void ServicePriestSummary() {
		assertNotNull(jsonService.priestSummary());
	}
	
	@Test
	public void GetAllEmployee() {
		assertNotNull(jsonService.getAllEmployees());
	}
}
