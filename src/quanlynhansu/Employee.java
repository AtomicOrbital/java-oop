package quanlynhansu;

public abstract class Employee {
	String id;
	String name;
	String phoneNumber;
	int workingDays;
	int dailySalary;
	
	public Employee(String id, String name, String phoneNumber, int workingDays, int dailySalary) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.workingDays = workingDays;
		this.dailySalary = dailySalary;
	}
	
	public abstract double calculateSalary();
}
