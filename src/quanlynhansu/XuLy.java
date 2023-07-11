package quanlynhansu;

import java.util.*;

public class XuLy {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Company company = null;

		while (true) {
			System.out.println("1. Nhập thông tin tên công ty ");
			System.out.println("2. Phân bổ nhân viên vào trưởng phòng ");
			System.out.println("3. Thêm thông tin nhân sự ");
			System.out.println("4. Xóa thông tin nhân sự ");
			System.out.println("5. Xuất ra thông tin toàn bộ người trong công ty ");
			System.out.println("6. Tính và xuất tổng lương cho toàn công ty ");
			System.out.println("7. Tìm nhân viên thường có lương cao nhất ");
			System.out.println("8. Tìm trường phòng có số lượng nhân viên dưới quyền nhiều nhất ");
			System.out.println("9. Sắp xếp nhân viên công ty theo thứ tự abc");
			System.out.println("10. Sắp xếp nhân viên công ty theo thứ tự lương giảm dần ");
			System.out.println("11. Tính giám đốc có số lượng cổ phần nhiều nhất ");
			System.out.println("12. Tính và xuất tổng thu nhập từng giám đốc ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:

				System.out.print("Nhập tên công ty: ");
				String companyName = scanner.nextLine();
				System.out.print("Nhập mã số thuế: ");
				String taxCode = scanner.nextLine();
				System.out.print("Nhập doanh thu của công ty: ");
				double revenue = scanner.nextDouble();
				company = new Company(companyName, taxCode, revenue);

				System.out.println("\nThông tin công ty đã được cập nhật:");
				System.out.println("Tên công ty: " + company.getCompanyName());
				System.out.println("Mã số thuế: " + company.getTaxCode());
				System.out.println("Doanh thu: " + company.getRevenue());

				break;
			case 2:
				if (company == null) {
					System.out.println("Vui lòng tạo thông tin công ty trước");
				} else {
					System.out.print("Nhập ID của trường phòng: ");
					String managerId = scanner.nextLine();

					Manager manager = null;
					for (Employee employee : company.getEmployees()) {
						if (employee.id.equals(managerId) && employee instanceof Manager) {
							manager = (Manager) employee;
							break;
						}
					}
					if (manager == null) {
						System.out.println("Không tìm thấy trường phòng");
						break;
					}

					System.out.println("Nhập vào ID của nhân viên: ");
					String staffId = scanner.nextLine();

					Staff staff = null;
					for (Employee employee : company.getEmployees()) {
						if (employee.id.equals(staffId) && employee instanceof Staff) {
							staff = (Staff) employee;
							break;
						}
					}

					if (staff == null) {
						System.out.println("Không tìm thấy nhân viên");
						break;
					}
					// Thêm nhân viên vào danh sách dưới quyền manager
					manager.addSubordinates(staff);

					staff.manager = manager;
					System.out.println("Danh sách nhân viên được thêm dưới quyền trưởng phòng");
					manager.displaySubordinates();
				}

				break;
			case 3:
				if (company == null) {
					System.out.println("Vui lòng tạo thông tin công ty trước");
					System.out.println();
				} else {
					System.out.println("Nhập ID nhân sự: ");
					String id = scanner.nextLine();
					System.out.println("Nhập họ tên nhân sự: ");
					String name = scanner.nextLine();
					System.out.println("Nhập số điện thoại nhân sự: ");
					String phoneNumber = scanner.nextLine();
					System.out.println("Nhập số ngày làm việc: ");
					int workingDays = scanner.nextInt();
					scanner.nextLine();

					System.out.println("Nhân sự này là ? staff/manager/director");
					String typeEmployee = scanner.nextLine();
					switch (typeEmployee.toLowerCase()) {
					case "staff":
						Staff staff = new Staff(id, name, phoneNumber, workingDays, 100);
						company.addEmployee(staff);
						break;
					case "manager":
						Manager manager = new Manager(id, name, phoneNumber, workingDays, 200);
						company.addEmployee(manager);
						break;
					case "director":
						System.out.println("Nhập số cổ phần: ");
						int shares = scanner.nextInt();
						scanner.nextLine();
						Director director = new Director(id, name, phoneNumber, workingDays, 300, shares);
						company.addEmployee(director);
						break;
					default:
						System.out.println("Lựa chọn không hợp lệ");
						break;
					}				
				}
				break;
			case 4:
				if (company == null) {
					System.out.println("Vui lòng tạo thông tin công ty trước");
				} else {
					System.out.println("Nhập ID nhân sự cần xóa");
					String employeeId = scanner.nextLine();
					company.removeEmployee(employeeId);
					System.out.println("Danh sách nhân viên sau khi xóa");
					company.displayEmployees();
				}
				break;
			case 5:
				if (company == null) {
					System.out.println("Vui lòng tạo thông tin công ty trước");
				} else {
					company.displayEmployees();
				}
				break;
			case 6:
				if (company == null) {
					System.out.println("Vui lòng tạo thông tin công ty trước");
				} else {
					System.out.println("Tổng lương toàn công ty");
					System.out.println(company.calculateTotalSalary());
				}
				break;
			case 7:
				if (company == null) {
					System.out.println("Vui lòng tạo thông tin công ty trước");
				} else {
					company.findHighestSalaryStaff();
				}

				break;
			case 8:
				Manager managerSubordinates = null;
				if (company == null) {
					System.out.println("Vui lòng tạo thông tin công ty trước");
				} else {
					company.findManagerWithMostSubordinates();
					managerSubordinates.displaySubordinates();
				}

				break;
			case 9:
				if (company == null) {
					System.out.println("Vui lòng tạo thông tin công ty trước");
				} else {
					company.sortEmployeesByNameCompany();
					company.displayEmployees();
				}

				break;
			case 10:
				if (company == null) {
					System.out.println("Vui lòng tạo thông tin công ty trước");
				} else {
					company.sortEmployeesSalaryByDecending();
					company.displayEmployees();
				}

				break;
			case 11:
				if (company == null) {
					System.out.println("Vui lòng tạo thông tin công ty trước");
				} else {
					company.findDirectorMostShares();
				}
				break;
			case 12:
				if (company == null) {
					System.out.println("Vui lòng tạo thông tin công ty trước");
				} else {
					company.calculateAndPrintDirectorIncome();
				}
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ");
				return;
			}
		}

	}

}
