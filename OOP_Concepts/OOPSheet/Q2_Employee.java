package OOPSheet;

/*
Q2. Create a program of the class called "Employee" with a name, designation, and salary 
attributes, and methods to calculate and update salary.
*/

public class Q2_Employee {

	public static void main(String[] args) {

		Employee e1 = new Employee("Rahul Sharma", Designation.SENIOR_ENGINEER, 50000);
		System.out.println(e1);
		System.out.println("Calculated salary with bonus: " + e1.calculateSalary());

		e1.updateSalary(5000);
		System.out.println("After hike: " + e1);

		e1.updateSalary(-2000); // invalid case test
	}
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

	public double calculateSalary() {
		double bonusPercent;
		switch (designation) {
		case TRAINEE -> bonusPercent = 0.05;
		case JUNIOR_ENGINEER -> bonusPercent = 0.10;
		case SENIOR_ENGINEER -> bonusPercent = 0.15;
		case SENIOR_MANAGER -> bonusPercent = 0.20;
		case CEO -> bonusPercent = 0.30;
		default -> bonusPercent = 0;
		}
		return salary + (salary * bonusPercent);
	}

	public void updateSalary(double hikeAmount) {
		if (hikeAmount > 0) {
			this.salary += hikeAmount;
		} else {
			System.out.println("Invalid hike amount, salary not updated");
		}
	}
}

enum Designation {
	TRAINEE, JUNIOR_ENGINEER, SENIOR_ENGINEER, SENIOR_MANAGER, CEO
}