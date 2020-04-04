package pl.wpulik.jobs.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeCsvParserTest {
	
	@Autowired
	EmployeeCsvParser csvParser;
	
	@Test
	public void csvReaderTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException {
		assertNotNull(invokePrivateMethodcsvReader());
	}
	
	@Test
	public void GetEmployeeDataTest() {
		assertNotNull(csvParser.getEmployeeData());
	}
	
	@Test
	public void GetEmployeeIdTest() {
		assertFalse(csvParser.getEmployeeData().get(0).getId() == 0);
	}
	
	
	private String invokePrivateMethodcsvReader() throws IllegalAccessException, IllegalArgumentException, 
	InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> clazz = csvParser.getClass();
		Method method = clazz.getDeclaredMethod("csvReader");
		method.setAccessible(true);
		return (String) method.invoke(csvParser);
	}

}
