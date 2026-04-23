/**
 * ================================================================
 * MAIN CLASS – UseCase19TrainConsistMgmnt
 * ================================================================
 *
 * Use Case 19: Binary Search for Bogie ID (Optimized Searching)
 *
 * Description:
 * This class demonstrates Binary Search algorithm for efficient
 * searching on sorted bogie ID data using divide-and-conquer strategy.
 *
 * At this stage, the application:
 * - Creates an array of bogie IDs
 * - Sorts the array before searching
 * - Implements binary search with low, mid, high indexes
 * - Compares using compareTo() for lexicographic ordering
 * - Divides search range by half each iteration
 * - Returns search result (found or not found)
 * - Demonstrates O(log n) efficiency
 *
 * This use case introduces:
 * - Binary Search algorithm fundamentals
 * - Divide-and-conquer strategy
 * - Sorted data precondition
 * - Mid-point calculation
 * - Range halving on each iteration
 * - String compareTo() method
 * - O(log n) time complexity awareness
 *
 * Comparison with UC18:
 * UC18: Linear Search - O(n), works on unsorted data
 * UC19: Binary Search - O(log n), requires sorted data
 *
 * Performance Example (searching 1 million items):
 * Linear Search: ~500,000 comparisons (worst case)
 * Binary Search: ~20 comparisons (worst case)
 *
 * @author Developer
 * @version 19.0
 */

import java.util.Arrays;

public class UseCase19TrainConsistMgmnt {

    // ============================================================
    // BINARY SEARCH IMPLEMENTATION
    // ============================================================
    /**
     * Performs binary search to find a bogie ID in a sorted array.
     * Uses divide-and-conquer strategy by halving search range each iteration.
     * Returns the index if found, -1 if not found.
     *
     * PRECONDITION: Array must be sorted in ascending order
     *
     * Time Complexity: O(log n) in all cases
     * Space Complexity: O(1) - no additional space
     *
     * @param bogieIds Sorted array of bogie IDs
     * @param searchKey The bogie ID to find
     * @return Index of the found element, -1 if not found
     */
    static int binarySearch(String[] bogieIds, String searchKey) {
        int low = 0;
        int high = bogieIds.length - 1;
        int comparisons = 0;

        System.out.println("   Starting binary search...");
        System.out.println("   Initial range: [0, " + high + "]");

        // Divide-and-conquer iterations
        while (low <= high) {
            comparisons++;
            
            // Calculate mid index
            int mid = low + (high - low) / 2;
            
            // Display search step
            System.out.println("   Pass " + comparisons + ": low=" + low + ", mid=" + mid + 
                             ", high=" + high + ", comparing with '" + bogieIds[mid] + "'");

            // Compare with middle element
            int comparison = searchKey.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                // Found
                System.out.println("   ✓ Found at index: " + mid);
                System.out.println("   Comparisons needed: " + comparisons);
                return mid;
            } else if (comparison < 0) {
                // Search left half
                high = mid - 1;
                System.out.println("   → Search left half");
            } else {
                // Search right half
                low = mid + 1;
                System.out.println("   → Search right half");
            }
        }

