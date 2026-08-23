package OOPSheet;

/*Q3. Create a program for the class called "Dog" with a name and breed attribute. Create two 
instances of the "Dog" class, set their attributes using the constructor and modify the 
attributes using the setter methods and print the updated values.*/

public class Q3_Dog {
	public static void main(String[] args) {
		Dog dog1 = new Dog("Bruno", Breed.GERMAN_SHEPHERD);
		Dog dog2 = new Dog("Mowgli", Breed.GOLDEN_RETRIEVER);

		dog1.setName("Mars");
		System.out.println(dog1);
		dog2.setBreed(Breed.HUSKY);
		System.out.println(dog2);
	}
}

class Dog {
	private String name;
	private Breed breed;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public Dog(String name, Breed breed) {
		super();
		this.name = name;
		this.breed = breed;
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", breed=" + breed + "]";
	}
}

enum Breed {
	LABRADOR, GERMAN_SHEPHERD, GOLDEN_RETRIEVER, BEAGLE, PUG, ROTTWEILER, HUSKY, DOBERMAN, PUG_MIX, SHIH_TZU
}