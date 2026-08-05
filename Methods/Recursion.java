import java.util.Arrays;
import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		questions : 

//			1. find the factorial of a given number using recurssion function. 

		System.out.println("Enter number");
		int x = sc.nextInt();
		sc.nextLine();
		System.out.printf("Factorial of %d is %d\n", x, factorial(x));

//			2. reverse the array using recurssion function. 

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		System.out.println("Before : " + Arrays.toString(array));
		reverseArray(array, 0, array.length - 1);
		System.out.println("After : " + Arrays.toString(array));

//			3. reverse the string using recurssion function. 
		System.out.println("Enter String");
		String string = sc.nextLine();
		System.out.println("Original String : " + string);
		System.out.println("Reversed String : " + reverseString(string));

//			4. sum of all the number from 1 to n using 
//				recurssion function. 

		System.out.println("Enter number");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.printf("Sum of numbers till %d : %d\n", n, sigmaN(n));

//			5. product of all the number from 1 to n using 
//				recurssion function. 
		System.out.println("Enter number");
		int mn = sc.nextInt();
		sc.nextLine();
		System.out.printf("Product of numbers till %d : %d\n", mn, factorial(mn));

//			6. print a fabonacii series using recurssion function.

		System.out.println("Enter number of term of fibonacci series");
		int fib = sc.nextInt();
		sc.nextLine();
		
		sc.close();
	}

	static long factorial(int x) {
		if (x < 0) {
			System.out.println("Num cant be negative for factorial");
			return 0;
		}
		if (x == 0 || x == 1) {
			return 1;
		}

		return x * factorial(x - 1);
	}

	static void reverseArray(int[] array, int left, int right) {

		if (left >= right) {
			return;
		}
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;

		reverseArray(array, left + 1, right - 1);
	}

	static String reverseString(String s) {
		if (s.length() <= 1) {
			return s; // base case: 0 or 1 char, already "reversed"
		}
		return reverseString(s.substring(1)) + s.charAt(0); // recurse on rest, then append first char at the end
	}

	static int sigmaN(int n) {
		if (n <= 0)
			return 0;
		return n + sigmaN(n - 1);
	}
	static void fibonacci(int n , int first , int next) {
		
		
	}

}
