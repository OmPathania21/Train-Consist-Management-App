/**
 * ================================================================
 * MAIN CLASS – UseCase15TrainConsistMgmnt
 * ================================================================
 *
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 *
 * Description:
 * This class demonstrates structured exception handling using
 * try-catch-finally blocks for runtime cargo safety validation.
 *
 * At this stage, the application:
 * - Creates goods bogies with defined shapes
 * - Attempts cargo assignments with safety validation
 * - Throws CargoSafetyException for unsafe combinations
 * - Catches exceptions gracefully without crashing
 * - Uses finally block for logging and cleanup
 * - Continues execution safely after failures
 *
 * This use case introduces:
 * - Custom runtime exception (unchecked exception)
 * - try-catch-finally structure
 * - Graceful failure handling
 * - finally block for mandatory cleanup
 * - Runtime validation and operational safety
 *
 * @author Developer
 * @version 15.0
 */

import java.util.List;
import java.util.ArrayList;

public class UseCase15TrainConsistMgmnt {

    // ============================================================
    // CUSTOM RUNTIME EXCEPTION CLASS
    // ============================================================
    /**
     * Custom runtime exception for cargo safety violations.
     * Thrown when unsafe cargo-bogie combinations are detected.
     * This is an unchecked exception (extends RuntimeException).
     */
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // ============================================================
    // GOODS BOGIE CLASS WITH CARGO ASSIGNMENT
    // ============================================================
    /**
     * Represents a goods bogie with shape-based cargo constraints.
     * Validates cargo assignments against safety rules.
     */
    static class GoodsBogie {
        String shape;           // "Rectangular" or "Cylindrical"
        String assignedCargo;   // Assigned cargo type
        boolean isValidated;    // Flag for validation status

        GoodsBogie(String shape) {
            this.shape = shape;
            this.assignedCargo = null;
            this.isValidated = false;
        }

        /**
         * Assigns cargo to the bogie with safety validation.
         * Rectangular bogies cannot carry petroleum.
         * Cylindrical bogies can carry any cargo.
         *
         * @param cargoType The type of cargo to assign
         * @throws CargoSafetyException if assignment violates safety rules
         */
        void assignCargo(String cargoType) {
            try {
                // Safety validation rule
                if (shape.equalsIgnoreCase("Rectangular") && 
                    cargoType.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException(
                        "UNSAFE: Cannot assign Petroleum to Rectangular bogie!");
                }

                // If validation passes, assign cargo
                this.assignedCargo = cargoType;
                System.out.println("   ✓ Cargo assigned successfully!");

            } catch (CargoSafetyException e) {
                // Handle safety exception
                System.out.println("   ✗ " + e.getMessage());
                this.assignedCargo = null; // Ensure cargo is not assigned

            } finally {
                // Cleanup and logging (always executes)
                this.isValidated = true;
                System.out.println("   [Validation completed for " + shape + " bogie]");
            }
        }

        @Override
        public String toString() {
            String status = (assignedCargo != null) ? assignedCargo : "Empty";
            return shape + " (Cargo: " + status + ")";
        }
    }

    // ============================================================
    // MAIN METHOD – DEMONSTRATING TRY-CATCH-FINALLY HANDLING
    // ============================================================
    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("       (try-catch-finally Handling)");
        System.out.println("=============================================\n");

        // Train consist list
        List<GoodsBogie> trainConsist = new ArrayList<>();

        // ============================================================
        // SCENARIO 1: SAFE ASSIGNMENTS
        // ============================================================
        System.out.println("--- Scenario 1: Safe Cargo Assignments ---\n");

        // Create cylindrical bogie and assign petroleum (SAFE)
        System.out.println("1. Assigning Petroleum to Cylindrical bogie:");
        GoodsBogie cylindricalBogie1 = new GoodsBogie("Cylindrical");
        cylindricalBogie1.assignCargo("Petroleum");
        trainConsist.add(cylindricalBogie1);
        System.out.println();

