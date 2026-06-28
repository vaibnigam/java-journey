public class Identifiers {
	public static void main ( String args[]) {
		int age = 5;
		int Age = 10;
		System.out.println(age + " " + Age);

		char c = 'd';
		char C = 'e';
		System.out.println(c + " " + C);

		String s = "vaibhav Nigam" ;
		String S = "Vaib";
		System.out.println(s + " " + S);
		
		Keywords k = new Keywords();
		k.show(20);
	}
}

class Keywords{
	
void show( int statics){
	System.out.println(2*statics);}
}
		