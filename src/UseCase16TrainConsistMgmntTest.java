import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class UseCase16TrainConsistMgmntTest {

    // ============================================================
    // TEST 1: Basic Sorting
    // ============================================================
    /**
     * Test: Bubble Sort correctly sorts typical unsorted array.
     * Verifies that array {72, 56, 24, 70, 60} becomes {24, 56, 60, 70, 72}.
     */
    @Test
    void testSort_BasicSorting() {
        int[] capacities = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    // ============================================================
    // TEST 2: Already Sorted Array
    // ============================================================
    /**
     * Test: Already sorted array remains unchanged.
     * Verifies that {24, 56, 60, 70, 72} remains {24, 56, 60, 70, 72}.
     */
    @Test
    void testSort_AlreadySortedArray() {
        int[] capacities = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    // ============================================================
    // TEST 3: Duplicate Values
    // ============================================================
    /**
     * Test: Duplicate capacities are handled correctly.
     * Verifies that {72, 56, 56, 24} becomes {24, 56, 56, 72}.
     */
    @Test
    void testSort_DuplicateValues() {
        int[] capacities = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    // ============================================================
    // TEST 4: Single Element Array
    // ============================================================
    /**
     * Test: Single element array does not change.
     * Verifies that {50} remains {50}.
     */
    @Test
    void testSort_SingleElementArray() {
        int[] capacities = {50};
        int[] expected = {50};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    // ============================================================
    // TEST 5: All Equal Values
    // ============================================================
    /**
     * Test: Arrays with identical values remain unchanged.
     * Verifies that {40, 40, 40} remains {40, 40, 40}.
     */
    @Test
    void testSort_AllEqualValues() {
        int[] capacities = {40, 40, 40};
        int[] expected = {40, 40, 40};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    // ============================================================
    // ADDITIONAL TEST CASES - EDGE CASES & VARIATIONS
    // ============================================================

    /**
     * Test: Two element array - unsorted.
     */
    @Test
    void testSort_TwoElementsUnsorted() {
        int[] capacities = {72, 24};
        int[] expected = {24, 72};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    /**
     * Test: Two element array - already sorted.
     */
    @Test
    void testSort_TwoElementsSorted() {
        int[] capacities = {24, 72};
        int[] expected = {24, 72};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    /**
     * Test: Two element array - equal values.
     */
    @Test
    void testSort_TwoElementsEqual() {
        int[] capacities = {56, 56};
        int[] expected = {56, 56};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    /**
     * Test: Reverse sorted array (worst case for Bubble Sort).
     */
    @Test
    void testSort_ReverseSortedArray() {
        int[] capacities = {90, 80, 70, 60, 50};
        int[] expected = {50, 60, 70, 80, 90};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    /**
     * Test: Large array with mixed values.
     */
    @Test
    void testSort_LargeArray() {
        int[] capacities = {72, 24, 90, 56, 40, 70, 60, 30, 80, 50};
        int[] expected = {24, 30, 40, 50, 56, 60, 70, 72, 80, 90};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    /**
     * Test: Array with negative values.
     */
    @Test
    void testSort_NegativeValues() {
        int[] capacities = {56, -10, 24, 0, 72};
        int[] expected = {-10, 0, 24, 56, 72};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    /**
     * Test: Array with zero value.
     */
    @Test
    void testSort_WithZeroValue() {
        int[] capacities = {56, 0, 24, 72};
        int[] expected = {0, 24, 56, 72};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    /**
     * Test: Array with multiple duplicates.
     */
    @Test
    void testSort_MultipleDuplicates() {
        int[] capacities = {72, 56, 72, 56, 24, 56, 24};
        int[] expected = {24, 24, 56, 56, 56, 72, 72};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    /**
     * Test: Array nearly sorted (minimal swaps needed).
     */
    @Test
    void testSort_NearlySorted() {
        int[] capacities = {24, 56, 60, 72, 70};
        int[] expected = {24, 56, 60, 70, 72};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    /**
     * Test: Verify bubble sort is stable (preserves relative order of equal elements).
     */
    @Test
    void testSort_StableSort() {
        // In a stable sort, equal elements maintain their original relative order
        int[] capacities = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    /**
     * Test: Verify all elements from original array are present after sorting.
     */
    @Test
    void testSort_PreservesAllElements() {
        int[] capacities = {72, 56, 24, 70, 60};
        int[] original = capacities.clone();
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        // Check that all original values are present
        Arrays.sort(original);
        assertArrayEquals(original, capacities);
    }

    /**
     * Test: Verify result is actually sorted (ascending order).
     */
    @Test
    void testSort_ResultIsAscending() {
        int[] capacities = {72, 56, 24, 70, 60};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        for (int i = 0; i < capacities.length - 1; i++) {
            assertTrue(capacities[i] <= capacities[i + 1], 
                "Array is not in ascending order at index " + i);
        }
    }

    /**
     * Test: Empty array handling (edge case).
     */
    @Test
    void testSort_EmptyArray() {
        int[] capacities = {};
        int[] expected = {};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    /**
     * Test: Minimum integer values.
     */
    @Test
    void testSort_MinimumValues() {
        int[] capacities = {24, Integer.MIN_VALUE, 56, 0};
        int[] expected = {Integer.MIN_VALUE, 0, 24, 56};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    /**
     * Test: Maximum integer values.
     */
    @Test
    void testSort_MaximumValues() {
        int[] capacities = {Integer.MAX_VALUE, 56, Integer.MAX_VALUE - 1, 0};
        int[] expected = {0, 56, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }

    /**
     * Test: Verify in-place sorting (original array is modified).
     */
    @Test
    void testSort_InPlaceSorting() {
        int[] capacities = {72, 56, 24};
        int[] original = capacities;  // Same reference
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        // Verify the same array object was modified
        assertSame(original, capacities);
        assertArrayEquals(new int[]{24, 56, 72}, capacities);
    }

    /**
     * Test: Verify sorting doesn't depend on input order.
     */
    @Test
    void testSort_ConsistentResults() {
        int[] capacities1 = {72, 56, 24, 70, 60};
        int[] capacities2 = {24, 70, 60, 72, 56};
        int[] capacities3 = {60, 24, 72, 70, 56};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities1);
        UseCase16TrainConsistMgmnt.bubbleSort(capacities2);
        UseCase16TrainConsistMgmnt.bubbleSort(capacities3);
        
        assertArrayEquals(capacities1, capacities2);
        assertArrayEquals(capacities2, capacities3);
    }

    /**
     * Test: Three element array in various orders.
     */
    @Test
    void testSort_ThreeElementVariations() {
        // Unsorted
        int[] arr1 = {72, 24, 56};
        UseCase16TrainConsistMgmnt.bubbleSort(arr1);
        assertArrayEquals(new int[]{24, 56, 72}, arr1);
        
        // Sorted
        int[] arr2 = {24, 56, 72};
        UseCase16TrainConsistMgmnt.bubbleSort(arr2);
        assertArrayEquals(new int[]{24, 56, 72}, arr2);
        
        // Reverse sorted
        int[] arr3 = {72, 56, 24};
        UseCase16TrainConsistMgmnt.bubbleSort(arr3);
        assertArrayEquals(new int[]{24, 56, 72}, arr3);
    }

    /**
     * Test: Verify algorithm handles passenger bogie capacity ranges.
     */
    @Test
    void testSort_RealisticCapacityRanges() {
        // Realistic capacity values for train bogies
        int[] capacities = {72, 56, 24, 90, 60};  // Sleeper, AC, First Class, General, Express
        int[] expected = {24, 56, 60, 72, 90};
        
        UseCase16TrainConsistMgmnt.bubbleSort(capacities);
        
        assertArrayEquals(expected, capacities);
    }
}
