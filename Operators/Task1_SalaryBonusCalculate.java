import java.util.Scanner;

public class Task1_SalaryBonusCalculate {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Employee name");
		String name = sc.nextLine();
		System.out.println("Years of experience");
		float years = sc.nextFloat();
		System.out.println("Current salary");
		double salary = sc.nextDouble();
		System.out.println("Performance rating out of 10");
		int rating = sc.nextInt();
		sc.nextLine();
		System.out.println("Is employee currently on probation (char — 'Y' ya 'N')");
		char probation = sc.nextLine().charAt(0);
		double bonusAmount;
		String bonusEligible;
		sc.close();

		if (rating >= 9) {
			bonusAmount = (salary * (.15));
			bonusEligible = "Yes";
			
		} else if (years >= 2 && probation == 'N' && rating >= 7) {
			bonusAmount = (salary * (.10));
			bonusEligible = "Yes";
			
		} else {
			bonusEligible = "No";
			bonusAmount = 0;
			
		}
		System.out.println("Employee Name: " + name);
		System.out.println("Bonus Eligible: " + bonusEligible);
		System.out.println("Bonus Amount: " + bonusAmount);
	}
}
