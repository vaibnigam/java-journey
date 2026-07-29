import java.util.Scanner;

public class DoWhile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//      que1();
//      que2();
//      que3(sc);
//      que4(sc);
//      que5(sc);
//      que6(sc);
//      que7(sc);
//      que8(sc);
//      que9(sc);
//      que10();

        sc.close();
    }

    private static void que10() {

        // 10. Ek program likho jo same logic while aur do-while dono se implement
        // kare aur output compare karo.
    }

    private static void que9(Scanner sc) {

        // 9. Ek guessing game banao — computer ek random number socheta hai
        // (1-100 ke beech), user guess karta hai, jab tak sahi guess na ho
        // "too high/too low" bataate raho.
    }

    private static void que8(Scanner sc) {

        // 8. Factorial nikaalo do-while loop se.

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Enter a positive number.");
            return;
        }

        int fact = 1;

        do {
            fact *= num;
            num--;
        } while (num != 0);

        System.out.println(fact);
    }

    private static void que7(Scanner sc) {

        // 7. Digit sum nikaalo do-while loop se.
        // Edge case: agar number 0 hai to kya hoga.

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int sum = 0;

        do {
            sum += num % 10;
            num /= 10;
        } while (num != 0);

        System.out.println(sum);
    }

    private static void que6(Scanner sc) {

        // 6. User se ek character lo aur check karo vowel hai ya consonant.
        // Do-while se implement karo taaki program dobara chalne ka option de
        // ("Continue? Y/N").

        char ch;
        char opt;

        do {

            System.out.println("Enter an alphabet");
            ch = sc.next().charAt(0);
            ch = Character.toLowerCase(ch);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.println("Vowel");
            } else {
                System.out.println("Consonant");
            }

            System.out.println("Continue? (Y/N)");
            opt = sc.next().charAt(0);

        } while (opt == 'Y' || opt == 'y');

        System.out.println("Thankyou");
    }

    private static void que5(Scanner sc) {

        // 5. User se number lo aur jab tak woh 1-10 ke range mein na ho,
        // dobara pucho.

        int a;

        do {
            System.out.println("Enter a number");
            a = sc.nextInt();
        } while (a < 1 || a > 10);

        System.out.println("Thankyou");
    }

    private static void que4(Scanner sc) {

        // 4. Ek simple ATM simulation banao.
        // Menu:
        // 1. Check Balance
        // 2. Deposit
        // 3. Withdraw
        // 4. Pin Change
        // 5. Exit

        int choice;

        do {

            System.out.println("Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Pin Change");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.println("1. Check Balance");
                break;

            case 2:
                System.out.println("2. Deposit");
                break;

            case 3:
                System.out.println("3. Withdraw");
                break;

            case 4:
                System.out.println("4. Pin Change");
                break;

            case 5:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice");
            }

        } while (choice != 5);
    }

    private static void que3(Scanner sc) {

        // 3. Ek calculator banao.
        // Menu:
        // 1. Add
        // 2. Subtract
        // 3. Multiply
        // 4. Divide
        // 5. Exit

        int choice;

        do {

            System.out.println("Menu:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.println("1. Add");
                break;

            case 2:
                System.out.println("2. Subtract");
                break;

            case 3:
                System.out.println("3. Multiply");
                break;

            case 4:
                System.out.println("4. Divide");
                break;

            case 5:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice");
            }

        } while (choice != 5);
    }

    private static void que2() {

        // 2. Ek do-while loop likho jaha condition shuru se hi false ho,
        // phir bhi verify karo ki body ek baar chalti hai.

        int i = 1;

        do {
            System.out.print(i++);
            System.out.print(" ");
        } while (i >= 10);
    }

    private static void que1() {

        // 1. Do-while loop se 1 se 10 tak numbers print karo.

        int i = 1;

        do {
            System.out.print(i++);
            System.out.print(" ");
        } while (i <= 10);
    }
}