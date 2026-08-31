package Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableIteratorDemo {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // =====================================================
        // ITERABLE
        // =====================================================

        /*
         * Iterable ek INTERFACE hai.
         *
         * Main method:
         *     iterator()
         *
         * Meaning:
         * "Mere elements ko traverse karna hai?
         *  Main tumhe Iterator de sakta hoon."
         *
         * ArrayList -> List -> Collection -> Iterable
         *
         * Isliye ArrayList ko for-each loop me use kar sakte hain.
         */

        for (Integer n : numbers) {
            System.out.println(n);
        }


        // =====================================================
        // ITERATOR
        // =====================================================

        /*
         * Iterator bhi ek INTERFACE hai.
         *
         * Iterator actual elements ko one-by-one traverse karta hai.
         *
         * Important methods:
         *
         * hasNext() -> next element available hai?
         * next()    -> next element return karo
         * remove()  -> last returned element remove karo
         */

        Iterator<Integer> itr = numbers.iterator();

        while (itr.hasNext()) {

            Integer n = itr.next();

            System.out.println(n);
        }


        // =====================================================
        // ITERATOR SE REMOVE
        // =====================================================

        Iterator<Integer> removeItr = numbers.iterator();

        while (removeItr.hasNext()) {

            Integer n = removeItr.next();

            if (n == 20) {

                // Iterator ke through safe removal
                removeItr.remove();
            }
        }

        System.out.println(numbers);
        // [10, 30]
    }
}


/*
===============================================================
ITERABLE vs ITERATOR
===============================================================

Iterable:
    "Main Iterator provide kar sakta hoon."

Iterator:
    "Main elements ko traverse karta hoon."

Relationship:

    Iterable
       |
       | iterator()
       ↓
    Iterator
       |
       ├── hasNext()
       ├── next()
       └── remove()


IMPORTANT INTERVIEW QUESTIONS
---------------------------------------------------------------

Q1. Why is Iterable used?

Ans:
Iterable allows an object to be traversed and enables the
enhanced for-each loop. It provides the iterator() method.


Q2. What is the difference between Iterable and Iterator?

Ans:
Iterable provides an Iterator, whereas Iterator is responsible
for actually traversing the elements.


Q3. Why does ArrayList support for-each?

Ans:
ArrayList indirectly implements Iterable through Collection,
so it provides iterator() and therefore can be used with
for-each.


Q4. What is the benefit of Iterator?

Ans:
It provides a standard way to traverse collections and allows
removal of elements during traversal using remove().


KEY POINT:
    for-each
       ↓
    iterator()
       ↓
    hasNext() + next()
===============================================================
*/