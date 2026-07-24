
public class UNICODE {
	public static void main(String args[]) {
		for (char i = '\u0905'; i <= '\u0939'; i++) {
			System.out.print(i + " ");
		}
		System.out.println(" ");
		String namaste = "\u0928\u092E\u0938\u094D\u0924\u0947";
		System.out.println(namaste + " ");

		System.out.println("Hindi Digits:");
		for (int i = 0x0966; i <= 0x096F; i++) {
			char digit = (char) i;
			System.out.print(digit + " ");
		}
		 System.out.println("\u0950");//om
	}
}
