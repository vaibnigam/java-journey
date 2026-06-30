import java.util.Scanner;
public class CelciusToFahrenheit {
	public static void main (String ... args) {
		System.out.println("Enter temperature in Celcius");
		Scanner sc = new Scanner(System.in);
		float temp = sc.nextFloat();

		System.out.println("Temeprature in Fahrenheit is " + ((temp * 9 / 5 ) + 32 ) );
}
}