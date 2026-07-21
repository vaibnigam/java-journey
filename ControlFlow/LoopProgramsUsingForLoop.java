import java.util.Scanner;

public class LoopProgramsUsingForLoop {
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
		System.out.println("24. Program to calculate series");
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
		case 24:
			q24_calculateSeries(sc);
			break;
		default:
			System.out.println("Invalid option");
			break;
		}

		sc.close();

	}

	private static void q24_calculateSeries(Scanner sc) {
		System.out.println("Series 1 :( 1*1 + 2*2 + ... n*n ) ");
		System.out.println("Series 2 :( 1 + 1+2 + 1+2+3 + 1+2+3+...n ) ");
		System.out.println("Series 3 :( 1 + 11 + 111 + 1111 + .... ) ");
		System.out.println("Enter which series you want to calculate");
		int choice = sc.nextInt();
		System.out.println("Enter value of n");
		int n = sc.nextInt();
		if (n <= 0) {
			System.out.println("Enter positive number");
			return;
		}
		int sum = 0;
		switch (choice) {
		case 1: {
			for (int i = 1; i <= n; i++) {
				sum += (i * i);
			}
			break;
		}
		case 2: {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++) {
					sum += j;
				}
			}
			break;
		}
		case 3: {
			int term = 0;
			for (int i = 1; i <= n; i++) {
				term = (10 * term) + 1;
				sum += term;
				if (i < n) {
				    System.out.print(term + " + ");
				} else {
				    System.out.print(term);
				}
			}
			break;
		}
		default:
			System.out.println("Invalid choice");
		}
		System.out.println();
		System.out.println(sum);
	}

	private static void q1_firstnNaturalNumbers(Scanner sc) {
		System.out.print("Enter how many natural numbers you want to print: ");
		int n = sc.nextInt();
		if (n <= 0) {
			System.out.println("Enter positive number");
			return;
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(i + ", ");
		}
	}

	private static void q2_sumOfFirstnNaturalNumbers(Scanner sc) {
		int sum = 0;
		System.out.print("Enter how many natural numbers you want to sum: ");
		int n = sc.nextInt();
		if (n < 0) {
			System.out.println("Enter positive number");
			return;
		}
		if (n == 0) {
			System.out.print("Sum of first " + n + " natural numbers is : 0");
			return;
		}
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
		long n = Math.abs(sc.nextLong());
		for (int i = 1;;) {
			if (n / 10 != 0) {
				i++;
				n = n / 10;
			} else {
				System.out.println("no of digits are " + i);
				return;
			}
		}

	}

	private static void q8_firstAndLastDigit(Scanner sc) {
		System.out.print("Enter number to know its first and last digits: ");
		long n = Math.abs(sc.nextLong());
		;
		int last = (int) (n % 10);
		for (;;) {
			if (n / 10 != 0) {
				n = n / 10;
			} else {
				System.out.println("First digit of the number is : " + n);
				System.out.println("Last digit of the number is : " + last);
				return;
			}
		}
	}

	private static void q9_operationsOnFirstAndLastDigit(Scanner sc) {
		System.out.println("Enter a number : ");
		int n = sc.nextInt();
		n = Math.abs(n);
		int last = n % 10;
		int first = n;
		for (;;) {
			if (first / 10 != 0)
				first = first / 10;
			else {
				System.out.println("The number is : " + n);
				System.out.println("First digit of the number is : " + first);
				System.out.println("Last digit of the number is : " + last);
				break;
			}
		}
		System.out.println("Enter operation : ");
		System.out.println("1 : add");
		System.out.println("2 : subtract : ");
		System.out.println("3 : multiply : ");
		System.out.println("4 : divide : ");
		System.out.println("5 : modulus : ");
		int op = sc.nextInt();

		switch (op) {
		case 1:
			System.out.print("Addition is : ");
			System.out.println(last + first);
			break;
		case 2:
			System.out.print("Subtraction is : ");
			System.out.println(first - last);
			break;
		case 3:
			System.out.print("Multiplication is : ");
			System.out.println(last * first);
			break;
		case 4:
			if (last != 0) {
				System.out.print("Division is : ");
				System.out.println(first / (float) last);
			} else
				System.out.println("Can't divide by zero");
			break;
		case 5:
			if (last != 0) {
				System.out.print("Modulus is : ");
				System.out.println(first % last);
			} else
				System.out.println("Can't divide by zero");
			break;
		default:
			System.out.println("Invalid operation");
		}

	}

	private static void q10_swapFirstAndLastDigit(Scanner sc) {
		System.out.println("Enter number : ");
		int n = Math.abs(sc.nextInt());
		System.out.println("The number is : " + n);
		int m = n;
		if (n < 10) {
			System.out.println("The new number is : " + n);
			return;
		}
		int last = m % 10;
		int first;
		int count = 0;
		for (;;) {
			if (n / 10 != 0) {
				count++;
				n = n / 10;
			} else {
				first = n;
				break;
			}
		}
		m = m % (int) (Math.pow(10, count));
		m = m / 10;
		int newNumber = ((int) (Math.pow(10, count)) * last) + 10 * m + first;
		System.out.println("The new number is : " + newNumber);
	}

	private static void q11_reverseNumber(Scanner sc) {
		System.out.println("Enter number : ");
		int n = Math.abs(sc.nextInt());
		System.out.println("The number is : " + n);
		System.out.print("The reverse number is : ");
		int rev = 0;
		for (; n != 0; n /= 10) {
			rev = (rev * 10) + (n % 10);
		}
		System.out.println(rev);

	}

	private static void q12_frequencyOfEachDigit(Scanner sc) {
		System.out.println("Enter number : ");
		long n = Math.abs(sc.nextLong());
		System.out.println("The number is : " + n);
		int zero, one, two, three, four, five, six, seven, eight, nine;
		zero = one = two = three = four = five = six = seven = eight = nine = 0;

		if (n == 0)
			zero++;
		else {

			for (; n != 0; n /= 10) {
				int mod = (int) n % 10;
				switch (mod) {
				case 0:
					zero += 1;
					break;
				case 1:
					one += 1;
					break;
				case 2:
					two += 1;
					break;
				case 3:
					three += 1;
					break;
				case 4:
					four += 1;
					break;
				case 5:
					five += 1;
					break;
				case 6:
					six += 1;
					break;
				case 7:
					seven += 1;
					break;
				case 8:
					eight += 1;
					break;
				case 9:
					nine += 1;
					break;
				}
			}
		}
		System.out.println("Frequency of each digit is : ");
		System.out.println(" zero : " + zero);
		System.out.println(" One : " + one);
		System.out.println(" two : " + two);
		System.out.println(" three : " + three);
		System.out.println(" four : " + four);
		System.out.println(" five : " + five);
		System.out.println(" six : " + six);
		System.out.println(" seven : " + seven);
		System.out.println(" eight : " + eight);
		System.out.println(" nine : " + nine);
	}

	private static void q13_numberToWords(Scanner sc) {
		System.out.println("Enter number : ");
		long n = Math.abs(sc.nextLong());
		System.out.println("The number is : " + n);
		if (n == 0) {
			System.out.print("zero ");
			return;
		}
		long original = n;
		int count = 1;
		for (; n / 10 != 0; n /= 10) {
			count++;
		}
		n = original;
		long rev = 0;
		for (; n != 0; n /= 10) {
			rev = (rev * 10) + (n % 10);
		}
		n = original;
		long numrev = rev;
		int revCount = 0;
		for (; numrev != 0; numrev /= 10) {
			revCount++;
		}
		if (revCount < count) {
			for (int i = 1; i <= (count - revCount); i++)
				System.out.print("zero ");
		}
		for (; rev != 0; rev /= 10) {
			int mod = (int) (rev % 10);
			switch (mod) {
			case 0:
				System.out.print("zero ");
				break;
			case 1:
				System.out.print("one ");
				break;
			case 2:
				System.out.print("two ");
				break;
			case 3:
				System.out.print("three ");
				break;
			case 4:
				System.out.print("four ");
				break;
			case 5:
				System.out.print("five ");
				break;
			case 6:
				System.out.print("six ");
				break;
			case 7:
				System.out.print("seven ");
				break;
			case 8:
				System.out.print("eight ");
				break;
			case 9:
				System.out.print("nine ");
				break;
			}
		}
	}

	private static void q14_asciiCharacters(Scanner sc) {
		System.out.println("What characters you want to print ");
		System.out.println("1 : A-Z");
		System.out.println("2 : a-z");
		System.out.println("3 : reverse A-Z");
		int a = sc.nextInt();
		switch (a) {
		case 1:
			for (char i = 'A'; i <= 'Z'; i++)
				System.out.print(i + " ");
			break;
		case 2:
			for (char i = 'a'; i <= 'z'; i++)
				System.out.print(i + " ");
			break;
		case 3:
			for (char i = 'Z'; i >= 'A'; i--)
				System.out.print(i + " ");
			break;

		}

	}

	private static void q15_factorsOfNumber(Scanner sc) {
		System.out.println("Enter number : ");
		long n = Math.abs(sc.nextLong());
		System.out.println("The number is : " + n);
		System.out.println("factors are");
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {

				System.out.print(i + " ");
			}
		}
		System.out.print(n);

	}

	private static void q16_factorial(Scanner sc) {
		System.out.println("Enter number : ");
		int n = sc.nextInt();

		if (n > 20) {
			System.out.println("factorial will be huge!! , Enter a number between 1-20");
			return;
		}
		long fact = 1;
		if (n < 0) {
			System.out.println("Number must be non-negative");
			return;
		} else if (n == 0 || n == 1) {

		} else {
			for (int i = n; i >= 1; i--) {
				fact = fact * i;
			}
		}
		System.out.println("Factorial of " + n + " is " + fact);
	}

	private static void q17_hcfAndLcm(Scanner sc) {
		System.out.println("Enter first number : ");
		int n = Math.abs(sc.nextInt());
		System.out.println("Enter second number : ");
		int m = Math.abs(sc.nextInt());

		if (n == 0 && m == 0) {
			System.out.println("hcf is undefined");
			System.out.println("lcm is " + 0);
			return;
		}
		if (n == 0 || m == 0) {
			int nonZero = (n == 0) ? m : n;
			System.out.println("hcf is " + nonZero);
			System.out.println("lcm is 0");
			return;
		}
		int hcf = 1;
		for (int i = 1; i <= Math.min(n, m); i++) {
			if (n % i == 0 && m % i == 0) {
				hcf = i;
			}
		}
		System.out.println("hcf is " + hcf);
		long lcm = ((long) n * m) / hcf;
		System.out.println("lcm is " + lcm);
	}

	private static void q18_primeOrNot(Scanner sc) {
		System.out.println("Enter number : ");
		int n = Math.abs(sc.nextInt());
		System.out.println("The number is : " + n);
		if (n == 1 || n == 0) {
			System.out.println("Neither prime nor composite");
			return;
		}
		boolean prime = true;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				prime = false;
				break;
			}
		}
		System.out.println(prime ? "prime" : "not prime");

	}

	private static void q19_primeNumbers(Scanner sc) {
		System.out.println("Print all Prime Numbers between 1 and N : ");
		System.out.println("Enter N : ");
		int n = Math.abs(sc.nextInt());
		if (n < 2) {
			System.out.println("No Numbers");
			return;
		}
		int count = 0;
		System.out.print("prime Numbers between 1 and " + n + " : ");

		for (int i = 2; i <= n; i++) {
			boolean isPrime = true;
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				System.out.print(i + " ");
				count++;
			}

		}
		System.out.println();
		System.out.println("Total count : " + count);

	}

	private static void q20_primeFactors(Scanner sc) {
		System.out.print("Enter a number: ");
		int n = Math.abs(sc.nextInt());
		System.out.print("Prime factors: ");
		for (int i = 2; i <= n; i++) {
			boolean isPrimeFactor = true;
			if (n % i == 0) {
				for (int j = 2; j * j <= i; j++) {
					if (i % j == 0) {
						isPrimeFactor = false;
						break;
					}
				}
				if (isPrimeFactor) {
					System.out.print(i + " ");
				}
			}
		}

	}

	private static void q21_fibonacciSeries(Scanner sc) {
		System.out.println("Enter number of terms");
		int n = Math.abs(sc.nextInt());
		;
		int first = 0;
		int next = 1;
		for (int i = 0; i < n; i++) {

			System.out.print(first + " ");
			int last = first + next;
			first = next;
			next = last;
		}
	}

	private static void q22_sumAndProductOfDigits(Scanner sc) {
		System.out.println("Enter a number");
		long number = Math.abs(sc.nextLong());
		int sum = 0;
		int product = 1;
		if (number == 0) {
			System.out.println("Sum of digits : 0");
			System.out.println("Product of digits : 0");
			return;
		}
		for (; number > 0; number /= 10) {
			int digit = (int) (number % 10);
			sum += digit;
			product *= digit;
		}

		System.out.println("Sum of digits :" + sum);
		System.out.println("Product of digits :" + product);

	}

	private static void q23_binaryToDecimal(Scanner sc) {
		/*
		 * System.out.println("Enter a number"); int a = sc.nextInt();
		 * System.out.print("Its binary is : ");
		 * System.out.println(Integer.toBinaryString(a)); System.out.println();
		 */

		/*
		 * int b = 0b10011001101; //{It will store b as a decimal value}
		 * System.out.println(b); //1229
		 */
		System.out.println("Enter a number \"only 0 and 1\"");
		long number = sc.nextLong();
		boolean isNegative = number < 0;
		long positiveNumber = Math.abs(number);
		long temp = positiveNumber;
		if (number < 0) {
			isNegative = true;
			positiveNumber = -number;
		}
		for (; temp > 0; temp /= 10) {
			if (temp % 10 != 0 && temp % 10 != 1) {
				System.out.println("Please enter a binary number - only 0 and 1");
				return;
			}
		}

		int decimal = 0;
		for (int i = 0; positiveNumber > 0; i++) {
			decimal += (positiveNumber % 10) * (1 << i);
			positiveNumber /= 10;
		}
		System.out.println("Your binary number is :" + number);
		if (isNegative) {
			System.out.println("Its decimal number is : " + -decimal);
		} else
			System.out.println("Its decimal number is : " + decimal);
	}
}
