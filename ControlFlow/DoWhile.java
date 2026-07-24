import java.util.Scanner;

public class DoWhile {

	public static void main(String[] args) {
//		Do-While Loop Questions
//
//		Category 1: Basic — Guaranteed At Least Once Execution
//
//		Do-while loop se 1 se 10 tak numbers print karo.
		int i = 1;
		do {
			System.out.println(i++);
		} while (i <= 10);
		System.out.println();
//		Ek do-while loop likho jaha condition shuru se hi false ho, phir bhi verify karo ki body ek baar chalti hai (concept-check question, output predict karna hai).
		int j = 1;
		do {
			System.out.println(j++);
		} while (j >= 10);
		System.out.println();
//		Category 2: Menu-Driven Program (classic do-while use case)
//		3. Ek calculator banao do-while loop se — menu mein options ho (Add, Subtract, Multiply, Divide, Exit), user jab tak "Exit" na choose kare, menu baar-baar dikhta rahe.
		Scanner sc = new Scanner(System.in);
		int option;
		do {

			System.out.println("1 :Add");
			System.out.println("2 :Subtract");
			System.out.println("3: Multiply");
			System.out.println("4 : Divide");
			option = sc.nextInt();
			switch (option) {
			case 1 , 2 , 3 , 4 :
				System.out.println("calculating");
				break;
			}
		} while (option <= 4 && option >= 1);
		System.out.println("Exited");
//				4. Ek simple ATM simulation banao — menu options (Check Balance, Deposit, Withdraw, Exit), do-while se driven, jab tak "Exit" na ho tab tak chalta rahe.
//
//		Category 3: Input Validation with Do-While
//		5. User se number lo (do-while se) aur jab tak woh 1-10 ke range mein na ho, dobara pucho (yaha do-while zaroori hai kyunki pehli baar to input lena hi hoga).
//		6. User se ek character lo aur check karo vowel hai ya consonant — do-while se implement karo taaki program dobara chalne ka option de ("Continue? Y/N").
//
//		Category 4: Number-Based (Do-While Version)
//		7. Digit sum nikaalo do-while loop se (same jaisa while wala tha, bas do-while se implement karo — dhyaan rakhna edge case: agar number 0 hai to kya hoga).
//		8. Factorial nikaalo do-while loop se.
//
//		Category 5: Repeat-Until Pattern
//		9. Ek guessing game banao — computer ek random number socheta hai (1-100 ke beech), user guess karta hai, jab tak sahi guess na ho "too high/too low" bataate raho (do-while se, kyunki pehla guess to lena hi hoga).
//
//		Category 6: Comparison/Conceptual Question
//		10. Ek program likho jo same logic while aur do-while dono se implement kare (jaise 1 se 5 print karna jaha initial value already loop se bahar hai), aur observe karo output mein farak aata hai ya nahi — agar condition shuru se true hai to farak nahi aayega, lekin agar condition shuru se false ho to bada farak dikhega.

	}

}
