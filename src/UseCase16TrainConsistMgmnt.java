/**
 * ================================================================
 * MAIN CLASS – UseCase16TrainConsistMgmnt
 * ================================================================
 *
 * Use Case 16: Sort Passenger Bogies by Capacity (Bubble Sort)
 *
 * Description:
 * This class introduces manual sorting using the Bubble Sort algorithm
 * without relying on built-in sorting methods like Arrays.sort().
 *
 * At this stage, the application:
 * - Creates an array of passenger bogie capacities
 * - Implements bubble sort algorithm with nested loops
 * - Performs element comparison and swapping
 * - Visualizes sorting process with iterations
 * - Displays sorted results
 * - Demonstrates algorithm-level thinking
 *
 * This use case introduces:
 * - Bubble Sort algorithm fundamentals
 * - Array manipulation and indexing
 * - Nested loop processing
 * - Swapping logic and value exchange
 * - Algorithmic thinking and complexity
 * - O(n²) time complexity awareness
 *
 * @author Developer
 * @version 16.0
 */

public class UseCase16TrainConsistMgmnt {

    // ============================================================
    // BUBBLE SORT IMPLEMENTATION
    // ============================================================
    /**
     * Sorts an array of integers using Bubble Sort algorithm.
     * Compares adjacent elements and swaps them if out of order.
     * Continues until array is sorted (no swaps in a pass).
     *
     * Time Complexity: O(n²) in worst and average cases
     * Space Complexity: O(1) - sorts in-place
     *
     * @param capacities Array of bogie capacities to sort
     */
    static void bubbleSort(int[] capacities) {
        int n = capacities.length;
        
        // Outer loop: number of passes
        for (int i = 0; i < n - 1; i++) {
            System.out.println("\n--- Pass " + (i + 1) + " ---");
            
            boolean swapped = false;  // Optimization: track if any swap occurred
            
            // Inner loop: compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // Display current comparison
                System.out.print("Comparing " + capacities[j] + " and " + capacities[j + 1]);
                
                // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {
                    // Swap if left element is greater than right element
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                    
                    swapped = true;
                    System.out.println(" → SWAPPED");
                } else {
                    System.out.println(" → OK");
                }
            }
            
            // Display array state after this pass
            System.out.print("Array after pass " + (i + 1) + ": ");
            displayArray(capacities);
            
            // Optimization: if no swaps occurred, array is sorted
            if (!swapped) {
                System.out.println("(Array is sorted - early exit)");
                break;
            }
        }
    }

    // ============================================================
    // HELPER METHOD: DISPLAY ARRAY
    // ============================================================
    /**
     * Displays array contents in a readable format.
     *
     * @param array Array to display
     */
    static void displayArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ============================================================
    // MAIN METHOD – DEMONSTRATING BUBBLE SORT
    // ============================================================
    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println("UC16 - Sort Passenger Bogies by Capacity");
        System.out.println("        (Bubble Sort Algorithm)");
        System.out.println("=============================================\n");

        // ============================================================
        // SCENARIO 1: BASIC SORTING
        // ============================================================
        System.out.println("--- Scenario 1: Basic Sorting ---\n");
        System.out.println("Passenger Bogie Types & Typical Capacities:");
        System.out.println("  Sleeper: 72 seats");
        System.out.println("  AC Chair: 56 seats");
        System.out.println("  First Class: 24 seats");
        System.out.println("  General: 70 seats");
        System.out.println("  Express: 60 seats");
        System.out.println();

        int[] capacities1 = {72, 56, 24, 70, 60};
        System.out.println("Original Array:");
        displayArray(capacities1);
        System.out.println("\nSorting using Bubble Sort:");
        
        bubbleSort(capacities1);
        
        System.out.println("\nFinal Sorted Array:");
        displayArray(capacities1);

        // ============================================================
        // SCENARIO 2: ALREADY SORTED ARRAY
        // ============================================================
        System.out.println("\n\n--- Scenario 2: Already Sorted Array ---\n");
        int[] capacities2 = {24, 56, 60, 70, 72};
        System.out.println("Original Array (Already Sorted):");
        displayArray(capacities2);
        System.out.println("\nSorting using Bubble Sort:");
        
        bubbleSort(capacities2);
        
        System.out.println("\nFinal Sorted Array:");
        displayArray(capacities2);

        // ============================================================
        // SCENARIO 3: DUPLICATE VALUES
        // ============================================================
        System.out.println("\n\n--- Scenario 3: Duplicate Capacity Values ---\n");
        int[] capacities3 = {72, 56, 56, 24, 72};
        System.out.println("Original Array (with duplicates):");
        displayArray(capacities3);
        System.out.println("\nSorting using Bubble Sort:");
        
        bubbleSort(capacities3);
        
        System.out.println("\nFinal Sorted Array:");
        displayArray(capacities3);

        // ============================================================
        // SCENARIO 4: SINGLE ELEMENT ARRAY
        // ============================================================
        System.out.println("\n\n--- Scenario 4: Single Element Array ---\n");
        int[] capacities4 = {50};
        System.out.println("Original Array (Single Element):");
        displayArray(capacities4);
        System.out.println("\nSorting using Bubble Sort:");
        
        bubbleSort(capacities4);
        
        System.out.println("\nFinal Sorted Array:");
        displayArray(capacities4);

        // ============================================================
        // SCENARIO 5: ALL EQUAL VALUES
        // ============================================================
        System.out.println("\n\n--- Scenario 5: All Equal Capacities ---\n");
        int[] capacities5 = {60, 60, 60, 60};
        System.out.println("Original Array (All Equal):");
        displayArray(capacities5);
        System.out.println("\nSorting using Bubble Sort:");
        
        bubbleSort(capacities5);
        
        System.out.println("\nFinal Sorted Array:");
        displayArray(capacities5);

        // ============================================================
        // SCENARIO 6: REVERSE SORTED ARRAY (WORST CASE)
        // ============================================================
        System.out.println("\n\n--- Scenario 6: Reverse Sorted Array (Worst Case) ---\n");
        int[] capacities6 = {90, 80, 70, 60, 50};
        System.out.println("Original Array (Reverse Sorted):");
        displayArray(capacities6);
        System.out.println("\nSorting using Bubble Sort (Requires Maximum Passes):");
        
        bubbleSort(capacities6);
        
        System.out.println("\nFinal Sorted Array:");
        displayArray(capacities6);

        // ============================================================
        // SUMMARY
        // ============================================================
        System.out.println("\n\n=============================================");
        System.out.println("UC16: Bubble Sort Demonstration Completed!");
        System.out.println("=============================================");
        System.out.println("\nAlgorithm Summary:");
        System.out.println("  - Time Complexity: O(n²)");
        System.out.println("  - Space Complexity: O(1)");
        System.out.println("  - Stable Sort: Yes (maintains relative order)");
        System.out.println("  - In-place Sort: Yes (modifies original array)");
        System.out.println("\nNote: This educational implementation helps understand");
        System.out.println("how sorting works at the algorithm level before using");
        System.out.println("high-level APIs like Arrays.sort() or Collections.sort().");
    }
}
