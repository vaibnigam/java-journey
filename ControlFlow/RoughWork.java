
public class RoughWork {

	public static void main(String[] args) {
		System.out.println("\n--Q19---------------\n");
		int n = 4;
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= n - i; k++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= i; j++) {
				if (j == 1 || j == i) {
					System.out.print(" * ");
				} else
					System.out.print("   ");
			}

			System.out.println();
		}

	}

}
