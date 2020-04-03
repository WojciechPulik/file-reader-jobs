package pl.wpulik.jobs.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeCsvParserTest {
	
	@Autowired
	EmployeeCsvParser csvParser;
	
	@Test
	public void GetEmployeeDataTest() {
		assertNotNull(csvParser.getEmployeeData());
	}
	
	@Test
	public void GetEmployeeIdTest() {
		assertFalse(csvParser.getEmployeeData().get(0).getId() == 0);
	}

}
