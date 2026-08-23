package OOPSheet;

/*Q9. Create a program of the class called "School" with attributes for students, teachers, and
classes, and methods to add and remove students and teachers, and to create classes.*/

import java.util.ArrayList;

public class Q9_School {
	public static void main(String[] args) {
	    School school = new School("Delhi Public School");

	    school.addStudent(new SchoolStudent("Rahul", 101));
	    school.addStudent(new SchoolStudent("Priya", 102));
	    school.addTeacher(new Teacher("Mr. Sharma", "Math"));
	    school.createClass("10-A");
	    school.createClass("10-B");

	    System.out.println(school);

	    school.removeStudent("Rahul");
	    school.removeTeacher("Ms. Gupta"); // not present, test the "not found" path

	    System.out.println(school);
	}
}

class Teacher {
	private String name;
	private String subject;

	public Teacher(String name, String subject) {
		this.name = name;
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", subject=" + subject + "]";
	}
}

class SchoolStudent {
	private String name;
	private int rollNumber;

	public SchoolStudent(String name, int rollNumber) {
		this.name = name;
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public String toString() {
		return "SchoolStudent [name=" + name + ", rollNumber=" + rollNumber + "]";
	}
}

class SchoolClass {
	private String className;

	public SchoolClass(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "SchoolClass [className=" + className + "]";
	}
}

class School {
	private String schoolName;
	private ArrayList<SchoolStudent> students;
	private ArrayList<Teacher> teachers;
	private ArrayList<SchoolClass> classes;

	public School(String schoolName) {
		this.schoolName = schoolName;
		this.students = new ArrayList<>();
		this.teachers = new ArrayList<>();
		this.classes = new ArrayList<>();
	}

	public String getSchoolName() {
		return schoolName;
	}

	public ArrayList<SchoolStudent> getStudents() {
		return students;
	}

	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public ArrayList<SchoolClass> getClasses() {
		return classes;
	}

	public void addStudent(SchoolStudent student) {
		students.add(student);
	}

	public void removeStudent(String name) {
		for (SchoolStudent s : students) {
			if (s.getName().equals(name)) {
				students.remove(s);
				return;
			}
		}
		System.out.println("Student not found");
	}

	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}

	public void removeTeacher(String name) {
		for (Teacher t : teachers) {
			if (t.getName().equals(name)) {
				teachers.remove(t);
				return;
			}
		}
		System.out.println("Teacher not found");
	}

	public void createClass(String className) {
		SchoolClass newClass = new SchoolClass(className);
		classes.add(newClass);
	}

	@Override
	public String toString() {
		return "School [schoolName=" + schoolName + ", students=" + students + ", teachers=" + teachers + ", classes="
				+ classes + "]";
	}
}