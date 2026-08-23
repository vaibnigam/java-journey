package OOPSheet;

import java.util.ArrayList;

public class Q8_Student {
	public static void main(String[] args) {
		Student s1 = new Student("Vaibhav", Grade.A1);

		s1.addCourse("Java");
		s1.addCourse("DSA");
		s1.addCourse("Spring Boot");
		System.out.println(s1);

		s1.addCourse("Java"); // duplicate test
		System.out.println(s1);

		s1.removeCourse("DSA");
		System.out.println(s1);

		s1.removeCourse("Python"); // not found test
		System.out.println(s1);
	}
}

class Student {
	private String name;
	private Grade grade;
	private ArrayList<String> courses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public ArrayList<String> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", courses=" + courses + "]";
	}

	public Student(String name, Grade grade) {
		this.name = name;
		this.grade = grade;
		this.courses = new ArrayList<String>();
	}

	public void addCourse(String course) {
		if (course == null || course.trim().isEmpty()) {
			System.out.println("Invalid course name");
			return;
		}
		if (courses.contains(course)) {
			System.out.println(course + " is already added");
			return;
		}
		courses.add(course);
	}

	public void removeCourse(String course) {
		if (courses.contains(course)) {
			courses.remove(course);
		} else {
			System.out.println(course + " not found in the course list");
		}
	}

}

enum Grade {
	A1, A2, B1, B2, B3, C1, D, F
}