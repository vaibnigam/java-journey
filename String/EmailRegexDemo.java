public class EmailRegexDemo {
	public static void main(String[] args) {

		// ===================== SIMPLE (LOOSE) EMAIL REGEX =====================
		// \w+ -> username: only letters, digits, underscore (no dot, no hyphen)
		// @ -> literal @ symbol
		// \w+ -> domain name: only letters, digits, underscore
		// \. -> literal dot
		// \w+ -> extension: only letters, digits, underscore (digits wrongly allowed
		// here)

		System.out.println("vaibhav@gmail.com".matches("\\w+@\\w+\\.\\w+"));
		// true -> simple, valid-looking email, works fine here

		System.out.println("vaibhav.nigam@gmail.com".matches("\\w+@\\w+\\.\\w+"));
		// false -> FAILS, because '.' in username isn't covered by \w

		System.out.println("vaibhav-nigam@gmail.com".matches("\\w+@\\w+\\.\\w+"));
		// false -> FAILS, because '-' in username isn't covered by \w

		System.out.println("vaibhav@my-company.com".matches("\\w+@\\w+\\.\\w+"));
		// false -> FAILS, because '-' in domain isn't covered by \w

		System.out.println("vaibhav@gmail.co12".matches("\\w+@\\w+\\.\\w+"));
		// true -> WRONGLY PASSES, digits shouldn't be allowed in a real extension

		// ===================== ROBUST (PRODUCTION-STYLE) EMAIL REGEX
		// =====================
		// ^ -> start of string
		// [\w.-]+ -> username: letters, digits, underscore, dot, hyphen allowed
		// @ -> literal @ symbol
		// [\w-]+ -> domain name: letters, digits, underscore, hyphen allowed
		// \. -> literal dot
		// [a-zA-Z]{2,} -> extension: only letters, minimum 2, no digits allowed
		// $ -> end of string
		String emailRegex = "^[\\w.-]+@[\\w-]+\\.[a-zA-Z]{2,}$";

		System.out.println("vaibhav@gmail.com".matches(emailRegex));
		// true -> straightforward valid email

		System.out.println("vaibhav.nigam@gmail.com".matches(emailRegex));
		// true -> dot in username now correctly allowed

		System.out.println("vaibhav-nigam@gmail.com".matches(emailRegex));
		// true -> hyphen in username now correctly allowed

		System.out.println("vaibhav@my-company.com".matches(emailRegex));
		// true -> hyphen in domain now correctly allowed

		System.out.println("vaibhav@gmail.co12".matches(emailRegex));
		// false -> correctly REJECTED, digits not allowed in extension

		System.out.println("vaibhav@gmail".matches(emailRegex));
		// false -> correctly REJECTED, no dot + extension present

		System.out.println("@gmail.com".matches(emailRegex));
		// false -> correctly REJECTED, username part is missing (needs at least 1 char
		// before @)

		System.out.println("vaibhav@.com".matches(emailRegex));
		System.out.println();
		System.out.println("vaibhav@.com".matches("^[\\w.-]+@[\\w-]+\\.[a-zA-Z]{2,}$"));
		// false -> correctly REJECTED, domain name part is missing before the dot

	}
}