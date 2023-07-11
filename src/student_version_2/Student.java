package student_version_2;

class Student {
	String name;
	String id;
	double mathScore;
	double physicsScore;
	double chemistryScore;
	
	public Student(String name, String id, double mathScore, double physicsScore, double chemistryScore) {
		this.name = name;
		this.id = id;
		this.mathScore = mathScore;
		this.physicsScore = physicsScore;
		this.chemistryScore = chemistryScore;
	}
	
	public double calculateAverageScore() {
		return (this.mathScore + this.physicsScore + this.chemistryScore) / 3;
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

}
