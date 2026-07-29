import java.util.Scanner;

public class MatrixPractice {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int choice;

		do {

			System.out.println("\n========== MATRIX PRACTICE ==========\n");

			System.out.println("16. Add Two Matrices");
			System.out.println("17. Subtract Two Matrices");
			System.out.println("18. Check Whether Matrices are Equal");
			System.out.println("19. Sum of Main Diagonal Elements");
			System.out.println("20. Sum of Each Row and Column");
			System.out.println("21. Check Identity Matrix");
			System.out.println("22. Scalar Matrix Multiplication");
			System.out.println("23. Check Square Matrix");
			System.out.println("24. Check Symmetric Matrix");
			System.out.println("25. Percentage Using Array");
			System.out.println("26. Enter New Matrix");
			System.out.println(" 0. Exit");

			System.out.print("\nEnter your choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 16:
				break;

			case 17:
				break;

			case 18:
				break;

			case 19:
				break;

			case 20:
				break;

			case 21:
				break;

			case 22:
				break;

			case 23:
				break;

			case 24:
				break;

			case 25:
				break;

			case 26:
				break;

			case 0:
				System.out.println("Thank You!!");
				break;

			default:
				System.out.println("Invalid Choice!");
			}

			System.out.println("\n-------------------------------------------\n");

		} while (choice != 0);

		sc.close();
	}
}