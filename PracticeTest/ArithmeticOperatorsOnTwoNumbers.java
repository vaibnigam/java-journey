import java.util.Scanner;

public class ArithmeticOperatorsOnTwoNumbers {
	public static void main(String ... args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number");
		long x = sc.nextLong();
		System.out.println("Enter second number");
		long y = sc.nextLong();

		System.out.println("Addition is : " +  (x + y) );
		System.out.println("Subtraction is : " +  (x - y) );
		System.out.println("Multiplication is : " +  x * y );
		System.out.println("Division is : " +  x / y );
		System.out.println("Modulus is : " +  x % y );
		}
}

		