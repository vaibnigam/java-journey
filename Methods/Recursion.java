import java.util.Arrays;
import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		questions : 

//			1. find the factorial of a given number using recurssion function. 

		System.out.println("Enter number for factorial");
		int x = sc.nextInt();
		sc.nextLine();
		System.out.printf("Factorial of %d is %d\n", x, factorial(x));

//			2. reverse the array using recurssion function. 
		int[] array = inputArray1D(sc);
		System.out.println("Your array : " + Arrays.toString(array));
		reverseArray(array, 0, array.length - 1);
		System.out.println("Reversed : " + Arrays.toString(array));

//			3. reverse the string using recurssion function. 
		sc.nextLine();
		System.out.println();
		System.out.println("Enter a String");
		String string = sc.nextLine();
		System.out.println("Original String : " + string);
		System.out.println("Reversed String : " + reverseString(string));

//			4. sum of all the number from 1 to n using 
//				recurssion function. 

		System.out.println("Enter a number to find the sum up to that number.");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.printf("Sum of numbers till %d : %d\n", n, sigmaN(n));

//			5. product of all the number from 1 to n using 
//				recurssion function. 
		System.out.println();
		System.out.println("Enter number to find product of all the number upto that number.");
		int mn = sc.nextInt();
		sc.nextLine();
		System.out.printf("Product of numbers till %d : %d\n", mn, factorial(mn));

//			6. print a fabonacii series using recurssion function.

		System.out.println("Enter number of term of fibonacci series");
		int terms = sc.nextInt();
		sc.nextLine();
		printFibonacci(terms);
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
		// reverseString("abc") -> strips 1st char each call, recurses on rest, until
		// length<=1 (base case)
		// then while unwinding, each saved first char gets appended at the END ->
		// "c"+'b'="cb" -> "cb"+'a'="cba"
		// net effect: first char processed ends up last -> string gets reversed
		System.out.println(s);
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

	static void printFibonacci(int terms) {
		for (int i = 0; i < terms; i++) {
			System.out.print(fib(i) + " ");
		}
		System.out.println();
	}

	static int fib(int n) {
		if (n == 0)
			return 0; // base case 1
		if (n == 1)
			return 1; // base case 2
		return fib(n - 1) + fib(n - 2); // recursive case
	}

	private static int[] inputArray1D(Scanner sc) {
		int arraySize = 0;
		while (arraySize <= 0) {
			System.out.println("Enter size of array");
			arraySize = sc.nextInt();

			if (arraySize <= 0)
				System.out.println("Invalid size! Please enter a positive number.");
		}
		int[] array = new int[arraySize];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter " + (i + 1) + " Element");
			array[i] = sc.nextInt();
		}
		return array;
	}

}