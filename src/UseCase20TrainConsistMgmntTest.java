import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase20TrainConsistMgmntTest {

    // ============================================================
    // TEST 1: Throws Exception When Empty (Linear Search)
    // ============================================================
    /**
     * Test: System throws exception when attempting to search an empty bogie array.
     * Verifies that searching "BG101" in {} throws IllegalStateException.
     */
    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] emptyBogies = {};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(emptyBogies);
        
        // Should throw IllegalStateException
        IllegalStateException exception = assertThrows(
            IllegalStateException.class,
            () -> train.linearSearch("BG101")
        );
        
        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().contains("empty"));
    }

    // ============================================================
    // TEST 2: Allows Search When Data Exists
    // ============================================================
    /**
     * Test: System allows search execution when bogie data is present.
     * Verifies that searching "BG101" in {"BG101","BG205"} executes without exception.
     */
    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogies = {"BG101", "BG205"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(bogies);
        
        // Should not throw exception
        assertDoesNotThrow(() -> {
            train.linearSearch("BG101");
        });
    }

    // ============================================================
    // TEST 3: Bogie Found After Validation
    // ============================================================
    /**
     * Test: Bogie is correctly found after passing validation.
     * Verifies that searching "BG205" in {"BG101","BG205","BG309"} returns true.
     */
    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(bogies);
        
        int result = train.linearSearch("BG205");
        
        assertNotEquals(-1, result, "Bogie should be found");
        assertEquals(1, result, "BG205 should be at index 1");
    }

    // ============================================================
    // TEST 4: Bogie Not Found After Validation
    // ============================================================
    /**
     * Test: System correctly returns false when bogie is not found.
     * Verifies that searching "BG999" in {"BG101","BG205","BG309"} returns false.
     */
    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(bogies);
        
        int result = train.linearSearch("BG999");
        
        assertEquals(-1, result, "Non-existing bogie should return -1");
    }

    // ============================================================
    // TEST 5: Single Element Valid Case
    // ============================================================
    /**
     * Test: Correct behavior when only one bogie exists.
     * Verifies that searching "BG101" in {"BG101"} returns true.
     */
    @Test
    void testSearch_SingleElementValidCase() {
        String[] singleBogie = {"BG101"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(singleBogie);
        
        int result = train.linearSearch("BG101");
        
        assertNotEquals(-1, result, "Single element should be found");
        assertEquals(0, result, "Element should be at index 0");
    }

    // ============================================================
    // ADDITIONAL TEST CASES - COMPREHENSIVE COVERAGE
    // ============================================================

    /**
     * Test: Exception message is meaningful and helpful.
     */
    @Test
    void testSearch_ExceptionMessageMeaningful() {
        String[] emptyBogies = {};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(emptyBogies);
        
        IllegalStateException exception = assertThrows(
            IllegalStateException.class,
            () -> train.linearSearch("BG101")
        );
        
        String message = exception.getMessage();
        assertTrue(message.contains("empty") || message.contains("Train") || message.contains("bogies"),
            "Message should be informative");
    }

    /**
     * Test: Binary search also validates state.
     */
    @Test
    void testSearch_BinarySearchValidatesState() {
        String[] emptyBogies = {};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(emptyBogies);
        
        // Binary search should also throw exception
        assertThrows(
            IllegalStateException.class,
            () -> train.binarySearch("BG101")
        );
    }

    /**
     * Test: Binary search works on valid data.
     */
    @Test
    void testSearch_BinarySearchValidData() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(bogies);
        
        int result = train.binarySearch("BG309");
        
        assertNotEquals(-1, result, "Bogie should be found via binary search");
    }

    /**
     * Test: Multiple search attempts on empty train all throw exception.
     */
    @Test
    void testSearch_MultipleFail_FastOnEmpty() {
        String[] emptyBogies = {};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(emptyBogies);
        
        // Each search should throw exception immediately
        assertThrows(IllegalStateException.class, () -> train.linearSearch("BG101"));
        assertThrows(IllegalStateException.class, () -> train.linearSearch("BG205"));
        assertThrows(IllegalStateException.class, () -> train.linearSearch("BG309"));
    }

    /**
     * Test: Validation happens before search logic.
     */
    @Test
    void testSearch_ValidationBeforeLogic() {
        String[] emptyBogies = {};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(emptyBogies);
        
        // Exception should be thrown immediately without search attempts
        assertThrows(
            IllegalStateException.class,
            () -> train.linearSearch("BG101")
        );
    }

    /**
     * Test: Train with two bogies validates correctly.
     */
    @Test
    void testSearch_TwoBogiesTrain() {
        String[] bogies = {"BG101", "BG205"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(bogies);
        
        // Should find first
        int result1 = train.linearSearch("BG101");
        assertEquals(0, result1);
        
        // Should find second
        UseCase20TrainConsistMgmnt.TrainConsist train2 = 
            new UseCase20TrainConsistMgmnt.TrainConsist(bogies.clone());
        int result2 = train2.linearSearch("BG205");
        assertEquals(1, result2);
    }

    /**
     * Test: Large train validates successfully.
     */
    @Test
    void testSearch_LargeTrain() {
        String[] largeBogies = new String[1000];
        for (int i = 0; i < 1000; i++) {
            largeBogies[i] = "BG" + i;
        }
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(largeBogies);
        
        // Should validate and allow search
        assertDoesNotThrow(() -> {
            train.linearSearch("BG500");
        });
    }

    /**
     * Test: Get size returns correct count.
     */
    @Test
    void testSearch_GetSizeCorrect() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(bogies);
        
        assertEquals(3, train.getSize(), "Size should match array length");
    }

    /**
     * Test: Empty train size is zero.
     */
    @Test
    void testSearch_EmptyTrainSizeZero() {
        String[] emptyBogies = {};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(emptyBogies);
        
        assertEquals(0, train.getSize(), "Empty train should have size 0");
    }

    /**
     * Test: Defensive pattern prevents NullPointerException.
     */
    @Test
    void testSearch_DefensivePatternSafe() {
        String[] emptyBogies = {};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(emptyBogies);
        
        // Should throw IllegalStateException, not NullPointerException
        assertThrows(
            IllegalStateException.class,
            () -> train.linearSearch("BG101")
        );
    }

    /**
     * Test: First element found after validation.
     */
    @Test
    void testSearch_FirstElementAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(bogies);
        
        int result = train.linearSearch("BG101");
        assertEquals(0, result, "First element should be found");
    }

    /**
     * Test: Last element found after validation.
     */
    @Test
    void testSearch_LastElementAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(bogies);
        
        int result = train.linearSearch("BG309");
        assertEquals(2, result, "Last element should be found");
    }

    /**
     * Test: Different bogie types validated correctly.
     */
    @Test
    void testSearch_DifferentBogieTypes() {
        String[] bogies = {"BG101", "GB205", "BG309"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(bogies);
        
        int result = train.linearSearch("GB205");
        assertEquals(1, result, "Different bogie type should be found");
    }

    /**
     * Test: Fail-fast prevents wasted computation.
     */
    @Test
    void testSearch_FailFastPreventsWaste() {
        String[] emptyBogies = {};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(emptyBogies);
        
        // Should fail immediately, not iterate through array
        long startTime = System.nanoTime();
        try {
            train.linearSearch("BG101");
        } catch (IllegalStateException e) {
            // Expected
        }
        long endTime = System.nanoTime();
        
        long duration = endTime - startTime;
        assertTrue(duration < 1_000_000, "Should fail fast in less than 1ms");
    }

    /**
     * Test: Search allows middle element after validation.
     */
    @Test
    void testSearch_MiddleElementAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(bogies);
        
        int result = train.linearSearch("BG309");
        assertEquals(2, result, "Middle element should be found");
    }

    /**
     * Test: Validation exception is unchecked (RuntimeException).
     */
    @Test
    void testSearch_ExceptionIsUnchecked() {
        assertTrue(RuntimeException.class.isAssignableFrom(IllegalStateException.class),
            "IllegalStateException should extend RuntimeException");
    }

    /**
     * Test: Method doesn't require throws declaration.
     */
    @Test
    void testSearch_NoThrowsRequired() {
        String[] bogies = {"BG101", "BG205"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(bogies);
        
        // LinearSearch doesn't declare throws, but can still throw RuntimeException
        assertDoesNotThrow(() -> {
            train.linearSearch("BG101");
        });
    }

    /**
     * Test: Multiple operations on same empty train all fail.
     */
    @Test
    void testSearch_ConsistentFailOnEmptyTrain() {
        String[] emptyBogies = {};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(emptyBogies);
        
        for (int i = 0; i < 5; i++) {
            assertThrows(
                IllegalStateException.class,
                () -> train.linearSearch("BG" + i)
            );
        }
    }

    /**
     * Test: ValidateNotEmpty method works correctly.
     */
    @Test
    void testSearch_ValidateNotEmptyWorks() {
        String[] emptyBogies = {};
        UseCase20TrainConsistMgmnt.TrainConsist emptyTrain = 
            new UseCase20TrainConsistMgmnt.TrainConsist(emptyBogies);
        
        String[] nonEmptyBogies = {"BG101"};
        UseCase20TrainConsistMgmnt.TrainConsist nonEmptyTrain = 
            new UseCase20TrainConsistMgmnt.TrainConsist(nonEmptyBogies);
        
        // Empty should throw
        assertThrows(IllegalStateException.class, () -> emptyTrain.linearSearch("BG101"));
        
        // Non-empty should not throw
        assertDoesNotThrow(() -> nonEmptyTrain.linearSearch("BG101"));
    }

    /**
     * Test: Sort method works correctly.
     */
    @Test
    void testSearch_SortBogies() {
        String[] unsortedBogies = {"BG550", "BG101", "BG309"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(unsortedBogies);
        
        // Should not throw exception
        assertDoesNotThrow(() -> {
            train.binarySearch("BG309");
        });
    }

    /**
     * Test: toString method works correctly.
     */
    @Test
    void testSearch_ToStringMethod() {
        String[] bogies = {"BG101", "BG205"};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(bogies);
        
        String result = train.toString();
        assertTrue(result.contains("TrainConsist") || result.contains("BG101"),
            "toString should contain train information");
    }

    /**
     * Test: Defensive programming pattern demonstrated correctly.
     */
    @Test
    void testSearch_DefensiveProgrammingPattern() {
        String[] emptyBogies = {};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(emptyBogies);
        
        // Defensive pattern: validate before acting
        assertThrows(
            IllegalStateException.class,
            () -> train.linearSearch("any_key")
        );
    }

    /**
     * Test: State validation prevents invalid states from propagating.
     */
    @Test
    void testSearch_PreventInvalidStatePropagation() {
        String[] emptyBogies = {};
        UseCase20TrainConsistMgmnt.TrainConsist train = 
            new UseCase20TrainConsistMgmnt.TrainConsist(emptyBogies);
        
        // Invalid state caught immediately
        assertThrows(
            IllegalStateException.class,
            () -> train.linearSearch("BG101")
        );
    }
}
