
public class ForLoop {

	public static void main(String[] args) {

//		questions :

//		1. Print a number from 1 to 100.

		for (int i = 1; i <= 100; i++)
			System.out.print(i + ", ");

		System.out.println(" ");
		System.out.println(" ");

//		2. print only the even number from 1 to 100.

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0)
				System.out.print(i + ", ");
		}
		System.out.println(" ");
		System.out.println(" ");

//		3. find the sum of a number from 1 to 10.

		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println(" ");

//		4. find the factorial of a number of 7.

		int fact = 1;
		for (int i = 7; i > 0; i--) {
			fact *= i;
		}
		System.out.println(fact);
		System.out.println(" ");

//		5. check the number is prime or not.

		int num = 97;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				System.out.println("not prime");
				break;
			}

		}
		System.out.println("prime");
		System.out.println(" ");

//	    6. convert the binary number to decimal number

		int n = 10101011;
		int rem, result = 0, value;

		for (int i = 0; n > 0; i++) {
			rem = n % 10;
			value = rem * ((int) (Math.pow(2, i)));
			result += value;
			n /= 10;
		}

		System.out.println(result);
		System.out.println(" ");

//		7. print a fabonacci series. 0 1 1 2 3 5 8 13 21....

		int first = 0, second = 1, next = 0;
		for (int i = 0; i < 25; i++) {
			System.out.print(first + ", ");
			next = first + second;
			first = second;
			second = next;
		}
		System.out.println(" ");
		System.out.println(" ");

		// second method - by swap
		int a = 0, b = 1;
		for (int i = 0; i < 25; i++) {
			System.out.print(a + ", ");
			b = b + a;
			a = b - a;
		}
		System.out.println(" ");
		System.out.println(" ");

//		8. print a number from 100 to 1.
		for (int i = 100; i > 0; i--) {
			System.out.print(i + ", ");

		}

	}
}