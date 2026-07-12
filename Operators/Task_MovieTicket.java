import java.util.Scanner;

public class Task_MovieTicket {
	static final int weekendCharge=20;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String name = customerName(sc);
		int age = customerAge(sc);
		double price = baseTicketPrice(sc);
		sc.nextLine();
		boolean isStudent = isStudent(sc);
		boolean isWeekend = isWeekend(sc);
		
		sc.close();
		
		int discount = discountPercent(age , isStudent , isWeekend);
		double finalPrice = calculateTicketPrice(price , discount , isWeekend , weekendCharge);
		printResult(name, discount, finalPrice);

	}

	private static String customerName(Scanner sc) {
		System.out.println("Customer Name");
		return sc.nextLine();
	}

	private static int customerAge(Scanner sc) {
		System.out.println("Customer Age");
		return sc.nextInt();
	}

	private static boolean isStudent(Scanner sc) {
		System.out.println("Is customer a student");
		char student = sc.nextLine().charAt(0);
		return student == 'Y';
	}

	private static boolean isWeekend(Scanner sc) {
		System.out.println("Is it a weekend day");
		char student = sc.nextLine().charAt(0);
		return student == 'Y';
	}

	private static double baseTicketPrice(Scanner sc) {
		System.out.println("Ticket Price");
		return sc.nextDouble();
	}

	public static void printResult(String name, int discount, double finalPrice) {
		System.out.println("Customer Name : " + name);
		System.out.println("Discount Applied : " + discount + "%");
		System.out.println("Final Price : " + finalPrice);
	}

	public static int discountPercent(int age , boolean isStudent , boolean isWeekend) {
		int discountApplied=0;
		if (age >= 60) {
			discountApplied = 30;}
		else if (isStudent && !isWeekend) {
			discountApplied = 20;}
		else if (age < 12) {
			discountApplied = 15;}
		else
			{discountApplied = 0;}
		return discountApplied;
	}
	public static double calculateTicketPrice(double price , int discount , boolean isWeekend ,int weekendCharge ) {
		double finalTicketPrice=0;
		if (isWeekend) {
			finalTicketPrice=price-(price * ((double)discount/100)) + weekendCharge;
		}else
		{
			finalTicketPrice=price-(price*((double)discount/100));}
		return finalTicketPrice;
}
}