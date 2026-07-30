import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class StringHW {
	public static void main(String[] args) {

		// ===================== 1. STRING POOL: == vs equals() =====================
		String s1 = "ABCD";
		String s2 = "ABCD";
		String s3 = new String("ABCD");

		System.out.println(s1 == s2);        // true  -> both point to same literal in String Pool
		System.out.println(s1 == s3);         // false -> s3 is a new object in heap, not pool
		System.out.println(s1.equals(s3));    // true  -> equals() compares content, not reference

		String s4 = s3.intern();              // manually puts/returns pool reference for s3's content
		System.out.println(s1 == s4);         // true  -> s4 now points to the same pool literal as s1


		// ===================== 2. STRINGBUILDER: append(), toString(), length() =====================
		StringBuilder sb1 = new StringBuilder();
		sb1.append("Hey ");
		System.out.println(sb1.toString());   // "Hey "

		while (sb1.length() < 10) {
			sb1.append("Heyy ");
		}
		String result1 = sb1.toString();
		System.out.println(result1);          // "Hey Heyy Heyy " (loop runs twice: len 4 -> 9 -> 14)

		sb1.setLength(0);                     // clears content, keeps same object (length -> 0)
		System.out.println(sb1);              // "" (empty)
		sb1.append("Heyy Vaib");               // sb1 = "Heyy Vaib"


		// ===================== 3. STRINGBUILDER: compareTo() =====================
		StringBuilder sb = new StringBuilder("Hello");
		System.out.println(sb.append(" Vaib"));   // "Hello Vaib" -> append() returns same object
		System.out.println(sb);                   // "Hello Vaib"
		System.out.println(sb.charAt(6));         // 'V'

		StringBuilder sb2 = new StringBuilder("hello vaib");
		System.out.println(sb.compareTo(sb2));    // -32 -> 'H'(72) - 'h'(104) = -32, first char mismatch

		StringBuilder a = new StringBuilder("apple");
		StringBuilder b = new StringBuilder("apple");
		System.out.println(a.compareTo(b));       // 0 -> identical content, no mismatch

		StringBuilder c = new StringBuilder("apple");
		StringBuilder d = new StringBuilder("banana");
		System.out.println(c.compareTo(d));       // -1 -> 'a'(97) - 'b'(98), first char mismatch

		StringBuilder e = new StringBuilder("banana");
		StringBuilder f = new StringBuilder("apple");
		System.out.println(e.compareTo(f));       // 1 -> 'b'(98) - 'a'(97), first char mismatch

		StringBuilder g = new StringBuilder("app");
		StringBuilder h = new StringBuilder("apple");
		System.out.println(g.compareTo(h));       // -2 -> all chars match, then length diff 3-5

		StringBuilder i = new StringBuilder("apple");
		StringBuilder j = new StringBuilder("app");
		System.out.println(i.compareTo(j));       // 2 -> all chars match, then length diff 5-3

		StringBuilder k = new StringBuilder("Zebra");
		StringBuilder l = new StringBuilder("apple");
		System.out.println(k.compareTo(l));       // -32 -> 'Z'(90) - 'a'(97); ALL uppercase < ALL lowercase in ASCII

		StringBuilder m = new StringBuilder("Vaibhav");
		StringBuilder n = new StringBuilder("Vaibhav");
		System.out.println(m.compareTo(n));       // 0 -> identical content


		// ===================== 4. STRINGBUILDER: insert() =====================
		System.out.println(sb.isEmpty());         // false -> sb is "Hello Vaib"
		System.out.println(sb);                   // "Hello Vaib"

		sb.insert(10, " Nigam");                  // "Hello Vaib Nigam" -> inserted at end (index 10 = length)
		sb.insert(0, "Nigam ");                    // "Nigam Hello Vaib Nigam" -> inserted at start
		sb.insert(6, "Nigam ");                     // "Nigam Nigam Hello Vaib Nigam" -> inserted after index 6
		System.out.println(sb);                    // "Nigam Nigam Hello Vaib Nigam"


		// ===================== 5. STRINGBUILDER: delete() & deleteCharAt() =====================
		sb.delete(0, 6);       // removes "Nigam " -> "Nigam Hello Vaib Nigam"
		sb.delete(6, 12);      // removes "Hello " -> "Nigam Vaib Nigam"
		sb.delete(0, 6);       // removes "Nigam " -> "Vaib Nigam"
		System.out.println(sb);   // "Vaib Nigam"

		sb.deleteCharAt(4);    // removes the space at index 4 -> "VaibNigam"
		sb.insert(4, " ");      // re-inserts space -> "Vaib Nigam"
		System.out.println(sb);   // "Vaib Nigam"


		// ===================== 6. STRINGBUILDER: reverse() & replace() =====================
		System.out.println(sb.reverse());    // "magiN biaV"
		System.out.println(sb.reverse());    // "Vaib Nigam" -> reversed back

		sb.replace(0, 4, "Vaibhav");           // replaces indices 0-3 ("Vaib") with "Vaibhav"
		System.out.println(sb);                // "Vaibhav Nigam"


		// ===================== 7. STRINGBUILDER: method chaining =====================
		String result = new StringBuilder().append("Hello").append(" ").append("World").toString();
		System.out.println(result);   // "Hello World" -> each append() returns 'this', enabling chaining


		// ===================== 8. isEmpty() vs isBlank() =====================
		StringBuilder sb3 = new StringBuilder();
		System.out.println(sb3.isEmpty());    // true  -> sb3 has no characters yet
		sb3.append(" ");
		System.out.println(sb3.isEmpty());    // false -> length is now 1 (a space), even though it looks "empty"

		String str2 = "";
		System.out.println(str2.isBlank());   // true  -> empty counts as blank
		System.out.println(str2.isEmpty());   // true  -> length is 0

		String str3 = " ";
		System.out.println(str3.isBlank());   // true  -> only whitespace counts as blank
		System.out.println(str3.isEmpty());   // false -> length is 1, not 0


		// ===================== 9. trim() vs strip() vs stripLeading/stripTrailing =====================
		String str = "  My Name is vaibhav  ";   // 2 leading + 2 trailing spaces

		System.out.println(str.trim());            // "My Name is vaibhav" -> both ends trimmed
		System.out.println(str.strip());            // "My Name is vaibhav" -> same result; strip() also handles Unicode whitespace, trim() doesn't
		System.out.println(str.stripLeading());      // "My Name is vaibhav  " -> only leading spaces removed
		System.out.println(str.stripTrailing());     // "  My Name is vaibhav" -> only trailing spaces removed
		System.out.println(str);                     // "  My Name is vaibhav  " -> unchanged (String is immutable)


		// ===================== 10. Case conversion =====================
		System.out.println(str.toLowerCase());   // "  my name is vaibhav  " -> spaces preserved, only case changes
		System.out.println(str.toUpperCase());   // "  MY NAME IS VAIBHAV  "
		System.out.println(str);                  // "  My Name is vaibhav  " -> unchanged (immutable)


		// ===================== 11. equals() vs equalsIgnoreCase(), repeat() =====================
		System.out.println("hello".equals("Hello"));            // false -> case-sensitive
		System.out.println("hello".equalsIgnoreCase("Hello"));   // true  -> ignores case
		System.out.println("ha".repeat(3));                       // "hahaha"


		// ===================== 12. String.format() =====================
		System.out.println(String.format("My name is %s and I am %d years old", "vaibhav", 28));
		// "My name is vaibhav and I am 28 years old"

		System.out.println(String.format(
				"String is %s and Float is %f and Newline is %n and Integer is %d and Char is %c and Boolean is %b ",
				"string", 2.8, 28, 'V', true));
		// "String is string and Float is 2.800000 and Newline is <newline> and Integer is 28 and Char is V and Boolean is true "


		// ===================== 13. substring() =====================
		System.out.println(str);                   // "  My Name is vaibhav  "
		System.out.println(str.substring(5));        // "Name is vaibhav  " -> from index 5 ('N') to end, trailing spaces included
		System.out.println(str.substring(5, 12));     // "Name is" -> index 5 to 11 (12 exclusive)


		// ===================== 14. indexOf() / lastIndexOf() (String vs char overloads) =====================
		String string = "12345678909876543212345678999009876512345678";
		System.out.println(string.indexOf("12"));       // 0  -> first "12" is at the very start
		System.out.println(string.indexOf('6'));         // 5  -> first '6'
		System.out.println(string.lastIndexOf("12"));    // 36 -> last occurrence of "12"
		System.out.println(string.lastIndexOf('8'));      // 43 -> last '8', at the very end


		// ===================== 15. contains / startsWith / endsWith =====================
		System.out.println(string.contains("9098"));       // true
		System.out.println(string.startsWith("123"));      // true
		System.out.println(string.endsWith("6789"));       // false -> string actually ends with "5678"
		System.out.println(string.endsWith("678"));        // true


		// ===================== 16. substring() again on a fresh string =====================
		string = "123456789";
		System.out.println(string.substring(2));      // "3456789" -> index 2 to end
		System.out.println(string.substring(3, 7));    // "4567" -> index 3 to 6 (7 exclusive)
		System.out.println(string);                     // "123456789" -> unchanged (immutable)


		// ===================== 17. replaceAll / replaceFirst / replace(char) / replace(CharSequence) =====================
		string = "ABCDEFGHIJABABCDCDEFEFGHGHIJIJ";
		System.out.println(string.replaceAll("AB", "00"));    // "00CDEFGHIJ0000CDCDEFEFGHGHIJIJ" -> ALL "AB" replaced (regex-capable)
		System.out.println(string.replaceFirst("AB", "00"));   // "00CDEFGHIJABABCDCDEFEFGHGHIJIJ" -> only FIRST "AB" replaced
		System.out.println(string.replace('A', 'Z'));            // "ZBCDEFGHIJZBZBCDCDEFEFGHGHIJIJ" -> every 'A' char replaced
		System.out.println(string.replace("AB", "00"));          // "00CDEFGHIJ0000CDCDEFEFGHGHIJIJ" -> ALL "AB" replaced (literal, not regex)


		// ===================== 18. concat() =====================
		string = "123456789";
		System.out.println(string.concat("0000"));   // "1234567890000" -> returns new string
		System.out.println(string);                    // "123456789" -> unchanged (immutable)

		string = string.concat("-ONETWOTHREEFOUR");     // reassigned this time
		System.out.println(string);                       // "123456789-ONETWOTHREEFOUR"


		// ===================== 19. String.join() =====================
		String strn = String.join(",", "One", "Two", "Three");
		System.out.println(strn);   // "One,Two,Three" -> varargs overload

		String strng = String.join(",", List.of("Four", "Five"));
		System.out.println(strng);  // "Four,Five" -> Iterable overload (List/Set)

		strn = strn + "," + strng + "," + String.join(",", List.of("Six", "Seven"));
		System.out.println(strn);   // "One,Two,Three,Four,Five,Six,Seven"


		// ===================== 20. StringTokenizer: countTokens(), nextToken(), hasMoreTokens() =====================
		StringTokenizer stk = new StringTokenizer(strn, ",");
		System.out.println(stk.countTokens());   // 7 -> counts remaining tokens WITHOUT consuming them

		System.out.println(stk.nextToken());   // "One"
		System.out.println(stk.nextToken());   // "Two"
		System.out.println(stk.nextToken());   // "Three"
		System.out.println(stk.nextToken());   // "Four"
		System.out.println(stk.nextToken());   // "Five"
		System.out.println(stk.nextToken());   // "Six"
		System.out.println(stk.nextToken());   // "Seven" -> last token; stk is now fully consumed
//		stk.nextToken();                       // would throw NoSuchElementException -> no tokens left

		StringTokenizer stkr = new StringTokenizer(strn, ",");
		while (stkr.hasMoreTokens()) {          // NOTE: must check stkr here, not the already-consumed stk
			System.out.println(stkr.nextToken());
		}
		// One
		// Two
		// Three
		// Four
		// Five
		// Six
		// Seven


		// ===================== 21. StringTokenizer: nextToken() vs nextElement() =====================
		StringTokenizer stkDemo = new StringTokenizer("A,B,C", ",");
		String t = stkDemo.nextToken();       // "A" -> nextToken() returns String directly (StringTokenizer's own method)
		Object o = stkDemo.nextElement();     // "B" -> nextElement() returns Object (inherited from Enumeration interface)
		System.out.println(t);                 // "A"
		System.out.println(o);                 // "B" -> needs a cast to String if String-specific methods are needed on it


		// ===================== 22. split() basics + StringTokenizer vs split() empty-token behavior =====================
		str = "Vaibhav,Nigam,Java,Developer";
		String[] parts = str.split(",");
		System.out.println(Arrays.toString(parts));   // "[Vaibhav, Nigam, Java, Developer]"
		System.out.println(str);                        // "Vaibhav,Nigam,Java,Developer" -> unchanged (immutable)

		str2 = "a ,,b";
		StringTokenizer stkzr = new StringTokenizer(str2, ",");
		System.out.println(stkzr.countTokens());   // 2 -> empty token between the two commas is SKIPPED
		while (stkzr.hasMoreTokens()) {
			System.out.print(stkzr.nextToken());     // "a b" -> prints back-to-back, no separator added
		}
		System.out.println();                          // line break for readability

		str3 = "a,,b";
		String[] parts3 = str3.split(",");
		System.out.println(Arrays.toString(parts3));   // "[a, , b]" -> empty string INCLUDED, unlike StringTokenizer


		// ===================== 23. split() with regex patterns =====================
		str = "Vaibhav123Nigam456Java";
		parts = str.split("\\d+");                       // splits on one-or-more consecutive digits
		System.out.println(Arrays.toString(parts));     // "[Vaibhav, Nigam, Java]"

		str2 = "one, two,three  ,four";
		String[] parts2 = str2.split("\\s*,\\s*");        // splits on comma with any optional spaces around it
		System.out.println(Arrays.toString(parts2));      // "[one, two, three, four]"


		// ===================== 24. split() limit parameter =====================
		String str4 = "a:b:c:d";
		String[] parts4 = str4.split(":", 2);
		System.out.println(Arrays.toString(parts4));     // "[a, b:c:d]" -> limit 2, only the first split happens

		String[] parts5 = str4.split(":", -1);
		System.out.println(Arrays.toString(parts5));      // "[a, b, c, d]" -> negative limit, all splits happen

		String data = "a,b,,";
		System.out.println(Arrays.toString(data.split(",")));       // "[a, b]"       -> default: trailing empties removed
		System.out.println(Arrays.toString(data.split(",", 0)));     // "[a, b]"       -> 0 behaves same as default
		System.out.println(Arrays.toString(data.split(",", -1)));    // "[a, b, , ]"   -> trailing empties preserved
		System.out.println(Arrays.toString(data.split(",", 2)));     // "[a, b,,]"     -> only 2 parts, rest kept as-is

		System.out.println(Arrays.toString("a,,b".split(",")));      // "[a, , b]" -> middle empty string always shows, limit doesn't affect it


		// ===================== 25. split() regex trap: escaping special characters =====================
		String str10 = "192.168.1.1";
		String[] parts10 = str10.split(".");       // ❌ WRONG -> "." in regex means "any character", not a literal dot
		System.out.println(Arrays.toString(parts10));   // "[]" -> every position matches, all resulting pieces are empty and trimmed away

		String[] parts11 = str10.split("\\.");      // ✅ CORRECT -> \\. escapes the dot to mean a literal "."
		System.out.println(Arrays.toString(parts11));   // "[192, 168, 1, 1]"
	}
}