public class ParsingConversionCasting {
	public static void main(String args[]) {
		// Conversion
		int x = 199;
		long l = x;
		double d = l;
		System.out.println(d + " : " + l);
		long t = 1998;
		float f = t;
		System.out.println(" : " + f);

		double z = 1234.234234;
		int y = (int) z;
		System.out.println(y);

		long w = 345678765432345L;
		int v = (int) w;
		System.out.println(v);
		System.out.println(v + w);
//**Java long ke 64 bits me se sirf sabse neeche (rightmost) 32 
//bits copy karke naya int bana deta hai — baaki upar ke 32 bits bina 
//kisi warning ke fenk (discard) de deta hai, aur jo bhi bits bache unhe 
//standard two's-complement rule se number me padha jata hai 
//(agar sabse pehla bacha hua bit 1 hai, toh result negative ban jata hai)

		int p = 223344;
		byte q = (byte) p;
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
		System.out.println(Integer.toBinaryString(-5));
		System.out.println(Integer.toBinaryString(5));
	}
}

//📦 ALL DATA TRANSFORMATIONS
//┃
//┣━━ 📂 CASTING (Compatible Types)
//┃    ┣━━ Primitives: [Widening] (Auto) vs. [Narrowing] (Manual Syntax)
//┃    ┗━━ Objects:    [Upcasting] (Auto) vs. [Downcasting] (Manual Syntax)
//┃
//┗━━ 📂 TYPE CONVERSION (Incompatible Types / Method-driven)
//     ┗━━ Specific Scenario: [Parsing] (String text ➔ Primitive Data)
