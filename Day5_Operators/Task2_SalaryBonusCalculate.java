
import java.util.Scanner;

public class Task2_SalaryBonusCalculate {

    private static final double SPECIAL_BONUS_RATE = 0.15;
    private static final double STANDARD_BONUS_RATE = 0.10;
    private static final int SPECIAL_RATING_THRESHOLD = 9;
    private static final int STANDARD_RATING_THRESHOLD = 7;
    private static final int MIN_EXPERIENCE_YEARS = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = readEmployeeName(sc);
        float experience = readExperience(sc);
        double salary = readSalary(sc);
        int rating = readRating(sc);
        boolean onProbation = readProbationStatus(sc);

        sc.close();

        double bonusAmount = calculateBonus(experience, salary, rating, onProbation);
        boolean isEligible = bonusAmount > 0;

        printResult(name, isEligible, bonusAmount);
    }

    private static String readEmployeeName(Scanner sc) {
        System.out.println("Employee name");
        return sc.nextLine();
    }

    private static float readExperience(Scanner sc) {
        System.out.println("Years of experience");
        return sc.nextFloat();
    }

    private static double readSalary(Scanner sc) {
        System.out.println("Current salary");
        return sc.nextDouble();
    }

    private static int readRating(Scanner sc) {
        System.out.println("Performance rating out of 10");
        int rating = sc.nextInt();
        sc.nextLine();
        return rating;
    }

    private static boolean readProbationStatus(Scanner sc) {
        System.out.println("Is employee currently on probation? (Y/N)");
        char probation = sc.nextLine().charAt(0);
        return probation == 'Y';
    }

    private static double calculateBonus(float experience, double salary, int rating, boolean onProbation) {
        if (rating >= SPECIAL_RATING_THRESHOLD) {
            return salary * SPECIAL_BONUS_RATE;
        }

        boolean qualifiesForStandardBonus = experience >= MIN_EXPERIENCE_YEARS
                && rating >= STANDARD_RATING_THRESHOLD
                && !onProbation;

        if (qualifiesForStandardBonus) {
            return salary * STANDARD_BONUS_RATE;
        }

        return 0;
    }

    private static void printResult(String name, boolean isEligible, double bonusAmount) {
        System.out.println("Employee Name: " + name);
        System.out.println("Bonus Eligible: " + (isEligible ? "Yes" : "No"));
        System.out.println("Bonus Amount: " + bonusAmount);
    }
}
