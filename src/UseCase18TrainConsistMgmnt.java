/**
 * ================================================================
 * MAIN CLASS – UseCase18TrainConsistMgmnt
 * ================================================================
 *
 * Use Case 18: Linear Search for Bogie ID (Array-Based Searching)
 *
 * Description:
 * This class demonstrates Linear Search algorithm to locate a specific
 * bogie ID from an unsorted list by sequential traversal.
 *
 * At this stage, the application:
 * - Creates an array of bogie IDs
 * - Implements linear search logic with traversal
 * - Compares each ID using equals() method
 * - Returns search result (found or not found)
 * - Demonstrates early termination on match
 * - Works with unsorted data
 *
 * This use case introduces:
 * - Linear Search algorithm fundamentals
 * - Sequential traversal of arrays
 * - Equality comparison using equals()
 * - Early termination optimization
 * - Unsorted data handling
 * - O(n) time complexity awareness
 *
 * Comparison with UC19 (Binary Search):
 * UC18: Linear Search - Works on unsorted data, O(n) complexity
 * UC19: Binary Search - Requires sorted data, O(log n) complexity
 *
 * @author Developer
 * @version 18.0
 */

public class UseCase18TrainConsistMgmnt {

    // ============================================================
    // LINEAR SEARCH IMPLEMENTATION
    // ============================================================
    /**
     * Performs linear search to find a bogie ID in the array.
     * Traverses the array sequentially, comparing each element.
     * Returns the index if found, -1 if not found.
     *
     * Time Complexity: O(n) in all cases (best, average, worst)
     * Space Complexity: O(1) - no additional space
     *
     * @param bogieIds Array of bogie IDs to search
     * @param searchKey The bogie ID to find
     * @return Index of the found element, -1 if not found
     */
    static int linearSearch(String[] bogieIds, String searchKey) {
        int comparisons = 0;
        
        // Sequential traversal
        for (int i = 0; i < bogieIds.length; i++) {
            comparisons++;
            
            // Equality comparison
            if (bogieIds[i].equals(searchKey)) {
                System.out.println("   Found at index: " + i);
                System.out.println("   Comparisons needed: " + comparisons);
                return i;  // Early termination
            }
        }
        
        // Not found
        System.out.println("   Not found in array");
        System.out.println("   Total comparisons: " + comparisons);
        return -1;
    }

    // ============================================================
    // HELPER METHOD: DISPLAY SEARCH RESULT
    // ============================================================
    /**
     * Displays the result of a linear search operation.
     *
     * @param searchKey The ID that was searched
     * @param index The index returned by linearSearch (-1 if not found)
     */
    static void displaySearchResult(String searchKey, int index) {
        if (index != -1) {
            System.out.println("   ✓ Bogie " + searchKey + " found at index " + index);
        } else {
            System.out.println("   ✗ Bogie " + searchKey + " not found");
        }
    }

    // ============================================================
    // MAIN METHOD – DEMONSTRATING LINEAR SEARCH
    // ============================================================
    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("       (Array-Based Searching)");
        System.out.println("=============================================\n");

        // ============================================================
        // SCENARIO 1: BASIC SEARCH WITH FOUND MATCH
        // ============================================================
        System.out.println("--- Scenario 1: Basic Search (Bogie Found) ---\n");
        String[] bogieIds1 = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        
        System.out.println("Train Consist Bogie IDs:");
        System.out.println("  [0] BG101  |  [1] BG205  |  [2] BG309  |  [3] BG412  |  [4] BG550");
        System.out.println();
        
        String searchKey1 = "BG309";
        System.out.println("Searching for: " + searchKey1);
        int result1 = linearSearch(bogieIds1, searchKey1);
        displaySearchResult(searchKey1, result1);
        System.out.println();

        // ============================================================
        // SCENARIO 2: SEARCH NOT FOUND
        // ============================================================
        System.out.println("--- Scenario 2: Search Not Found ---\n");
        
        String searchKey2 = "BG999";
        System.out.println("Searching for: " + searchKey2);
        int result2 = linearSearch(bogieIds1, searchKey2);
        displaySearchResult(searchKey2, result2);
        System.out.println();

        // ============================================================
        // SCENARIO 3: FIRST ELEMENT MATCH (BEST CASE)
        // ============================================================
        System.out.println("--- Scenario 3: First Element Match (Best Case) ---\n");
        
        String searchKey3 = "BG101";
        System.out.println("Searching for: " + searchKey3);
        int result3 = linearSearch(bogieIds1, searchKey3);
        displaySearchResult(searchKey3, result3);
        System.out.println();

        // ============================================================
        // SCENARIO 4: LAST ELEMENT MATCH (WORST CASE)
        // ============================================================
        System.out.println("--- Scenario 4: Last Element Match (Worst Case) ---\n");
        
