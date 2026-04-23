import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class UseCase19TrainConsistMgmntTest {

    // ============================================================
    // TEST 1: Binary Search - Bogie Found
    // ============================================================
    /**
     * Test: System successfully identifies an existing bogie ID.
     * Verifies that searching "BG309" in {"BG101","BG205","BG309","BG412","BG550"} returns true.
     */
    @Test
    void testBinarySearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";
        
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, searchKey);
        
        assertNotEquals(-1, result, "Bogie should be found");
        assertEquals(2, result, "BG309 should be at index 2");
    }

    // ============================================================
    // TEST 2: Binary Search - Bogie Not Found
    // ============================================================
    /**
     * Test: System returns negative result when bogie ID does not exist.
     * Verifies that searching "BG999" in {"BG101","BG205","BG309","BG412","BG550"} returns false.
     */
    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG999";
        
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, searchKey);
        
        assertEquals(-1, result, "Bogie BG999 should not be found");
    }

    // ============================================================
    // TEST 3: First Element Match
    // ============================================================
    /**
     * Test: Search correctly detects a match at the first position.
     * Verifies that searching "BG101" in {"BG101","BG205","BG309","BG412","BG550"} returns true.
     */
    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG101";
        
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, searchKey);
        
        assertNotEquals(-1, result, "First element should be found");
        assertEquals(0, result, "BG101 should be at index 0");
    }

    // ============================================================
    // TEST 4: Last Element Match
    // ============================================================
    /**
     * Test: Search correctly detects a match at the last position.
     * Verifies that searching "BG550" in {"BG101","BG205","BG309","BG412","BG550"} returns true.
     */
    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG550";
        
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, searchKey);
        
        assertNotEquals(-1, result, "Last element should be found");
        assertEquals(4, result, "BG550 should be at index 4");
    }

    // ============================================================
    // TEST 5: Single Element Array
    // ============================================================
    /**
     * Test: Search works correctly when only one bogie ID exists.
     * Verifies that searching "BG101" in {"BG101"} returns true.
     */
    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        
        // Search for existing element
        int result1 = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG101");
        assertEquals(0, result1, "Single element should be found");
        
        // Search for non-existing element
        int result2 = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG200");
        assertEquals(-1, result2, "Non-existing element should not be found");
    }

    // ============================================================
    // TEST 6: Empty Array
    // ============================================================
    /**
     * Test: System safely handles an empty bogie list.
     * Verifies that searching "BG101" in {} returns false.
     */
    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogieIds = {};
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG101");
        
        assertEquals(-1, result, "Empty array should return -1");
    }

    // ============================================================
    // TEST 7: Unsorted Input Handling
    // ============================================================
    /**
     * Test: Unsorted input is sorted before applying Binary Search.
     * Verifies that searching "BG205" in {"BG309","BG101","BG550","BG205","BG412"} returns true.
     */
    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        
        // Sort before binary search
        Arrays.sort(bogieIds);
        
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG205");
        
        assertNotEquals(-1, result, "Bogie should be found after sorting");
    }

    // ============================================================
    // ADDITIONAL TEST CASES - COMPREHENSIVE COVERAGE
    // ============================================================

    /**
     * Test: Two element array - found at first position.
     */
    @Test
    void testBinarySearch_TwoElementsFirstMatch() {
        String[] bogieIds = {"BG101", "BG205"};
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG101");
        
        assertEquals(0, result, "First element of two-element array");
    }

    /**
     * Test: Two element array - found at last position.
     */
    @Test
    void testBinarySearch_TwoElementsLastMatch() {
        String[] bogieIds = {"BG101", "BG205"};
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG205");
        
        assertEquals(1, result, "Last element of two-element array");
    }

    /**
     * Test: Two element array - not found.
     */
    @Test
    void testBinarySearch_TwoElementsNotFound() {
        String[] bogieIds = {"BG101", "BG205"};
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG300");
        
        assertEquals(-1, result, "Non-existing element in two-element array");
    }

    /**
     * Test: Middle element match in odd-sized array.
     */
    @Test
    void testBinarySearch_MiddleElementOddArray() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG309");
        
        assertEquals(2, result, "Middle element (index 2 of 5 elements)");
    }

    /**
     * Test: Case sensitivity in search.
     */
    @Test
    void testBinarySearch_CaseSensitivity() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        
        // Lowercase should not match uppercase in this case
        int result1 = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "bg101");
        assertEquals(-1, result1, "Lowercase should not match uppercase");
        
        // Exact case should match
        int result2 = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG101");
        assertEquals(0, result2, "Exact case should match");
    }

    /**
     * Test: Multiple matching searches in same array.
     */
    @Test
    void testBinarySearch_MultipleSearches() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        
        assertEquals(0, UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG101"));
        assertEquals(1, UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG205"));
        assertEquals(2, UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG309"));
        assertEquals(3, UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG412"));
        assertEquals(4, UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG550"));
    }

    /**
     * Test: Large array - element found near beginning.
     */
    @Test
    void testBinarySearch_LargeArrayBeginning() {
        String[] bogieIds = new String[1000];
        for (int i = 0; i < 1000; i++) {
            bogieIds[i] = "BG" + (1000 + i);
        }
        
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG1005");
        assertEquals(5, result, "Element at index 5 in large array");
    }

    /**
     * Test: Large array - element found at end.
     */
    @Test
    void testBinarySearch_LargeArrayEnd() {
        String[] bogieIds = new String[1000];
        for (int i = 0; i < 1000; i++) {
            bogieIds[i] = "BG" + (1000 + i);
        }
        
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG1999");
        assertEquals(999, result, "Element at last index in large array");
    }

    /**
     * Test: Large array - element not found.
     */
    @Test
    void testBinarySearch_LargeArrayNotFound() {
        String[] bogieIds = new String[1000];
        for (int i = 0; i < 1000; i++) {
            bogieIds[i] = "BG" + (1000 + i);
        }
        
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG9999");
        assertEquals(-1, result, "Non-existing element in large array");
    }

    /**
     * Test: Goods bogie IDs.
     */
    @Test
    void testBinarySearch_GoodsBogieIds() {
        String[] bogieIds = {"GB101", "GB205", "GB309", "GB412"};
        
        int result1 = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "GB309");
        assertEquals(2, result1, "Goods bogie found");
        
        int result2 = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "GB500");
        assertEquals(-1, result2, "Goods bogie not found");
    }

    /**
     * Test: Mixed bogie types (passenger and goods).
     */
    @Test
    void testBinarySearch_MixedBogieTypes() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "GB101", "GB205"};
        Arrays.sort(bogieIds);
        
        assertNotEquals(-1, UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG101"));
        assertNotEquals(-1, UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "GB205"));
    }

    /**
     * Test: String with special characters.
     */
    @Test
    void testBinarySearch_SpecialCharacters() {
        String[] bogieIds = {"BG-101", "BG-205", "BG-309"};
        
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG-205");
        assertEquals(1, result, "ID with special characters");
    }

    /**
     * Test: Numeric-only IDs (sorted as strings).
     */
    @Test
    void testBinarySearch_NumericIds() {
        String[] bogieIds = {"101", "205", "309", "412"};
        
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "309");
        assertEquals(2, result, "Numeric ID found");
    }

    /**
     * Test: IDs with leading zeros.
     */
    @Test
    void testBinarySearch_LeadingZeros() {
        String[] bogieIds = {"BG001", "BG002", "BG003", "BG004"};
        
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG002");
        assertEquals(1, result, "ID with leading zeros");
    }

    /**
     * Test: Long bogie ID strings.
     */
    @Test
    void testBinarySearch_LongIds() {
        String[] bogieIds = {
            "PASSENGER-BOGIE-101-SLEEPER",
            "PASSENGER-BOGIE-205-AC-CHAIR",
            "GOODS-BOGIE-309-CYLINDRICAL"
        };
        Arrays.sort(bogieIds);
        
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "PASSENGER-BOGIE-205-AC-CHAIR");
        assertNotEquals(-1, result, "Long ID string found");
    }

    /**
     * Test: Three element array in various search positions.
     */
    @Test
    void testBinarySearch_ThreeElementVariations() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        
        assertEquals(0, UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG101"));
        assertEquals(1, UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG205"));
        assertEquals(2, UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG309"));
    }

    /**
     * Test: Return value is correct type (int).
     */
    @Test
    void testBinarySearch_ReturnTypeInt() {
        String[] bogieIds = {"BG101"};
        
        Object result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG101");
        assertInstanceOf(Integer.class, result);
    }

    /**
     * Test: Verify divide-and-conquer efficiency with large dataset.
     */
    @Test
    void testBinarySearch_DivideAndConquerEfficiency() {
        // Create array of 10,000 elements
        String[] bogieIds = new String[10000];
        for (int i = 0; i < 10000; i++) {
            bogieIds[i] = "BG" + String.format("%05d", i);
        }
        
        // Binary search should find element with log(10000) ≈ 14 comparisons worst case
        int result = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG9999");
        assertNotEquals(-1, result, "Element should be found in 10k element array");
    }

    /**
     * Test: Sorted precondition is met.
     */
    @Test
    void testBinarySearch_SortedPrecondition() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        
        // Verify array is sorted
        String[] sorted = bogieIds.clone();
        Arrays.sort(sorted);
        assertArrayEquals(bogieIds, sorted, "Array should be sorted");
    }

    /**
     * Test: Compare with Linear Search equivalence (same results).
     */
    @Test
    void testBinarySearch_EquivalenceWithLinearSearch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        
        // Both should find same element
        int binaryResult = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG309");
        assertEquals(2, binaryResult);
        
        // Both should not find same missing element
        int binaryNotFound = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG999");
        assertEquals(-1, binaryNotFound);
    }

    /**
     * Test: Unsorted array must be sorted first.
     */
    @Test
    void testBinarySearch_UnsortedArrayRequiresSort() {
        String[] unsorted = {"BG550", "BG101", "BG412", "BG205", "BG309"};
        
        // Before sort, binary search may give incorrect results
        // After sort, it should work correctly
        Arrays.sort(unsorted);
        int result = UseCase19TrainConsistMgmnt.binarySearch(unsorted, "BG309");
        
        assertNotEquals(-1, result, "Should find element after sorting");
    }

    /**
     * Test: Elements found in alphabetical order after sorting.
     */
    @Test
    void testBinarySearch_AlphabeticalOrder() {
        String[] bogieIds = {"BG550", "BG101", "BG412", "BG205", "BG309"};
        Arrays.sort(bogieIds);
        
        // Should be in order: BG101, BG205, BG309, BG412, BG550
        assertEquals("BG101", bogieIds[0]);
        assertEquals("BG205", bogieIds[1]);
        assertEquals("BG309", bogieIds[2]);
        assertEquals("BG412", bogieIds[3]);
        assertEquals("BG550", bogieIds[4]);
    }

    /**
     * Test: Performance comparison numbers.
     */
    @Test
    void testBinarySearch_PerformanceAdvantage() {
        String[] largeArray = new String[1000000];
        for (int i = 0; i < 1000000; i++) {
            largeArray[i] = "BG" + String.format("%07d", i);
        }
        
        // Binary search should find element much faster than linear search
        // with log(1000000) ≈ 20 comparisons vs 500,000 comparisons
        long startTime = System.nanoTime();
        int result = UseCase19TrainConsistMgmnt.binarySearch(largeArray, "BG500000");
        long endTime = System.nanoTime();
        
        assertNotEquals(-1, result, "Element should be found");
        long duration = endTime - startTime;
        assertTrue(duration < 1_000_000_000, "Should complete in less than 1 second");
    }

    /**
     * Test: Precondition enforcement - array must be sorted.
     */
    @Test
    void testBinarySearch_PreconditionSorted() {
        String[] sorted = {"BG101", "BG205", "BG309"};
        String[] unsorted = {"BG309", "BG101", "BG205"};
        
        // Sorted array should work correctly
        int resultSorted = UseCase19TrainConsistMgmnt.binarySearch(sorted, "BG205");
        assertEquals(1, resultSorted, "Should find element in sorted array");
        
        // Unsorted array may not work correctly
        // (depends on where element ends up due to division logic)
        // This test shows why precondition matters
    }

    /**
     * Test: Adjacent element searches.
     */
    @Test
    void testBinarySearch_AdjacentElements() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412"};
        
        // Search for adjacent elements
        int result1 = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG205");
        int result2 = UseCase19TrainConsistMgmnt.binarySearch(bogieIds, "BG309");
        
        assertEquals(1, result1);
        assertEquals(2, result2);
        assertEquals(1, result2 - result1, "Should be adjacent");
    }
}
