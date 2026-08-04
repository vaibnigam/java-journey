import java.util.Arrays;

public class RegexHW {
	public static void main(String[] args) {

		// ===================== 1. REGEX BASIC SYMBOLS =====================
		System.out.println("abc".matches("a.c")); // true -> '.' matches any single character ('b')
		System.out.println("a1c".matches("a.c")); // true -> '.' matches a digit too, since it means "any char"

		System.out.println("42".matches("\\d\\d")); // true -> \d matches any single digit, used twice for 2 digits
		System.out.println("4a".matches("\\d\\D")); // true -> \D matches any NON-digit char

		System.out.println("a b".matches("a\\sb")); // true -> \s matches the whitespace between a and b

		System.out.println("a_1".matches("\\w\\w\\w")); // true -> \w matches letter, digit, or underscore (word char)

		System.out.println("".matches("a*")); // true -> '*' = 0 or more 'a's, empty string qualifies
		System.out.println("aaa".matches("a*")); // true -> 3 'a's also qualifies

		System.out.println("".matches("a+")); // false -> '+' = 1 or more, empty string doesn't have even one
		System.out.println("aaa".matches("a+")); // true

		System.out.println("color".matches("colou?r")); // true -> '?' = 0 or 1 of 'u', so "color" (no u) matches
		System.out.println("colour".matches("colou?r")); // true -> "colour" (with u) also matches

		System.out.println("b".matches("[aeiou]")); // false -> 'b' is not in the vowel set
		System.out.println("e".matches("[aeiou]")); // true -> 'e' is a vowel

		System.out.println("m".matches("[a-z]")); // true -> range a-z covers lowercase letters

		System.out.println("Hello World".matches("^Hello.*")); // true -> ^ anchors to start of string
		System.out.println("Hello World".matches(".*World$")); // true -> $ anchors to end of string

		System.out.println("123".matches("\\d{3}")); // true -> exactly 3 digits
		System.out.println("12".matches("\\d{3}")); // false -> only 2 digits, needs exactly 3

		System.out.println("1234".matches("\\d{2,4}")); // true -> between 2 and 4 digits, "1234" has 4

		System.out.println("cat".matches("cat|dog")); // true -> '|' is OR, matches "cat" or "dog"
		System.out.println("dog".matches("cat|dog")); // true
		System.out.println("fish".matches("cat|dog")); // false -> neither option matches

		// ===================== 2. matches() : FULL STRING, NOT PARTIAL
		// =====================
		System.out.println("Hello123".matches("\\d+")); // false -> whole string must be digits, "Hello" part breaks it
		System.out.println("Hello123".matches(".*\\d+.*")); // true -> "anything + digits + anything" covers the whole
															// string

		System.out.println("98765".matches("\\d{10}")); // false -> only 5 digits present, need exactly 10
		System.out.println("9876543210".matches("\\d{10}")); // true -> exactly 10 digits

		// ===================== 3. matches() : PRACTICAL PATTERNS =====================
		String email = "vaibhav@gmail.com";
		System.out.println(email.matches("\\w+@\\w+\\.\\w+")); // true -> word chars + @ + word chars + . + word chars

		String name = "Vaibhav";
		System.out.println(name.matches("[a-zA-Z]+")); // true -> only letters, one or more

		String name2 = "Vaibhav123";
		System.out.println(name2.matches("[a-zA-Z]+")); // false -> digits present, pattern only allows letters

		String code = "ABC123";
		System.out.println(code.matches("[a-zA-Z0-9]+")); // true -> letters and digits both allowed

		// ===================== 4. split() WITH REGEX =====================
		System.out.println(Arrays.toString("a,b,c".split(",")));
		// [a, b, c] -> plain character, no special regex meaning here

		System.out.println(Arrays.toString("abc123def456ghi".split("\\d+")));
		// [abc, def, ghi] -> splits wherever one-or-more digits occur

		System.out.println(Arrays.toString("a,b;c d".split("[,; ]")));
		// [a, b, c, d] -> character class: comma OR semicolon OR space, any one
		// triggers a split

		System.out.println(Arrays.toString("Hello    World  Java".split("\\s+")));
		// [Hello, World, Java] -> one-or-more whitespace treated as a single split
		// point

		System.out.println(Arrays.toString("a.b.c".split("\\.")));
		// [a, b, c] -> '.' escaped with \\. to mean a literal dot, not "any character"

//		 |(Java string)                     | Kya hota hai          | Regex ko kya milta hai       | Result                                    |
//		 |----------------------------------|---------------------- |------------------------------|--------------------------------------------|
//		 | "\d"                             | Compile error         | -                            | Illegal escape character                  |
//		 | "\\d"                            | Valid                 | \d (1 backslash + d)         | Digit match                                |
//		 | "\."                             | Compile error         | -                            | Illegal escape character                  |
//		 | "\\."                            | Valid                 | \.                           | Literal dot match                          |
//		 | "."                              | Valid                 | .                            | Any character match                        |
//		 | ","                              | Valid                 | ,                            | Literal comma (no escaping needed anywhere)|
	}
}