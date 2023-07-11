package quanlynhansu;

public class Staff extends Employee {
	Manager manager;
	
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Staff(String id, String name, String phoneNumber, int workingDays, int dailySalary) {
		super(id, name, phoneNumber, workingDays, 100);
		
	}

	@Override
	public double calculateSalary() {
		return workingDays * dailySalary;
	}
	
}
