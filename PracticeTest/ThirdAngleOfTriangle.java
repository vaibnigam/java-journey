import java.util.Scanner;
public class ThirdAngleOfTriangle {
	public static void main (String ... args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first angle of a trianle");
		float a = sc.nextFloat();
		System.out.println("Enter second angle of a trianle");
		float b = sc.nextFloat();

		float c = 180 -a -b ;
		System.out.println("Third angle of the trianle is " + c);
}
}