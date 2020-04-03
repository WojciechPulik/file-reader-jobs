package pl.wpulik.jobs.model;

public class TempObj {
	private long id;
	String name;
	String surname;
	String job;
	String salary;
	
	public TempObj() {}

	public TempObj(long id, String name, String surname, String job, String salary) {
		super();
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "TempObj [id=" + id + ", name=" + name + ", surname=" + surname + ", job=" + job + ", salary=" + salary
				+ "]";
	}
	
	
	
	
}
