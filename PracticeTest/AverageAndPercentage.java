public class AverageAndPercentage {
public static void main (String ... args ) {
	byte a = Byte.parseByte(args[0]);
	byte b = Byte.parseByte(args[1]);
	byte c = Byte.parseByte(args[2]);
	byte d = Byte.parseByte(args[3]);
	byte e = Byte.parseByte(args[4]);
	System.out.println("Entered Marks are " + args[0] + " " + args[1] + " "+ args[2] + " "+ args[3] + " "+ args[4] + " ");
	int sum = a + b + c + d + e ;
	float average = (float)sum/5; 
	System.out.println("Average marks are " + average );
	System.out.println("Percentage is " + average +"%");
}
} 
	