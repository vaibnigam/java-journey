import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * DESIGN PRINCIPLE: SOLID
 * ============================================================================
 * 
 * Importance: ⭐⭐⭐⭐⭐ (5/5)
 * 
 * SOLID is an acronym for 5 fundamental object-oriented design principles:
 *  1. S - Single Responsibility Principle (SRP)
 *  2. O - Open/Closed Principle (OCP)
 *  3. L - Liskov Substitution Principle (LSP)
 *  4. I - Interface Segregation Principle (ISP)
 *  5. D - Dependency Inversion Principle (DIP)
 * 
 * Core Objective:
 *  - Build maintainable, understandable, scalable, and testable OOP systems.
 * 
 * Real-World Use Cases:
 *  - Enterprise E-Commerce / Order Processing Systems
 *  - Notification & Messaging Engines
 *  - Payment Gateways & Processing Pipelines
 *  - Extensible Plugin Architectures
 * ============================================================================
 */
public class SOLID_Principles {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("            SOLID PRINCIPLES IN JAVA              ");
        System.out.println("==================================================\n");

        // 1. SRP Demo
        System.out.println("--- 1. Single Responsibility Principle (SRP) ---");
        Invoice invoice = new Invoice("INV-1001", Arrays.asList(
                new Item("Laptop", 1200.0),
                new Item("Mouse", 25.0),
                new Item("Keyboard", 75.0)
        ));
        InvoiceRepository repository = new InvoiceRepository();
        InvoicePrinter printer = new InvoicePrinter();

        repository.save(invoice);
        printer.print(invoice);

        // 2. OCP Demo (Payment Strategies)
        System.out.println("\n--- 2. Open/Closed Principle (OCP) ---");
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.process(new CreditCardPayment(), invoice.calculateTotal());
        paymentProcessor.process(new CryptoPayment(), invoice.calculateTotal());

        // 3. LSP Demo (Collection Substitutability & Exception Handling)
        System.out.println("\n--- 3. Liskov Substitution Principle (LSP) ---");
        List<Account> accounts = List.of(
                new RegularCheckingAccount("ACC-1", 500.0),
                new HighYieldSavingsAccount("ACC-2", 1500.0)
        );
        for (Account acc : accounts) {
            try {
                acc.withdraw(100.0);
                System.out.println("Successfully withdrew from " + acc.getAccountId() + ". Balance: $" + acc.getBalance());
            } catch (InsufficientFundsException e) {
                System.err.println("LSP safe exception handled: " + e.getMessage());
            }
        }

        // 4. ISP Demo
        System.out.println("\n--- 4. Interface Segregation Principle (ISP) ---");
        MultiFunctionPrinter mfp = new MultiFunctionPrinter();
        mfp.print("Monthly Report");
        mfp.scan("/docs/report.pdf");

        BasicPrinter basicPrinter = new BasicPrinter();
        basicPrinter.print("Receipt #42");

