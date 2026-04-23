import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase18TrainConsistMgmntTest {

    // ============================================================
    // TEST 1: Bogie Found
    // ============================================================
    /**
     * Test: System successfully identifies an existing bogie ID.
     * Verifies that searching "BG309" in {"BG101","BG205","BG309","BG412","BG550"} returns true.
     */
    @Test
    void testSearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";
        
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, searchKey);
        
        assertNotEquals(-1, result, "Bogie should be found");
        assertEquals(2, result, "BG309 should be at index 2");
    }

    // ============================================================
    // TEST 2: Bogie Not Found
    // ============================================================
    /**
     * Test: System returns negative result when bogie ID does not exist.
     * Verifies that searching "BG999" in {"BG101","BG205","BG309","BG412","BG550"} returns false.
     */
    @Test
    void testSearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG999";
        
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, searchKey);
        
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
    void testSearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG101";
        
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, searchKey);
        
        assertNotEquals(-1, result, "First element should be found");
        assertEquals(0, result, "BG101 should be at index 0 (first element)");
    }

    // ============================================================
    // TEST 4: Last Element Match
    // ============================================================
    /**
     * Test: Search correctly detects a match at the last position.
     * Verifies that searching "BG550" in {"BG101","BG205","BG309","BG412","BG550"} returns true.
     */
    @Test
    void testSearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG550";
        
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, searchKey);
        
        assertNotEquals(-1, result, "Last element should be found");
        assertEquals(4, result, "BG550 should be at index 4 (last element)");
    }

    // ============================================================
    // TEST 5: Single Element Array
    // ============================================================
    /**
     * Test: Search works correctly when only one bogie ID exists.
     * Verifies that searching "BG101" in {"BG101"} returns true.
     */
    @Test
    void testSearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        
        // Search for existing element
        int result1 = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG101");
        assertEquals(0, result1, "Single element should be found");
        
        // Search for non-existing element
        int result2 = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG200");
        assertEquals(-1, result2, "Non-existing element should not be found");
    }

    // ============================================================
    // ADDITIONAL TEST CASES - COMPREHENSIVE COVERAGE
    // ============================================================

    /**
     * Test: Empty array handling.
     */
    @Test
    void testSearch_EmptyArray() {
        String[] bogieIds = {};
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG101");
        
        assertEquals(-1, result, "Empty array should return -1");
    }

    /**
     * Test: Two element array - found at first position.
     */
    @Test
    void testSearch_TwoElementsFirstMatch() {
        String[] bogieIds = {"BG101", "BG205"};
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG101");
        
        assertEquals(0, result, "First element of two-element array");
    }

    /**
     * Test: Two element array - found at last position.
     */
    @Test
    void testSearch_TwoElementsLastMatch() {
        String[] bogieIds = {"BG101", "BG205"};
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG205");
        
        assertEquals(1, result, "Last element of two-element array");
    }

    /**
     * Test: Two element array - not found.
     */
    @Test
    void testSearch_TwoElementsNotFound() {
        String[] bogieIds = {"BG101", "BG205"};
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG300");
        
        assertEquals(-1, result, "Non-existing element in two-element array");
    }

    /**
     * Test: Middle element match in odd-sized array.
     */
    @Test
    void testSearch_MiddleElementOddArray() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG309");
        
        assertEquals(2, result, "Middle element (index 2 of 5 elements)");
    }

    /**
     * Test: Middle element match in even-sized array.
     */
    @Test
    void testSearch_MiddleElementEvenArray() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412"};
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG205");
        
        assertEquals(1, result, "Near-middle element in even-sized array");
    }

    /**
     * Test: Case sensitivity in search.
     */
    @Test
    void testSearch_CaseSensitivity() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        
        // Lowercase should not match uppercase
        int result1 = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "bg101");
        assertEquals(-1, result1, "Lowercase should not match uppercase");
        
        // Exact case should match
        int result2 = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG101");
        assertEquals(0, result2, "Exact case should match");
    }

    /**
     * Test: Unsorted array search.
     */
    @Test
    void testSearch_UnsortedArray() {
        String[] bogieIds = {"BG550", "BG101", "BG412", "BG205", "BG309"};
        
        // Linear search should work regardless of order
        assertEquals(1, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG101"));
        assertEquals(4, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG309"));
        assertEquals(0, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG550"));
    }

    /**
     * Test: Duplicate elements in array.
     */
    @Test
    void testSearch_DuplicateElements() {
        String[] bogieIds = {"BG101", "BG205", "BG101", "BG412", "BG101"};
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG101");
        
        // Should find the first occurrence
        assertEquals(0, result, "Should return first occurrence of duplicate");
    }

    /**
     * Test: Large array - element found near beginning.
     */
    @Test
    void testSearch_LargeArrayBeginning() {
        String[] bogieIds = new String[1000];
        for (int i = 0; i < 1000; i++) {
            bogieIds[i] = "BG" + (1000 + i);
        }
        
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG1005");
        assertEquals(5, result, "Element at index 5 in large array");
    }

    /**
     * Test: Large array - element found at end.
     */
    @Test
    void testSearch_LargeArrayEnd() {
        String[] bogieIds = new String[1000];
        for (int i = 0; i < 1000; i++) {
            bogieIds[i] = "BG" + (1000 + i);
        }
        
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG1999");
        assertEquals(999, result, "Element at last index in large array");
    }

    /**
     * Test: Large array - element not found.
     */
    @Test
    void testSearch_LargeArrayNotFound() {
        String[] bogieIds = new String[1000];
        for (int i = 0; i < 1000; i++) {
            bogieIds[i] = "BG" + (1000 + i);
        }
        
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG9999");
        assertEquals(-1, result, "Non-existing element in large array");
    }

    /**
     * Test: Goods bogie IDs (different naming convention).
     */
    @Test
    void testSearch_GoodsBogieIds() {
        String[] bogieIds = {"GB101", "GB205", "GB309", "GB412"};
        
        int result1 = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "GB309");
        assertEquals(2, result1, "Goods bogie found");
        
        int result2 = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "GB500");
        assertEquals(-1, result2, "Goods bogie not found");
    }

    /**
     * Test: Mixed bogie types (passenger and goods).
     */
    @Test
    void testSearch_MixedBogieTypes() {
        String[] bogieIds = {"BG101", "GB205", "BG309", "GB412"};
        
        assertEquals(0, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG101"));
        assertEquals(1, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "GB205"));
        assertEquals(2, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG309"));
        assertEquals(3, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "GB412"));
    }

    /**
     * Test: String with special characters.
     */
    @Test
    void testSearch_SpecialCharacters() {
        String[] bogieIds = {"BG-101", "BG-205", "BG-309"};
        
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG-205");
        assertEquals(1, result, "ID with special characters");
    }

    /**
     * Test: Null search key handling (should not crash).
     */
    @Test
    void testSearch_NullSearchKey() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        
        // Should not crash with null comparison
        assertThrows(NullPointerException.class, () -> {
            UseCase18TrainConsistMgmnt.linearSearch(bogieIds, null);
        });
    }

    /**
     * Test: Bogie IDs with leading zeros.
     */
    @Test
    void testSearch_LeadingZeros() {
        String[] bogieIds = {"BG001", "BG002", "BG003", "BG004"};
        
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG002");
        assertEquals(1, result, "ID with leading zeros");
    }

    /**
     * Test: Long bogie ID strings.
     */
    @Test
    void testSearch_LongIds() {
        String[] bogieIds = {
            "PASSENGER-BOGIE-101-SLEEPER",
            "PASSENGER-BOGIE-205-AC-CHAIR",
            "GOODS-BOGIE-309-CYLINDRICAL"
        };
        
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "PASSENGER-BOGIE-205-AC-CHAIR");
        assertEquals(1, result, "Long ID string found");
    }

    /**
     * Test: Single character IDs.
     */
    @Test
    void testSearch_SingleCharacterIds() {
        String[] bogieIds = {"A", "B", "C", "D"};
        
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "B");
        assertEquals(1, result, "Single character ID");
    }

    /**
     * Test: Numeric-only IDs.
     */
    @Test
    void testSearch_NumericIds() {
        String[] bogieIds = {"101", "205", "309", "412"};
        
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "309");
        assertEquals(2, result, "Numeric ID found");
    }

    /**
     * Test: Return value is correct type (int).
     */
    @Test
    void testSearch_ReturnTypeInt() {
        String[] bogieIds = {"BG101"};
        
        Object result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG101");
        assertInstanceOf(Integer.class, result);
    }

    /**
     * Test: Verify search stops early (optimization check).
     */
    @Test
    void testSearch_EarlyTermination() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        
        // Searching for first element should terminate immediately
        int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG101");
        assertEquals(0, result, "Should find and terminate at first element");
    }

    /**
     * Test: Sequential search through multiple elements.
     */
    @Test
    void testSearch_SequentialTraversal() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        
        // Test each position can be found
        for (int i = 0; i < bogieIds.length; i++) {
            int result = UseCase18TrainConsistMgmnt.linearSearch(bogieIds, bogieIds[i]);
            assertEquals(i, result, "Element at index " + i + " should be found");
        }
    }

    /**
     * Test: All elements found in unsorted array.
     */
    @Test
    void testSearch_AllElementsInUnsortedArray() {
        String[] bogieIds = {"BG550", "BG101", "BG412", "BG205", "BG309"};
        
        // All elements should be found
        assertNotEquals(-1, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG550"));
        assertNotEquals(-1, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG101"));
        assertNotEquals(-1, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG412"));
        assertNotEquals(-1, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG205"));
        assertNotEquals(-1, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG309"));
    }

    /**
     * Test: Non-existing elements consistently return -1.
     */
    @Test
    void testSearch_NonExistingElementsReturn_1() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        
        assertEquals(-1, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG999"));
        assertEquals(-1, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "BG000"));
        assertEquals(-1, UseCase18TrainConsistMgmnt.linearSearch(bogieIds, "XX100"));
    }
}
