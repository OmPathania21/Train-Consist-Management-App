/**
 * ================================================================
 * MAIN CLASS – UseCase20TrainConsistMgmnt
 * ================================================================
 *
 * Use Case 20: Exception Handling During Search Operations
 *
 * Description:
 * This class demonstrates defensive programming by validating
 * system state before performing search operations using
 * IllegalStateException for fail-fast behavior.
 *
 * At this stage, the application:
 * - Validates that bogie collection is not empty
 * - Throws IllegalStateException if no bogies exist
 * - Implements fail-fast principle
 * - Provides meaningful error messages
 * - Prevents invalid search execution
 * - Demonstrates state validation pattern
 *
 * This use case introduces:
 * - Defensive programming techniques
 * - IllegalStateException for state violations
 * - Fail-fast principle and early stopping
 * - State validation before operations
 * - Runtime exception handling
 * - Precondition validation
 *
 * Progression:
 * UC18: Linear Search - Basic searching
 * UC19: Binary Search - Optimized searching
 * UC20: Exception Handling - Defensive search with validation
 *
 * @author Developer
 * @version 20.0
 */

import java.util.Arrays;

public class UseCase20TrainConsistMgmnt {

    // ============================================================
    // TRAIN CLASS WITH STATE VALIDATION
    // ============================================================
    /**
     * Represents a train consist with defensive search operations.
     * Validates state before executing search logic.
     */
    static class TrainConsist {
        private String[] bogieIds;
        private boolean isSorted;

        /**
         * Constructor initializes train with bogie IDs.
         *
         * @param bogieIds Array of bogie IDs
         */
        TrainConsist(String[] bogieIds) {
            this.bogieIds = bogieIds;
            this.isSorted = false;
        }

        /**
         * Sorts the bogie IDs for binary search.
         */
        void sortBogies() {
            Arrays.sort(bogieIds);
            isSorted = true;
        }

        /**
         * Returns the number of bogies in the train.
         *
         * @return Number of bogies
         */
        int getSize() {
            return bogieIds.length;
        }

        /**
         * Validates that the train has bogies before searching.
         * Implements fail-fast principle.
         *
         * @throws IllegalStateException if no bogies exist
         */
        void validateNotEmpty() {
            if (bogieIds.length == 0) {
                throw new IllegalStateException(
                    "Cannot search: Train consist is empty. Add bogies before searching.");
            }
        }

        /**
         * Performs linear search with state validation.
         * Checks if train is empty before executing search.
         *
         * @param searchKey The bogie ID to find
         * @return Index if found, -1 if not found
         * @throws IllegalStateException if train is empty
         */
        int linearSearch(String searchKey) {
            // Fail-fast validation
            validateNotEmpty();

            System.out.println("   Train has " + bogieIds.length + " bogies");
            System.out.println("   Performing linear search...");

            int comparisons = 0;

            // Search logic only executes after validation
            for (int i = 0; i < bogieIds.length; i++) {
                comparisons++;
                if (bogieIds[i].equals(searchKey)) {
                    System.out.println("   ✓ Found at index: " + i);
                    System.out.println("   Comparisons: " + comparisons);
                    return i;
                }
            }

            System.out.println("   ✗ Not found in array");
            System.out.println("   Total comparisons: " + comparisons);
            return -1;
        }