        // 5. DIP Demo (Collections & Decoupled Services)
        System.out.println("\n--- 5. Dependency Inversion Principle (DIP) ---");
        NotificationChannel emailChannel = new EmailNotificationService();
        NotificationManager manager = new NotificationManager(emailChannel);
        manager.notifyUsers(List.of("alice@example.com", "bob@example.com"), "Your invoice is ready!");
    }

    // =========================================================================
    // 1. SINGLE RESPONSIBILITY PRINCIPLE (SRP)
    // "A class should have one, and only one, reason to change."
    // =========================================================================

    public static class Item {
        private final String name;
        private final double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
    }

    // Entity: Responsible ONLY for invoice data & business calculations
    public static class Invoice {
        private final String id;
        private final List<Item> items;

        public Invoice(String id, List<Item> items) {
            this.id = id;
            // Collections Framework: Defensive unmodifiable copy
            this.items = List.copyOf(items);
        }

        public String getId() { return id; }
        public List<Item> getItems() { return items; }

        public double calculateTotal() {
            // Collection Stream API
            return items.stream().mapToDouble(Item::getPrice).sum();
        }
    }

    // Repository: Responsible ONLY for database persistence
    public static class InvoiceRepository {
        private final Map<String, Invoice> database = new HashMap<>();

        public void save(Invoice invoice) {
            if (invoice == null) {
                throw new InvalidInvoiceException("Invoice cannot be null");
            }
            database.put(invoice.getId(), invoice);
            System.out.println("[DB] Saved Invoice: " + invoice.getId() + " with " + invoice.getItems().size() + " items.");
        }
    }

    // View / Formatter: Responsible ONLY for rendering / printing
    public static class InvoicePrinter {
        public void print(Invoice invoice) {
            System.out.println("[Printer] Invoice: " + invoice.getId() + " | Total: $" + invoice.calculateTotal());
        }
    }

    // =========================================================================
    // 2. OPEN/CLOSED PRINCIPLE (OCP)
    // "Software entities should be open for extension, but closed for modification."
    // =========================================================================

    public interface PaymentMethod {
        void pay(double amount) throws PaymentFailedException;
    }

    public static class CreditCardPayment implements PaymentMethod {
        @Override
        public void pay(double amount) throws PaymentFailedException {
            if (amount <= 0) throw new PaymentFailedException("Invalid credit card payment amount: $" + amount);
            System.out.println("[Payment] Paid $" + amount + " via Credit Card.");
        }
    }

    public static class CryptoPayment implements PaymentMethod {
        @Override
        public void pay(double amount) throws PaymentFailedException {
            if (amount <= 0) throw new PaymentFailedException("Invalid crypto payment amount: $" + amount);
            System.out.println("[Payment] Paid $" + amount + " via Ethereum Smart Contract.");
        }
    }

    // PaymentProcessor does not need modification when adding new payment methods
    public static class PaymentProcessor {
        public void process(PaymentMethod method, double amount) {
            try {
                method.pay(amount);
            } catch (PaymentFailedException e) {
                System.err.println("[Payment Error] " + e.getMessage());
            }
        }
    }

    // =========================================================================
    // 3. LISKOV SUBSTITUTION PRINCIPLE (LSP)
    // "Subtypes must be substitutable for their base types without altering correctness."
    // =========================================================================

    public static abstract class Account {
        protected final String accountId;
        protected double balance;

        public Account(String accountId, double balance) {
            this.accountId = accountId;
            this.balance = balance;
        }

        public String getAccountId() { return accountId; }
        public double getBalance() { return balance; }

        public abstract void withdraw(double amount) throws InsufficientFundsException;
    }

    public static class RegularCheckingAccount extends Account {
        public RegularCheckingAccount(String accountId, double balance) {
            super(accountId, balance);
        }

        @Override
        public void withdraw(double amount) throws InsufficientFundsException {
            if (amount > balance) {
                throw new InsufficientFundsException("Overdraft denied on checking account " + accountId);
            }
            balance -= amount;
        }
    }

    public static class HighYieldSavingsAccount extends Account {
        public HighYieldSavingsAccount(String accountId, double balance) {
            super(accountId, balance);
        }

        @Override
        public void withdraw(double amount) throws InsufficientFundsException {
            // Maintains base contract without throwing unexpected RuntimeException
            if (amount > balance) {
                throw new InsufficientFundsException("Savings withdrawal exceeds current balance on " + accountId);
            }
            balance -= amount;
        }
    }

    // =========================================================================
    // 4. INTERFACE SEGREGATION PRINCIPLE (ISP)
    // "Clients should not be forced to depend upon interfaces that they do not use."
    // =========================================================================

    public interface Printable {
        void print(String document);
    }

    public interface Scannable {
        void scan(String path);
    }

    public interface Faxable {
        void fax(String document, String destination);
    }

    public static class BasicPrinter implements Printable {
        @Override
        public void print(String document) {
            System.out.println("[BasicPrinter] Printing: " + document);
        }
    }

    public static class MultiFunctionPrinter implements Printable, Scannable {
        @Override
        public void print(String document) {
            System.out.println("[MFP] Printing: " + document);
        }

        @Override
        public void scan(String path) {
            System.out.println("[MFP] Scanned to path: " + path);
        }
    }

    // =========================================================================
    // 5. DEPENDENCY INVERSION PRINCIPLE (DIP)
    // "High-level modules should not depend on low-level modules. Both should depend on abstractions."
    // =========================================================================

    public interface NotificationChannel {
        void send(String recipient, String message);
    }

    public static class EmailNotificationService implements NotificationChannel {
        @Override
        public void send(String recipient, String message) {
            System.out.println("[Email -> " + recipient + "] " + message);
        }
    }

    public static class SmsNotificationService implements NotificationChannel {
        @Override
        public void send(String recipient, String message) {
            System.out.println("[SMS -> " + recipient + "] " + message);
        }
    }

    // High-level module depends on abstraction (NotificationChannel), not concrete Email/SMS classes
    public static class NotificationManager {
        private final NotificationChannel channel;

        public NotificationManager(NotificationChannel channel) {
            this.channel = Objects.requireNonNull(channel, "NotificationChannel must not be null");
        }

        public void notifyUsers(Collection<String> recipients, String message) {
            if (recipients == null || recipients.isEmpty()) {
                throw new IllegalArgumentException("Recipients collection must not be empty");
            }
            recipients.forEach(user -> channel.send(user, message));
        }
    }

    // =========================================================================
    // CUSTOM EXCEPTIONS DEMONSTRATING SPECIFIC RESPONSIBILITIES & CONTRACTS
    // =========================================================================

    public static class InvalidInvoiceException extends RuntimeException {
        public InvalidInvoiceException(String message) {
            super(message);
        }
    }

    public static class PaymentFailedException extends Exception {
        public PaymentFailedException(String message) {
            super(message);
        }
    }

    public static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }
}
