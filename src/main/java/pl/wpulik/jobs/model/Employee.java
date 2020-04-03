package pl.wpulik.jobs.model;

public class Employee {
	
	private long id;
	String name;
	String surname;
	String job;
	double salary;
	
	public Employee() {}

	public Employee(long id, String name, String surname, String job, double salary) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.job = job;
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	

}
