import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = inputArray1D(sc);
		int choice;
		do {
			displayMenu();
			printArray(array);
			System.out.print("\nEnter your choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				sumCountAndProduct(array);
				break;
			case 2:
				displayArrayInReverse(array);
				break;
			case 3:
				copyArray(array);
				break;
			case 4:
				countTotalAndDuplicateElements(array);
				break;
			case 5:
				printUniqueElements(array);
				break;
			case 6, 11:
				findMaximumAndMinimum(array);
				break;
			case 7:
				separateOddAndEvenElements(array);
				break;
			case 8:
				sortAscending(array);
				break;
			case 9:
				sortDescending(array);
				break;
			case 10:
				insertElement(array, sc);
				break;
			case 12:
				findSecondLargest(array);
				break;
			case 13:
				mergeArrays(array);
				break;
			case 14:
				leftRotate(array, sc);
				break;
			case 15:
				rightRotate(array, sc);
				break;
			case 16:
				array = inputArray1D(sc);
				break;
			case 0:
				System.out.println("Thankyou!!");
				break;
			default:
				System.out.println("Invalid Choice!");
			}
			System.out.println("\n-------------------------------------------\n");
		} while (choice != 0);
		sc.close();
	}

	private static void displayMenu() {
		System.out.println("\n========== What do you Want!! ==========\n");

		System.out.println(" 1. Sum, Count and Product of Array Elements");
		System.out.println(" 2. Display Array in Reverse");
		System.out.println(" 3. Copy One Array into Another");
		System.out.println(" 4. Count Total and Duplicate Elements");
		System.out.println(" 5. Print Unique Elements");
		System.out.println(" 6. Find Maximum and Minimum Element");
		System.out.println(" 7. Separate Odd and Even Elements");
		System.out.println(" 8. Sort Array in Ascending Order");
		System.out.println(" 9. Sort Array in Descending Order");
		System.out.println("10. Insert New Value in Array");
		System.out.println("11. Find Largest and Smallest Element");
		System.out.println("12. Find Second Largest Element");
		System.out.println("13. Merge Two Arrays");
		System.out.println("14. Left Rotate Array");
		System.out.println("15. Right Rotate Array");
		System.out.println("16. Enter new array");
		System.out.println("0. Exit Program");

		System.out.println();
		System.out.println("Your array");
	}

	private static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	// ===================== ARRAY =====================
	private static int[] inputArray1D(Scanner sc) {
		int arraySize = 0;
		while (arraySize <= 0) {
			System.out.println("Enter size of array");
			arraySize = sc.nextInt();

			if (arraySize <= 0)
				System.out.println("Invalid size! Please enter a positive number.");
		}
		int[] array = new int[arraySize];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter " + (i + 1) + " Element");
			array[i] = sc.nextInt();
		}
		return array;
	}

	private static void sumCountAndProduct(int[] array) {

		int sum = 0;
		int product = 1;
		for (int x : array) {
			sum += x;
			product *= x;
		}
		System.out.println("Total elements in array : " + array.length);
		System.out.println("Sum of elements in array : " + sum);
		System.out.println("Product of elements in array : " + product);
	}

	private static void displayArrayInReverse(int[] array) {
//		"Null Array"
//		int[] array = null; There is no array object in memory.  
//		(array == null) --> It checks whether the array exists or not.

//		"Empty Array"
//		int[] array = new int[0];
//		(array.length == 0)  -->It checks whether the array exists but has no elements.

		System.out.print("Reverse : ");
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
	}

	private static void copyArray(int[] array) {

		// --------------------------------------------------
		// Method 1: Copy array manually using a loop
		// --------------------------------------------------

		int[] copyArray = new int[array.length]; // Create a new array of the same size

		for (int i = 0; i < array.length; i++) {
			copyArray[i] = array[i]; // Copy each element one by one
		}

		System.out.println(array == copyArray); // false -> Different array objects (different references)
		System.out.println(array.equals(copyArray)); // false -> equals() also compares references for arrays

		// --------------------------------------------------
		// Method 2: Copy array using clone()
		// --------------------------------------------------

		int[] clonedArray = array.clone(); // Creates a new array object with the same elements

		System.out.print("Copied Array: ");
		printArray(clonedArray);

		System.out.println(array == clonedArray); // false -> clone() creates a different array object
		System.out.println(array.equals(clonedArray)); // false -> Arrays inherit Object.equals(), so references are
														// compared

		// --------------------------------------------------
		// Method 3: Copy by Assignment
		// --------------------------------------------------

		int[] copy = array; // No new array is created; both variables point to the same array

		System.out.println(array == copy); // true -> Both references point to the same array object
		System.out.println(array.equals(copy)); // true -> Same object, so Object.equals() returns true

		// For all Java objects, if:a == b is true, then: a.equals(b) must also be true
	}

	private static void countTotalAndDuplicateElements(int[] array) {
		System.out.println("Total Elements: " + array.length);

		int duplicateCount = 0;
		System.out.print("Duplicate Elements: ");
		for (int i = 0; i < array.length; i++) {

			boolean alreadyProcessed = false;

			// Check whether the current element has already been processed
			for (int k = 0; k < i; k++) {
				if (array[i] == array[k]) {
					alreadyProcessed = true;
					break;
				}
			}

			if (alreadyProcessed) {
				continue;
			}

			// Search for another occurrence of the current element
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					duplicateCount++;
					System.out.print(array[i] + " ");
					break;
				}
			}
		}
		System.out.println();
		System.out.println("Number of Duplicate Elements: " + duplicateCount);
	}

	private static void printUniqueElements(int[] array) {

//		Distinct Elements -->	Appear at least once
//		Unique Elements -->	Appear exactly once.

		System.out.println("Total no of elements : " + array.length);
		System.out.print("Unique elements : ");
		boolean unique = true;
		
		for (int i = 0; i < array.length; i++) {
			int count = 0;
			for (int j = i + 1; j < array.length; j++) {
				for(int k = 0;k<i;k++) {
					if (array[i]==array[k]) 
					continue;
				}
				
				if (array[i] == array[j]) {
					count++;
				}
			}

			if (count==0) {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();
	}

	private static void findMaximumAndMinimum(int[] array) {
		int max = array[0];
		int min = array[0];
		for (int i = 0; i < array.length; i++) {

			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		System.out.println("Greatest element is : " + max);
		System.out.println("Lowest element is : " + min);

	}

	private static void separateOddAndEvenElements(int[] array) {

		System.out.print("Even : ");
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();
		System.out.print("Odd : ");
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
				System.out.print(array[i] + " ");
			}
		}

	}

	private static void sortAscending(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[i]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

	private static void sortDescending(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[i]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

	private static void insertElement(int[] array, Scanner sc) {

//		right now inserting element in end in a new array 

		System.out.println("Enter element to insert");
		int element = sc.nextInt();
		int[] newArray = new int[array.length + 1];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		newArray[newArray.length - 1] = element;
		printArray(newArray);

	}

	private static void findSecondLargest(int[] array) {

		int[] sorted = Arrays.copyOf(array, array.length);
		printArray(sorted);
		
		System.out.print("Second Largest : ");
		
	}

	private static void mergeArrays(int[] array) {
		int[] newArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] mergedArray = new int[array.length + newArray.length];

		for (int j = 0; j < array.length; j++) {
			mergedArray[j] = array[j];
		}
		for (int i = 0; i < newArray.length; i++) {
			mergedArray[array.length + i] = newArray[i];
		}

//		System.out.println(mergedArray.toString()); --> it will print memory address
		System.out.println(Arrays.toString(mergedArray));

	}

	private static void leftRotate(int[] array, Scanner sc) {
		System.out.println("Enter how many left rotations you want:");
		int k = sc.nextInt();

		// Normalize rotations to handle values greater than array length and negative
		// rotations
		k = ((k % array.length) + array.length) % array.length;

		System.out.print("Rotated array: ");

		int[] rotatedArray = new int[array.length];

		// Copy elements from index k to the end of the original array
		// and place them at the beginning of the rotated array
		for (int i = k; i < array.length; i++) {
			rotatedArray[i - k] = array[i];
		}

		// Copy the first k elements of the original array
		// to the last k positions of the rotated array
		for (int j = 0; j < k; j++) {
			rotatedArray[array.length - k + j] = array[j];
		}

		// Display the rotated array
		System.out.println(Arrays.toString(rotatedArray));
	}

	private static void rightRotate(int[] array, Scanner sc) {
		System.out.println("Enter how many right rotations you want:");
		int k = sc.nextInt();
		k = ((k % array.length) + array.length) % array.length;
		System.out.print("Rotated array: ");
		int[] rotatedArray = new int[array.length];
		for (int i = 0; i < k; i++) {
			rotatedArray[i] = array[array.length - k + i];
		}
		for (int i = k; i < array.length; i++) {
			rotatedArray[i] = array[i - k];
		}
		System.out.println(Arrays.toString(rotatedArray));
	}

}