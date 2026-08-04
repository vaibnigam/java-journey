import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class StringHandlingPractice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		String s = "The Quick Brown Fox Jumps Over The Lazy Dog";

		do {
			System.out.println("\n===== Java String Handling Practice Menu =====");
			System.out.println("1.  Get character at given index");
			System.out.println("2.  Concatenate two strings");
			System.out.println("3.  Check if string contains a sequence of char values");
			System.out.println("4.  Print current date and time in specified format");
			System.out.println("5.  Get index of all characters of the alphabet");
			System.out.println("6.  Get length of a given string");
			System.out.println("7.  Replace a specified character with another character");
			System.out.println("8.  Convert all characters to lowercase");
			System.out.println("9.  Remove duplicate characters from a string");
			System.out.println("10. Divide a string into n equal parts");
			System.out.println("11. Reverse every word in a string");
			System.out.println("12. Repeat every character twice");
			System.out.println("13. Sum of numbers appearing in a string");
			System.out.println("14. Sort array of strings by length (asc/desc)");
			System.out.println("15. Check if input text equals \"Java is Programming Language\"");
			System.out.println("16. Swap two strings without third variable");
			System.out.println("17. Find all permutations of a string");
			System.out.println("18. Count vowels and consonants (Java 8)");
			System.out.println("19. Find maximum occurring character");
			System.out.println("20. Find first non-repeating character");
			System.out.println("21. Check if string contains only digits");
			System.out.println("22. Return highest occurred character");
			System.out.println("0.  Exit");
			System.out.println("\nString is : " + s);
			System.out.print("Enter your choice: ");

			choice = sc.nextInt();
			sc.nextLine(); // consume leftover newline

			switch (choice) {
			case 1:
				getCharAtIndex(s, sc);
				break;
			case 2:
				concatenateStrings(s);
				break;
			case 3:
				containsSequence(s, sc);
				break;
			case 4:
				printCurrentDateTime();
				break;
			case 5:
				getAlphabetIndexes(s);
				break;
			case 6:
				getStringLength(s);
				break;
			case 7:
				replaceCharacter(s, sc);
				break;
			case 8:
				convertToLowercase(s);
				break;
			case 9:
				removeDuplicates(s);
				break;
			case 10:
				divideStringIntoParts();
				break;
			case 11:
				reverseEveryWord();
				break;
			case 12:
				repeatEachCharacterTwice();
				break;
			case 13:
				sumOfNumbersInString();
				break;
			case 14:
				sortStringArrayByLength();
				break;
			case 15:
				checkInputText(sc, s);
				break;
			case 16:
				swapStringsWithoutThirdVariable();
				break;
			case 17:
				findAllPermutations();
				break;
			case 18:
				countVowelsAndConsonants(s);
				break;
			case 19:
				findMaxOccurringCharacter(s);
				break;
			case 20:
				findFirstNonRepeatingCharacter(s);
				break;
			case 21:
				checkOnlyDigits(sc);
				break;
			case 22:
				returnHighestOccurredCharacter();
				break;
			case 0:
				System.out.println("Exiting.... Bye!");
				break;
			default:
				System.out.println("Invalid choice, try again.");
			}

		} while (choice != 0);

		sc.close();
	}

	// 1. Get character at given index
	static void getCharAtIndex(String s, Scanner sc) {
		System.out.println("string is : " + s);
		int i;
		do {
			System.out.printf("Enter index between 0 to %d", s.length());
			i = sc.nextInt();
		} while (i < 0 || i >= s.length());
		System.out.printf("Char at index %d is \'%c\'", i, s.charAt(i));
	}

	// 2. Concatenate a given string to the end of another string
	static void concatenateStrings(String s) {
		String s2 = " -- The End";
		String s3 = s + s2;
		System.out.println(s3);
	}

	// 3. Test if a given string contains the specified sequence of char values
	static void containsSequence(String s, Scanner sc) {
		System.out.println("Enter sequence");
		String sequence = sc.next();
		boolean contains = s.contains(sequence);
		System.out.println("Sequence is present in String  " + contains);
	}

	// 4. Print current date and time in a specified format
	static void printCurrentDateTime() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth() + " " + now.getHour()
				+ ":" + now.getMinute() + ":" + now.getSecond());
		// better
		DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MMMM-dd hh:mm:ss");
		System.out.println(now.format(format));
	}

	// 5. Get the index of all the characters of the alphabet
