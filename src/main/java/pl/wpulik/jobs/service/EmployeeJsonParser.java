package pl.wpulik.jobs.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import pl.wpulik.jobs.model.Employee;
import pl.wpulik.jobs.model.TempObj;

@Service
public class EmployeeJsonParser {
	
	private static String path = "src/main/resources/files/employees (2) (1).json";
	
	
	private JSONObject jsonObj() throws Exception{
		File f = new File(path);
		JSONObject json = null;
        if (f.exists()){
            InputStream is = new FileInputStream(path);
            String jsonTxt = IOUtils.toString(is, "UTF-8");
            json = new JSONObject(jsonTxt);                 
        }  
        return json;
	}
	
	public List<Employee> getEmployeeData(){
		ObjectMapper mapper = new ObjectMapper();
		List<Employee> resultList = new ArrayList<>();
		List<TempObj> list = new ArrayList<>();
        String jsonString = "";
        
		try {
			jsonString = jsonObj().getJSONArray("employees").toString();
		} catch (JSONException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
  		try {
			list = Arrays.asList(mapper.readValue(jsonString, TempObj[].class));
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
        
        for(TempObj e: list) {
        	resultList.add(new Employee(
        			e.getId(), 
        			e.getName(), 
        			e.getSurname(), 
        			e.getJob(), 
        			Double.parseDouble(e.getSalary().replace(',', '.').replace('"', ' ')))
        			);
        }
        return resultList;
	}
	
	
}







