public class VarArgs {

	public static void main(String[] args) {

		// ===================== 1. WHAT ARE VARARGS =====================
		// Varargs (variable-length arguments) let a method accept ZERO or MORE
		// arguments of a given type, without needing separate overloaded methods
		// for each possible number of arguments.
		// Syntax: type... paramName   (three dots after the type)
		// Internally, Java treats varargs as an ARRAY inside the method body.

		System.out.println("Sum of nothing: " + sum());
		System.out.println("Sum of 1 number: " + sum(5));
		System.out.println("Sum of 3 numbers: " + sum(1, 2, 3));
		System.out.println("Sum of 5 numbers: " + sum(1, 2, 3, 4, 5));


		// ===================== 2. PASSING AN ACTUAL ARRAY DIRECTLY =====================
		// Since varargs are treated as an array internally, you CAN pass an actual
		// array directly instead of listing individual values — both work the same.

		int[] numbers = { 10, 20, 30 };
		System.out.println("Sum from array: " + sum(numbers));


		// ===================== 3. VARARGS MUST BE THE LAST PARAMETER =====================
		// If a method has other fixed parameters ALONG WITH varargs, the varargs
		// parameter MUST come LAST. You can't have anything after it.
		// (See printDetails() below for a working example of this.)

		printDetails("Vaibhav", 95, 88, 76, 100);
		printDetails("NoScores");   // works fine with ZERO scores too


		// ===================== 4. ONLY ONE VARARGS PARAMETER ALLOWED PER METHOD =====================
		// A method can have AT MOST one varargs parameter — you cannot write
		// something like: method(int... a, int... b) — this is a compile error.
		// (Not demonstrated here since it wouldn't compile — just good to remember.)


		// ===================== 5. VARARGS WITH DIFFERENT TYPES =====================
		// Varargs work with any type — primitives, String, or even generic Object
		// (which lets you mix types, since Object is the superclass of everything).

		printAll("apple", "banana", "cherry");
		printAll(1, 2.5, "text", true);   // Object... accepts a mix of types


		// ===================== 6. OVERLOAD RESOLUTION: EXACT MATCH BEATS VARARGS =====================
		// If BOTH a normal overloaded method AND a varargs version could match a
		// call, Java ALWAYS prefers the EXACT/fixed-arity match first — varargs is
		// treated as the LOWEST priority option, used only when nothing else fits.

		greet("Vaibhav");         // calls the fixed-parameter version (exact match wins)
		greet("Vaibhav", "Nigam", "Sir"); // calls the varargs version (no exact match exists for 3 args)


		// ===================== 7. EMPTY VARARGS = EMPTY ARRAY, NOT NULL =====================
		// Calling a varargs method with ZERO arguments does NOT pass null —
		// it passes an array of length 0. Safe to check .length without a null check.

		checkEmpty();          // length will be 0, not a NullPointerException
	}


	// ===================== METHOD DEFINITIONS =====================

	// Basic varargs — accepts any number of ints (including zero)
	static int sum(int... nums) {
		int total = 0;
		for (int n : nums) {   // nums behaves exactly like a normal int[] here
			total += n;
		}
		return total;
	}

	// Varargs combined with a FIXED parameter — fixed parameter(s) must come FIRST,
	// varargs must be LAST
	static void printDetails(String name, int... scores) {
		System.out.print(name + "'s scores: ");
		if (scores.length == 0) {
			System.out.println("(no scores provided)");
			return;
		}
		for (int score : scores) {
			System.out.print(score + " ");
		}
		System.out.println();
	}

	// Varargs of Object — allows mixing different types in a single call
	static void printAll(Object... items) {
		for (Object item : items) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

	// Overload resolution demo — Java prefers the exact-match version over varargs
	static void greet(String name) {
		System.out.println("Fixed-param version: Hello, " + name);
	}

	static void greet(String... names) {
		System.out.println("Varargs version: Hello, " + String.join(" ", names));
	}

	// Demonstrates that zero-argument varargs calls give an empty array, not null
	static void checkEmpty(int... values) {
		System.out.println("Array is null? " + (values == null));
		System.out.println("Array length: " + values.length);
	}
}