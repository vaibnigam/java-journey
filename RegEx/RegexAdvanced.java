import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexAdvanced {
	public static void main(String[] args) {

		// ===================== 1. Pattern + Matcher (vs String.matches()) =====================
		// matches() is a SHORTCUT — internally it does Pattern.compile(regex).matcher(s).matches()
		// EVERY time you call it. If you're checking many strings against the SAME regex,
		// compiling once and reusing the Pattern is more efficient.
		// Also: matches() only tells you true/false for the WHOLE string.
		// Pattern + Matcher lets you SEARCH for matches ANYWHERE inside a string, and get
		// MULTIPLE matches, not just one true/false answer.

		Pattern p1 = Pattern.compile("\\d+");
		Matcher m1 = p1.matcher("Order 101 shipped, Order 102 pending, Order 103 cancelled");

		while (m1.find()) {
			// find() moves forward through the string, finding the NEXT match each time
			// it's called. Returns false once no more matches exist.
			System.out.println("Found: " + m1.group() + " at position " + m1.start() + "-" + m1.end());
		}
		// Found: 101 at position 6-9
		// Found: 102 at position 21-24
		// Found: 103 at position 36-39


		// ===================== 2. Capturing Groups () =====================
		// Parentheses () don't just group characters together — they also CAPTURE
		// whatever matched inside them, so you can extract that piece separately.
		// group(0) or group() = the ENTIRE match
		// group(1) = whatever matched inside the FIRST (...)
		// group(2) = whatever matched inside the SECOND (...), and so on.

		Pattern p2 = Pattern.compile("(\\w+)@(\\w+)\\.(\\w+)");
		Matcher m2 = p2.matcher("vaibhav@gmail.com");

		if (m2.matches()) {
			System.out.println("Full match : " + m2.group(0)); // vaibhav@gmail.com
			System.out.println("Username   : " + m2.group(1)); // vaibhav
			System.out.println("Domain     : " + m2.group(2)); // gmail
			System.out.println("Extension  : " + m2.group(3)); // com
		}


		// ===================== 3. replaceAll() using captured groups ($1, $2...) =====================
		// Inside the REPLACEMENT string, $1, $2, etc. refer back to whatever was
		// captured by group 1, group 2, etc. in the pattern — lets you REARRANGE
		// or REUSE parts of the match, not just delete/replace them blindly.

		String name = "John Smith";
		String swapped = name.replaceAll("(\\w+) (\\w+)", "$2 $1");
		System.out.println(swapped); // Smith John

		String date = "05-08-2026";
		String reformatted = date.replaceAll("(\\d{2})-(\\d{2})-(\\d{4})", "$3/$2/$1");
		System.out.println(reformatted); // 2026/08/05


		// ===================== 4. Non-Capturing Groups (?:...) =====================
		// Sometimes you need parentheses ONLY for grouping (e.g. to apply a quantifier
		// to multiple characters, or for alternation with |), but you DON'T care about
		// capturing that part separately. (?:...) groups WITHOUT creating a numbered
		// group — keeps group numbering clean when you have real capturing groups too.

		System.out.println("catcatcat".matches("(?:cat){3}"));   // true -> "cat" repeated exactly 3 times
		System.out.println("catdog".matches("(?:cat|dog){2}"));   // true -> "cat" or "dog", repeated twice consecutively

		// Compare: capturing version would be "(cat){3}" -> works the same for matching,
		// but group(1) would then hold "cat" (last repetition) — often not needed, hence non-capturing.


		// ===================== 5. Lookahead / Lookbehind (zero-width assertions) =====================
		// These CHECK for something nearby WITHOUT actually consuming/matching those
		// characters as part of the result. Very common in password validation, where
		// you need MULTIPLE conditions to all be true on the SAME string.

		// (?=...)  -> POSITIVE lookahead: must be FOLLOWED by ... (but ... isn't consumed)
		// (?!...)  -> NEGATIVE lookahead: must NOT be followed by ...
		// (?<=...) -> POSITIVE lookbehind: must be PRECEDED by ...
		// (?<!...) -> NEGATIVE lookbehind: must NOT be preceded by ...

		// Example: password must be at least 8 chars AND contain at least one digit
		// (?=.*\\d) checks "somewhere ahead there is a digit" WITHOUT consuming characters,
		// so the engine can then separately check .{8,} for the full length requirement.
		System.out.println("pass1234".matches("(?=.*\\d).{8,}"));  // true  -> has a digit, length >= 8
		System.out.println("password".matches("(?=.*\\d).{8,}"));  // false -> no digit present

		// Strong password: min 8 chars, at least 1 upper, 1 lower, 1 digit, 1 special char
		String strongPasswordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
		System.out.println("Passw0rd@".matches(strongPasswordRegex)); // true
		System.out.println("password".matches(strongPasswordRegex));  // false -> missing upper, digit, special char

		// Lookbehind example: find digits that come right AFTER a "$" sign
		Pattern pricePattern = Pattern.compile("(?<=\\$)\\d+");
		Matcher priceMatcher = pricePattern.matcher("Price: $500, Discount: 50");
		while (priceMatcher.find()) {
			System.out.println("Price found: " + priceMatcher.group()); // 500 only, not 50 (no $ before it)
		}


		// ===================== 6. Greedy vs Lazy Quantifiers =====================
		// By default, *, +, {n,m} are GREEDY — they try to match AS MUCH as possible,
		// then backtrack only if needed. Adding a '?' right after makes them LAZY —
		// they try to match AS LITTLE as possible instead.
		// This matters a LOT when there are multiple possible matches in one string.

		String html = "<a><b>";
		System.out.println(html.replaceAll("<.*>", "X"));    // X       -> greedy ".*" grabs from FIRST < to LAST >
		System.out.println(html.replaceAll("<.*?>", "X"));   // XX      -> lazy ".*?" stops at the FIRST >, matches separately

		System.out.println("aaa".replaceAll("a+", "X"));      // X       -> greedy, matches all 3 a's together
		System.out.println("aaa".replaceAll("a+?", "X"));     // XXX     -> lazy, matches one 'a' at a time


		// ===================== 7. Word Boundary \b =====================
		// \b matches the INVISIBLE position between a word character (\w) and a
		// non-word character (or start/end of string) — it doesn't consume any
		// characters itself. Used to match WHOLE words only, not substrings inside
		// other words.

		System.out.println("cat category".replaceAll("\\bcat\\b", "dog"));
		// "dog category" -> only the standalone word "cat" is replaced, "category" untouched

		System.out.println("cat category".replaceAll("cat", "dog"));
		// "dog dogegory" -> WITHOUT \b, "cat" inside "category" also gets replaced (usually wrong!)


		// ===================== 8. split() with a LIMIT parameter =====================
		// split(regex) with only one argument removes trailing empty strings and
		// splits as many times as possible. split(regex, limit) gives you CONTROL:
		//   limit > 0  -> split AT MOST (limit - 1) times, remaining text stays as the last piece
		//   limit == 0 -> same as no limit, but trailing empty strings ARE removed (default behavior)
		//   limit < 0  -> split as many times as possible, and KEEP trailing empty strings

		String csv = "a,b,c,d";
		System.out.println(java.util.Arrays.toString(csv.split(",", 2)));
		// [a, b,c,d] -> stops after ONE split, rest stays together as the 2nd element

		String trailing = "a,b,,";
		System.out.println(java.util.Arrays.toString(trailing.split(",")));    // [a, b] -> trailing empties removed
		System.out.println(java.util.Arrays.toString(trailing.split(",", -1))); // [a, b, , ] -> trailing empties KEPT


		// ===================== 9. Case-Insensitive Matching =====================
		// Two ways to ignore case: pass a flag to Pattern.compile(), or use the
		// inline flag "(?i)" directly inside the regex string itself.

		Pattern p3 = Pattern.compile("hello", Pattern.CASE_INSENSITIVE);
		System.out.println(p3.matcher("HELLO world").find()); // true

		System.out.println("HELLO".matches("(?i)hello")); // true -> inline flag, no need for Pattern.compile


		// ===================== 10. More Real-World Validation Patterns =====================

		// Indian PAN card: 5 letters, 4 digits, 1 letter (e.g. ABCDE1234F)
		String panRegex = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
		System.out.println("ABCDE1234F".matches(panRegex)); // true
		System.out.println("abcde1234f".matches(panRegex)); // false -> case-sensitive by default

		// IPv4 address (basic structure check — does NOT validate 0-255 range)
		String ipRegexBasic = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";
		System.out.println("192.168.1.1".matches(ipRegexBasic));   // true
		System.out.println("999.999.999.999".matches(ipRegexBasic)); // true -> structurally valid, but NOT a real IP!
		// (proper range validation needs a much longer regex, or manual parsing + checking 0-255)

		// URL (simplified)
		String urlRegex = "^(https?://)([\\w.-]+)(\\.[a-zA-Z]{2,})(/.*)?$";
		System.out.println("https://www.google.com/search".matches(urlRegex)); // true
		System.out.println("ftp://files.com".matches(urlRegex));               // false -> only http/https allowed

	}
}