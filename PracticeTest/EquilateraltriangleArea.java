import java.util.Scanner;
public class EquilateraltriangleArea {
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter side of equilateral trianle");
		float side = sc.nextFloat();
		double area = Math.sqrt(3)/4 * side * side ;

		System.out.println("Area of equilateral trianle is " + area);
}
}