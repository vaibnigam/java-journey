import java.util.Scanner;
public class Circle {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter radius");
	float a = sc.nextFloat();
	final float pi = 3.14f;
	System.out.println("area of circle is : " + pi*a*a);
	System.out.println("perimeter of circle is : " + 2*pi*a);
}

}
