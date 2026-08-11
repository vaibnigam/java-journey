import java.time.LocalDate;

public class ClassPractice {

	public static void main(String[] args) {
		// Creating a new Employee object and assigning values to its fields
		Employee e1 = new Employee();
		e1.id = 1001;
		e1.name = "VN";
		e1.email = "V@gmail.com";
		e1.dob = LocalDate.of(1997, 11, 8);
		e1.salary = 1000;
		e1.department = "Engineer";

		// Prints e1 using overridden toString()
		System.out.println(e1);

		// Creating another reference e2, initially pointing to a new Employee object
		Employee e2 = new Employee();

		// Now e2 is reassigned to point to the SAME object as e1 (reference copy, not a
		// new object)
		e2 = e1;

		// == compares references (memory addresses) -> true, since e1 and e2 point to
		// same object
		System.out.println(e1 == e2);

		// equals() here uses default Object.equals() (not overridden in Employee)
		// so it also compares references internally -> true
		System.out.print(e1.equals(e2));
		System.out.println();

		// Both print same data since e1 and e2 refer to the same object in memory
		System.out.println(e1);
		System.out.println(e2);
	}
}

class Employee {
	int id;
	String name;
	String email;
	LocalDate dob;
	int salary;
	String department;

	// Overriding toString() to print Employee fields in readable format
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", salary=" + salary
				+ ", department=" + department + "]";
	}

}