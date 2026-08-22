package OOPSheet;

/*Q1. Create a program of the class called "Person" with a name and age attribute. Create two 
instances of the "Person" class, set their attributes using the constructor, and print their 
name and age.*/

public class Q1_Person {
	public static void main(String[] args) {
		Person p1 = new Person("Vaihav Nigam", 28);
		Person p2 = new Person("Vashu Nigam", 28);
		System.out.println(p1);
		System.out.println(p2);
		Person p3 = new Person("", -2);
		System.out.println(p3);
	}
}

class Person {
	private String name;
	private int age;

	public void setName(String name) {
		if (name != null && !name.trim().isEmpty()) {
			this.name = name;
		} else {
			System.out.println("Invalid name cant be set");
		}
	}

	public void setAge(int age) {
		if (age >= 0 && age <= 100) {
			this.age = age;
		} else {
			System.out.println("Invalid age cant be set");
		}
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public Person(String name, int age) {
		setName(name);
		setAge(age);
	}

	@Override
	public String toString() {
		return "name = " + name + ", age = " + age;
	}
}
