/**
 * ================================================================
 * MAIN CLASS – UseCase17TrainConsistMgmnt
 * ================================================================
 *
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 *
 * Description:
 * This class demonstrates using Java's built-in Arrays.sort() method
 * for efficient alphabetical sorting of bogie type names.
 *
 * At this stage, the application:
 * - Creates arrays of bogie type names
 * - Uses Arrays.sort() for optimized sorting
 * - Sorts strings in natural alphabetical order
 * - Displays results using Arrays.toString()
 * - Emphasizes library usage over custom logic
 * - Handles various input scenarios
 *
 * This use case introduces:
 * - Arrays.sort() utility method
 * - Natural ordering of strings
 * - O(n log n) time complexity awareness
 * - Library optimization benefits
 * - Separation of algorithm and usage
 * - Production-ready code practices
 *
 * Comparison with UC16:
 * UC16: Manual Bubble Sort - Educational, O(n²) complexity
 * UC17: Arrays.sort() - Production, O(n log n) complexity
 *
 * @author Developer
 * @version 17.0
 */

import java.util.Arrays;

public class UseCase17TrainConsistMgmnt {

    // ============================================================
    // HELPER METHOD: DISPLAY SORTING RESULTS
    // ============================================================
    /**
     * Displays bogie names array in a formatted manner.
     *
     * @param bogieNames Array of bogie type names
     */
    static void displayBogies(String[] bogieNames) {
        System.out.println(Arrays.toString(bogieNames));
    }

    // ============================================================
    // MAIN METHOD – DEMONSTRATING ARRAYS.SORT()
    // ============================================================
    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("=============================================\n");

        // ============================================================
        // SCENARIO 1: BASIC ALPHABETICAL SORTING
        // ============================================================
        System.out.println("--- Scenario 1: Basic Alphabetical Sorting ---\n");
        System.out.println("Passenger Bogie Types:");
        String[] passengerBogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        
        System.out.println("Original Order:");
        displayBogies(passengerBogies);
        
        Arrays.sort(passengerBogies);
        
        System.out.println("Sorted Order (Alphabetical):");
        displayBogies(passengerBogies);
        System.out.println();

        // ============================================================
        // SCENARIO 2: UNSORTED INPUT HANDLING
        // ============================================================
        System.out.println("--- Scenario 2: Unsorted Input Handling ---\n");
        String[] unsortedBogies = {"Luxury", "General", "Sleeper", "AC Chair", "First Class"};
        
        System.out.println("Original Order (Random):");
        displayBogies(unsortedBogies);
        
        Arrays.sort(unsortedBogies);
        
        System.out.println("Sorted Order (Alphabetical):");
        displayBogies(unsortedBogies);
        System.out.println();

        // ============================================================
        // SCENARIO 3: ALREADY SORTED ARRAY
        // ============================================================
        System.out.println("--- Scenario 3: Already Sorted Array ---\n");
        String[] alreadySorted = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        
        System.out.println("Original Order (Already Sorted):");
        displayBogies(alreadySorted);
        
        Arrays.sort(alreadySorted);
        
        System.out.println("After Arrays.sort() (Unchanged):");
        displayBogies(alreadySorted);
        System.out.println();

        // ============================================================
        // SCENARIO 4: DUPLICATE BOGIE NAMES
        // ============================================================
        System.out.println("--- Scenario 4: Duplicate Bogie Names ---\n");
        String[] duplicateBogies = {"Sleeper", "AC Chair", "Sleeper", "General", "AC Chair", "Sleeper"};
        
        System.out.println("Original Order (With Duplicates):");
        displayBogies(duplicateBogies);
        
        Arrays.sort(duplicateBogies);
        
        System.out.println("Sorted Order (Duplicates Retained):");
        displayBogies(duplicateBogies);
        System.out.println();

        // ============================================================
        // SCENARIO 5: SINGLE ELEMENT ARRAY
        // ============================================================
        System.out.println("--- Scenario 5: Single Element Array ---\n");
        String[] singleBogy = {"Sleeper"};
        
        System.out.println("Original Order (Single Element):");
        displayBogies(singleBogy);
        
