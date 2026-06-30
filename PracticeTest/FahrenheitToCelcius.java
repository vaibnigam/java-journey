import java.util.Scanner;
public class FahrenheitToCelcius {
	public static void main (String ... args) {
		System.out.println("Enter temperature in Fahrenheit ");
		Scanner sc = new Scanner(System.in);
		float temp = sc.nextFloat();

		System.out.println("Temeprature in celsius is " +  (temp - 32 )* 5 / 9 );
}
}