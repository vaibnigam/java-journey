import java.util.Scanner;

public class DistancetwoPoints {
	public static void main (String ... Args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Point's x cordinate");
		double x1 = sc.nextDouble();		
		
		System.out.println("Enter First Point's y cordinate");
		double y1 = sc.nextDouble();

		System.out.println("Enter Second Point's x cordinate");
		double x2 = sc.nextDouble();

		System.out.println("Enter Second Point's y cordinate");
		double y2 = sc.nextDouble();
		
		double dx = x1-x2;
		double dy = y1-y2;

		double distance = Math.sqrt(dx*dx + dy*dy);
		System.out.println("distance between two points is " + distance);
}
}
