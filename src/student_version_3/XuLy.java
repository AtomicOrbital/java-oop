package student_version_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XuLy {
	public static void main(String[] args) {
		// Khởi tạo danh sách sinh viên
		StudentList studentList = new StudentList();
		Scanner scanner = new Scanner(System.in);
		
		//Tạo dữ liệu giả
		studentList.dumyData();
		
		while(true) {
			System.out.println("\nMenu");
			System.out.println("1. Thêm sinh viên");
			System.out.println("2. In thông tin sinh viên");
			System.out.println("3. Tìm sinh viên có điểm trung bình cao nhất");
			System.out.println("4. In sinh viên yếu");
			System.out.println("5. Tìm sinh viên theo tên ");
			System.out.println("6. Tìm sinh viên theo mã");
			System.out.println("7. Xóa sinh viên theo mã");
			System.out.println("8. Thoát");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
		
			switch(choice) {
				case 1:
					//Nhập thông tin sinh viên
					System.out.print("Vui lòng nhập họ và tên: ");
					String name = scanner.nextLine();
					System.out.print("Vui lòng nhập mã sinh viên: ");
					String id = scanner.nextLine();
					System.out.print("Vui lòng nhập điểm toán: ");
					double mathScore = scanner.nextDouble();
					System.out.print("Vui lòng nhập điểm lý: ");
					double physicsScore = scanner.nextDouble();
					System.out.print("Vui lòng nhập điểm hóa: ");
					double chemistryScore = scanner.nextDouble();
					scanner.nextLine(); 
					
					// Thêm sinh viên vào danh sách
					studentList.addStudent(new Student(name, id, mathScore, physicsScore, chemistryScore));
					break;
				case 2:
					// In ra thông tin sinh viên
					studentList.printStudentInfo();
					break;
				case 3:
					// Tìm sinh viên có điểm trung bình cao nhất
					List<Student> highestScoreStudent = studentList.getHighestScoreStudent();
					if(highestScoreStudent != null) {
						System.out.println("Sinh viên có điểm trung bình cao nhất là: ");
						System.out.println();
						for(Student s: highestScoreStudent) {
							s.printStudentsInfo();
							System.out.println();
						}
					} else {
						System.out.println("Không có sinh viên nào được tìm thấy");
					}
					break;
				case 4:
					// In ra tất cả sinh viên yếu
					List<Student> weakStudents = studentList.getWeakStudents();
					if(weakStudents.isEmpty()) {
						System.out.println("Không có sinh viên yếu");
					} else {
						for(Student s : weakStudents) {
							s.printStudentsInfo();
						}
					}				
					break;
				case 5:
					// Tìm sinh viên theo tên
					System.out.println("Vui lòng nhập tên sinh viên cần tìm");
					String searchName = scanner.nextLine();
					List<Student> foundNameStudent = studentList.findStudentByName(searchName);
					
					if(foundNameStudent.isEmpty()) {
						System.out.println("không tìm thấy sinh viên có tên " + searchName);
					} else {
						System.out.println("Sinh viên bạn cần tìm có tên: ");
						for(Student s:foundNameStudent) {
							s.printStudentsInfo();
						}
					}							
					break;
				case 6:
					// Tìm sinh viên theo mã
					System.out.println("Vui lòng nhập mã sinh viên cần tìm");
					String searchId = scanner.nextLine();
					Student foundIDStudent = studentList.findStudentByID(searchId);
					System.out.println("Sinh viên bạn tìm có mã: ");
					if(foundIDStudent != null) {
						foundIDStudent.printStudentsInfo();
					} else {
						System.out.println("Không tìm thấy sinh viên có mã: " + searchId);
					}
					break;
				case 7:
					// Nhập mã sinh viên cần xóa
					System.out.print("Vui lòng nhập mã sinh viên cần xóa: ");
					String deleteId = scanner.nextLine();
					studentList.removeStudentByID(deleteId);
					System.out.println("Danh sách sinh viên sau khi xóa: ");
					studentList.printStudentInfo();
					break;
				case 8:
					System.out.println("Thoát chương trình");
					return;
				default:
					System.out.println("Lựa chọn không hợp lệ!Vui lòng thử lại.");
			}
		}
	}
}