        /**
         * Performs binary search with state validation.
         * Requires sorted data and non-empty collection.
         *
         * @param searchKey The bogie ID to find
         * @return Index if found, -1 if not found
         * @throws IllegalStateException if train is empty
         */
        int binarySearch(String searchKey) {
            // Fail-fast validation
            validateNotEmpty();

            System.out.println("   Train has " + bogieIds.length + " bogies");
            if (!isSorted) {
                System.out.println("   Sorting bogies before binary search...");
                sortBogies();
            }
            System.out.println("   Performing binary search...");

            int low = 0;
            int high = bogieIds.length - 1;
            int comparisons = 0;

            while (low <= high) {
                comparisons++;
                int mid = low + (high - low) / 2;
                int comparison = searchKey.compareTo(bogieIds[mid]);

                if (comparison == 0) {
                    System.out.println("   ✓ Found at index: " + mid);
                    System.out.println("   Comparisons: " + comparisons);
                    return mid;
                } else if (comparison < 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            System.out.println("   ✗ Not found in array");
            System.out.println("   Total comparisons: " + comparisons);
            return -1;
        }

        @Override
        public String toString() {
            return "TrainConsist{" + "bogies=" + Arrays.toString(bogieIds) + "}";
        }
    }

    // ============================================================
    // HELPER METHOD: DISPLAY MESSAGE
    // ============================================================
    /**
     * Displays a formatted message.
     *
     * @param message Message to display
     */
    static void displayMessage(String message) {
        System.out.println(message);
    }

    // ============================================================
    // MAIN METHOD – DEMONSTRATING DEFENSIVE SEARCH OPERATIONS
    // ============================================================
    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("       (Defensive Programming)");
        System.out.println("=============================================\n");

        // ============================================================
        // SCENARIO 1: SEARCH ON EMPTY TRAIN (EXCEPTION CASE)
        // ============================================================
        System.out.println("--- Scenario 1: Search on Empty Train ---\n");
        TrainConsist emptyTrain = new TrainConsist(new String[]{});
        
        System.out.println("Train Status: Empty");
        System.out.println("Attempting linear search for 'BG101'...\n");
        
        try {
            int result = emptyTrain.linearSearch("BG101");
        } catch (IllegalStateException e) {
            System.out.println("✗ Exception caught: " + e.getMessage());
            System.out.println("   (Fail-fast principle: Operation prevented early)\n");
        }

        // ============================================================
        // SCENARIO 2: SEARCH ON VALID TRAIN (SUCCESS)
        // ============================================================
        System.out.println("--- Scenario 2: Linear Search on Valid Train ---\n");
        String[] validBogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        TrainConsist train1 = new TrainConsist(validBogies);
        
        System.out.println("Train Status: " + train1.toString());
        System.out.println("Searching for 'BG309'...\n");
        
        try {
            int result = train1.linearSearch("BG309");
            if (result != -1) {
                System.out.println("✓ Search successful\n");
            }
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage() + "\n");
        }

        // ============================================================
        // SCENARIO 3: BOGIE NOT FOUND (AFTER VALIDATION)
        // ============================================================
        System.out.println("--- Scenario 3: Bogie Not Found (After Validation) ---\n");
        TrainConsist train2 = new TrainConsist(validBogies.clone());
        
        System.out.println("Train Status: " + train2.toString());
        System.out.println("Searching for 'BG999'...\n");
        
        try {
            int result = train2.linearSearch("BG999");
            if (result == -1) {
                System.out.println("✓ Bogie not found (expected result)\n");
            }
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage() + "\n");
        }

        // ============================================================
        // SCENARIO 4: BINARY SEARCH ON VALID TRAIN
        // ============================================================
        System.out.println("--- Scenario 4: Binary Search on Valid Train ---\n");
        TrainConsist train3 = new TrainConsist(validBogies.clone());
        
        System.out.println("Train Status: " + train3.toString());
        System.out.println("Searching for 'BG412' using binary search...\n");
        
