import java.util.Arrays;
import java.util.Scanner;

public class RegexQues {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		Email Validation
		System.out.println("Enter Email");
		String email = sc.next();
		boolean isValidEmail = validateEmail(email);
		System.out.println("is email valid : " + isValidEmail);

//		Indian Mobile Number Validation
		System.out.println("Enter Mobile No.");
		String mobile = sc.next();
		boolean isValidMobileNumber = validatePhone(mobile);
		System.out.println("is phone Number valid : " + isValidMobileNumber);
		sc.close();

//		Extract All Numbers from Text
		String text = "Order 101 shipped, Order 102 pending, Order 103 cancelled";
		String[] numbers = text.split("[^0-9]+");
		System.out.println(Arrays.toString(numbers));
		// [, 101, 102, 103] -> pehla empty string aata hai kyunki string letter se
		// start hoti hai

//		Whenever using split(regex), ask yourself:
//
//			What does the regex match? ✅
//			Everything the regex matches will be removed.
//			Everything left between those removed parts becomes array elements.
//			If the string starts with something that gets removed, the first element is "" (empty string).
//			If the string ends with something that gets removed, the trailing empty string is discarded by default.

//		Extract Words from a Sentence
		String sentence = "Hello, World! How are you?";
		String[] words = sentence.split("[^a-zA-Z]+"); // non-letter sequences pe split
		System.out.println(Arrays.toString(words));
		// [Hello, World, How, are, you]
		
//		Query String Parsing (URL params)
		String query = "name=Vaibhav&age=28&city=Bhopal";
		String[] pairs = query.split("&");
		for (String pair : pairs) {
		    String[] keyValue = pair.split("=");
		    System.out.println(keyValue[0] + " -> " + keyValue[1]);
		}
		// name -> Vaibhav
		// age -> 28
		// city -> Bhopal
		
	}

	private static boolean validateEmail(String email) {
		return email.matches("^[\\w.-]+@[\\w-]+\\.[a-zA-Z]{2,}$");
//		Regex Part	   Meaning
//		^	           Start of string
//		[\w.-]+	       Username: one or more letters, digits, _, ., or -
//		@	           Literal @ symbol
//		[\w-]+	       Domain name: one or more letters, digits, _, or -
//		\.	           Literal dot (.)
//		[a-zA-Z]{2,}   Extension: at least 2 alphabetic letters (com, in, org)
//		$	           End of string
	}

	private static boolean validatePhone(String mobile) {
		return mobile.matches("^[6-9]\\d{9}$");
	}

}
