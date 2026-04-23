import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class UseCase17TrainConsistMgmntTest {

    // ============================================================
    // TEST 1: Basic Alphabetical Sorting
    // ============================================================
    /**
     * Test: Bogie names are sorted alphabetically using Arrays.sort().
     * Verifies that {"Sleeper","AC Chair","First Class","General","Luxury"} 
     * becomes {"AC Chair","First Class","General","Luxury","Sleeper"}.
     */
    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    // ============================================================
    // TEST 2: Unsorted Input Handling
    // ============================================================
    /**
     * Test: Unsorted list of bogie names is rearranged alphabetically.
     * Verifies that {"Luxury","General","Sleeper","AC Chair"} 
     * becomes {"AC Chair","General","Luxury","Sleeper"}.
     */
    @Test
    void testSort_UnsortedInput() {
        String[] bogieNames = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    // ============================================================
    // TEST 3: Already Sorted Array
    // ============================================================
    /**
     * Test: Already sorted bogie name array remains unchanged.
     * Verifies that {"AC Chair","First Class","General"} 
     * remains {"AC Chair","First Class","General"}.
     */
    @Test
    void testSort_AlreadySortedArray() {
        String[] bogieNames = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    // ============================================================
    // TEST 4: Duplicate Bogie Names
    // ============================================================
    /**
     * Test: Duplicate bogie names are retained and correctly ordered.
     * Verifies that {"Sleeper","AC Chair","Sleeper","General"} 
     * becomes {"AC Chair","General","Sleeper","Sleeper"}.
     */
    @Test
    void testSort_DuplicateBogieNames() {
        String[] bogieNames = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    // ============================================================
    // TEST 5: Single Element Array
    // ============================================================
    /**
     * Test: Sorting a single element array does not change it.
     * Verifies that {"Sleeper"} remains {"Sleeper"}.
     */
    @Test
    void testSort_SingleElementArray() {
        String[] bogieNames = {"Sleeper"};
        String[] expected = {"Sleeper"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    // ============================================================
    // ADDITIONAL TEST CASES - EDGE CASES & VARIATIONS
    // ============================================================

    /**
     * Test: Empty array handling.
     */
    @Test
    void testSort_EmptyArray() {
        String[] bogieNames = {};
        String[] expected = {};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: Two element array - unsorted.
     */
    @Test
    void testSort_TwoElementsUnsorted() {
        String[] bogieNames = {"Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "Sleeper"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: Two element array - already sorted.
     */
    @Test
    void testSort_TwoElementsSorted() {
        String[] bogieNames = {"AC Chair", "Sleeper"};
        String[] expected = {"AC Chair", "Sleeper"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: Two element array - equal values.
     */
    @Test
    void testSort_TwoElementsEqual() {
        String[] bogieNames = {"Sleeper", "Sleeper"};
        String[] expected = {"Sleeper", "Sleeper"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: All identical elements.
     */
    @Test
    void testSort_AllIdenticalElements() {
        String[] bogieNames = {"Sleeper", "Sleeper", "Sleeper", "Sleeper"};
        String[] expected = {"Sleeper", "Sleeper", "Sleeper", "Sleeper"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: Multiple duplicates mixed with different values.
     */
    @Test
    void testSort_MultipleDuplicatesWithDifferentValues() {
        String[] bogieNames = {"Sleeper", "AC Chair", "Sleeper", "General", "AC Chair", "Luxury", "Sleeper"};
        String[] expected = {"AC Chair", "AC Chair", "General", "Luxury", "Sleeper", "Sleeper", "Sleeper"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: Reverse sorted array (worst case for some algorithms, not for TimSort).
     */
    @Test
    void testSort_ReverseSortedArray() {
        String[] bogieNames = {"Sleeper", "Luxury", "General", "First Class", "AC Chair"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: Goods bogie types.
     */
    @Test
    void testSort_GoodsBogieTypes() {
        String[] bogieNames = {"Cylindrical", "Rectangular", "Tanker", "Flatbed", "Covered"};
        String[] expected = {"Covered", "Cylindrical", "Flatbed", "Rectangular", "Tanker"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: Single letter differences in names.
     */
    @Test
    void testSort_SingleLetterDifferences() {
        String[] bogieNames = {"Class", "Clash", "Clause", "Clamp"};
        String[] expected = {"Clamp", "Clash", "Clause", "Class"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: Names with numbers (numeric suffixes).
     */
    @Test
    void testSort_NamesWithNumbers() {
        String[] bogieNames = {"Bogie3", "Bogie1", "Bogie10", "Bogie2"};
        String[] expected = {"Bogie1", "Bogie10", "Bogie2", "Bogie3"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: Names with spaces.
     */
    @Test
    void testSort_NamesWithSpaces() {
        String[] bogieNames = {"First Class", "AC Chair", "Second Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General", "Second Class"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: Verify in-place sorting (original array is modified).
     */
    @Test
    void testSort_InPlaceSorting() {
        String[] bogieNames = {"Sleeper", "AC Chair", "General"};
        String[] original = bogieNames;  // Same reference
        
        Arrays.sort(bogieNames);
        
        // Verify the same array object was modified
        assertSame(original, bogieNames);
        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper"}, bogieNames);
    }

    /**
     * Test: Large dataset sorting.
     */
    @Test
    void testSort_LargeDataset() {
        String[] bogieNames = {
            "Sleeper", "AC Chair", "First Class", "General", "Luxury",
            "Cylindrical", "Rectangular", "Tanker", "Flatbed", "Covered"
        };
        String[] expected = {
            "AC Chair", "Covered", "Cylindrical", "First Class", "Flatbed",
            "General", "Luxury", "Rectangular", "Sleeper", "Tanker"
        };
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: Verify sorting doesn't depend on initial order.
     */
    @Test
    void testSort_ConsistentResults() {
        String[] arr1 = {"Sleeper", "AC Chair", "General", "Luxury", "First Class"};
        String[] arr2 = {"Luxury", "General", "Sleeper", "AC Chair", "First Class"};
        String[] arr3 = {"First Class", "AC Chair", "Sleeper", "General", "Luxury"};
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        
        assertArrayEquals(arr1, arr2);
        assertArrayEquals(arr2, arr3);
    }

    /**
     * Test: Verify Arrays.toString() can display sorted result.
     */
    @Test
    void testSort_ToStringRepresentation() {
        String[] bogieNames = {"Sleeper", "AC Chair", "General"};
        Arrays.sort(bogieNames);
        
        String result = Arrays.toString(bogieNames);
        
        assertTrue(result.contains("AC Chair"));
        assertTrue(result.contains("General"));
        assertTrue(result.contains("Sleeper"));
    }

    /**
     * Test: Alphabetical vs lexicographic ordering.
     */
    @Test
    void testSort_LexicographicOrdering() {
        String[] bogieNames = {"apple", "Apple", "banana", "Banana"};
        Arrays.sort(bogieNames);
        
        // Uppercase letters come before lowercase in ASCII ordering
        assertEquals("Apple", bogieNames[0]);
        assertEquals("Banana", bogieNames[1]);
        assertEquals("apple", bogieNames[2]);
        assertEquals("banana", bogieNames[3]);
    }

    /**
     * Test: Special characters in names.
     */
    @Test
    void testSort_SpecialCharacters() {
        String[] bogieNames = {"Sleeper-A", "AC-Chair", "First-Class", "General-B"};
        String[] expected = {"AC-Chair", "First-Class", "General-B", "Sleeper-A"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: String with different lengths.
     */
    @Test
    void testSort_DifferentLengths() {
        String[] bogieNames = {"A", "AA", "AAA", "B", "BB"};
        String[] expected = {"A", "AA", "AAA", "B", "BB"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }

    /**
     * Test: Verify sorted array is in ascending order.
     */
    @Test
    void testSort_AscendingOrderVerification() {
        String[] bogieNames = {"Sleeper", "AC Chair", "General", "Luxury", "First Class"};
        Arrays.sort(bogieNames);
        
        for (int i = 0; i < bogieNames.length - 1; i++) {
            assertTrue(bogieNames[i].compareTo(bogieNames[i + 1]) <= 0,
                "Array is not in ascending order at index " + i);
        }
    }

    /**
     * Test: Verify all elements are preserved after sorting.
     */
    @Test
    void testSort_ElementPreservation() {
        String[] original = {"Sleeper", "AC Chair", "General", "Luxury", "First Class"};
        String[] bogieNames = original.clone();
        
        Arrays.sort(bogieNames);
        
        // Check each element exists in the original
        for (String name : original) {
            assertTrue(Arrays.asList(bogieNames).contains(name),
                "Element " + name + " missing after sorting");
        }
    }

    /**
     * Test: Three element array in various orders.
     */
    @Test
    void testSort_ThreeElementVariations() {
        // Unsorted
        String[] arr1 = {"Sleeper", "AC Chair", "General"};
        Arrays.sort(arr1);
        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper"}, arr1);
        
        // Sorted
        String[] arr2 = {"AC Chair", "General", "Sleeper"};
        Arrays.sort(arr2);
        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper"}, arr2);
        
        // Reverse sorted
        String[] arr3 = {"Sleeper", "General", "AC Chair"};
        Arrays.sort(arr3);
        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper"}, arr3);
    }

    /**
     * Test: Case sensitivity in sorting.
     */
    @Test
    void testSort_CaseSensitivity() {
        String[] bogieNames = {"sleeper", "AC Chair", "general", "First Class"};
        Arrays.sort(bogieNames);
        
        // Arrays.sort() is case-sensitive; uppercase comes before lowercase
        assertEquals("AC Chair", bogieNames[0]);
        assertEquals("First Class", bogieNames[1]);
        assertEquals("general", bogieNames[2]);
        assertEquals("sleeper", bogieNames[3]);
    }

    /**
     * Test: Performance characteristics (should complete quickly).
     */
    @Test
    void testSort_PerformanceTimeSensitive() {
        String[] bogieNames = new String[1000];
        for (int i = 0; i < 1000; i++) {
            bogieNames[i] = "Bogie" + (1000 - i);
        }
        
        long startTime = System.nanoTime();
        Arrays.sort(bogieNames);
        long endTime = System.nanoTime();
        
        long duration = endTime - startTime;
        
        // Should complete in less than 100 milliseconds
        assertTrue(duration < 100_000_000,
            "Sorting 1000 elements took too long: " + duration + " ns");
    }

    /**
     * Test: Verify sorted result matches a manually verified expected order.
     */
    @Test
    void testSort_RealisticBogieNames() {
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury", "Express"};
        String[] expected = {"AC Chair", "Express", "First Class", "General", "Luxury", "Sleeper"};
        
        Arrays.sort(bogieNames);
        
        assertArrayEquals(expected, bogieNames);
    }
}
