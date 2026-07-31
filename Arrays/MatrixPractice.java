import java.util.Arrays;
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
			System.out.println(" 0. Exit");

			System.out.print("\nEnter your choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 16:
				addMatrices();
				break;

			case 17:
				subtractMatrices();
				break;

			case 18:
				equalMatrices();
				break;

			case 19:
				sumDiagonal();
				break;

			case 20:
				rowAndColoumnSum();
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

	private static void rowAndColoumnSum() {
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

//		int[][] matrix2 = { { 11, 22, 33 }, { 44, 55, 66 }, { 77, 88, 99 } };
		int sum = 0;
		for (int i = 0; i < matrix1.length; i++) {
			sum = 0;
			for (int j = 0; j < matrix1[i].length; j++) {
				sum += matrix1[i][j];
			}
			System.out.printf("Sum of %d row is %d", i + 1, sum);
			System.out.println();
		}
	}

	private static void sumDiagonal() {
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] matrix2 = { { 11, 22, 33 }, { 44, 55, 66 }, { 77, 88, 99 } };

		int sum1 = 0;
		for (int i = 0; i < matrix1.length; i++) {
			if (i == matrix1.length - i - 1) {
				sum1 += matrix1[i][i];
			} else {
				sum1 += (matrix1[i][i] + matrix1[i][matrix1.length - i - 1]);
			}
		}
		int sum2 = 0;
		for (int i = 0; i < matrix2.length; i++) {
			if (i == matrix2.length - i - 1) {
				sum2 += matrix2[i][i];
			} else {
				sum2 += (matrix2[i][i] + matrix2[i][matrix2.length - i - 1]);
			}
		}
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum1 + sum2);

	}

	private static void equalMatrices() {
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

//		int[][] matrix2 = { { 11, 22, 33 }, { 44, 55, 66 }, { 77, 88, 99 } }; //notequal
//		int[][] matrix2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; //equal
		int[][] matrix2 = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } }; // not equal

		boolean isEqual = true;
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[i].length; j++) {
				if (matrix1[i][j] != matrix2[i][j]) {
					isEqual = false;
				}
			}
		}
		System.out.println(isEqual ? "Equal" : "NotEqual");
	}

	private static void subtractMatrices() {
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] matrix2 = { { 11, 22, 33 }, { 44, 55, 66 }, { 77, 88, 99 } };

		int[][] newMatrix = new int[matrix1.length][matrix1[0].length];

		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[i].length; j++) {
				newMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
			}
		}
		System.out.println(Arrays.deepToString(newMatrix));
	}

	private static void addMatrices() {
		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] matrix2 = { { 11, 22, 33 }, { 44, 55, 66 }, { 77, 88, 99 } };

		int[][] newMatrix = new int[matrix1.length][matrix1[0].length];

		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[i].length; j++) {
				newMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		System.out.println(Arrays.deepToString(newMatrix));
	}
}