        Arrays.sort(singleBogy);
        
        System.out.println("After Arrays.sort() (Unchanged):");
        displayBogies(singleBogy);
        System.out.println();

        // ============================================================
        // SCENARIO 6: GOODS BOGIE TYPES
        // ============================================================
        System.out.println("--- Scenario 6: Goods Bogie Types ---\n");
        String[] goodsBogies = {"Cylindrical", "Rectangular", "Tanker", "Flatbed", "Covered"};
        
        System.out.println("Original Order:");
        displayBogies(goodsBogies);
        
        Arrays.sort(goodsBogies);
        
        System.out.println("Sorted Order (Alphabetical):");
        displayBogies(goodsBogies);
        System.out.println();

        // ============================================================
        // SCENARIO 7: MIXED CASE HANDLING
        // ============================================================
        System.out.println("--- Scenario 7: Mixed Case Sensitivity ---\n");
        String[] mixedCaseBogies = {"sleeper", "AC Chair", "First Class", "general"};
        
        System.out.println("Original Order (Mixed Cases):");
        displayBogies(mixedCaseBogies);
        
        Arrays.sort(mixedCaseBogies);
        
        System.out.println("Sorted Order (Case-Sensitive):");
        displayBogies(mixedCaseBogies);
        System.out.println("Note: Uppercase letters come before lowercase in ASCII order");
        System.out.println();

        // ============================================================
        // SCENARIO 8: LARGER DATASET
        // ============================================================
        System.out.println("--- Scenario 8: Larger Dataset ---\n");
        String[] largeDataset = {
            "Sleeper", "AC Chair", "First Class", "General", "Luxury",
            "Cylindrical", "Rectangular", "Tanker", "Flatbed", "Covered"
        };
        
        System.out.println("Original Order (" + largeDataset.length + " bogies):");
        displayBogies(largeDataset);
        
        long startTime = System.nanoTime();
        Arrays.sort(largeDataset);
        long endTime = System.nanoTime();
        
        System.out.println("Sorted Order (Alphabetical):");
        displayBogies(largeDataset);
        System.out.println("Sorting time: " + (endTime - startTime) + " nanoseconds");
        System.out.println();

        // ============================================================
        // SCENARIO 9: REVERSE SORTED (BEFORE SORT)
        // ============================================================
        System.out.println("--- Scenario 9: Reverse Sorted Input ---\n");
        String[] reverseSorted = {"Sleeper", "Luxury", "General", "First Class", "AC Chair"};
        
        System.out.println("Original Order (Reverse Alphabetical):");
        displayBogies(reverseSorted);
        
        Arrays.sort(reverseSorted);
        
        System.out.println("Sorted Order (Forward Alphabetical):");
        displayBogies(reverseSorted);
        System.out.println();

        // ============================================================
        // PERFORMANCE COMPARISON
        // ============================================================
        System.out.println("--- Performance Note ---\n");
        System.out.println("Arrays.sort() uses optimized algorithms:");
        System.out.println("  - For objects (like String): TimSort - O(n log n)");
        System.out.println("  - For primitives (like int): Dual-pivot Quicksort - O(n log n)");
        System.out.println("  - Much faster than manual Bubble Sort O(n²)");
        System.out.println();

        // ============================================================
        // SUMMARY
        // ============================================================
        System.out.println("=============================================");
        System.out.println("UC17: Arrays.sort() Demonstration Completed!");
        System.out.println("=============================================");
        System.out.println("\nKey Takeaways:");
        System.out.println("  ✓ Use built-in library methods for sorting");
        System.out.println("  ✓ Arrays.sort() is highly optimized");
        System.out.println("  ✓ O(n log n) is much better than O(n²)");
        System.out.println("  ✓ Code is clean, readable, and maintainable");
        System.out.println("  ✓ Production systems rely on these utilities");
        System.out.println("\nComparison with UC16:");
        System.out.println("  UC16 (Bubble Sort): Educational, manual logic, O(n²)");
        System.out.println("  UC17 (Arrays.sort): Production-ready, library, O(n log n)");
    }
}