        // Not found
        System.out.println("   ✗ Not found in array");
        System.out.println("   Total comparisons: " + comparisons);
        return -1;
    }

    // ============================================================
    // HELPER METHOD: DISPLAY ARRAY
    // ============================================================
    /**
     * Displays array contents in indexed format.
     *
     * @param bogieIds Array to display
     */
    static void displayBogies(String[] bogieIds) {
        System.out.print("   [");
        for (int i = 0; i < bogieIds.length; i++) {
            System.out.print(i + ":" + bogieIds[i]);
            if (i < bogieIds.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ============================================================
    // HELPER METHOD: DISPLAY SEARCH RESULT
    // ============================================================
    /**
     * Displays the result of a binary search operation.
     *
     * @param searchKey The ID that was searched
     * @param index The index returned by binarySearch (-1 if not found)
     */
    static void displaySearchResult(String searchKey, int index) {
        if (index != -1) {
            System.out.println("   ✓ Bogie " + searchKey + " found at index " + index);
        } else {
            System.out.println("   ✗ Bogie " + searchKey + " not found");
        }
    }

    // ============================================================
    // MAIN METHOD – DEMONSTRATING BINARY SEARCH
    // ============================================================
    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("       (Optimized Searching)");
        System.out.println("=============================================\n");

        // ============================================================
        // SCENARIO 1: BASIC BINARY SEARCH - MIDDLE ELEMENT FOUND
        // ============================================================
        System.out.println("--- Scenario 1: Basic Search (Middle Element) ---\n");
        String[] bogieIds1 = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        
        System.out.println("Train Consist Bogie IDs (Already Sorted):");
        displayBogies(bogieIds1);
        System.out.println();
        
        String searchKey1 = "BG309";
        System.out.println("Searching for: " + searchKey1);
        int result1 = binarySearch(bogieIds1, searchKey1);
        displaySearchResult(searchKey1, result1);
        System.out.println();

        // ============================================================
        // SCENARIO 2: BINARY SEARCH - NOT FOUND
        // ============================================================
        System.out.println("--- Scenario 2: Search Not Found ---\n");
        
        String searchKey2 = "BG999";
        System.out.println("Searching for: " + searchKey2);
        int result2 = binarySearch(bogieIds1, searchKey2);
        displaySearchResult(searchKey2, result2);
        System.out.println();

        // ============================================================
        // SCENARIO 3: FIRST ELEMENT MATCH (BEST CASE)
        // ============================================================
        System.out.println("--- Scenario 3: First Element Match ---\n");
        
        String searchKey3 = "BG101";
        System.out.println("Searching for: " + searchKey3);
        int result3 = binarySearch(bogieIds1, searchKey3);
        displaySearchResult(searchKey3, result3);
        System.out.println();

        // ============================================================
        // SCENARIO 4: LAST ELEMENT MATCH
        // ============================================================
        System.out.println("--- Scenario 4: Last Element Match ---\n");
        
        String searchKey4 = "BG550";
        System.out.println("Searching for: " + searchKey4);
        int result4 = binarySearch(bogieIds1, searchKey4);
        displaySearchResult(searchKey4, result4);
        System.out.println();

        // ============================================================
        // SCENARIO 5: SINGLE ELEMENT ARRAY
        // ============================================================
        System.out.println("--- Scenario 5: Single Element Array ---\n");
        String[] bogieIds2 = {"BG101"};
        
        System.out.println("Train Consist (Single Bogie):");
        displayBogies(bogieIds2);
        System.out.println();
        
        String searchKey5a = "BG101";
        System.out.println("Searching for: " + searchKey5a);
        int result5a = binarySearch(bogieIds2, searchKey5a);
        displaySearchResult(searchKey5a, result5a);
        System.out.println();
        
        String searchKey5b = "BG200";
        System.out.println("Searching for: " + searchKey5b);
        int result5b = binarySearch(bogieIds2, searchKey5b);
        displaySearchResult(searchKey5b, result5b);
        System.out.println();

        // ============================================================
        // SCENARIO 6: EMPTY ARRAY HANDLING
        // ============================================================
        System.out.println("--- Scenario 6: Empty Array Handling ---\n");
        String[] bogieIds3 = {};
        
        System.out.println("Train Consist (Empty):");
        displayBogies(bogieIds3);
        System.out.println();
        
        String searchKey6 = "BG101";
        System.out.println("Searching for: " + searchKey6);
        int result6 = binarySearch(bogieIds3, searchKey6);
        displaySearchResult(searchKey6, result6);
        System.out.println();

        // ============================================================
        // SCENARIO 7: UNSORTED INPUT HANDLING
        // ============================================================
        System.out.println("--- Scenario 7: Unsorted Input (Auto-Sorted) ---\n");
        String[] bogieIds4 = {"BG550", "BG101", "BG412", "BG205", "BG309"};
        
        System.out.println("Unsorted Train Consist Bogie IDs:");
        displayBogies(bogieIds4);
        System.out.println();
        
        // Sort before binary search
        Arrays.sort(bogieIds4);
        System.out.println("After sorting:");
        displayBogies(bogieIds4);
        System.out.println();
        
        String searchKey7 = "BG205";
        System.out.println("Searching for: " + searchKey7);
        int result7 = binarySearch(bogieIds4, searchKey7);
        displaySearchResult(searchKey7, result7);
        System.out.println();

        // ============================================================
        // SCENARIO 8: LARGE DATASET SEARCH
        // ============================================================
        System.out.println("--- Scenario 8: Large Dataset (1000 Bogies) ---\n");
        String[] largeDataset = new String[1000];
        for (int i = 0; i < 1000; i++) {
            largeDataset[i] = "BG" + (1000 + i * 10);
        }
        
        System.out.println("Train Consist with 1000 bogies");
        System.out.println("Range: BG1000 to BG11990");
        System.out.println();
        
        // Search near the end (worst case for binary search would require log(1000) ≈ 10 comparisons)
        String searchKey8a = "BG6900";
        System.out.println("Searching for: " + searchKey8a);
        int result8a = binarySearch(largeDataset, searchKey8a);
        displaySearchResult(searchKey8a, result8a);
        System.out.println();
        
        // Search that doesn't exist
        String searchKey8b = "BG5555";
        System.out.println("Searching for: " + searchKey8b + " (does not exist)");
        int result8b = binarySearch(largeDataset, searchKey8b);
        displaySearchResult(searchKey8b, result8b);
        System.out.println();

        // ============================================================
        // SCENARIO 9: GOODS BOGIE IDS
        // ============================================================
        System.out.println("--- Scenario 9: Goods Bogie IDs ---\n");
        String[] goodsBogieIds = {"GB101", "GB205", "GB309", "GB412", "GB550"};
        
        System.out.println("Goods Bogie IDs (Sorted):");
        displayBogies(goodsBogieIds);
        System.out.println();
        
        String searchKey9 = "GB309";
        System.out.println("Searching for: " + searchKey9);
        int result9 = binarySearch(goodsBogieIds, searchKey9);
        displaySearchResult(searchKey9, result9);
        System.out.println();

        // ============================================================
        // PERFORMANCE COMPARISON
        // ============================================================
        System.out.println("--- Performance Comparison ---\n");
        System.out.println("Data Set Size vs Search Comparisons:");
        System.out.println();
        System.out.println("         Size  |  Linear (worst)  |  Binary (worst)  |  Speedup");
        System.out.println("      ---------|------------------|------------------|----------");
        System.out.println("        100   |       100        |        7         |  14.3x");
        System.out.println("       1000   |      1000        |       10         | 100.0x");
        System.out.println("     10000   |     10000        |       14         | 714.3x");
        System.out.println("    100000   |    100000        |       17         | 5882.4x");
        System.out.println("   1000000   |   1000000        |       20         |50000.0x");
        System.out.println();

        // ============================================================
        // SUMMARY
        // ============================================================
        System.out.println("=============================================");
        System.out.println("UC19: Binary Search Demonstration Completed!");
        System.out.println("=============================================");
        System.out.println("\nAlgorithm Summary:");
        System.out.println("  - Time Complexity: O(log n)");
        System.out.println("  - Space Complexity: O(1)");
        System.out.println("  - Precondition: Data MUST be sorted");
        System.out.println("  - Strategy: Divide-and-conquer");
        System.out.println();
        System.out.println("Key Characteristics:");
        System.out.println("  ✓ Dramatically faster than linear search");
        System.out.println("  ✓ Scales well with large datasets");
        System.out.println("  ✓ Requires sorted data");
        System.out.println("  ✓ Uses compareTo() for string comparison");
        System.out.println("  ✓ Perfect for production systems");
        System.out.println();
        System.out.println("Use Cases:");
        System.out.println("  ✓ Railway bogie lookup systems");
        System.out.println("  ✓ Large database searches");
        System.out.println("  ✓ Production inventory systems");
        System.out.println("  ✓ Any scenario needing fast search");
        System.out.println();
        System.out.println("Journey Through Searching:");
        System.out.println("  UC18: Linear Search - Understand basics");
        System.out.println("  UC19: Binary Search - Optimize performance");
    }
}
