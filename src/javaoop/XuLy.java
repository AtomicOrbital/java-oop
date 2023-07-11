package javaoop;

import java.util.Scanner;

public class XuLy {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Vui long nhap ho va ten: ");
		String name = scanner.nextLine();
		System.out.print("Vui long nhap ma sinh vien: ");
		String id = scanner.nextLine();
		System.out.print("Vui long nhap diem toan: ");
		double mathScore = scanner.nextDouble();
		System.out.print("Vui long nhap diem ly: ");
		double physicsScore = scanner.nextDouble();
		System.out.print("Vui long nhap diem toan: ");
		double chemistryScore = scanner.nextDouble();
		
		
		
		
		Student student = new Student(name, id, mathScore, physicsScore, chemistryScore);
		
		System.out.println("Điểm trung bình: " + student.getAverageScore());
		System.out.println("Xếp loại: " + student.getGrade());
	}

}
