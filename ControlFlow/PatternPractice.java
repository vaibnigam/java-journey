public class PatternPractice {
	public static void main(String[] args) {
		pattern27();
		pattern1();
		pattern2();
		pattern3();
		pattern4();
		pattern5();
		pattern6();
		pattern7();
		pattern8();
		hW1();
		hW2();
		pattern9();
		pattern10();
		pattern11();
		pattern12();
		pattern13();
		pattern14();
		pattern15();
		pattern16();
		pattern17();
		pattern18();
		pattern19();
		pattern20();
		pattern21();
		pattern22();
		pattern23();
		pattern24();
		pattern25();
	}

	private static void pattern27() {
		System.out.println("\n--Q27---------------\n");

//			1 2 3 4 5
//			2 4 6 8 10
//			3 6 9 12 15
//			4 8 12 16 20
//			5 10 15 20 25

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(i * j + " ");
			}
			System.out.println();
		}

	}

	private static void pattern1() {
		System.out.println("\n--Q1---------------\n");

//		*
//		* *
//		* * *
//		* * * *

		int n = 4;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void pattern3() {
		System.out.println("\n--Q3---------------\n");

//		1
//		2 2
//		3 3 3
//		4 4 4 4

		int n = 4;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	private static void pattern2() {
		System.out.println("\n--Q2---------------\n");

//		1
//		1 2
//		1 2 3
//		1 2 3 4

		int n = 4;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	private static void pattern4() {
		System.out.println("\n--Q4---------------\n");

//		10 9 8 7
//		6 5 4
//		3 2 
//		1

		int n = 4;
		int num = 10;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n + 1 - i; j++) {
				System.out.print(num-- + " ");
			}
			System.out.println();
		}
	}

	private static void pattern5() {
		System.out.println("\n--Q5---------------\n");

//		1
//		2 3
//		4 5 6
//		7 8 9 10

		int n = 4;
		int num = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(num++ + " ");
			}
			System.out.println();
		}
	}

	private static void pattern6() {
		System.out.println("\n--Q6---------------\n");

//		* * * *
//		* * *
//		* *
//		*

		int n = 4;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= (n + 1) - i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void pattern7() {
		System.out.println("\n--Q7---------------\n");

//		    *
//		   * *
//		  * * *
//		 * * * *
//		* * * * *

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int k = n; k >= i; k--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void pattern8() {
		System.out.println("\n--Q8---------------\n");

//		1
//		0 1
//		1 0 1
//		0 1 0 1
//		1 0 1 0 1

		int n = 5;
		for (int i = 1; i <= n; i++) {
			int num = i;
			for (int j = 1; j <= i; j++) {
				System.out.print(num++ % 2 == 0 ? "0 " : "1 ");
			}
			System.out.println();
		}
	}

	private static void hW1() {
		System.out.println("\n--HW1---------------\n");
//		------------------------------------------
//		*
//		* *
//		* * *
//		* * * *
//		* * * * *

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();

//		------------------------------------------
//		
//		* * * * *
//		* * * *
//		* * *
//		* *
//		* 

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n + 1 - i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();

//		-------------------------------------------
//		
//		* * * * * 
//		  * * * * 
//		    * * * 
//		      * *
//			    *

		for (int i = 1; i <= n; i++) {
			for (int k = 1; k < i; k++) {
				System.out.print("  ");
			}
			for (int j = n; j >= i; j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void hW2() {
		System.out.println("\n--HW2---------------\n");

//	-----------------------------------------------
//		
//			        *
//			       * * 
//			      * * * 
//			     * * * * 
//			    * * * * * 

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int k = n; k >= i; k--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		System.out.println();

//		-----------------------------------------------
//
//			        * 
//			      * * *
//			    * * * * *
//			  * * * * * * *
//			* * * * * * * * * 
		n = 5;
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= n - i; k++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
//		-----------------------------------------------
//
//			  	    * 
//			      * * *
//			    * * * * *
//			  * * * * * * *
//			* * * * * * * * * 
//			  * * * * * * *
//			    * * * * *
//			      * * *
//				    *
		n = 5;
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= n - i; k++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for (int i = n - 1; i >= 1; i--) {
			for (int k = 1; k <= n - i; k++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
//		-----------------------------------------------
//
//				 * * * * *
//				 *       *
//				 *       * 
//				 *       *
//				 * * * * *
		n = 5;
		for (int i = 1; i <= n; i++) {
			if (i == 1 || i == n) {
				for (int j = 1; j <= n; j++) {
					System.out.print(" *");
				}
			} else {
				for (int j = 1; j <= n; j++) {
					if (j == 1 || j == n) {
						System.out.print(" *");
					} else {
						System.out.print("  ");
					}
				}
			}
			System.out.println();
		}
		System.out.println();
//		-----------------------------------------------
//
//			        * 
//			        *  
//			    * * * * * 
//				    * 
//				    *
		n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == n / 2 + 1 || j == n / 2 + 1) {
					System.out.print(" *");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println();
//		-----------------------------------------------
//		
//			   *       *
//		    	 *   * 
//			       *
//			     *   * 
//			   *       *
		n = 5;
		for (int i = 1; i <= n; i++) {
			int num = i;
			for (int j = 1; j <= n; j++) {
				if (i == j || i + j == 6) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
				num++;
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void pattern9() {
		System.out.println("\n--Q9---------------\n");
		System.out.println("Pascal's Triangle");

//			    1
//			   1 1
//			  1 2 1
//			 1 3 3 1
//			1 4 6 4 1

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int k = i; k <= n; k++) {
				System.out.print(" ");
			}
			int num = 1;
			for (int j = 1; j <= i; j++) {
				if (j == 1 || j == i) {
					System.out.print(" 1");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void pattern10() {
		System.out.println("\n--10---------------\n");

//			       A
//			     A B A
//			   A B C B A
//			 A B C D C B A

		int n = 4;
		for (int i = 1; i <= n; i++) {
			for (int k = i; k <= n; k++) {
				System.out.print(" ");
			}
			int num = 1;
			for (int j = 1; j <= 2 * i - 1; j++) {
				if (j == 1 || j == i) {
					System.out.print(" A");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void pattern11() {
		System.out.println("\n--Q11---------------\n");

//				*
//				* *
//				* * *
//				* * * *
//				* * *
//				* *
//				*

		int n = 4;
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		for (int i = n - 1; i >= 1; i--) {
			for (int k = 1; k <= i; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void pattern12() {
		System.out.println("\n--Q12---------------\n");

//					   *
//				      * *
//					 * * *
//					* * * *
//				   * * * * *
//					* * * * 
//					 * * * 
//					  * * 
//					   *

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= n - i; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for (int i = n - 1; i >= 1; i--) {
			for (int k = 1; k <= n - i; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void pattern13() {
		System.out.println("\n--Q13---------------\n");

//				        *
//				      * *
//				    * * *
//				  * * * *
//				* * * * *

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= n - i; k++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

	private static void pattern14() {
		System.out.println("\n--Q14---------------\n");

//				 * * * * *
//				   * * * *
//				     * * *
//				       * *
//				         *

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print("  ");
			}
			for (int k = i; k <= n; k++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

	private static void pattern15() {
		System.out.println("\n--Q15---------------\n");

//				  *  *  *  *  *
//				  *           *
//				  *           *
//				  *           *
//				  *  *  *  *  *	

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print("  ");
				if (i == 1 || i == n || j == 1 || j == n) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void pattern16() {
		System.out.println("\n--Q16---------------\n");

//				    *
//				   * *
//				  *   *
//				 *     *
//				* * * * *

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= n - i; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				if (i == n || j == 1 || j == i)
					System.out.print(" *");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	private static void pattern17() {
		System.out.println("\n--Q17---------------\n");

//				      a
//				     a b
//				    a b c
//				   a b c d
//				  a b c d e

		int n = 5;
		for (int i = 1; i <= n; i++) {
			char ch = 'a';
			for (int k = 1; k <= n - i; k++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {

				System.out.print(" " + ch++);
			}
			System.out.println();
		}
	}

	private static void pattern18() {
		System.out.println("\n--Q18---------------\n");

//				 *             *
//				 * *         * *
//				 * * *     * * *
//				 * * * * * * * *
//				 * * * * * * * *
//				 * * *     * * *
//				 * *         * *
//				 *             *

		int n = 4;
		for (int i = 1; i <= n; i++) {
			// star
			for (int k = 1; k <= i; k++) {
				System.out.print(" *");
			}
			// space
			for (int j = 1; j <= 2 * n - 2 * i; j++) {
				System.out.print("  ");
			}
			// star
			for (int l = 1; l <= i; l++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		for (int i = n; i >= 1; i--) {
			// star
			for (int k = 1; k <= i; k++) {
				System.out.print(" *");
			}
			// space
			for (int j = 1; j <= 2 * n - 2 * i; j++) {
				System.out.print("  ");
			}
			// star
			for (int l = 1; l <= i; l++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

	private static void pattern19() {
		System.out.println("\n--Q19---------------\n");
	}

	private static void pattern20() {

		System.out.println("\n--Q20---------------\n");

//					* 
//					* * 
//					* * * 
//					* * * * 
//					* * * 
//					* * 
//					* 

		int n = 4;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
		for (int i = n - 1; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}

	private static void pattern21() {

		System.out.println("\n--Q21---------------\n");

//				 1 1 1 1 1 1
//				 0 0 0 0 0 0
//				 1 1 1 1 1 1
//				 0 0 0 0 0 0
//				 1 1 1 1 1 1
//				 0 0 0 0 0 0

		int n = 6;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(i % 2 == 0 ? " 0" : " 1");
			}
			System.out.println();
		}
	}

	private static void pattern22() {
		System.out.println("\n--Q22---------------\n");
	}

	private static void pattern23() {

		System.out.println("\n--Q23---------------\n");

//				1 
//				2 1 
//				3 2 1 
//				4 3 2 1 
//				5 4 3 2 1 

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	private static void pattern24() {

		System.out.println("\n--Q24---------------\n");
		
//			         1 0
//			       1 0 1 0
//			     1 0 1 0 1 0
//			   1 0 1 0 1 0 1 0
//			 1 0 1 0 1 0 1 0 1 0
//			1 0 1 0 1 0 1 0 1 0 1 0

		int n = 6;
		for (int i = 1; i <= n; i++) {
			for(int k = 1; k<=n-i;k++) {
				System.out.print("  ");
			}
			for (int j = 1; j<=i; j++) {
				System.out.print(" 1");
				System.out.print(" 0");
			}System.out.println();
		}

	}

	private static void pattern25() {

		System.out.println("\n--Q25---------------\n");

//				  5 5 5 5 5 
//				    4 4 4 4 
//				      3 3 3 
//				        2 2 
//				          1

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= i; k++) {
				System.out.print("  ");
			}
			for (int j = 0; j <= n - i; j++) {
				System.out.print(" " + (n + 1 - i));
			}
			System.out.println();
		}
	}
}