import java.time.LocalDateTime;

public class JavaStringSheetQuestions {
	public static void main(String[] args) {
		// q1
		String s = "Java Exercise";
		System.out.println(s.charAt(0));// J
		System.out.println(s.charAt(12));// e

		// q2
		String s1 = "vaib";
		String s2 = "nigam";
		String s3 = s1 + s2;
		System.out.println(s3); // vaibnigam
		String s4 = s1.concat(s2);
		System.out.println(s4); // vaibnigam
		System.out.println(s3==s4); //false
		System.out.println(s3.equals(s4)); //true
		
		//q3
		String s5="123vaibhav456nigam789";
		System.out.println(s5.contains("456"));//true
		System.out.println(s5.contains("Vaib"));//false //case-sensitive
		
		//q4
//		LocalDateTime dt = now
	}
}
