import java.util.Scanner;
public class PrintAsciiValue{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a character");
		char a = sc.next().charAt(0);
		System.out.println("ASCII value of " + a + " is " + (int) a);
}
}