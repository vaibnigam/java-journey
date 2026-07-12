import java.util.Scanner;

public class IfElsePractice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu - \n");
		System.out.println("1. Program to check two integers are equal or not");
		System.out.println("2. Program to check if a given number is even or odd");
		System.out.println("3. Program to check if a given number is positive or negative");
		System.out.println("4. Program to check if a given year is a Leap year");
		System.out.println("5. Program to check if a person is eligible to vote");
		System.out.println("6. Program to categorize a person based on their height");
		System.out.println("7. Program to find the largest of three numbers");
		System.out.println("8. Program to calculate roots of a quadratic equation");
		System.out.println("9. Program to calculate result, grade and percentage from marks");
		System.out.println("10. Program to show a suitable message according to temperature");
		System.out.println("11. Program to check if a Triangle is Equilateral, Isosceles or Scalene");
		System.out.println("12. Program to check if a Character is an Alphabet, Digit or Special Character");
		System.out.println("13. Program to check whether an Alphabet is Vowel or Consonant");
		System.out.println("14. Program to calculate Profit and Loss on a Transaction");
		System.out.println("15. Program to find Maximum and Minimum of Two Numbers");
		System.out.println("16. Program to check all sides of a Triangle and determine if it is Valid or Not");
		System.out.println("17. Program to check side of a Rectangle and determine if it is a Square or Not");
		System.out.println(" ");
		System.out.println("Enter program number : ");
		int programNumber = sc.nextInt();

		if (programNumber == 1) {
			q1_checkEqualInteger(sc);
		} else if (programNumber == 2) {
			q2_checkEvenOdd(sc);
		} else if (programNumber == 3) {
			q3_checkPositiveOrNegative(sc);
		} else if (programNumber == 4) {
			q4_checkLeap(sc);
		} else if (programNumber == 5) {
			q5_canVote(sc);
		} else if (programNumber == 6) {
			q6_heightCategorizer(sc);
		} else if (programNumber == 7) {
			q7_largestOfThree(sc);
		} else if (programNumber == 8) {
			q8_rootsOfQuadratic(sc);
		} else if (programNumber == 9) {
			q9_calculateResultAndGrades(sc);
		} else if (programNumber == 10) {
			q10_weatherReport(sc);
		} else if (programNumber == 11) {
			q11_typeOfTriangle(sc);
		} else if (programNumber == 12) {
			q12_typeOfChar(sc);
		} else if (programNumber == 13) {
			q13_vowelOrConsonant(sc);
		} else if (programNumber == 14) {
			q14_profitLoss(sc);
		} else if (programNumber == 15) {
			q15_maximumMinimum(sc);
		} else if (programNumber == 16) {
			q16_isTriangleValid(sc);
		} else if (programNumber == 17) {
			q17_typeOfQuadriletral(sc);
		} else {
			System.out.print("Invalid option ");
		}
		sc.close();
	}

	private static void q17_typeOfQuadriletral(Scanner sc) {
		System.out.println("Enter length of the rectangle :");
		int length = sc.nextInt();
		System.out.println("Enter breadth of the rectangle :");
		int breadth = sc.nextInt();
		if (length <= 0 || breadth <= 0) {
			System.out.println("Length of each side must be greater than zero");
		} else if (length == breadth) {
			System.out.println("This rectangle is a square");
		} else
			System.out.println("This rectangle is not a square");
	}

	private static void q16_isTriangleValid(Scanner sc) {
		System.out.println("Enter first side of the triangle :");
		int a = sc.nextInt();
		System.out.println("Enter second side of the triangle :");
		int b = sc.nextInt();
		System.out.println("Enter third side of the triangle :");
		int c = sc.nextInt();
		if (a <= 0 || b <= 0 || c <= 0)
			System.out.println("Length of each side must be greater than zero");
		else if (a + b <= c || a + c <= b || b + c <= a)
			System.out.println("These sides do not form a triangle");
		else
			System.out.println("These sides form a valid triangle");

	}

	private static void q15_maximumMinimum(Scanner sc) {
		System.out.println("Enter first number A");
		long a = sc.nextLong();
		System.out.println("Enter second number B");
		long b = sc.nextLong();

		if (a > b) {
			System.out.println("A is maximum : " + a);
			System.out.println("B is minimum : " + b);
		} else if (a == b)
			System.out.println("Both are equal : " + a);
		else {
			System.out.println("B is maximum : " + b);
			System.out.println("A is minimum : " + a);
		}
	}

	private static void q14_profitLoss(Scanner sc) {
		System.out.println("Enter cost price of the product");
		int cost = sc.nextInt();
		if (cost < 0) {
			System.out.println("Invalid Cost Price");
			return;
		}
		System.out.println("Enter Marked Price of the product");
		int mark = sc.nextInt();

		if (mark < 0) {
			System.out.println("Invalid Marked Price");
			return;
		}
		System.out.println("Enter discount on the product");
		int discount = sc.nextInt();
		if (discount < 0 || discount > 100) {
			System.out.println("Invalid Discount");
			return;
		}

		double sell = mark - (mark * (discount / 100f));

		if (sell > cost) {
			System.out.println("Its a profit of \u20B9 " + (sell - cost));
		} else if (cost > sell) {
			System.out.println("Its a loss of \u20B9 " + (cost - sell));
		} else
			System.out.println("No Profit No Loss");

	}

	private static void q13_vowelOrConsonant(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter an alphabet");
		char c = sc.nextLine().charAt(0);
		if ((c > 'Z' || c < 'A') && (c > 'z' || c < 'a'))
			System.out.println("Not an alphabet");
		else if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I'
				|| c == 'O' || c == 'U')
			System.out.println("Its a vowel");
		else
			System.out.println("Its a consonant");
	}

	private static void q12_typeOfChar(Scanner sc) {
		System.out.println("Enter character");
		sc.nextLine();
		char c = sc.nextLine().charAt(0);
		if (c >= 'a' && c <= 'z')
			System.out.println("It's a lower case alphabet");
		else if (c >= 'A' && c <= 'Z')
			System.out.println("It's an upper case alphabet");
		else if (c >= '0' && c <= '9')
			System.out.println("It's a numeric value");
		else
			System.out.println("It's a special character");
	}

	private static void q11_typeOfTriangle(Scanner sc) {
		System.out.println("Enter first side of a triangle");
		int a = sc.nextInt();
		System.out.println("Enter second side of a triangle");
		int b = sc.nextInt();

		System.out.println("Enter third side of a triangle");
		int c = sc.nextInt();
		if (a <= 0 || b <= 0 || c <= 0) {
			System.out.println("Length of each side must be greater than zero");
			return;
		}
		if ((a + b <= c) || (c + b <= a) || (a + c <= b))
			System.out.println("These sides do not form a triangle");
		else if (a == b && b == c)
			System.out.println("These are sides of a equilateral triangle");
		else if ((a == b && b != c) || (b == c && b != a) || (a == c && a != b))
			System.out.println("These are sides of a isoceles triangle");
		else if (a != b && b != c)
			System.out.println("These are sides of a scalene triangle");

	}

	private static void q10_weatherReport(Scanner sc) {
		System.out.println("Enter Temperature in \u00B0C : ");
		int temp = sc.nextInt();
		if (temp < -90 || temp > 60)
			System.out.println("Invalid Weather");
		else if (temp <= 0)
			System.out.println("Extreme Cold " + temp + "\u00B0C");
		else if (temp < 15)
			System.out.println("Cold weather " + temp + "\u00B0C");
		else if (temp < 25)
			System.out.println("Pleasant weather " + temp + "\u00B0C");
		else if (temp < 35)
			System.out.println("Warm weather " + temp + "\u00B0C");
		else if (temp < 45)
			System.out.println("Hot weather " + temp + "\u00B0C");
		else
			System.out.println("Extreme Hot " + temp + "\u00B0C");

	}

	private static void q9_calculateResultAndGrades(Scanner sc) {
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

//		boolean pass = true;

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

		if (a < 33 || b < 33 || c < 33 || d < 33 || e < 33) {
			System.out.println(" Student Name : " + name);
			System.out.println(" Student Roll No : " + roll);
			System.out.println(" Result : Failed ");
			System.out.println(" Marks Achieved : " + marksScored);
			System.out.println(" Total Marks : " + totalMarks);
			System.out.println(" Percentage : " + percentage + "%");
			System.out.println(" Grade : " + grade);

//			pass = false;
			return;
		}

		if (percentage >= 90) {
			grade = "A+";
		} else if (percentage >= 80) {
			grade = "A";
		} else if (percentage >= 70) {
			grade = "B+";
		} else if (percentage >= 60) {
			grade = "B";
		} else if (percentage >= 50) {
			grade = "C";
		} else if (percentage >= 40) {
			grade = "D";
		} else if (percentage >= 33) {
			grade = "E";
		}

		System.out.println(" Student Name : " + name);
		System.out.println(" Student Roll No : " + roll);
		System.out.println(" Result : Passed ");
		System.out.println(" Marks Achieved : " + marksScored);
		System.out.println(" Total Marks : " + totalMarks);
		System.out.println(" Percentage : " + percentage + "%");
		System.out.println(" Grade : " + grade);

	}

	private static void q8_rootsOfQuadratic(Scanner sc) {
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

		if (D < 0)
			System.out.println("No real roots ");
		else if (D == 0) {
			double x = (-b) / (2 * a);
			System.out.println("Root is " + x);
		} else {
			double x1 = (((-b) + Math.sqrt(D)) / (2 * a));
			double x2 = (((-b) - Math.sqrt(D)) / (2 * a));
			System.out.println("Roots are " + x1 + " " + x2);
		}

	}

	private static void q7_largestOfThree(Scanner sc) {
		System.out.println("Enter first number A = : ");
		int a = sc.nextInt();
		System.out.println("Enter second number B = : ");
		int b = sc.nextInt();
		System.out.println("Enter third number C = : ");
		int c = sc.nextInt();

		if (a == b && a == c) {
			System.out.println("All numbers are equal : " + a);
		} else if (a > b && a > c) {
			System.out.println("A is highest : " + a);
		} else if (b > c && b > a) {
			System.out.println("B is highest : " + b);
		} else if (c > a && c > b) {
			System.out.println("C is highest : " + c);
		} else if (a == b && a > c) {
			System.out.println("A & B are highest : " + a);
		} else if (b == c && b > a) {
			System.out.println("B & C are highest : " + b);
		} else if (c == a && c > b) {
			System.out.println("A & C are highest : " + c);
		}
	}

	private static void q6_heightCategorizer(Scanner sc) {
		System.out.println("Enter height in cm ");
		int height = sc.nextInt();
		if (height <= 0) {
			System.out.println("Invalid Height");
			return;
		}
		if (height > 190)
			System.out.println("Very Tall");
		else if (height > 170)
			System.out.println("Tall");
		else if (height > 150)
			System.out.println("Average");
		else
			System.out.println("Short");
	}

	private static void q1_checkEqualInteger(Scanner sc) {
		System.out.println("Enter first number : ");
		int a = sc.nextInt();
		System.out.println("Enter second number : ");
		int b = sc.nextInt();
		if (a == b)
			System.out.println("Numbers are equal");
		else
			System.out.println("Numbers are not equal");
	}

	private static void q2_checkEvenOdd(Scanner sc) {
		System.out.println("Enter a number : ");
		int c = sc.nextInt();
		if (c == 0)
			System.out.println("Zero is Even");
		else if (c % 2 == 0) {
			if (c < 0)
				System.out.println("Negative Even Number");
			else
				System.out.println("Positive Even Number");
		} else {
			if (c > 0)
				System.out.println("Positive Odd Number");
			else
				System.out.println("Negative Odd Number");
		}
	}

	private static void q3_checkPositiveOrNegative(Scanner sc) {
		System.out.println("Enter number : ");
		int d = sc.nextInt();
		if (d == 0)
			System.out.println("Neither Positive Nor Negative");
		else if (d > 0)
			System.out.println("Positive Number");
		else
			System.out.println("Negative Number");
	}

	private static void q4_checkLeap(Scanner sc) {
		System.out.println("Enter year : ");
		int e = sc.nextInt();
		if (e % 4 == 0) {
			if (e % 100 == 0) {
				if (e % 400 == 0) {
					System.out.println("It's a Leap year");
				} else
					System.out.println("Not a leap year");
			} else
				System.out.println("It's a Leap year");
		} else
			System.out.println("Not a leap year");
	}

	private static void q5_canVote(Scanner sc) {
		sc.nextLine();
		System.out.println("Enter name : ");
		String name = sc.nextLine();
		System.out.println("Enter age : ");
		int g = sc.nextInt();
		if (g < 0) {
			System.out.println("Invalid Age");
			return;
		}
		if (g >= 18)
			System.out.println(name + " is eligible to vote");
		else
			System.out.println(name + " is not eligible to vote");
	}
}
