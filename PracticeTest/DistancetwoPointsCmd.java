public class DistancetwoPointsCmd {
	public static void main (String ... Args) {

		
		double x1 = Double.parseDouble(Args[0]);		
		double x2 = Double.parseDouble(Args[1]);
		double y1 = Double.parseDouble(Args[2]);
		double y2 = Double.parseDouble(Args[3]);
		
		double dx = x1-x2;
		double dy = y1-y2;

		double distance = Math.sqrt(dx*dx + dy*dy);
		System.out.println("distance between two points is " + distance);
}
}
