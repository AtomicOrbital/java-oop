package quanlynhansu;

import java.util.*;

public class Company {
	 String companyName;
	 String taxCode;
	 double revenue;
	 List<Employee> employees;

	public Company(String name, String taxCode, double revenue) {
		this.companyName = name;
		this.taxCode = taxCode;
		this.revenue = revenue;
		employees = new ArrayList<>();
	}
	
	
	
	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getTaxCode() {
		return taxCode;
	}



	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}



	public double getRevenue() {
		return revenue;
	}



	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}



	public List<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}



	public void addEmployee(Employee employee) {
		this.employees.add(employee);
		if(employee instanceof Staff) {
			Staff staff = (Staff) employee;
			if(staff.manager != null) {
				staff.manager.addSubordinates(staff);
			}
		}
	}
	
	public void removeEmployee(String employeeId) {
		Employee toRemove = null;
		for(Employee employee : employees) {
			if(employee.id.equals(employeeId)) {
				toRemove = employee;
				break;
			}
		}
		
		if(toRemove == null) {
			System.out.println("Không tìm thấy nhân viên với ID: " + employeeId);
		}
		
		if(toRemove	instanceof Manager) {
			Manager managerToRemove = (Manager) toRemove;
			for(Employee employee : employees) {
				if(employee instanceof Staff) {
					Staff staff = (Staff) employee;
					if(staff.manager == toRemove) {
						staff.manager = null;
					}
				}
			}
		}
		
		if(toRemove instanceof Staff) {
			Staff staffToRemove = (Staff) toRemove;
			if(staffToRemove.manager != null) {
				staffToRemove.manager.subordinates.remove(staffToRemove);
			}
		}
		employees.remove(toRemove);
		System.out.println("Đã xóa nhân viên với ID: " + toRemove);
	}
	
	public double calculateTotalSalary() {
		double totalSalary = 0;
		for(Employee employee:employees) {
			totalSalary += employee.calculateSalary();
		}
		return totalSalary;
	}
	
	public void findHighestSalaryStaff() {
		Staff highestSalaryStaff = null;
		double maxSalary = 0;
		
		for(Employee employee:employees) {
			if(employee instanceof Staff) {
				Staff staff = (Staff) employee;
				double salary = staff.calculateSalary();
				if(salary > maxSalary) {
					highestSalaryStaff = staff;
					maxSalary = salary;
				}
			}
		}
		if(highestSalaryStaff != null) {
			System.out.println("Nhân viên thường có lương cao nhất: " + highestSalaryStaff + ", lương" + maxSalary);		
		} else {
			System.out.println("Không có nhân viên thường nào trong công ty");
		}
	}
	
	public void findManagerWithMostSubordinates() {
		Manager managerWithMostSubordinates = null;
		int maxSubordinates = 0;
		
		for(Employee employee : employees) {
			if(employee instanceof Manager) {
				Manager manager = (Manager) employee;
				int numberOfSubordinates = manager.subordinates.size();
				if(numberOfSubordinates > maxSubordinates) {
					maxSubordinates = numberOfSubordinates;
					managerWithMostSubordinates = manager;
				}
			}
		}
		if(managerWithMostSubordinates != null) {
			System.out.println("Trường phòng có số lượng nhân viên nhiều nhất " + managerWithMostSubordinates.name + ", số nhân viên: " + maxSubordinates);
		} else {
			System.out.println("Không có trường phòng nào trong công ty");
		}
	}
	
	public void sortEmployeesByNameCompany() {
		for(int i=0; i<employees.size() - 1; i++) {
			int smallestNameIndex = i;
			
			for(int j=i+1; j < employees.size(); j++) {
				String currentName = employees.get(j).name;
				String smallestName = employees.get(smallestNameIndex).name;
				
				// Nếu nhân viên hiện tại nhỏ hơn, cập nhật smallestNameIndex
				if(currentName.compareTo(smallestName) < 0) {
					smallestNameIndex = j; 
				}
			}
			Collections.swap(employees, i, smallestNameIndex);
		}
	}
	
	public void sortEmployeesSalaryByDecending() {
		for(int i=0; i<employees.size()-1; i++) {
			int highestSalaryIndex = i;
			
			for(int j = i + 1; j < employees.size(); j++) {
				double currentSalary = employees.get(j).calculateSalary();
				double highestSalary = employees.get(highestSalaryIndex).calculateSalary();
				
				// Nếu nhân viên hiện tại lương cao hơn, cập nhật highestSalary
				if(currentSalary > highestSalary) {
					highestSalaryIndex = j;
				}
			}
			Collections.swap(employees, i, highestSalaryIndex);		
		}
	}
	
	
	public void sortEmployeesBySalaryDescending() {
		for(int i=0; i<employees.size() - 1; i++) {
			int maxSalaryIndex = i;
			
			for(int j = i + 1; j < employees.size(); j++) {
				double currentSalary = employees.get(j).calculateSalary();
				double maxSalary = employees.get(maxSalaryIndex).calculateSalary();
				
				if(currentSalary > maxSalary) {
					maxSalaryIndex = j;
				}
			}
			Collections.swap(employees, i, maxSalaryIndex);
		}		
	}
	
	public void findDirectorMostShares() {
		Director directorWithMostShares = null;
		double maxShares = 0;
		
		for(Employee employee : employees) {
			if(employee instanceof Director) {
				Director director = (Director) employee;
				if(director.shares > maxShares) {
					maxShares = director.shares;
					directorWithMostShares = director;
				}
			}
		}
		
		if(directorWithMostShares != null) {
			System.out.println("Giám đốc có cổ phần cao nhất : " + directorWithMostShares + " với số cổ phần : " + maxShares);
		} else {
			System.out.println("Không có giám đốc nào trong công ty");
		}
	}
	
	public void calculateAndPrintDirectorIncome() {
		// Tính lợi nhuận công ty
		double totalSalary = 0;
		for(Employee employee:employees) {
			totalSalary += employee.calculateSalary();
		}
		double profit = revenue - totalSalary;
		
		//Tinh va in giam doc
		for(Employee employee : employees) {
			if(employee instanceof Director) {
				Director director = (Director) employee;
				double income = director.calculateSalary() + ((director.shares/100) * profit);
				System.out.println("Giám đốc " + director.name + " có thu nhập là: " + income);
			}
		}
	}
	
	public void displayEmployees() {
		for(Employee employee:employees) {
			System.out.println("ID: " + employee.id);
			System.out.println("Name: " + employee.name);
			System.out.println("Phone Number: " + employee.phoneNumber);
			System.out.println("Working Days: " + employee.workingDays);
			System.out.println("Daily Salary: " + employee.dailySalary);
			System.out.println("Caculated Salary: " + employee.calculateSalary());
			if(employee instanceof Staff) {
				Staff staff = (Staff) employee;
				System.out.println(staff.id + " " + staff.name + " " + staff.phoneNumber + " " + staff.workingDays + " " + staff.dailySalary + " " + staff.calculateSalary());
			} else if(employee instanceof Manager) {
				Manager manager = (Manager) employee;
				System.out.println(manager.id + " " + manager.name + " " + manager.phoneNumber + " " + manager.workingDays + " " + manager.dailySalary + " " + manager.calculateSalary());
			} else if(employee instanceof Director) {
				
				Director director = (Director) employee;
				System.out.println(director.id + " " + director.name + " " + director.phoneNumber + " " + director.workingDays + " " + director.dailySalary + " " + director.calculateSalary());
			}
			System.out.println();
		}
	}
}
