public class FirstTask {
	public static void main (String ... args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[2]);
		String op = args[1];
	if(op.equals("+")) {
            System.out.println(a+b);
        }
        else if(op.equals("-")) {
            System.out.println(a-b);
        }
        else if(op.equals("*")) {
            System.out.println(a*b);
        }
        else if(op.equals("/")) {
           System.out.println(a/b);
        }
   
	}
}