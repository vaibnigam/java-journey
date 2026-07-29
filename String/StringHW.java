
public class StringHW {
	public static void main(String[] args) {
		String s1 = "ABCD";
		String s2 = "ABCD";
		String s3 = new String("ABCD");

		System.out.println(s1 == s2); // true --> (==) compares references
		System.out.println(s1 == s3); // false
		System.out.println(s1.equals(s3)); // true --> (.equals) compares content

//		intern() manually Pool mein string daalta hai ya existing Pool reference return karta hai.
		String s4 = s3.intern();
		System.out.println(s1 == s4); // true --> (==) compares references

		StringBuilder sb1 = new StringBuilder();
		sb1.append("Hey ");
		System.out.println(sb1.toString());
		while (sb1.length() < 10) {
			sb1.append("Heyy ");
		}
		String result1 = sb1.toString();
		System.out.println(result1);
		sb1.setLength(0);
		System.out.println(sb1);
		sb1.append("Heyy Vaib");

		StringBuilder sb = new StringBuilder("Hello");
		System.out.println(sb.append(" Vaib")); // Hello Vaib
		System.out.println(sb); // Hello Vaib
		System.out.println(sb.charAt(6)); // V
		StringBuilder sb2 = new StringBuilder("hello vaib");
		System.out.println(sb.compareTo(sb2));

		StringBuilder a = new StringBuilder("apple");
		StringBuilder b = new StringBuilder("apple");
		System.out.println(a.compareTo(b));
		// 0 -> dono strings exactly same hain, koi mismatch nahi mila

		StringBuilder c = new StringBuilder("apple");
		StringBuilder d = new StringBuilder("banana");
		System.out.println(c.compareTo(d));
		// -1 -> pehla mismatch: 'a'(97) vs 'b'(98), diff = 97-98 = -1

		StringBuilder e = new StringBuilder("banana");
		StringBuilder f = new StringBuilder("apple");
		System.out.println(e.compareTo(f));
		// 1 -> pehla mismatch: 'b'(98) vs 'a'(97), diff = 98-97 = 1

		StringBuilder g = new StringBuilder("app");
		StringBuilder h = new StringBuilder("apple");
		System.out.println(g.compareTo(h));
		// -2 -> "app" ke saare characters "apple" se match ho gaye,
		// lekin "app" chota hai, length diff = 3 - 5 = -2

		StringBuilder i = new StringBuilder("apple");
		StringBuilder j = new StringBuilder("app");
		System.out.println(i.compareTo(j));
		// 2 -> ulta case, "apple" bada hai "app" se, length diff = 5 - 3 = 2

		StringBuilder k = new StringBuilder("Zebra");
		StringBuilder l = new StringBuilder("apple");
		System.out.println(k.compareTo(l));
		// -32 -> 'Z'(90) vs 'a'(97), diff = 90-97 = -32
		// yaha dhyan de: uppercase 'Z' bhi lowercase 'a' se chota treat hota hai
		// kyunki ASCII mein sabhi uppercase letters (65-90) lowercase (97-122) se pehle
		// aate hain

		StringBuilder m = new StringBuilder("Vaibhav");
		StringBuilder n = new StringBuilder("Vaibhav");
		System.out.println(m.compareTo(n)); // 0

		System.out.println(sb.isEmpty()); // false
		System.out.println(sb); // Hello Vaib
		sb.insert(10, " Nigam"); // Hello Vaib Nigam
		sb.insert(0, "Nigam "); // Nigam Hello Vaib Nigam
		sb.insert(6, "Nigam "); // Nigam Nigam Hello Vaib Nigam
		System.out.println(sb);

		sb.delete(0, 6); // Nigam Hello Vaib Nigam
		sb.delete(6, 12); // Nigam Vaib Nigam
		sb.delete(0, 6); // Vaib Nigam
		System.out.println(sb);

		sb.deleteCharAt(4); // VaibNigam
		sb.insert(4, " "); // Vaib Nigam
		System.out.println(sb);

		System.out.println(sb.reverse()); // magiN biaV
		System.out.println(sb.reverse()); // Vaib Nigam

		sb.replace(0, 4, "Vaibhav"); // Vaibhav Nigam
		System.out.println(sb);

		String result = new StringBuilder().append("Hello").append(" ").append("World").toString();

		System.out.println(result);

		StringBuilder sb3 = new StringBuilder();
		System.out.println(sb.isEmpty()); // false
		sb3.append(" ");
		System.out.println(sb.isEmpty()); // false

		String str2 = "";
		System.out.println(str2.isBlank()); // true
		System.out.println(str2.isEmpty()); // true

		String str3 = " ";
		System.out.println(str3.isBlank()); // true
		System.out.println(str3.isEmpty()); // false

		String str = "  My Name is vaibhav  ";
		System.out.println(str.trim());
		// "My Name is vaibhav" -> leading aur trailing dono spaces hat gaye

		System.out.println(str.strip());
		// "My Name is vaibhav" -> same result yaha, but strip() Unicode whitespace
		// bhi handle karta hai (jaise non-breaking space), trim() sirf ASCII
		// space/control chars tak limited hai

		System.out.println(str.stripLeading());
		// "My Name is vaibhav " -> sirf shuru ke spaces hate, trailing spaces waise hi
		// rahe

		System.out.println(str.stripTrailing());
		// " My Name is vaibhav" -> sirf end ke spaces hate, leading spaces waise hi
		// rahe

		System.out.println(str);
		// " My Name is vaibhav " -> original str bilkul unchanged hai
		// kyunki String immutable hai — koi bhi method naya String return karta hai,
		// original ko nahi todta

		System.out.println(str.toLowerCase()); // my name is vaibhav
		System.out.println(str.toUpperCase()); // MY NAME IS VAIBHAV
		System.out.println(str); // My Name is vaibhav

		System.out.println("hello".equals("Hello"));
		; // false
		System.out.println("hello".equalsIgnoreCase("Hello"));
		; // true
		System.out.println("ha".repeat(3)); // hahaha

		System.out.println(String.format("My name is %s and I am %d years old", "vaibhav", 28));
		System.out.println(String.format(
				"String is %s and Float is %f and Newline is %n and Integer is %d and Char is %c and Boolean is %b ",
				"string", 2.8, 28, 'V', true));

		System.out.println(str);
		System.out.println(str.substring(5)); // Name is vaibhav
		System.out.println(str.substring(5, 12)); // Name is

		String string = "12345678909876543212345678999009876512345678";
		System.out.println(string.indexOf("12")); // string
		System.out.println(string.indexOf('6')); // char
		System.out.println(string.lastIndexOf("12"));
		System.out.println(string.lastIndexOf('8'));
		System.out.println(string.contains("9098")); // true
		System.out.println(string.startsWith("123")); // true
		System.out.println(string.endsWith("6789")); // false
		System.out.println(string.endsWith("678")); // true

		string = "123456789";
		System.out.println(string.substring(2)); // 3456789
		System.out.println(string.substring(3, 7)); // 3456789
		System.out.println(string); // 123456789

		string = "ABCDEFGHIJABABCDCDEFEFGHGHIJIJ";
		System.out.println(string.replaceAll("AB", "00")); // 00CDEFGHIJ0000CDCDEFEFGHGHIJIJ
		System.out.println(string.replaceFirst("AB", "00")); // 00CDEFGHIJABABCDCDEFEFGHGHIJIJ
		System.out.println(string.replace('A', 'Z')); // ZBCDEFGHIJZBZBCDCDEFEFGHGHIJIJ
		System.out.println(string.replace("AB", "00")); // 00CDEFGHIJ0000CDCDEFEFGHGHIJIJ
		
		string="123456789";
		System.out.println(string.concat("0000"));//1234567890000
		System.out.println(string); //123456789
		string = string.concat("-ONETWOTHREEFOUR");
		System.out.println(string);//123456789-ONETWOTHREEFOUR
	}
}
