public class StaticLocalInstance {
	public static void main ( String args[] ) {
		int x = 25;
		System.out.println("I am a local variable i must always be assigned with a value" + x );
		System.out.println(Vehicle.type);
		//System.out.println(Vehicle.brand);

		Vehicle v = new Vehicle();
		System.out.println(v.brand);
	}
}

class Vehicle {
	static String type = "baleno";
	String brand = "maruti";
}