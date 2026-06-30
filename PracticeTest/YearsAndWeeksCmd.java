public class YearsAndWeeksCmd {
	public static void main ( String Args[]) {

	long days = Long.parseLong(Args[0]);
		System.out.println(" In " + days + " days . There are total " + days/365 + " years and " + days%365 + " days ");
System.out.println(" In " + days + " days . There are total " + days/7 + " weeks and " + days%7 + " days ");

}
}