package quanlynhansu;

public class Director extends Employee {
	double shares;
	
	public Director(String id, String name, String phoneNumber, int workingDays, int dailySalary, double shares ) {
		super(id, name, phoneNumber, workingDays, 300);
		this.shares = shares;
	}

	@Override
	public double calculateSalary() {
		return workingDays * dailySalary;
	}
	

}
