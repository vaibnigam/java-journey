import java.util.Scanner;
public class Areas{
	public static void main(String args[]) {
		double PI = Math.PI;
	System.out.println("Value of PI is  " + PI);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter radius of circle");
		double radius = sc.nextDouble();
	System.out.println("Area of circle is " + PI*radius*radius);
	System.out.println("Area of semicircle is " + PI*radius*radius/2);
		System.out.println("Enter height of triangle");
		double height = sc.nextDouble();
		System.out.println("Enter base of triangle");
		double base = sc.nextDouble();

	System.out.println("Area of triangle is " + base*height/2);
	System.out.println("Enter length of rectangle");
		double length = sc.nextDouble();
	System.out.println("Enter breadth of rectangle");
		double breadth = sc.nextDouble();

	System.out.println("Area of rectangle is " + length*breadth);
		System.out.println("Enter side of square");
		double side = sc.nextDouble();
	System.out.println("Area of square is " + side*side);
		
	}
}

