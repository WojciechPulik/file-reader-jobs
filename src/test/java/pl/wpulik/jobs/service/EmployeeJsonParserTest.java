package pl.wpulik.jobs.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeJsonParserTest {
	
	@Autowired
	EmployeeJsonParser jsonParser;
	
	@Test
	public void jsonObjTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
	NoSuchMethodException, SecurityException {
		assertNotNull(invokePrivateMethodJsonObj());
	}
	
	@Test
	public void GetEmployeeDataTest() {
		assertNotNull(jsonParser.getEmployeeData());
	}
	
	@Test
	public void GetEmployeeIdTest() {
		assertFalse(jsonParser.getEmployeeData().get(0).getId() == 0);
	}

	private JSONObject invokePrivateMethodJsonObj() throws IllegalAccessException, IllegalArgumentException, 
	InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> clazz = jsonParser.getClass();
		Method method = clazz.getDeclaredMethod("jsonObj");
		method.setAccessible(true);
		return (JSONObject) method.invoke(jsonParser);
	}

}
