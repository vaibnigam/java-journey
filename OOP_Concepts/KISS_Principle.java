import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * DESIGN PRINCIPLE: KISS (Keep It Simple, Stupid / Keep It Simple)
 * ============================================================================
 * 
 * Importance: ⭐⭐⭐⭐⭐ (5/5)
 * 
 * Core Concept:
 *  - Most systems work best if they are kept simple rather than made complex.
 *  - Simplicity should be a key goal in design, and unnecessary complexity should be avoided.
 *  - "Simplicity is prerequisite for reliability." - Edsger W. Dijkstra
 * 
 * Real-World Use Cases:
 *  - Choosing built-in Java Collections/Streams over bloated bespoke custom structures.
 *  - Using clear, direct control flows instead of convoluted 10-layer design patterns for trivial tasks.
 *  - Clear exception strategies using standard Java exceptions or lightweight domain exceptions.
 * ============================================================================
 */
public class KISS_Principle {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("               KISS PRINCIPLE IN JAVA             ");
        System.out.println("==================================================\n");

        // 1. OOP: Simple vs Over-Engineered Discount Calculation
        System.out.println("--- 1. OOP: Simple vs Over-Engineered Design ---");
        
        // KISS Approach: Direct, readable, and extensible without bloat
        DiscountCalculator simpleCalc = new SimpleDiscountCalculator();
        double discountedPrice = simpleCalc.calculateDiscount(100.0, "VIP");
        System.out.println("KISS Discounted Price for VIP: $" + discountedPrice);

        // 2. Collection Framework: Finding duplicates simply
        System.out.println("\n--- 2. Collection Framework: Simple vs Complex Collection Manipulation ---");
        List<String> userEmails = List.of(
                "john@example.com", 
                "alice@example.com", 
                "john@example.com", 
                "bob@example.com", 
                "alice@example.com"
        );

        // Overcomplicated: manual 2-pass nested loops or complex custom trees
        // KISS: 1-line standard Java Set / Stream grouping
        Set<String> duplicates = findDuplicatesKISS(userEmails);
        System.out.println("Identified Duplicates (KISS Set approach): " + duplicates);

        Map<String, Long> frequencyMap = countFrequencyKISS(userEmails);
        System.out.println("Frequency Map (KISS Stream approach): " + frequencyMap);

        // 3. Exception Handling: Straightforward & Meaningful Error Handling
        System.out.println("\n--- 3. Exception Handling: Pragmatic Error Handling ---");
        try {
            int parsedAge = parseAgeSafely("not_a_number");
        } catch (IllegalArgumentException e) {
            System.err.println("KISS Clean Validation Exception: " + e.getMessage());
        }
    }

    // =========================================================================
    // SECTION 1: OOP (KISS vs OVER-ENGINEERING)
    // =========================================================================

    /**
     * [VIOLATION OF KISS] Over-Engineered Anti-Pattern
     * Creating AbstractDiscountStrategyFactoryProvider with AbstractCommandContext 
     * just to apply a 10% discount.
     */
    interface ComplexDiscountStrategyFactoryProvider { /* Bloated boilerplate */ }

    /**
     * [KISS SOLUTION] Direct, clean, and practical abstraction
     */
    public interface DiscountCalculator {
        double calculateDiscount(double originalAmount, String customerType);
    }

    public static class SimpleDiscountCalculator implements DiscountCalculator {
        private static final Map<String, Double> DISCOUNT_RATES = Map.of(
                "REGULAR", 0.05,
                "VIP", 0.20,
                "EMPLOYEE", 0.30
        );

        @Override
        public double calculateDiscount(double originalAmount, String customerType) {
            if (originalAmount < 0) {
                throw new IllegalArgumentException("Amount cannot be negative: " + originalAmount);
            }
            if (customerType == null) {
                return originalAmount;
            }
            double rate = DISCOUNT_RATES.getOrDefault(customerType.toUpperCase(), 0.0);
            return originalAmount * (1.0 - rate);
        }
    }

    // =========================================================================
    // SECTION 2: COLLECTIONS FRAMEWORK (KISS IDIOMATIC USAGE)
    // =========================================================================

    /**
     * KISS: Finding duplicates using Java's HashSet in a single linear pass.
     */
    public static <T> Set<T> findDuplicatesKISS(Collection<T> items) {
        if (items == null || items.isEmpty()) return Collections.emptySet();

        Set<T> seen = new HashSet<>();
        Set<T> duplicates = new HashSet<>();

        for (T item : items) {
            // If it can't be added to 'seen', it is a duplicate!
            if (!seen.add(item)) {
                duplicates.add(item);
            }
        }
        return Collections.unmodifiableSet(duplicates);
    }

    /**
     * KISS: Frequency counting using standard Stream collector.
     */
    public static <T> Map<T, Long> countFrequencyKISS(Collection<T> items) {
        if (items == null) return Collections.emptyMap();
        return items.stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));
    }

    // =========================================================================
    // SECTION 3: EXCEPTION HANDLING (KISS VS OVER-COMPLEX ERROR TREES)
    // =========================================================================

    /**
     * [KISS EXCEPTION HANDLING]
     * Use built-in standard exceptions (IllegalArgumentException, IllegalStateException, 
     * NoSuchElementException) whenever their semantics fit accurately, rather than 
     * creating dozens of 1-line custom classes.
     */
    public static int parseAgeSafely(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Age input cannot be null or blank");
        }
        try {
            int age = Integer.parseInt(input.trim());
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Age must be between 0 and 150, got: " + age);
            }
            return age;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid age numeric format: '" + input + "'", e);
        }
    }
}
