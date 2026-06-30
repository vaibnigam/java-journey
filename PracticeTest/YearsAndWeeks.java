import java.util.Scanner;

public class YearsAndWeeks {
	public static void main (String Args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter days");
		long days = sc.nextInt();

		System.out.println("In " + days + " days. There are total " + (days/365) + " years and " + (days%365) + " days. ");
		System.out.println("In " + days + " days. there are total " + days/7 + " weeks and " + days%7 + " days.");
}
}