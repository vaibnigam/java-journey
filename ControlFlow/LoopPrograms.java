import java.util.Scanner;

public class LoopPrograms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("List of Programs - \n");
		System.out.println("1. Program to Display the First n Natural Numbers");
		System.out.println("2. Program to Find the Sum of First n Natural Numbers");
		System.out.println("3. Program to Read n Numbers from Keyboard and Find their Sum and Average");
		System.out.println("4. Program to Print Square and Cube of a Given Integer");
		System.out.println("5. Program to Display N Terms of Odd Natural Numbers and their Sum");
		System.out.println("6. Program to Print all Even Numbers and their Sum");
		System.out.println("7. Program to Count Number of Digits in a Number");
		System.out.println("8. Program to Find First and Last Digit of a Number");
		System.out.println("9. Program to Find Sum, Subtraction, Multiplication and Division of First and Last Digit");
		System.out.println("10. Program to Swap First and Last Digit of a Number");
		System.out.println("11. Program to Reverse a Number");
		System.out.println("12. Program to Find Frequency of Each Digit in a Number");
		System.out.println("13. Program to Print a Number in Words");
		System.out.println("14. Program to Print all ASCII Characters with their Values");
		System.out.println("15. Program to Find all Factors of a Number");
		System.out.println("16. Program to Calculate Factorial of a Number");
		System.out.println("17. Program to Find HCF and LCM of Two Numbers");
		System.out.println("18. Program to Check whether a Number is Prime or Not");
		System.out.println("19. Program to Print all Prime Numbers between 1 and N");
		System.out.println("20. Program to Find all Prime Factors of a Number");
		System.out.println("21. Program to Print Fibonacci Series");
		System.out.println("22. Program to Calculate Sum and Product of all Digits of a Number");
		System.out.println("23. Program to Convert Binary Number to Decimal Number");
		System.out.println();
		System.out.print("Enter program number : ");
		int programNumber = sc.nextInt();

		switch (programNumber) {
		case 1:
			q1_firstnNaturalNumbers(sc);
			break;

		case 2:
			q2_sumOfFirstnNaturalNumbers(sc);
			break;

		case 3:
			q3_sumAndAverageOfnNumbers(sc);
			break;

		case 4:
			q4_squareAndCube(sc);
			break;

		case 5:
			q5_oddNumbersAndSum(sc);
			break;

		case 6:
			q6_evenNumbersAndSum(sc);
			break;

		case 7:
			q7_countDigits(sc);
			break;

		case 8:
			q8_firstAndLastDigit(sc);
			break;

		case 9:
			q9_operationsOnFirstAndLastDigit(sc);
			break;

		case 10:
			q10_swapFirstAndLastDigit(sc);
			break;

		case 11:
			q11_reverseNumber(sc);
			break;

		case 12:
			q12_frequencyOfEachDigit(sc);
			break;

		case 13:
			q13_numberToWords(sc);
			break;

		case 14:
			q14_asciiCharacters(sc);
			break;

		case 15:
			q15_factorsOfNumber(sc);
			break;

		case 16:
			q16_factorial(sc);
			break;

		case 17:
			q17_hcfAndLcm(sc);
			break;

		case 18:
			q18_primeOrNot(sc);
			break;

		case 19:
			q19_primeNumbers(sc);
			break;

		case 20:
			q20_primeFactors(sc);
			break;

		case 21:
			q21_fibonacciSeries(sc);
			break;

		case 22:
			q22_sumAndProductOfDigits(sc);
			break;

		case 23:
			q23_binaryToDecimal(sc);
			break;

		default:
			System.out.println("Invalid option");
			break;
		}

		sc.close();

	}

	private static void q1_firstnNaturalNumbers(Scanner sc) {
		System.out.print("Enter how many natural numbers you want to print: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.print(i + ", ");
		}
	}

	private static void q2_sumOfFirstnNaturalNumbers(Scanner sc) {
		int sum = 0;
		System.out.print("Enter how many natural numbers you want to sum: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++)
			sum += i;
		System.out.print("Sum of first " + n + " natural numbers is : ");
		System.out.println(sum);
	}

	private static void q3_sumAndAverageOfnNumbers(Scanner sc) {
		System.out.print("Enter how many numbers you want to enter: ");
		int n = sc.nextInt();
		if (n <= 0) {
			System.out.println("Please enter a positive number");
			return;
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			System.out.print("Enter number " + i + " : ");
			int a = sc.nextInt();
			sum += a;
		}
		System.out.println("Sum is : " + sum);
		float avg = sum / (float) n;
		System.out.println("Average is : " + avg);

	}
// how to use loop here
	private static void q4_squareAndCube(Scanner sc) {
		System.out.print("Enter a number : ");
		int num = sc.nextInt();
		long square = (long) num * num;
		long cube = square * num;
		System.out.println("Square of the number is : " + square);
		System.out.println("Cube of the number is : " + cube);
	}

	private static void q5_oddNumbersAndSum(Scanner sc) {
		System.out.print("Enter how many odd numbers you want to print and sum: ");
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 1; i <= 2 * n - 1; i += 2) {
			System.out.print(i + " ");
			sum += i;
		}
		System.out.println();
		System.out.println("Sum is : " + sum);

	}

	private static void q6_evenNumbersAndSum(Scanner sc) {
		System.out.print("Enter how many even numbers you want to print and sum: ");
		int n = sc.nextInt();
		int sum = 0;
		for (int i = 2; i <= 2 * n; i += 2) {
			System.out.print(i + " ");
			sum += i;
		}
		System.out.println();
		System.out.println("Sum is : " + sum);

	}

	private static void q7_countDigits(Scanner sc) {
		System.out.print("Enter number to count its digits: ");
		long n = sc.nextLong();
		for (int i = 1;;) {
			if (n / 10 != 0) {
				i++;
				n = n / 10;
			} else {
				System.out.println(i);
				return;
			}
		}

	}
 //check for negative integers
	private static void q8_firstAndLastDigit(Scanner sc) {
		System.out.print("Enter number to know its first and last digits: ");
		long n = sc.nextLong();
		int last = (int) (n % 10);
		for (;;) {
			if (n / 10 != 0) {
				n = n / 10;
			} else {
				System.out.println("Last digit of the number is : " + last);
				System.out.println("First digit of the number is : " + n);
				return;
			}
		}
	}

	private static void q9_operationsOnFirstAndLastDigit(Scanner sc) {
	}

	private static void q10_swapFirstAndLastDigit(Scanner sc) {
	}

	private static void q11_reverseNumber(Scanner sc) {
	}

	private static void q12_frequencyOfEachDigit(Scanner sc) {
	}

	private static void q13_numberToWords(Scanner sc) {
	}

	private static void q14_asciiCharacters(Scanner sc) {
	}

	private static void q15_factorsOfNumber(Scanner sc) {
	}

	private static void q16_factorial(Scanner sc) {
	}

	private static void q17_hcfAndLcm(Scanner sc) {
	}

	private static void q18_primeOrNot(Scanner sc) {
	}

	private static void q19_primeNumbers(Scanner sc) {
	}

	private static void q20_primeFactors(Scanner sc) {
	}

	private static void q21_fibonacciSeries(Scanner sc) {
	}

	private static void q22_sumAndProductOfDigits(Scanner sc) {
	}

	private static void q23_binaryToDecimal(Scanner sc) {
	}
}