        // Create rectangular bogie and assign coal (SAFE)
        System.out.println("2. Assigning Coal to Rectangular bogie:");
        GoodsBogie rectangularBogie1 = new GoodsBogie("Rectangular");
        rectangularBogie1.assignCargo("Coal");
        trainConsist.add(rectangularBogie1);
        System.out.println();

        // ============================================================
        // SCENARIO 2: UNSAFE ASSIGNMENT (EXCEPTION HANDLING)
        // ============================================================
        System.out.println("--- Scenario 2: Unsafe Cargo Assignment (Handled Gracefully) ---\n");

        // Attempt to assign petroleum to rectangular bogie (UNSAFE)
        System.out.println("3. Attempting Petroleum to Rectangular bogie (UNSAFE):");
        GoodsBogie rectangularBogie2 = new GoodsBogie("Rectangular");
        rectangularBogie2.assignCargo("Petroleum");  // This will trigger exception
        // Note: Despite exception, program continues!
        trainConsist.add(rectangularBogie2);
        System.out.println();

        // ============================================================
        // SCENARIO 3: MULTIPLE ASSIGNMENTS CONTINUE AFTER FAILURE
        // ============================================================
        System.out.println("--- Scenario 3: Program Continues After Exception ---\n");

        // More safe assignments after exception (demonstrates robustness)
        System.out.println("4. Assigning Grain to Cylindrical bogie:");
        GoodsBogie cylindricalBogie2 = new GoodsBogie("Cylindrical");
        cylindricalBogie2.assignCargo("Grain");
        trainConsist.add(cylindricalBogie2);
        System.out.println();

        System.out.println("5. Assigning Ore to Rectangular bogie:");
        GoodsBogie rectangularBogie3 = new GoodsBogie("Rectangular");
        rectangularBogie3.assignCargo("Ore");
        trainConsist.add(rectangularBogie3);
        System.out.println();

        // ============================================================
        // SCENARIO 4: NESTED TRY-CATCH DEMONSTRATION
        // ============================================================
        System.out.println("--- Scenario 4: Nested Try-Catch Demonstration ---\n");

        try {
            System.out.println("6. Processing multiple assignments in a batch:");
            
            try {
                GoodsBogie rectangularBogie4 = new GoodsBogie("Rectangular");
                rectangularBogie4.assignCargo("Petroleum");  // Will fail
                trainConsist.add(rectangularBogie4);
            } catch (CargoSafetyException e) {
                System.out.println("   [Inner catch] Exception handled: " + e.getMessage());
            }

            try {
                GoodsBogie cylindricalBogie3 = new GoodsBogie("Cylindrical");
                cylindricalBogie3.assignCargo("Petroleum");  // Will succeed
                trainConsist.add(cylindricalBogie3);
            } catch (CargoSafetyException e) {
                System.out.println("   [Inner catch] This should not execute");
            }

        } catch (Exception e) {
            System.out.println("   [Outer catch] Unexpected error: " + e.getMessage());
        } finally {
            System.out.println("   [Finally] Batch processing completed");
        }

        System.out.println();

        // ============================================================
        // FINAL TRAIN CONSIST SUMMARY
        // ============================================================
        System.out.println("--- Final Train Consist Summary ---");
        System.out.println("Total bogies in train: " + trainConsist.size());
        
        int validCargoCount = 0;
        int emptyBogieCount = 0;
        
        for (int i = 0; i < trainConsist.size(); i++) {
            GoodsBogie bogie = trainConsist.get(i);
            System.out.println((i + 1) + ". " + bogie);
            
            if (bogie.assignedCargo != null) {
                validCargoCount++;
            } else {
                emptyBogieCount++;
            }
        }

        System.out.println();
        System.out.println("Summary:");
        System.out.println("  - Bogies with assigned cargo: " + validCargoCount);
        System.out.println("  - Empty bogies (failed assignment): " + emptyBogieCount);
        System.out.println();
        System.out.println("UC15: Safe cargo assignment completed successfully!");
        System.out.println("      The system handled exceptions gracefully without crashing.");
    }
}
