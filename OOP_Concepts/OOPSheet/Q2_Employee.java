package OOPSheet;

/*
Q2. Create a program of the class called "Employee" with a name, designation, and salary 
attributes, and methods to calculate and update salary.
*/

public class Q2_Employee {

}

class Employee {
	
	private String name;
	private Designation designation;
	private double salary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Designation getDesignation() {
		return designation;
	}
	public void setDesignation(Designation designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Employee(String name, Designation designation, double salary) {
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", designation=" + designation + ", salary=" + salary + "]";
	}
	
	
	
	
	
}

enum Designation {
	TRAINEE, JUNIOR_ENGINEER, SENIOR_ENGINEER, SENIOR_MANAGER, CEO
}