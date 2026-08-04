import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {

		// ===================== 1. WHAT IS Scanner =====================
		// Scanner -> a class in java.util used to read input from various sources
		// like keyboard (System.in), files, or even a String itself.
		// System.in -> the standard input stream, represents KEYBOARD input.
		// Passing System.in to Scanner tells it: "read whatever the user types."

		Scanner sc = new Scanner(System.in);


		// ===================== 2. next() vs nextLine() =====================
		// next()      -> reads ONE token only, STOPS at the first whitespace
		// nextLine()  -> reads the ENTIRE line, INCLUDING spaces, until Enter is pressed

		System.out.println("Enter your first name (single word):");
		String firstName = sc.next();
		System.out.println("You entered: " + firstName);

		// Flushing leftover newline left behind by next() before using nextLine()
		// (explained in detail in section 9 below)
		sc.nextLine();

		System.out.println("Enter your full address (can have spaces):");
		String address = sc.nextLine();
		System.out.println("You entered: " + address);


		// ===================== 3. nextInt() =====================
		// Reads the next token and PARSES it as an int.
		// Throws InputMismatchException if the token isn't a valid integer.

		System.out.println("Enter your age (int):");
		int age = sc.nextInt();
		System.out.println("Age entered: " + age);


		// ===================== 4. nextDouble() =====================
		// Reads the next token and parses it as a double (decimal number, larger range/precision).

		System.out.println("Enter your height in meters (double):");
		double height = sc.nextDouble();
		System.out.println("Height entered: " + height);


		// ===================== 5. nextFloat() =====================
		// Reads the next token and parses it as a float (decimal number, smaller precision than double).

		System.out.println("Enter your weight in kg (float):");
		float weight = sc.nextFloat();
		System.out.println("Weight entered: " + weight);


		// ===================== 6. nextLong() =====================
		// Reads the next token and parses it as a long (for numbers too big to fit in int).

		System.out.println("Enter your phone number (long):");
		long phoneNumber = sc.nextLong();
		System.out.println("Phone number entered: " + phoneNumber);


		// ===================== 7. nextBoolean() =====================
		// Reads the next token and parses it as a boolean.
		// Only accepts "true" or "false" (case-insensitive) — anything else throws
		// InputMismatchException.

		System.out.println("Are you a student? (true/false):");
		boolean isStudent = sc.nextBoolean();
		System.out.println("Student status: " + isStudent);


		// ===================== 8. next() again, after nextBoolean() =====================
		// nextInt(), nextDouble(), nextFloat(), nextLong(), nextBoolean() all leave the
		// trailing "\n" (Enter key) sitting in the buffer, unread — same issue as next().

		sc.nextLine(); // flush leftover newline from nextBoolean()

		System.out.println("Enter your favorite quote (full line):");
		String quote = sc.nextLine();
		System.out.println("Quote entered: " + quote);


		// ===================== 9. THE SCANNER BUFFER ISSUE (IMPORTANT) =====================
		// WHY IT HAPPENS:
		// nextInt(), nextDouble(), nextFloat(), nextLong(), nextBoolean(), and next()
		// only consume the TOKEN itself (e.g. "25"), NOT the newline character "\n"
		// that gets created when the user presses Enter after typing.
		// That leftover "\n" stays sitting in the input buffer, UNCONSUMED.
		//
		// THE PROBLEM:
		// If you then call nextLine() right after one of those methods, nextLine()
		// doesn't wait for new input — it immediately reads that LEFTOVER "\n" that
		// was already sitting there, sees it as an "empty line", and returns "" instantly.
		// This makes it LOOK like nextLine() is being "skipped".
		//
		// THE FIX:
		// Call an EXTRA sc.nextLine() right after nextInt()/next()/etc. — this consumes
		// (flushes) that leftover "\n" by itself, so the NEXT real nextLine() call
		// properly waits for the user to type a new line.

		System.out.println("\n----- DEMONSTRATING THE BUFFER ISSUE -----");

		System.out.println("Enter a number:");
		int demoNumber = sc.nextInt();
		// NOT calling sc.nextLine() here on purpose, to show the bug:

		System.out.println("Enter a sentence:");
		String demoSentence = sc.nextLine();
		// demoSentence will be "" (empty) here! Because nextLine() just consumed
		// the leftover "\n" from the nextInt() call above, instead of waiting for
		// the user to actually type something.

		System.out.println("Number: " + demoNumber);
		System.out.println("Sentence (BUGGY - likely empty): \"" + demoSentence + "\"");

		// ----- CORRECT WAY -----
		System.out.println("\n----- CORRECT WAY (with flush) -----");

		System.out.println("Enter a number:");
		int demoNumber2 = sc.nextInt();
		sc.nextLine(); // flush the leftover "\n" immediately after nextInt()

		System.out.println("Enter a sentence:");
		String demoSentence2 = sc.nextLine(); // now this properly waits for real input

		System.out.println("Number: " + demoNumber2);
		System.out.println("Sentence (CORRECT): \"" + demoSentence2 + "\"");


		// ===================== 10. CLOSING THE SCANNER =====================
		// Always close the Scanner when done, to release the underlying resource.
		// Only close ONE Scanner wrapping System.in per program — closing it also
		// closes System.in itself, so you can't reopen a new Scanner(System.in)
		// afterward in the same run.

		sc.close();
	}
}