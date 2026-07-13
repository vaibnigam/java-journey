import java.util.Scanner;

public class SwitchCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("List of Programs - \n");
		System.out.println("1. Program to print Day of Week name");
		System.out.println("2. Program to print total number of days in month");
		System.out.println("3. Program to check an alphabet is a vowel or consonant");
		System.out.println("4. Program to find maximum and minimum of two numbers");
		System.out.println("5. Program to check number is even or odd");
		System.out.println("6. Program to check number is positive or negative");
		System.out.println("7. Program to find roots of quadratic equation");
		System.out.println("8. Program to create a simple calculator");
		System.out.println("9. Program to print number between 1 to 10 in character format");
		System.out.println("10. Program to accept user id and confirm department");
		System.out.println("11. Program to check password is correct or not");
		System.out.println("12. Program to check id and password is correct or not");
		System.out.println("13. Program to display user details using their id");
		System.out.println("14. Program to calculate percentage of marks and show grade");
		System.out.println("15. Program to convert a positive number into negative and negative into positive");
		System.out.println("16. Program to convert even number into upper nearest odd number");
		System.out.println(" ");
		System.out.println("Enter program number : ");
		int programNumber = sc.nextInt();
		switch (programNumber) {
		case 1:
			q1_daysOfWeek(sc);
			break;
		case 2:
			q2_daysInMonth(sc);
			break;
		case 3:
			q3_vowelOrConsonant(sc);
			break;
		case 4:
			q4_maximumMinimum(sc);
			break;
		case 5:
			q5_evenOdd(sc);
			break;
		case 6:
			q6_positiveNegative(sc);
			break;
		case 7:
			q7_rootsOfQuadratic(sc);
			break;
		case 8:
			q8_simpleCalculator(sc);
			break;
		case 9:
			q9_numbersInChar(sc);
			break;
		case 10:
			q10_departmentFromId(sc);
			break;
		case 11:
			q11_passwordCheck(sc);
			break;
		case 12:
			q12_idPasswordCheck(sc);
			break;
		case 13:
			q13_userDetailsFromId(sc);
			break;
		case 14:
			q14_percentageAndGrade(sc);
			break;
		case 15:
			q15_postiveNegativeConvert(sc);
			break;
		case 16:
			q16_evenToUpperOdd(sc);
			break;
		default:
			System.out.print("Invalid option ");
		}

		sc.close();
	}

	private static void q16_evenToUpperOdd(Scanner sc) {
		System.out.println("Enter an even number : ");
		long a = sc.nextLong();
		int isEven = a % 2 == 0 ? 0 : 1;
		switch (isEven) {
		case 0:
			System.out.println((a + 1) + " is the nearest upper odd");
			break;
		default:
			System.out.println("This is not an even number. ");
		}

	}

	private static void q15_postiveNegativeConvert(Scanner sc) {
		System.out.println("Enter a number : ");
		long a = sc.nextLong();
		int sign = a > 0 ? 1 : a == 0 ? 0 : -1;
		switch (sign) {
		case -1:
			System.out.print("Negative to Positive is : ");
			System.out.println(-a);
			break;
		case 1:
			System.out.print("Positive to Negative is : ");
			System.out.println(-a);
			break;
		default:
			System.out.println("Number is neither positive nor negative");
		}
	}

	private static void q14_percentageAndGrade(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter name : ");
		String name = sc.nextLine();
		System.out.println("Enter roll no : ");
		int roll = sc.nextInt();
		System.out.println("Enter English marks : ");
		int b = sc.nextInt();
		System.out.println("Enter Hindi marks : ");
		int c = sc.nextInt();
		System.out.println("Enter Maths marks : ");
		int d = sc.nextInt();
		System.out.println("Enter Physics marks : ");
		int e = sc.nextInt();
		System.out.println("Enter Chemistry : ");
		int a = sc.nextInt();

		if (a < 0 || a > 100) {
			System.out.println("Invalid Marks in Chemistry");
			return;
		}
		if (b < 0 || b > 100) {
			System.out.println("Invalid Marks in English");
			return;
		}
		if (c < 0 || c > 100) {
			System.out.println("Invalid Marks in Hindi");
			return;
		}
		if (d < 0 || d > 100) {
			System.out.println("Invalid Marks in Maths");
			return;
		}
		if (e < 0 || e > 100) {
			System.out.println("Invalid Marks in Physics");
			return;
		}

		int totalMarks = 500;
		int marksScored = a + b + c + d + e;
		float percentage = (marksScored / (float) totalMarks) * 100;
		String grade = "N/A";
		int group = (int) percentage / 10;

		if (a < 33 || b < 33 || c < 33 || d < 33 || e < 33) {
			System.out.println(" Student Name : " + name);
			System.out.println(" Student Roll No : " + roll);
			System.out.println(" Result : Failed ");
			System.out.println(" Marks Achieved : " + marksScored);
			System.out.println(" Total Marks : " + totalMarks);
			System.out.println(" Percentage : " + percentage + "%");
			System.out.println(" Grade : " + grade);

//				pass = false;
			return;
		}
		switch (group) {
		case 9,10:
			grade = "A+";
			break;
		case 8:
			grade = "A";
			break;
		case 7:
			grade = "B+";
			break;
		case 6:
			grade = "B";
			break;
		case 5:
			grade = "C";
			break;
		case 4:
			grade = "D";
			break;
		default:
			grade = "E";
			break;
		}

		System.out.println(" Student Name : " + name);
		System.out.println(" Student Roll No : " + roll);
		System.out.println(" Result : Passed ");
		System.out.println(" Marks Achieved : " + marksScored);
		System.out.println(" Total Marks : " + totalMarks);
		System.out.println(" Percentage : " + percentage + "%");
		System.out.println(" Grade : " + grade);

	}

	private static void q13_userDetailsFromId(Scanner sc) {

	    System.out.println("Enter your three digit User ID");
	    int id = sc.nextInt();

	    switch (id) {

	    case 101:
	        System.out.println("User ID      : 101");
	        System.out.println("Name         : Rahul Sharma");
	        System.out.println("Department   : Human Resources");
	        System.out.println("Designation  : HR Executive");
	        System.out.println("Salary       : ₹35,000");
	        break;

	    case 202:
	        System.out.println("User ID      : 202");
	        System.out.println("Name         : Priya Singh");
	        System.out.println("Department   : Administration");
	        System.out.println("Designation  : Admin Officer");
	        System.out.println("Salary       : ₹40,000");
	        break;

	    case 303:
	        System.out.println("User ID      : 303");
	        System.out.println("Name         : Amit Verma");
	        System.out.println("Department   : Finance");
	        System.out.println("Designation  : Accountant");
	        System.out.println("Salary       : ₹50,000");
	        break;

	    case 404:
	        System.out.println("User ID      : 404");
	        System.out.println("Name         : Neha Gupta");
	        System.out.println("Department   : Marketing");
	        System.out.println("Designation  : Marketing Executive");
	        System.out.println("Salary       : ₹45,000");
	        break;

	    case 505:
	        System.out.println("User ID      : 505");
	        System.out.println("Name         : Arjun Mehta");
	        System.out.println("Department   : Sales");
	        System.out.println("Designation  : Sales Manager");
	        System.out.println("Salary       : ₹60,000");
	        break;

	    case 606:
	        System.out.println("User ID      : 606");
	        System.out.println("Name         : Sneha Patel");
	        System.out.println("Department   : Operations");
	        System.out.println("Designation  : Operations Executive");
	        System.out.println("Salary       : ₹48,000");
	        break;

	    case 707:
	        System.out.println("User ID      : 707");
	        System.out.println("Name         : Karan Joshi");
	        System.out.println("Department   : Customer Support");
	        System.out.println("Designation  : Support Engineer");
	        System.out.println("Salary       : ₹38,000");
	        break;

	    case 808:
	        System.out.println("User ID      : 808");
	        System.out.println("Name         : Anjali Kapoor");
	        System.out.println("Department   : Research & Development");
	        System.out.println("Designation  : Software Engineer");
	        System.out.println("Salary       : ₹70,000");
	        break;

	    case 909:
	        System.out.println("User ID      : 909");
	        System.out.println("Name         : Vikram Nair");
	        System.out.println("Department   : Legal");
	        System.out.println("Designation  : Legal Advisor");
	        System.out.println("Salary       : ₹65,000");
	        break;

	    default:
	        System.out.println("User ID not found.");
	    }
	}

	private static void q12_idPasswordCheck(Scanner sc) {
		System.out.println("Enter your three digit User ID");
		int userId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your password");
		String password = sc.nextLine();
		int group = userId / 100;
		switch (group) {
		case 1:
			switch (password) {
			case "Passw0rd1":
				System.out.println("Correct password");
				break;
			default:
				System.out.println("Incorrect password");
				break;
			}
			break;
		case 2:
			switch (password) {
			case "Passw0rd2":
				System.out.println("Correct password");
				break;
			default:
				System.out.println("Incorrect password");
				break;
			}
			break;
		case 3:
			switch (password) {
			case "Passw0rd3":
				System.out.println("Correct password");
				break;
			default:
				System.out.println("Incorrect password");
				break;
			}
			break;
		case 4:
			switch (password) {
			case "Passw0rd4":
				System.out.println("Correct password");
				break;
			default:
				System.out.println("Incorrect password");
				break;
			}
			break;
		case 5:
			switch (password) {
			case "Passw0rd5":
				System.out.println("Correct password");
				break;
			default:
				System.out.println("Incorrect password");
				break;
			}
			break;
		case 6:
			switch (password) {
			case "Passw0rd6":
				System.out.println("Correct password");
				break;
			default:
				System.out.println("Incorrect password");
				break;
			}
			break;
		case 7:
			switch (password) {
			case "Passw0rd7":
				System.out.println("Correct password");
				break;
			default:
				System.out.println("Incorrect password");
				break;
			}
			break;
		case 8:
			switch (password) {
			case "Passw0rd8":
				System.out.println("Correct password");
				break;
			default:
				System.out.println("Incorrect password");
				break;
			}
			break;
		case 9:
			switch (password) {
			case "Passw0rd9":
				System.out.println("Correct password");
				break;
			default:
				System.out.println("Incorrect password");
				break;
			}
			break;
		default:
			System.out.println("Not a valid USER ID");
			break;
		}
	}

	private static void q11_passwordCheck(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter your password");
		String password = sc.nextLine();
		switch (password) {
		case "Passw0rd":
			System.out.println("Correct password");
			break;
		default:
			System.out.println("Incorrect password");
			break;
		}
	}

	private static void q10_departmentFromId(Scanner sc) {
		System.out.println("Enter your three digit User ID");
		int id = sc.nextInt();
		int department = id / 100;
		switch (department) {
		case 1:
			System.out.println("Human Resources (HR)");
			break;
		case 2:
			System.out.println("Administration");
			break;
		case 3:
			System.out.println("Finance");
			break;
		case 4:
			System.out.println("Marketing");
			break;
		case 5:
			System.out.println("Sales");
			break;
		case 6:
			System.out.println("Operations");
			break;
		case 7:
			System.out.println("Customer Support");
			break;
		case 8:
			System.out.println("Research & Development (R&D)");
			break;
		case 9:
			System.out.println("Legal");
			break;
		default:
			System.out.println("Not a valid USER ID");
		}

	}

	private static void q9_numbersInChar(Scanner sc) {
		System.out.println("Enter number between (1 to 10)");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;
		default:
			System.out.println("Number out of range");
		}
	}

	private static void q8_simpleCalculator(Scanner sc) {
		System.out.println("Enter first number A");
		long a = sc.nextLong();
		System.out.println("Enter second number B");
		long b = sc.nextLong();
		System.out.println("What Operation you want to perform ");
		System.out.println("1 : + ");
		System.out.println("2 : - ");
		System.out.println("3 : * ");
		System.out.println("4 : \u00F7");
		System.out.println("5 : % ");
		int op = sc.nextInt();
		switch (op) {
		case 1:
			System.out.println(a + b);
			break;
		case 2:
			System.out.println(a - b);
			break;
		case 3:
			System.out.println(a * b);
			break;
		case 4:
			if (b == 0)
				System.out.println("Cannot divide by zero");
			else
				System.out.println(a / b);
			break;
		case 5:
			if (b == 0)
				System.out.println("Modulus by zero is not allowed");
			else
				System.out.println(a % b);
			break;
		default:
			System.out.println("Not a valid operation");
		}

	}

	private static void q7_rootsOfQuadratic(Scanner sc) {
		System.out.println("Quadratic equation is (Ax^2 + Bx + C): ");
		System.out.println("Enter first number A = : ");
		double a = sc.nextDouble();
		if (a == 0) {
			System.out.println("A cannot be zero for a quadratic equation");
			return;
		}
		System.out.println("Enter second number B = : ");
		double b = sc.nextDouble();
		System.out.println("Enter third number C = : ");
		double c = sc.nextDouble();

		double D = (b * b) - (4 * a * c);
		int result = D > 0 ? 1 : D == 0 ? 0 : -1;
		switch (result) {
		case 1:
			System.out.println("There will be two real roots");
			double x1 = (((-b) + Math.sqrt(D)) / (2 * a));
			double x2 = (((-b) - Math.sqrt(D)) / (2 * a));
			System.out.println("Roots are " + x1 + " " + x2);
			break;
		case -1:
			System.out.println("The roots are not real");
			break;
		case 0:
			System.out.println("This equation has two equal real roots");
			double x = (-b) / (2 * a);
			System.out.println("Root is " + x);
			break;
		}
	}

	private static void q6_positiveNegative(Scanner sc) {
		System.out.println("Enter a number");
		int a = sc.nextInt();
		int result = a > 0 ? 1 : a == 0 ? 0 : -1;
		switch (result) {
		case 1:
			System.out.print(a + " is a positive number");
			break;
		case -1:
			System.out.print(a + " is a negative number");
			break;
		default:
			System.out.print("The number is 0");
		}
	}

	private static void q5_evenOdd(Scanner sc) {
		System.out.println("Enter a number");
		int a = sc.nextInt();
		switch (a % 2) {
		case 0:
			System.out.println(a + " is an even number");
			break;
		default:
			System.out.println(a + " is an odd number");
			break;

		}

	}

	private static void q4_maximumMinimum(Scanner sc) {
		System.out.println("Enter first number A");
		long a = sc.nextLong();
		System.out.println("Enter second number B");
		long b = sc.nextLong();
		int result;
		if (a > b)
			result = 1;
		else if (a < b)
			result = 2;
		else
			result = 0;
		switch (result) {
		case 1:
			System.out.println("A is maximum : " + a);
			System.out.println("B is minimum : " + b);
			break;

		case 2:
			System.out.println("B is maximum : " + b);
			System.out.println("A is minimum : " + a);
			break;

		default:
			System.out.println("A and B are equal : " + b);
		}
	}

	private static void q3_vowelOrConsonant(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter an alphabet");
		char alphabet = sc.nextLine().charAt(0);
		switch (alphabet) {
		case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
			System.out.println(alphabet + " is a vowel");
			break;
		case 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z',
				'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z':
			System.out.println(alphabet + " is a consonant");
			break;

		default:
			System.out.println("This character is not an Alphabet");
		}

	}

	private static void q2_daysInMonth(Scanner sc) {
		System.out.println("Enter month number");
		int month = sc.nextInt();

		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12:
			System.out.println("It's a 31 days month");
			break;
		case 4, 6, 9, 11:
			System.out.println("It's a 30 days month");
			break;
		case 2:
			System.out.println("This month normally has 28 days, but it has 29 days in a leap year.");
			break;
		default:
			System.out.println("Invalid Month");
			break;
		}

	}

	private static void q1_daysOfWeek(Scanner sc) {
		System.out.println("Enter day number (1-7)");
		int day = sc.nextInt();

		switch (day) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;
		default:
			System.out.println("Invalid day number");

		}
	}
}