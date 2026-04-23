import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase14TrainConsistMgmntTest {

    // ============================================================
    // TEST 1: Valid Capacity Creation
    // ============================================================
    /**
     * Test: Valid capacity (> 0) creates bogie successfully.
     * Verifies that a passenger bogie with valid capacity is 
     * instantiated without throwing an exception.
     */
    @Test
    void testException_ValidCapacityCreation() {
        try {
            UseCase14TrainConsistMgmnt.PassengerBogie bogie = 
                new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
            assertNotNull(bogie);
            assertEquals(72, bogie.capacity);
            assertEquals("Sleeper", bogie.type);
        } catch (UseCase14TrainConsistMgmnt.InvalidCapacityException e) {
            fail("Valid capacity should not throw exception: " + e.getMessage());
        }
    }

    // ============================================================
    // TEST 2: Negative Capacity Throws Exception
    // ============================================================
    /**
     * Test: Negative capacity value triggers InvalidCapacityException.
     * Verifies that a capacity value of -10 throws the custom exception.
     */
    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", -10);
        });
    }

    // ============================================================
    // TEST 3: Zero Capacity Throws Exception
    // ============================================================
    /**
     * Test: Zero capacity value is treated as invalid.
     * Verifies that a capacity value of 0 throws InvalidCapacityException.
     */
    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("AC Chair", 0);
        });
    }

    // ============================================================
    // TEST 4: Exception Message Validation
    // ============================================================
    /**
     * Test: Exception message is clear and meaningful.
     * Verifies that the exception message matches the expected text
     * when invalid capacity is detected.
     */
    @Test
    void testException_ExceptionMessageValidation() {
        UseCase14TrainConsistMgmnt.InvalidCapacityException exception = 
            assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.PassengerBogie("First Class", -5);
        });
        
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    // ============================================================
    // TEST 5: Object Integrity After Creation
    // ============================================================
    /**
     * Test: Valid bogie objects retain correct properties.
     * Verifies that bogie properties match constructor parameters
     * after successful creation.
     */
    @Test
    void testException_ObjectIntegrityAfterCreation() {
        try {
            UseCase14TrainConsistMgmnt.PassengerBogie bogie = 
                new UseCase14TrainConsistMgmnt.PassengerBogie("AC Chair", 56);
            
            assertEquals("AC Chair", bogie.type);
            assertEquals(56, bogie.capacity);
            assertTrue(bogie.capacity > 0);
        } catch (UseCase14TrainConsistMgmnt.InvalidCapacityException e) {
            fail("Valid bogie creation should not fail: " + e.getMessage());
        }
    }

    // ============================================================
    // TEST 6: Multiple Valid Bogies Creation
    // ============================================================
    /**
     * Test: Multiple valid bogies can be created without exceptions.
     * Verifies that the system can create multiple bogie objects
     * successfully in sequence.
     */
    @Test
    void testException_MultipleValidBogiesCreation() {
        try {
            UseCase14TrainConsistMgmnt.PassengerBogie bogie1 = 
                new UseCase14TrainConsistMgmnt.PassengerBogie("Sleeper", 72);
            UseCase14TrainConsistMgmnt.PassengerBogie bogie2 = 
                new UseCase14TrainConsistMgmnt.PassengerBogie("AC Chair", 56);
            UseCase14TrainConsistMgmnt.PassengerBogie bogie3 = 
                new UseCase14TrainConsistMgmnt.PassengerBogie("First Class", 24);
            
            assertEquals(72, bogie1.capacity);
            assertEquals(56, bogie2.capacity);
            assertEquals(24, bogie3.capacity);
        } catch (UseCase14TrainConsistMgmnt.InvalidCapacityException e) {
            fail("Valid bogie creation should not throw exception: " + e.getMessage());
        }
    }

    // ============================================================
    // ADDITIONAL EDGE CASE TESTS
    // ============================================================

    /**
     * Test: Minimum valid capacity (1) is accepted.
     */
    @Test
    void testException_MinimumValidCapacity() {
        try {
            UseCase14TrainConsistMgmnt.PassengerBogie bogie = 
                new UseCase14TrainConsistMgmnt.PassengerBogie("Special", 1);
            assertEquals(1, bogie.capacity);
        } catch (UseCase14TrainConsistMgmnt.InvalidCapacityException e) {
            fail("Capacity of 1 should be valid: " + e.getMessage());
        }
    }

    /**
     * Test: Large valid capacity values are accepted.
     */
    @Test
    void testException_LargeValidCapacity() {
        try {
            UseCase14TrainConsistMgmnt.PassengerBogie bogie = 
                new UseCase14TrainConsistMgmnt.PassengerBogie("Express", 1000);
            assertEquals(1000, bogie.capacity);
        } catch (UseCase14TrainConsistMgmnt.InvalidCapacityException e) {
            fail("Large capacity should be valid: " + e.getMessage());
        }
    }

    /**
     * Test: Multiple invalid capacity attempts are all rejected.
     */
    @Test
    void testException_MultipleInvalidCapacityAttempts() {
        int[] invalidCapacities = {-1, -100, 0, -999};
        
        for (int capacity : invalidCapacities) {
            assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
                new UseCase14TrainConsistMgmnt.PassengerBogie("Test", capacity);
            });
        }
    }

    /**
     * Test: Goods bogie creation (no validation in UC14).
     */
    @Test
    void testException_GoodsBogieCreation() {
        UseCase14TrainConsistMgmnt.GoodsBogie bogie = 
            new UseCase14TrainConsistMgmnt.GoodsBogie("Rectangular", "Coal");
        
        assertNotNull(bogie);
        assertEquals("Rectangular", bogie.type);
        assertEquals("Coal", bogie.cargoType);
    }

    /**
     * Test: Exception is a checked exception (extends Exception).
     */
    @Test
    void testException_IsCheckedException() {
        assertTrue(Exception.class.isAssignableFrom(
            UseCase14TrainConsistMgmnt.InvalidCapacityException.class
        ));
    }
}
