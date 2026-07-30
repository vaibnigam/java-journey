import java.util.Arrays;

public class RegexNegationDemo {
	public static void main(String[] args) {

		// ===================== 1. NEGATION BASICS: [^...] =====================
		// [0-9]  -> in mein se koi ek: 0 se 9 tak ka digit
		// [^0-9] -> in ke ALAWA koi ek: digit ke alawa kuch bhi (letter, space, symbol, etc.)
		// '^' as the FIRST character inside [] flips the meaning to "NOT these"

		System.out.println("5".matches("[^0-9]"));    // false -> '5' ek digit hai, negation isse reject karega
		System.out.println("a".matches("[^0-9]"));     // true  -> 'a' digit nahi hai, isliye match hua
		System.out.println(" ".matches("[^0-9]"));     // true  -> space bhi digit nahi hai
		System.out.println("@".matches("[^0-9]"));      // true  -> symbol bhi digit nahi hai


		// ===================== 2. REAL USE CASE: EXTRACT ONLY NUMBERS =====================
		// [^0-9]+ -> ek ya zyada consecutive non-digit characters, delimiter ke roop mein use
		String text = "Order 101 shipped, Order 102 pending";
		String[] numbers = text.split("[^0-9]+");
		System.out.println(Arrays.toString(numbers));
		// [, 101, 102] -> pehla element empty string hai kyunki string letter se start hoti hai
		// (split ka rule: delimiter agar string ki shuruaat mein hi mile, to empty string result ke start mein aati hai)


		// ===================== 3. NEGATION WITH DIFFERENT CHARACTER CLASSES =====================
		System.out.println("m".matches("[a-z]"));      // true  -> 'm' lowercase letter hai
		System.out.println("m".matches("[^a-z]"));      // false -> lowercase letters ke alawa sab chahiye, 'm' unmein se hai isliye reject

		System.out.println("5".matches("[^a-z]"));       // true -> digit hai, lowercase letter nahi, isliye match hua
		System.out.println(" ".matches("[^a-z]"));        // true -> space bhi lowercase letter nahi hai

		System.out.println("a".matches("[aeiou]"));       // true  -> 'a' ek vowel hai
		System.out.println("a".matches("[^aeiou]"));       // false -> vowels ke alawa sab chahiye, 'a' khud vowel hai isliye reject
		System.out.println("b".matches("[^aeiou]"));        // true  -> 'b' consonant hai, vowel nahi -> match


		// ===================== 4. NEGATION IN split() : REMOVING UNWANTED CHARACTERS =====================
		// sentence se sirf words nikalna, punctuation ko delimiter bana ke
		String sentence = "Hello, World! How are you?";
		String[] words = sentence.split("[^a-zA-Z]+");   // jo letter nahi hai, uska group delimiter ban gaya
		System.out.println(Arrays.toString(words));
		// [Hello, World, How, are, you]


		// ===================== 5. '^' KA DO ALAG MATLAB - CONTEXT SE PEHCHANO =====================
		// Case A: character class ke ANDAR, pehle position pe -> NEGATION
		System.out.println("5".matches("[^0-9]"));       // false -> yaha ^ negation hai (character class ke andar)

		// Case B: character class ke BAHAR, pattern ke start mein -> START-OF-STRING ANCHOR
		System.out.println("Hello World".matches("^Hello.*"));   // true -> yaha ^ anchor hai, negation nahi
	}
}