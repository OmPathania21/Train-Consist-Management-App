/**
 * ================================================================
 * MAIN CLASS – UseCase14TrainConsistMgmnt
 * ================================================================
 *
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 *
 * Description:
 * This class introduces custom exception handling to enforce
 * business rules and prevent invalid bogie creation.
 *
 * At this stage, the application:
 * - Defines a custom exception (InvalidCapacityException)
 * - Validates capacity during bogie construction
 * - Throws custom exception for invalid capacity (≤ 0)
 * - Implements fail-fast validation
 * - Protects system from corrupted input
 *
 * This use case introduces:
 * - Custom exception classes
 * - Exception inheritance (extends Exception)
 * - throw keyword
 * - throws declaration
 * - Fail-fast validation pattern
 * - Business rule enforcement
 *
 * @author Developer
 * @version 14.0
 */

import java.util.List;
import java.util.ArrayList;

public class UseCase14TrainConsistMgmnt {

    // ============================================================
    // CUSTOM EXCEPTION CLASS
    // ============================================================
    /**
     * Custom exception for invalid bogie capacity.
     * Thrown when capacity is less than or equal to zero.
     */
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ============================================================
    // PASSENGER BOGIE CLASS WITH CAPACITY VALIDATION
    // ============================================================
    /**
     * Represents a passenger bogie with validated capacity.
     * Throws InvalidCapacityException if capacity <= 0.
     */
    static class PassengerBogie {
        String type;
        int capacity;

        /**
         * Constructor with capacity validation.
         * 
         * @param type The type of passenger bogie (Sleeper, AC Chair, First Class)
         * @param capacity The number of seats (must be > 0)
         * @throws InvalidCapacityException if capacity <= 0
         */
        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return type + " (Capacity: " + capacity + ")";
        }
    }

    // ============================================================
    // GOODS BOGIE CLASS (No validation for UC14 focus)
    // ============================================================
    /**
     * Represents a goods bogie with cargo type.
     */
    static class GoodsBogie {
        String type;
        String cargoType;

        GoodsBogie(String type, String cargoType) {
            this.type = type;
            this.cargoType = cargoType;
        }

        @Override
        public String toString() {
            return type + " (Cargo: " + cargoType + ")";
        }
    }

    // ============================================================
    // MAIN METHOD – DEMONSTRATING EXCEPTION HANDLING
    // ============================================================
    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("       (Custom Exception Handling)");
        System.out.println("=============================================\n");

        // Train consist list
        List<Object> trainConsist = new ArrayList<>();

        // ---- VALID BOGIE CREATION ----
        System.out.println("--- Creating Valid Bogies ---");
        try {
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            trainConsist.add(sleeper);
            System.out.println("✓ Created: " + sleeper);
        } catch (InvalidCapacityException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }

        try {
            PassengerBogie acChair = new PassengerBogie("AC Chair", 56);
            trainConsist.add(acChair);
            System.out.println("✓ Created: " + acChair);
        } catch (InvalidCapacityException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }

        try {
            PassengerBogie firstClass = new PassengerBogie("First Class", 24);
            trainConsist.add(firstClass);
            System.out.println("✓ Created: " + firstClass);
        } catch (InvalidCapacityException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }

        System.out.println();

        // ---- INVALID BOGIE CREATION: NEGATIVE CAPACITY ----
        System.out.println("--- Attempting Invalid Bogies ---");
        try {
            PassengerBogie invalidBogie1 = new PassengerBogie("Sleeper", -10);
            trainConsist.add(invalidBogie1);
            System.out.println("✓ Created: " + invalidBogie1);
        } catch (InvalidCapacityException e) {
            System.out.println("✗ Rejected - Negative Capacity: " + e.getMessage());
        }

        // ---- INVALID BOGIE CREATION: ZERO CAPACITY ----
        try {
            PassengerBogie invalidBogie2 = new PassengerBogie("AC Chair", 0);
            trainConsist.add(invalidBogie2);
            System.out.println("✓ Created: " + invalidBogie2);
        } catch (InvalidCapacityException e) {
            System.out.println("✗ Rejected - Zero Capacity: " + e.getMessage());
        }

        System.out.println();

        // ---- GOODS BOGIES (No validation in UC14) ----
        System.out.println("--- Adding Goods Bogies ---");
        trainConsist.add(new GoodsBogie("Rectangular", "Coal"));
        System.out.println("✓ Created: Rectangular (Cargo: Coal)");

        trainConsist.add(new GoodsBogie("Cylindrical", "Petroleum"));
        System.out.println("✓ Created: Cylindrical (Cargo: Petroleum)");

        System.out.println();

        // ---- DISPLAY FINAL TRAIN CONSIST ----
        System.out.println("--- Final Train Consist ---");
        System.out.println("Total bogies in train: " + trainConsist.size());
        for (int i = 0; i < trainConsist.size(); i++) {
            System.out.println((i + 1) + ". " + trainConsist.get(i));
        }

        System.out.println();
        System.out.println("UC14: Custom exception handling completed successfully!");
    }
}
