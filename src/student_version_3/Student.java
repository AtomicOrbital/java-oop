package student_version_3;

import java.text.DecimalFormat;

class Student {
	String name;
	String id;
	double mathScore;
	double physicsScore;
	double chemistryScore;
	
	public Student() {
		
	}
	
	public Student(String name, String id, double mathScore, double physicsScore, double chemistryScore) {
		this.name = name;
		this.id = id;
		this.mathScore = mathScore;
		this.physicsScore = physicsScore;
		this.chemistryScore = chemistryScore;
	}
	
	public double calculateAverageScore() {
		double avg = (this.mathScore + this.physicsScore + this.chemistryScore) / 3;
		//DecimalFormat df = new DecimalFormat("#.##");
		return Double.parseDouble(String.format("%.2f", avg));
	}
	
	public String grade() {
		double avg = calculateAverageScore();
		if(avg >= 9) {
			return "Xuat sac";
		} else if(avg >= 8) {
			return "Giỏi";
		} else if(avg >= 7) {
			return "Khá";
		} else if(avg >= 6) {
			return "TB Khá";
		} else if(avg >= 5) {
			return "TB";
		} else {
			return "Yếu";
		}
	}

	public void printStudentsInfo() {	
		System.out.println("Họ và tên: " + name);
		System.out.println("Mã sinh viên: " + id);
		System.out.println("Điểm trung bình của 3 môn là: " + calculateAverageScore());
		System.out.println("Xếp loại: " + grade());
	}
}
