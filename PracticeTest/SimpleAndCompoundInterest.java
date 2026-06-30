import java.util.Scanner;
public class SimpleAndCompoundInterest {
	public static void main ( String ... args ) {	

		Interest intr = new Interest();
intr.takeInput();
		//double y = intr.simpleInterest();
		//double z = intr.compoundInterest();
		System.out.println("Simple Interest is " + intr.simpleInterest() );
		System.out.println("Compound Interest is " + intr.compoundInterest() );
}
}

class Interest {
Scanner sc = new Scanner(System.in);

double p ;
float t , r;

		void takeInput(){
		
		System.out.println("Enter Principal amount");
		 p = sc.nextDouble();

		System.out.println("Enter rate of interest");
		 r = sc.nextFloat();
		
		System.out.println("Enter tenure");
		 t = sc.nextFloat();}

	double simpleInterest(){
		double si = (p*r*t) / 100.0 ;
		return si;
		}

	double compoundInterest(){
		double A = p * Math.pow((1 + r/100.0), t);
		double ci = A - p;
		return ci;
}
}
		

		
	
		
		
		
		
		
		
		
		