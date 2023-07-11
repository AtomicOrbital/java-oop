package quanlynhansu;

import java.util.*;

public class Manager extends Employee {
	List<Staff> subordinates;
	
	public Manager(String id, String name, String phoneNumber, int workingDays, int dailySalary) {
		super(id, name, phoneNumber, workingDays, 200);
		this.subordinates = new ArrayList<>();
	}
	
	public void addSubordinates (Staff staff) {
		this.subordinates.add(staff);
	}

	@Override
	public double calculateSalary() {
		return dailySalary * workingDays + 100 * subordinates.size();
	}
	
	public void displaySubordinates() {
        System.out.println("Trưởng phòng " + this.name + " có các nhân viên dưới quyền:");
        for(Staff s : this.subordinates) {
            System.out.println(" - " + s.name);
        }
    }
}
