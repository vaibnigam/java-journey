public class PrintASCIITable {
	public static void main(String args[]) {
		printASCII();
		
}

static void printASCII(){
for (int i = 0; i <= 127; i++) {
    System.out.println(i + " -> " + (char) i); }
}
}