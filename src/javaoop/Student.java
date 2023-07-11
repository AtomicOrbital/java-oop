package javaoop;

class Student {
	private String name;
	private String id;
	private double mathScore;
	private double physicsSocre;
	private double chemistryScore;
	private double averageScore;
	private String grade;
	
	// phuong thuc khoi tao
	public Student(String name, String id, double mathScore, double physicsScore, double chemistryScore) {
		this.name = name;
		this.id = id;
		this.mathScore = mathScore;
		this.physicsSocre = physicsScore;
		this.chemistryScore = chemistryScore;

	}
	
	//xay dung phuong thuc get,set cho tung thuoc tinh
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public double getMathScore() {
		return mathScore;
	}
	
	public void setMathScore(double mathScore) {
		this.mathScore = mathScore;
	}
	
	public double getPhysicsScore() {
		return physicsSocre;
	}
	
	public void setPhysicsScore(double physicsScore) {
		this.physicsSocre = physicsScore;
	}
	
	public double getChemistryScore() {
		return chemistryScore;
	}
	
	public void setChemistryScore(double chemistryScore) {
		this.chemistryScore = chemistryScore;
	}
	
	public double getAverageScore() {
		this.averageScore = (this.mathScore + this.physicsSocre + this.chemistryScore) / 3;
		return this.averageScore;
	}
	
	public String getGrade() {
		double avg = this.getAverageScore();
		if(avg >= 9) {
			this.grade = "Xuat sac";
		} else if(avg >= 8) {
			this.grade = "Gioi";
		} else if(avg >= 7) {
			this.grade = "Kha";
		} else if(avg >= 6) {
			this.grade = "TB Kha";
		} else if(avg >= 5) {
			this.grade = "TB";
		} else {
			this.grade = "Yeu";
		}
		return this.grade;
	}
}
