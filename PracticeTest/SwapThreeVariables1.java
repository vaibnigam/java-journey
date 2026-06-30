public class SwapThreeVariables1 { 
	public static void main(String ... args) {
		int a = 10;
		int b = 20;
		int c = 30;
                int d ;
	System.out.println("Value of a is : " + a + ". Value of b is : " + b + ". Value of c is : " + c );
		
		d = a ;
		a = b;
		b = c;
		c = d;
		 
System.out.println("Value of a is now : " + a + ". Value of b is now : " + b + ". Value of c is now : " + c );
}
}