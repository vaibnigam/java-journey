public class ArithmeticOps{
	public static void main(String args[]){
	int length = 2;
	int breadth = 4;

	System.out.println("Area of rectangle is " + (length*breadth));

	int radius = 5;
	System.out.println("Area of circle is " + (3.14*radius*radius));
	System.out.println("Ciurcumefrence is " + (2*3.14*radius));
	
	int num = 91;
	System.out.println("Square of number is " + (num*num) + " and cube of number is " + (num*num*num));

	int x = -30;
	int y = 4;
	int z = -4;

	System.out.println("-30 divide by 4 is " + x/y + " reminder is " + x%y );
	System.out.println("-30 divide by -4 is " + x/z + " reminder is " + x%z );
}
}

	