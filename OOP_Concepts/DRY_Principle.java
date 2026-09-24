import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * DESIGN PRINCIPLE: DRY (Don't Repeat Yourself)
 * ============================================================================
 * 
 * Importance: ⭐⭐⭐⭐⭐ (5/5)
 * 
 * Core Concept:
 *  - "Every piece of knowledge must have a single, unambiguous, authoritative 
 *     representation within a system." (Andy Hunt & Dave Thomas - Pragmatic Programmer)
 *  - Duplication causes maintenance nightmares: fixing a bug in one place requires
 *     remembering to fix it everywhere else.
 * 
 * Real-World Use Cases:
 *  - Centralized input validation & sanitization across microservices.
 *  - Reusable collection filtering, pagination, and sorting pipelines.
 *  - Unified exception handling and HTTP/API error mapping.
 *  - Template Method / Functional pipelines avoiding duplicated boilerplate.
 * ============================================================================
 */
public class DRY_Principle {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("               DRY PRINCIPLE IN JAVA              ");
        System.out.println("==================================================\n");

        // 1. OOP & Centralized Validation Demo
        System.out.println("--- 1. OOP: Centralized Validation Logic ---");
        try {
            Customer c1 = new Customer("C-101", "john.doe@company.com", "+1-555-0199");
            System.out.println("Created valid customer: " + c1);
            
            // This will fail validation centrally
            new Customer("C-102", "invalid-email-address", "123");
        } catch (ValidationException e) {
            System.err.println("Validation caught via DRY validator: " + e.getMessage());
        }

        // 2. Collection Framework & Generic Filtering/Transformation Demo
        System.out.println("\n--- 2. Collection Framework: Reusable Pipeline & Pagination ---");
        List<Order> orders = List.of(
                new Order("O-1", 150.0, OrderStatus.COMPLETED),
                new Order("O-2", 45.0, OrderStatus.PENDING),
                new Order("O-3", 320.0, OrderStatus.COMPLETED),
                new Order("O-4", 890.0, OrderStatus.CANCELLED),
                new Order("O-5", 210.0, OrderStatus.COMPLETED),
                new Order("O-6", 15.0, OrderStatus.PENDING)
        );

        // DRY: Reusable generic collection filter utility
        List<Order> highValueCompletedOrders = CollectionUtils.filter(
                orders,
                order -> order.getStatus() == OrderStatus.COMPLETED && order.getAmount() > 100.0
        );
        System.out.println("High Value Completed Orders: " + highValueCompletedOrders);

        // DRY: Generic Paginator for any Collection
        List<Order> page1 = CollectionUtils.paginate(orders, 1, 2);
        List<Order> page2 = CollectionUtils.paginate(orders, 2, 2);
        System.out.println("Page 1 (Size 2): " + page1);
        System.out.println("Page 2 (Size 2): " + page2);

        // 3. Exception Handling: DRY Exception Translation Template
        System.out.println("\n--- 3. Exception Handling: Safe Execution Template (Avoid Try-Catch Boilerplate) ---");
        
        // Instead of writing try-catch blocks in 10 different service methods:
        String result = SafeExecutor.executeWithFallback(
                () -> riskyDatabaseCall("SELECT * FROM USERS"),
                "Fallback Data (Default)"
        );
        System.out.println("Safe execution result: " + result);

        SafeExecutor.executeAndWrap(
                () -> riskyExternalApiCall(),
                ServiceExecutionException::new
        );
    }

    // =========================================================================
    // SECTION 1: OOP & REUSABLE VALIDATION ENGINE (DRY)
    // =========================================================================

    public static final class ValidationUtils {
        private ValidationUtils() {} // Prevent instantiation

        public static void requireValidEmail(String email) {
            if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                throw new ValidationException("Invalid email format: " + email);
            }
        }

        public static void requireNonEmpty(String value, String fieldName) {
            if (value == null || value.trim().isEmpty()) {
                throw new ValidationException(fieldName + " cannot be null or empty");
            }
        }

        public static void requirePositive(double value, String fieldName) {
            if (value <= 0) {
                throw new ValidationException(fieldName + " must be strictly positive, got: " + value);
            }
        }
    }

    public static class Customer {
        private final String id;
        private final String email;
        private final String phone;

        public Customer(String id, String email, String phone) {
            // Reusing centralized DRY validation logic
            ValidationUtils.requireNonEmpty(id, "Customer ID");
            ValidationUtils.requireValidEmail(email);
            ValidationUtils.requireNonEmpty(phone, "Phone Number");

            this.id = id;
            this.email = email;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Customer[id=" + id + ", email=" + email + "]";
        }
    }

    public enum OrderStatus { PENDING, COMPLETED, CANCELLED }

    public static class Order {
        private final String id;
        private final double amount;
        private final OrderStatus status;

        public Order(String id, double amount, OrderStatus status) {
            ValidationUtils.requireNonEmpty(id, "Order ID");
            ValidationUtils.requirePositive(amount, "Order Amount");
            this.id = id;
            this.amount = amount;
            this.status = Objects.requireNonNull(status, "Status cannot be null");
        }

        public String getId() { return id; }
        public double getAmount() { return amount; }
        public OrderStatus getStatus() { return status; }

        @Override
        public String toString() {
            return "Order(" + id + ", $" + amount + ", " + status + ")";
        }
    }

    // =========================================================================
    // SECTION 2: COLLECTIONS FRAMEWORK (DRY GENERIC UTILITIES)
    // =========================================================================

    public static final class CollectionUtils {
        private CollectionUtils() {}

        /**
         * Generic reusable filtering across any collection type.
         */
        public static <T> List<T> filter(Collection<T> source, Predicate<T> predicate) {
            if (source == null || predicate == null) return Collections.emptyList();
            return source.stream()
                    .filter(predicate)
                    .collect(Collectors.toUnmodifiableList());
        }

        /**
         * Generic pagination utility to avoid duplicating subList/math logic across repositories.
         */
        public static <T> List<T> paginate(List<T> source, int pageNumber, int pageSize) {
            if (source == null || source.isEmpty() || pageNumber <= 0 || pageSize <= 0) {
                return Collections.emptyList();
            }
            int fromIndex = (pageNumber - 1) * pageSize;
            if (fromIndex >= source.size()) {
                return Collections.emptyList();
            }
            int toIndex = Math.min(fromIndex + pageSize, source.size());
            return Collections.unmodifiableList(source.subList(fromIndex, toIndex));
        }
    }

    // =========================================================================
    // SECTION 3: EXCEPTION HANDLING (DRY SAFE-EXECUTION & TEMPLATE PATTERN)
    // =========================================================================

    @FunctionalInterface
    public interface CheckedSupplier<T> {
        T get() throws Exception;
    }

    @FunctionalInterface
    public interface CheckedRunnable {
        void run() throws Exception;
    }

    public static final class SafeExecutor {
        private SafeExecutor() {}

        /**
         * Centralizes try-catch-fallback logic so developers don't repeat boilerplate.
         */
        public static <T> T executeWithFallback(CheckedSupplier<T> action, T fallbackValue) {
            try {
                return action.get();
            } catch (Exception e) {
                System.err.println("[SafeExecutor Warning] Execution failed (" + e.getMessage() + "). Applying fallback.");
                return fallbackValue;
            }
        }

        /**
         * Centralizes checked-to-domain exception translation.
         */
        public static void executeAndWrap(CheckedRunnable action, Function<Throwable, RuntimeException> exceptionTransformer) {
            try {
                action.run();
            } catch (Exception e) {
                System.err.println("[SafeExecutor] Intercepted raw exception: " + e.getClass().getSimpleName());
                throw exceptionTransformer.apply(e);
            }
        }
    }

    private static String riskyDatabaseCall(String sql) throws Exception {
        throw new java.sql.SQLException("Connection timed out querying database");
    }

    private static void riskyExternalApiCall() throws Exception {
        throw new java.io.IOException("HTTP 503 Service Unavailable from 3rd-party Gateway");
    }

    // Custom Domain Exceptions
    public static class ValidationException extends RuntimeException {
        public ValidationException(String message) { super(message); }
    }

    public static class ServiceExecutionException extends RuntimeException {
        public ServiceExecutionException(Throwable cause) { super("Service operation failed", cause); }
    }
}
