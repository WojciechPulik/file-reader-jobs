package pl.wpulik.jobs.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import pl.wpulik.jobs.model.Employee;

@Service
public class EmployeeCsvParser {
	
	private static String path = "src/main/resources/files/employees (2) (1).csv";
	
	private String dataPrepare (String lines) {
		String prepared = lines
				.replace(',', '.')
				.replace(';', ',')
				.replace('"', ' ')
				.replace(" ","");
		return prepared;
	}
	
	private String csvReader() {
		String lines = "";
		String prepared = "";
		String allFile = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while(true) {
				lines = br.readLine();
				if(lines == null) {
					break;
				}
				prepared = dataPrepare(lines);
				allFile = allFile + prepared + "\n";	
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return allFile;
	}
	
	public List<Employee> getEmployeeData(){
		List<Employee> employees = new ArrayList<>();
		String values = csvReader();
		
		StringReader stringReader = new StringReader(values);
		try {
			CSVParser parse = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);
			for(CSVRecord s: parse) {
				long id = Long.parseLong(s.get("id"));
				String name = s.get("name");
				String surname = s.get("surname");
				String job = s.get("job");
				double salary = Double.parseDouble(s.get("salary"));
				employees.add(new Employee(id, name, surname, job, salary));			
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return employees;
	}

}
