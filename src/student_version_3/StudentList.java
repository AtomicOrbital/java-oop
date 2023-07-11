package student_version_3;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
	List<Student> students = new ArrayList<Student>();
	
	public StudentList() {
		
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public Student findStudentByID(String id) {
		for(Student s : students) {
			if(s.id.equals(id)) {
				return s;
			}
		}
		return null;
	}
	
	public List<Student> findStudentByName(String name){
		List<Student> result = new ArrayList<Student>();
		
		for(Student s:students) {
			if(s.name.equalsIgnoreCase(name)) {
				result.add(s);
			}
		}
		return result;
	}
	
	public void removeStudentByID(String id) {
		Student student = findStudentByID(id);
		if(student != null) {
			students.remove(student);
		}
	}
	
	public List<Student> getHighestScoreStudent() {
		if(students.size() == 0) {
			return null;
		}
		
		List<Student> listHighestStudents = new ArrayList<>();
		double highestScore = students.get(0).calculateAverageScore();
		for(Student s:students) {
			if(s.calculateAverageScore() > highestScore) {
				highestScore = s.calculateAverageScore();
				listHighestStudents.clear();
				listHighestStudents.add(s);
			} else if(s.calculateAverageScore() == highestScore) {
				listHighestStudents.add(s);
			}
		}
		return listHighestStudents;
	}
	
	public List<Student> getWeakStudents(){
		List<Student> result = new ArrayList<Student>();
		for(Student s:students) {
			if(s.grade().equals("Yếu")) {
				result.add(s);
			}
		}
		return result;
	}
	
	public void printStudentInfo() {
		for(Student s:students) {
			s.printStudentsInfo();	
		}
	}
	
	public void dumyData() {
		this.addStudent(new Student("Nguyen Van A", "001", 9.56, 8.4, 7.8));
		this.addStudent(new Student("Nguyen Van B", "002", 7.89, 8, 7));
		this.addStudent(new Student("Nguyen Van C", "003", 10, 8.4, 7.8));
		this.addStudent(new Student("Nguyen Van D", "004", 4, 8.4, 7.8));
		this.addStudent(new Student("Nguyen Van E", "005", 4, 6, 7.8));
		this.addStudent(new Student("Nguyen Van F", "006", 2, 4, 5));
		this.addStudent(new Student("Nguyen Van Asdf", "007", 10, 8.4, 7.8));
	}

}
