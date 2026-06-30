public class SwapTwoVariables2 {
	public static void main(String args[]){
		int a = 10;
		int b = 20;
		System.out.println("value of a is " + a);
		System.out.println("value of b is " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a is now " + a);
		System.out.println("b is now " + b);
	}
}