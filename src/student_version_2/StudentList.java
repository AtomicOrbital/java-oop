package student_version_2;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
	List<Student> students = new ArrayList<Student>();
	
	public StudentList() {
		
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void printStudentsInfo() {
		for(Student s:students) {
			System.out.println("Họ và tên: " + s.name);
			System.out.println("Mã sinh viên: " + s.id);
			System.out.println("Điểm trung bình của 3 môn là: " + s.calculateAverageScore());
			System.out.println("Xếp loại: " + s.grade());
		}
	}
}
