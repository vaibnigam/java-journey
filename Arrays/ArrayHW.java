public class ArrayHW {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // --------------------------------------------------
        // 1. Sum of all the elements in the array
        // --------------------------------------------------

        int total = 0;
        for (int value : array) {
            total += value;
        }
        System.out.println(total);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println(sum);

        // --------------------------------------------------
        // 2. Product of all the elements in the array
        // --------------------------------------------------

        int product1 = 1;
        for (int value : array) {
            product1 *= value;
        }
        System.out.println(product1);

        int product2 = 1;
        for (int i = 0; i < array.length; i++) {
            product2 *= array[i];
        }
        System.out.println(product2);

        // --------------------------------------------------
        // 3. Sum of only even numbers
        // --------------------------------------------------

        int evenSum1 = 0;
        for (int value : array) {
            if (value % 2 == 0) {
                evenSum1 += value;
            }
        }
        System.out.println(evenSum1);

        int evenSum2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenSum2 += array[i];
            }
        }
        System.out.println(evenSum2);

        // --------------------------------------------------
        // 4. Swap first and last elements
        // --------------------------------------------------

        array[0] = array[0] + array[array.length - 1];
        array[array.length - 1] = array[0] - array[array.length - 1];
        array[0] = array[0] - array[array.length - 1];

        for (int value : array) {
            System.out.print(value + " ");
        }

        // Reinitialize array

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println();

        for (int value : array) {
            System.out.print(value + " ");
        }

        System.out.println();

        // --------------------------------------------------
        // 5. Reverse the array
        // --------------------------------------------------

        int[] ary = {1, 2, 3, 5, 7, 4, 5, 1, 2, 3, 4, 5};

        // Print in reverse order

        for (int i = ary.length - 1; i >= 0; i--) {
            System.out.print(ary[i] + " ");
        }

        System.out.println();

        // Create a reversed array

        int[] reverse = new int[ary.length];

        for (int i = 0; i < ary.length; i++) {
            reverse[ary.length - 1 - i] = ary[i];
        }

        for (int value : reverse) {
            System.out.print(value + " ");
        }

        System.out.println();
        System.out.println();

        // --------------------------------------------------
        // 6. Find duplicate elements
        // --------------------------------------------------

        int[] arry = {1, 2, 3, 5, 7, 4, 5, 1, 2, 3, 4, 5};

        for (int i = 0; i < arry.length; i++) {

            for (int j = i + 1; j < arry.length; j++) {

                if (arry[i] == arry[j]) {
                    System.out.println("Duplicate found: " + arry[i]);
                    break;
                }
            }
        }
        
//        int[] ay = {1, 2, 3, 5, 7, 4, 5, 1, 2, 3, 4, 5};
        String[] ay = {"1","2"};
//        int x;          ------ cant use a variable declared oitside in for each loop
//        for ( x : ay) {
        for (String x : ay) {
        	System.out.print(x + " ");
        }
    }
}