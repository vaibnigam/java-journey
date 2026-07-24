import java.util.Scanner;

public class WhileLoop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		que1();
//		que2();
//		que3();
//		que4(sc);
//		que5(sc);
//		que6(sc);
//		que7(sc); 
//		que8(sc);
//		que9(sc);
//		que10(sc);
//		que11(sc);
//		que12(sc);
//		que13(sc);
		sc.close();
	}

	private static void que17(Scanner sc) {
		// TODO Auto-generated method stub

	}

	private static void que16(Scanner sc) {
		// TODO Auto-generated method stub

	}

	private static void que15(Scanner sc) {
		// TODO Auto-generated method stub

	}

	private static void que14(Scanner sc) {
		// TODO Auto-generated method stub

	}

	private static void que13(Scanner sc) {
//		13. User se ek positive number maango, jab tak negative number de tab tak error dikhake dobara pucho.
		System.out.println("Enter positive num : ");
		int n = sc.nextInt();
		while (n < 0) {
			System.out.println("enter again");
			n = sc.nextInt();
		}
		System.out.println("Thankyou!");

	}

	private static void que12(Scanner sc) {
//		12. Ek password validation loop banao — jab tak user sahi password na de (max 3 attempts ka tracking bhi karo, counter variable use karke).
		System.out.println("Enter password : ");
		String pass = sc.next();
		int RetryCount = 1;
		while (RetryCount <= 3) {

			if ("password".equals(pass)) {
				System.out.println("Access Granted");
				return;
			}
			if (RetryCount == 3) {
				break;
			}
			if (!"password".equals(pass)) {
				System.out.println("Enter password again: ");
				RetryCount++;
				pass = sc.next();
			}
		}
		System.out.println("Max attempt reached");
	}

	private static void que11(Scanner sc) {
//		11. User se age lo, jab tak valid age (1-120) na de tab tak dobara pucho.
		System.out.println("Enter age : ");
		int age = sc.nextInt();
		while (age < 1 || age > 120) {
			System.out.println("Enter correct age : ");
			age = sc.nextInt();

		}
		System.out.println("Age Confirmed : " + age);

	}

	private static void que10(Scanner sc) {
//		10. Armstrong number check karo while loop se (jaise 153 = 1³+5³+3³).
		System.out.println("Enter number");
		int num = sc.nextInt();
		int m = num;
		int n = num;
		int count = 0;
		double sum = 0;
		while (m != 0) {
			count++;
			m /= 10;
		}
		while (n != 0) {
			sum = sum + Math.pow((n % 10), count);
			n /= 10;
		}
		System.out.println(sum == num ? "Armstrong" : "Not Armstrong");
	}

	private static void que9(Scanner sc) {
		System.out.println("Enter number");
		int n = sc.nextInt();
		int count = 0;
		while (n != 0) {
			count++;
			n /= 10;
		}
		System.out.println("count :" + count);

	}

	private static void que8(Scanner sc) {
//	8. Check karo ek number palindrome hai ya nahi (while loop se, reverse wale logic ka use karke).
		System.out.println("Enter number");
		int n = sc.nextInt();
		int m = n;
		int rev = 0;
		while (n != 0) {
			rev = rev * 10 + n % 10;
			n /= 10;
		}
		System.out.println(rev);
		System.out.println(m == rev ? "Palindrome" : "Not Palindrome");
	}

	private static void que7(Scanner sc) {
//	7. Ek number reverse karo while loop use karke (jaise 1234 → 4321).
		System.out.println("Enter number");
		int n = sc.nextInt();
		int rev = 0;
		while (n != 0) {
			rev = rev * 10 + n % 10;
			n /= 10;
		}
		System.out.println(rev);

	}

	private static void que6(Scanner sc) {
//	6. 1 se N tak kitne numbers 3 se divisible hain, unki count nikaalo while loop se.
		System.out.println("Enter number");
		int n = sc.nextInt();
		int count = 0;
		int i = 1;
		while (i <= n) {
			if (i % 3 == 0) {
				count++;
				System.out.println(i++ + " ");
			} else
				i++;
		}
		System.out.println("Total : " + count);
	}

	private static void que5(Scanner sc) {

//	5. Ek number diya hai, uske digits ka sum while loop se nikaalo (jaise 4527 → 4+5+2+7).

		System.out.println("Enter number");
		int n = sc.nextInt();
		int sum = 0;
		while (n != 0) {
			sum = sum + n % 10;
			n /= 10;
		}
		System.out.println("Sum of digits : " + sum);
	}

	private static void que4(Scanner sc) {

//	4. User se numbers lo jab tak woh -1 na de (sentinel value), sabka sum aur average nikaalo.

		System.out.println("Enter numbers");
		int n = sc.nextInt();
		int sum = 0;
		float avg = 0.0f;
		int count = 0;
		while (n != -1) {
			sum = sum + n;
			count++;
			avg = (float) sum / count;
			n = sc.nextInt();
		}
		System.out.println("Exited with -1");
		System.out.println("Sum is : " + sum);
		System.out.println("Total numbers : " + count);
		System.out.println("Average is : " + avg);
	}

	private static void que3() {
//	3.--	1 se 100 tak sirf even numbers print karo.
		int i = 2;
		while (i <= 100) {
			System.out.print(i + " ");
			i += 2;
		}
		System.out.println();
		System.out.println();

	}

	private static void que2() {
//	2.--	50 se 1 tak reverse counting print karo (decrement wala while loop).
		int i = 50;
		while (i >= 1) {
			System.out.print(i-- + " ");
		}
		System.out.println();
		System.out.println();
	}

	private static void que1() {
//	1. --	1 se 20 tak numbers print karo while loop se.
		int i = 1;
		while (i <= 20) {
			System.out.print(i++ + " ");
		}
		System.out.println();
		System.out.println();
	}
}
