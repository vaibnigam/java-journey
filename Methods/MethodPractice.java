import java.util.Scanner;

public class MethodPractice {

	public static void main(String[] args) {

//		questions : 
//			1. check the number is even or odd using user-defined function. 

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number");
		int x = sc.nextInt();

		System.out.println("Is your number even : " + (isEven(x) ? "Yes" : "No"));

		System.out.println("Is your number odd : " + (isEven(x) ? "No" : "Yes"));

//			2. check the number is prime or not using user-defined function. 

		System.out.println("Is your number prime : " + (isPrime(x) ? "Yes" : "No"));

//			3. check the given string is a valid email or not using user-defined function. 

		System.out.println("Enter email");
		String email = sc.next();
		System.out.println("Is your email valid : " + (validEmail(email) ? "Yes" : "No"));

//			4. print all the prime number from 1 to n using user-defined function. 

		System.out.println();
		System.out.println("Enter number to find all the prime number from 1 to n");
		int y = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= y; i++) {
			if (isPrime(i)) {
				sb.append(i);
				sb.append(" ");
			}
		}
		System.out.println(sb.toString());

//			5. write a program to create a power function to find the power of any given 
//				number without using Math.pow().

		System.out.println("Enter number to find its power");
		int num = sc.nextInt();
		System.out.println("Enter power of the number");
		int power = sc.nextInt();
		System.out.println("Answer is : " + findPower(num, power));
		sc.close();
	}

	static boolean isEven(int x) {
		return x % 2 == 0;
	}

	static boolean isPrime(int x) {
		if (x == 2)
			return true;
		if (x < 2 || isEven(x))
			return false;
		for (int i = 3; i * i <= x; i += 2) {
			if (x % i == 0)
				return false;
		}
		return true;
	}

	static boolean validEmail(String email) {
		return email.matches("^[\\w.-]+@[\\w-]+\\.[a-zA-Z]{2,}$");
	}

	static double findPower(int num, int power) {
//		return (long) Math.pow(num, power);
		double result = 1;
		int exponent = Math.abs(power);
		for (int i = 0; i < exponent; i++) {
			result *= num;
		}
		if (power < 0) {
			result = 1 / result;
		}
		return result;
	}
}