        try {
            int result = train3.binarySearch("BG412");
            if (result != -1) {
                System.out.println("✓ Binary search successful\n");
            }
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage() + "\n");
        }

        // ============================================================
        // SCENARIO 5: SINGLE BOGIE TRAIN
        // ============================================================
        System.out.println("--- Scenario 5: Single Bogie Train ---\n");
        TrainConsist singleBogy = new TrainConsist(new String[]{"BG101"});
        
        System.out.println("Train Status: " + singleBogy.toString());
        System.out.println("Searching for 'BG101'...\n");
        
        try {
            int result = singleBogy.linearSearch("BG101");
            if (result != -1) {
                System.out.println("✓ Search successful\n");
            }
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage() + "\n");
        }

        // ============================================================
        // SCENARIO 6: MULTIPLE EMPTY SEARCH ATTEMPTS
        // ============================================================
        System.out.println("--- Scenario 6: Multiple Empty Search Attempts ---\n");
        TrainConsist emptyTrain2 = new TrainConsist(new String[]{});
        String[] searchKeys = {"BG101", "BG205", "BG309"};
        
        System.out.println("Train Status: Empty");
        System.out.println("Attempting multiple searches...\n");
        
        for (String key : searchKeys) {
            try {
                System.out.println("Searching for: " + key);
                int result = emptyTrain2.linearSearch(key);
            } catch (IllegalStateException e) {
                System.out.println("✗ Exception: " + e.getMessage() + "\n");
            }
        }

        // ============================================================
        // SCENARIO 7: DEFENSIVE PATTERN DEMONSTRATION
        // ============================================================
        System.out.println("--- Scenario 7: Defensive Pattern Flow ---\n");
        System.out.println("Code flow with defensive programming:");
        System.out.println("  1. User initiates search operation");
        System.out.println("  2. System checks: Is train empty?");
        System.out.println("  3a. If YES → throw IllegalStateException (fail-fast)");
        System.out.println("  3b. If NO → proceed with search logic");
        System.out.println("  4. User receives meaningful error or result");
        System.out.println();

        TrainConsist defensiveTrain = new TrainConsist(new String[]{"BG101", "BG205"});
        System.out.println("Demonstrating with valid train:");
        System.out.println("Train Status: " + defensiveTrain.toString());
        System.out.println("Step 1: User initiates search for 'BG101'");
        System.out.println("Step 2-3b: Train is not empty, proceeding...\n");
        
        try {
            int result = defensiveTrain.linearSearch("BG101");
            System.out.println("Step 4: Search completed successfully\n");
        } catch (IllegalStateException e) {
            System.out.println("Exception caught: " + e.getMessage() + "\n");
        }

        // ============================================================
        // SCENARIO 8: LARGE TRAIN WITH VALIDATION
        // ============================================================
        System.out.println("--- Scenario 8: Large Train Validation ---\n");
        String[] largeBogies = new String[1000];
        for (int i = 0; i < 1000; i++) {
            largeBogies[i] = "BG" + String.format("%04d", i);
        }
        TrainConsist largeTrain = new TrainConsist(largeBogies);
        
        System.out.println("Train Status: " + largeTrain.getSize() + " bogies");
        System.out.println("Searching for 'BG0500' in large train...\n");
        
        try {
            int result = largeTrain.binarySearch("BG0500");
            System.out.println("✓ Search completed\n");
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage() + "\n");
        }

        // ============================================================
        // SCENARIO 9: EXCEPTION HANDLING BEST PRACTICE
        // ============================================================
        System.out.println("--- Scenario 9: Exception Handling Best Practice ---\n");
        System.out.println("When to throw IllegalStateException:");
        System.out.println("  ✓ Object state is invalid for the operation");
        System.out.println("  ✓ Method is called at inappropriate time");
        System.out.println("  ✓ Preconditions are violated");
        System.out.println("  ✓ Operation cannot proceed safely");
        System.out.println();
        System.out.println("In this application:");
        System.out.println("  → Searching empty train is inappropriate state");
        System.out.println("  → Throw exception immediately (fail-fast)");
        System.out.println("  → Prevent wasted computation");
        System.out.println("  → Provide clear error message\n");

        // ============================================================
        // SUMMARY
        // ============================================================
        System.out.println("=============================================");
        System.out.println("UC20: Defensive Search Operations Completed!");
        System.out.println("=============================================");
        System.out.println("\nKey Concepts:");
        System.out.println("  ✓ Defensive Programming");
        System.out.println("  ✓ State Validation (Precondition Checking)");
        System.out.println("  ✓ Fail-Fast Principle");
        System.out.println("  ✓ IllegalStateException Usage");
        System.out.println("  ✓ Meaningful Error Messages");
        System.out.println();
        System.out.println("Benefits:");
        System.out.println("  ✓ Prevents invalid operations");
        System.out.println("  ✓ Improves system reliability");
        System.out.println("  ✓ Makes errors explicit");
        System.out.println("  ✓ Saves computational resources");
        System.out.println("  ✓ Enhances user experience");
    }
}