//	index.Of = Returns the index within this string of the first occurrence of the specified character
	static void getAlphabetIndexes(String s) {
		s = s.toLowerCase();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.println("Index of " + ch + " is : " + s.indexOf(ch));
		}
	}

	// 6. Get the length of a given string
	static void getStringLength(String s) {
		System.out.println("The length of the string is : " + s.length());

	}

	// 7. Replace a specified character with another character
	static void replaceCharacter(String s, Scanner sc) {
		System.out.println("Enter character to replace ");
		char ch = sc.next().charAt(0);
		System.out.println("Your selected character is : " + ch);
		if (s.indexOf(ch) == -1) {
			System.out.println("Character not present!");
		}
		System.out.println("Enter character to replace with ");
		char nh = sc.next().charAt(0);
		System.out.println("Your replace with character is : " + nh);
		String s2 = s.replace(ch, nh);
		System.out.println(s);
		System.out.println(s2);
	}

	// 8. Convert all the characters in a string to lowercase
	static void convertToLowercase(String s) {
		System.out.print("String in lowercase : ");
		System.out.println(s.toLowerCase());
	}

	// 9. Print string after removing duplicate characters
	static void removeDuplicates(String s) {
		System.out.println("removeDuplicates using string");
		String s2 = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (s2.indexOf(ch) == -1) {
				s2 += ch;
			}
		}
		System.out.println(s2);

		System.out.println("removeDuplicates using string builder");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (sb.indexOf(s.valueOf(ch)) == -1) {
				sb.append(ch);
			}
		}
		System.out.println(sb.toString());
	}

	// 10. Divide a string into n equal parts
	static void divideStringIntoParts() {
		String s = "abcdefghijklmnopqrstuvwxyz";
		int n = 5;
		for (int i = 0; i < s.length(); i += n) {
			if (i + n > s.length()) {
				String parts = s.substring(i);
				System.out.print(parts);
			} else {
				String parts = s.substring(i, i + n);
				System.out.print(parts + " , ");
			}
		}
		System.out.println();
	}

	// 11. Reverse every word in a string using methods
	static void reverseEveryWord() {
		System.out.println("using string");
		String s = "This is a test String";
		String[] words = s.split(" ");
		for (String w : words) {
			for (int i = w.length() - 1; i >= 0; i--) {
				System.out.print(w.charAt(i));
			}
			System.out.print(" ");
		}
		System.out.println();

		System.out.println("using string builder");
		StringBuilder sb = new StringBuilder();
		String s2 = "This is a test String";
		String[] words2 = s2.split(" ");
		for (String w : words2) {
			sb.append(new StringBuilder(w).reverse().append(" "));
		}
		System.out.println(sb.toString());
	}

	// 12. Create a new string repeating every character twice
	static void repeatEachCharacterTwice() {
		StringBuilder sb = new StringBuilder();
		String s = "welcome";
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			sb.append(s.charAt(i));
		}
		System.out.println(sb.toString());
	}

	// 13. Calculate the sum of the numbers appearing in a given string
	static void sumOfNumbersInString() {
		String s = "15 s25 s 20string";
		String[] nums = s.split("[^0-9]+");
		int sum = 0;
		System.out.println(Arrays.toString(nums));
		for (String n : nums) {
			sum += Integer.parseInt(n);
		}
		System.out.println(sum);

	}

	// 14. Sort an array of strings in ascending and descending order by length
	static void sortStringArrayByLength() {
		String s = "Green , White ,  Black , Pink , Orange , Blue , Champagne , Indigo , Ivory ";
		StringBuilder sb = new StringBuilder();
		String[] colours = s.split("[^a-zA-Z]+");

		// Ascending by length
		Arrays.sort(colours, (a, b) -> a.length() - b.length());
		System.out.println("Ascending: " + Arrays.toString(colours));

		// Descending by length
		Arrays.sort(colours, (a, b) -> b.length() - a.length());
		System.out.println("Descending: " + Arrays.toString(colours));

	}

	// 15. Check if an input text equals "Java is Programming Language"
	static void checkInputText(Scanner sc, String s) {
		System.out.println("Enter text");
		String st = sc.nextLine();
		// if text passed "Java is Programming Language"
		System.out.println(st.equals("Java is Programming Language")); // true
		System.out.println(st == "Java is Programming Language"); // false

	}

	// 16. Swap two strings without using a third string variable
	static void swapStringsWithoutThirdVariable() {
		String s1 = "Good";
		int n = s1.length();
		String s2 = "Morning";
		s1 = s1.concat(s2);
		s2 = s1.substring(0, n);
		s1 = s1.substring(n);
		System.out.println(s1);
		System.out.println(s2);
	}

	// 17. Find all permutations of a string
