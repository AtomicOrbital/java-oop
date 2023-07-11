package student_version_2;

import java.util.Scanner;

public class XuLy {
	public static void main(String[] args) {
		StudentList studentList = new StudentList();
		
		Scanner scanner = new Scanner(System.in);
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
		
		studentList.addStudent(new Student(name, id, mathScore, physicsScore, chemistryScore));
		//studentList.addStudent(new Student("Nguyen Van B", "sv02 ", 7.5, 8, 6));
		
		studentList.printStudentsInfo();
	}

}