        String searchKey4 = "BG550";
        System.out.println("Searching for: " + searchKey4);
        int result4 = linearSearch(bogieIds1, searchKey4);
        displaySearchResult(searchKey4, result4);
        System.out.println();

        // ============================================================
        // SCENARIO 5: SINGLE ELEMENT ARRAY
        // ============================================================
        System.out.println("--- Scenario 5: Single Element Array ---\n");
        String[] bogieIds2 = {"BG101"};
        
        System.out.println("Train Consist (Single Bogie):");
        System.out.println("  [0] BG101");
        System.out.println();
        
        String searchKey5a = "BG101";
        System.out.println("Searching for: " + searchKey5a);
        int result5a = linearSearch(bogieIds2, searchKey5a);
        displaySearchResult(searchKey5a, result5a);
        System.out.println();
        
        String searchKey5b = "BG200";
        System.out.println("Searching for: " + searchKey5b);
        int result5b = linearSearch(bogieIds2, searchKey5b);
        displaySearchResult(searchKey5b, result5b);
        System.out.println();

        // ============================================================
        // SCENARIO 6: UNSORTED DATA (MULTIPLE MATCHES CONCEPT)
        // ============================================================
        System.out.println("--- Scenario 6: Unsorted Bogie ID Array ---\n");
        String[] bogieIds3 = {"BG550", "BG101", "BG412", "BG205", "BG309"};
        
        System.out.println("Unsorted Train Consist Bogie IDs:");
        System.out.println("  [0] BG550  |  [1] BG101  |  [2] BG412  |  [3] BG205  |  [4] BG309");
        System.out.println();
        
        String searchKey6 = "BG205";
        System.out.println("Searching for: " + searchKey6 + " (Same data, different order)");
        int result6 = linearSearch(bogieIds3, searchKey6);
        displaySearchResult(searchKey6, result6);
        System.out.println();

        // ============================================================
        // SCENARIO 7: LARGE DATASET
        // ============================================================
        System.out.println("--- Scenario 7: Large Dataset Search ---\n");
        String[] largeDataset = new String[100];
        for (int i = 0; i < 100; i++) {
            largeDataset[i] = "BG" + (i * 10 + 100);
        }
        
        System.out.println("Train Consist with 100 bogies (BG100 to BG1090)");
        System.out.println();
        
        // Search that requires many comparisons
        String searchKey7a = "BG990";
        System.out.println("Searching for: " + searchKey7a);
        int result7a = linearSearch(largeDataset, searchKey7a);
        displaySearchResult(searchKey7a, result7a);
        System.out.println();
        
        // Search that doesn't exist
        String searchKey7b = "BG5000";
        System.out.println("Searching for: " + searchKey7b);
        int result7b = linearSearch(largeDataset, searchKey7b);
        displaySearchResult(searchKey7b, result7b);
        System.out.println();

        // ============================================================
        // SCENARIO 8: MIDDLE ELEMENT MATCH (AVERAGE CASE)
        // ============================================================
        System.out.println("--- Scenario 8: Middle Element Match (Average Case) ---\n");
        
        String searchKey8 = "BG412";
        System.out.println("Searching for: " + searchKey8 + " (Middle of array)");
        int result8 = linearSearch(bogieIds1, searchKey8);
        displaySearchResult(searchKey8, result8);
        System.out.println();

        // ============================================================
        // SCENARIO 9: GOODS BOGIE IDS
        // ============================================================
        System.out.println("--- Scenario 9: Goods Bogie IDs ---\n");
        String[] goodsBogieIds = {"GB101", "GB205", "GB309", "GB412"};
        
        System.out.println("Goods Bogie IDs:");
        System.out.println("  [0] GB101  |  [1] GB205  |  [2] GB309  |  [3] GB412");
        System.out.println();
        
        String searchKey9 = "GB309";
        System.out.println("Searching for: " + searchKey9);
        int result9 = linearSearch(goodsBogieIds, searchKey9);
        displaySearchResult(searchKey9, result9);
        System.out.println();

        // ============================================================
        // SUMMARY
        // ============================================================
        System.out.println("=============================================");
        System.out.println("UC18: Linear Search Demonstration Completed!");
        System.out.println("=============================================");
        System.out.println("\nAlgorithm Summary:");
        System.out.println("  - Time Complexity: O(n)");
        System.out.println("  - Space Complexity: O(1)");
        System.out.println("  - Best Case: O(1) - element at first position");
        System.out.println("  - Average Case: O(n/2)");
        System.out.println("  - Worst Case: O(n) - element at last position or not found");
        System.out.println("\nKey Features:");
        System.out.println("  ✓ Works with unsorted data");
        System.out.println("  ✓ Simple and reliable");
        System.out.println("  ✓ Early termination on match");
        System.out.println("  ✓ Foundation for more advanced searches");
        System.out.println("\nNext Step (UC19):");
        System.out.println("  Binary Search - O(log n) for sorted data");
    }
}