// 17. Find all permutations of a string
	static void findAllPermutations() {
		String s = "XYZ";

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (j == i)
					continue; // skip if same index as i

				for (int k = 0; k < s.length(); k++) {
					if (k == i || k == j)
						continue; // skip if same index as i or j

					System.out.println("" + s.charAt(i) + s.charAt(j) + s.charAt(k));
				}
			}
		}
	}

	// 18. Count vowels and consonants in a string (Java 8)
	static void countVowelsAndConsonants(String s) {
		s = s.toLowerCase();
		int vowel = 0;
		int cons = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
						|| s.charAt(i) == 'u') {
					vowel++;
				} else {
					cons++;
				}
			}
		}
		System.out.println("Vowels : " + vowel);
		System.out.println("Cons : " + cons);
	}

	// 19. Find the maximum occurring character in a given string
	static void findMaxOccurringCharacter(String s) {
		char ch = s.charAt(0);
		int maxCharCount = 0;
		char maxOcc = ch;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				continue; // skip spaces entirely — don't count or compare them
			}
			boolean alreadyCounted = false;
			for (int k = 0; k < i; k++) {
				if (s.charAt(k) == s.charAt(i)) {
					alreadyCounted = true;
				}
			}
			if (alreadyCounted) {
				continue;
			}
			int count = 0;
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					count++;
				}
			}
			if (count > maxCharCount) {
				maxCharCount = count;
				maxOcc = s.charAt(i);
			}
		}
		System.out.println(maxOcc + " " + maxCharCount);
	}

	// 20. Find the first non-repeating character in a given string
	static void findFirstNonRepeatingCharacter(String s) {
		char ch = ' ';
		outer: for (int i = 0; i < s.length(); i++) {
			boolean alreadyCounted = false;
			for (int k = 0; k < i; k++) {
				if (s.charAt(k) == s.charAt(i)) {
					alreadyCounted = true;
				}
			}
			if (alreadyCounted) {
				continue;
			}
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					continue outer;
				}
			}
			ch = s.charAt(i);
			break outer;
		}
		System.out.println(ch);

	}

	// 21. Check if a string contains only digits
	static void checkOnlyDigits(Scanner sc) {
		System.out.println("Enter String");
		String s = sc.nextLine();
		boolean onlyDigits = s.matches("[0-9]+");
		System.out.println(onlyDigits);
	}

	// 22. Return the highest occurred character in a string
	static void returnHighestOccurredCharacter() {
		// same as 19

	}
}