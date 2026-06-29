public class ParsingConversionCasting {
	public static void main(String args[]) {
		//Conversion
		int x = 199;
		long l = x;
		double d = l;
	System.out.println(d + " " + l);
		long t = 1998;
		float f = t;
	System.out.println(" " + f);

 double z = 1234.234234;
int y = (int) z ;
System.out.println(y);

long w = 345678765432345L;
int v = (int) w;
System.out.println (v);

int p = 223344;
byte q = (byte) p ;
System.out.println(q);

double o = 123456789.123456789;
float m = (float) o;
System.out.println(m);

int xx = 100;
String s = "1234";
int yy = Integer.parseInt(s);
System.out.println(yy + "yy");

String st = String.valueOf(xx);
System.out.println(st);
}}
