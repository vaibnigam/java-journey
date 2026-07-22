public class PatternPractice {
	public static void main(String[] args) {
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

	private static void pattern2() {
		System.out.println("\n--Q2---------------\n");

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

	private static void pattern3() {
		System.out.println("\n--Q3---------------\n");

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
				}else {
					System.out.print("  ");
				}
			}System.out.println();
		}
		System.out.println();
//		-----------------------------------------------
//		
//			   *       *
//		    	 *   * 
//			       *
//			     *   * 
//			   *       *
//		n = 5;
//		for (int i = 1; i <= n; i++) {
//			int num=i;
//			for (int j = 1; j <= n; j++) {
//				if (num%2==0) {
//					System.out.print(" *  ");
//				}else {
//					System.out.print("   ");
//				}num++;
//			}System.out.println();
//		}
//		System.out.println();
	}
}