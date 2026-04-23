import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmntTest {

    // ============================================================
    // TEST 1: Safe Cargo Assignment
    // ============================================================
    /**
     * Test: Safe cargo assignments succeed without exceptions.
     * Verifies that cylindrical bogie assigned petroleum is processed successfully.
     */
    @Test
    void testCargo_SafeAssignment() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        
        // Should not throw exception
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
        
        // Cargo should be assigned
        assertEquals("Petroleum", bogie.assignedCargo);
        assertTrue(bogie.isValidated);
    }

    // ============================================================
    // TEST 2: Unsafe Assignment Handled
    // ============================================================
    /**
     * Test: Unsafe cargo assignments trigger CargoSafetyException.
     * Verifies that assigning petroleum to rectangular bogie raises exception
     * but is caught and handled gracefully.
     */
    @Test
    void testCargo_UnsafeAssignmentHandled() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        
        // assignCargo handles the exception internally, so no exception propagates
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
        
        // Validation should still complete (finally block executed)
        assertTrue(bogie.isValidated);
    }

    // ============================================================
    // TEST 3: Cargo Not Assigned After Failure
    // ============================================================
    /**
     * Test: Cargo is not assigned when unsafe combination occurs.
     * Verifies that rectangular bogie does not store petroleum cargo
     * after failed safety validation.
     */
    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        
        // Attempt unsafe assignment
        bogie.assignCargo("Petroleum");
        
        // Cargo should NOT be assigned
        assertNull(bogie.assignedCargo);
    }

    // ============================================================
    // TEST 4: Program Continues After Exception
    // ============================================================
    /**
     * Test: Application continues execution after exception handling.
     * Verifies that multiple cargo assignments proceed without terminating
     * the program, even after an unsafe assignment attempt.
     */
    @Test
    void testCargo_ProgramContinuesAfterException() {
        // First unsafe assignment
        UseCase15TrainConsistMgmnt.GoodsBogie bogie1 = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        bogie1.assignCargo("Petroleum");
        
        // Program should continue and allow more assignments
        UseCase15TrainConsistMgmnt.GoodsBogie bogie2 = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        bogie2.assignCargo("Petroleum");
        
        // Second assignment should succeed
        assertEquals("Petroleum", bogie2.assignedCargo);
    }

    // ============================================================
    // TEST 5: Finally Block Execution
    // ============================================================
    /**
     * Test: Finally block executes regardless of assignment success or failure.
     * Verifies that validation completion flag is set (set in finally block).
     */
    @Test
    void testCargo_FinallyBlockExecution() {
        // Test with successful assignment
        UseCase15TrainConsistMgmnt.GoodsBogie bogie1 = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        bogie1.assignCargo("Coal");
        
        assertTrue(bogie1.isValidated, "isValidated should be true after successful assignment");
        
        // Test with failed assignment
        UseCase15TrainConsistMgmnt.GoodsBogie bogie2 = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        bogie2.assignCargo("Petroleum");
        
        assertTrue(bogie2.isValidated, "isValidated should be true even after failed assignment");
    }

    // ============================================================
    // ADDITIONAL TEST CASES - EDGE CASES & SPECIFIC SCENARIOS
    // ============================================================

    /**
     * Test: Rectangular bogie can safely accept coal.
     */
    @Test
    void testCargo_RectangularWithCoal() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        
        bogie.assignCargo("Coal");
        assertEquals("Coal", bogie.assignedCargo);
    }

    /**
     * Test: Rectangular bogie can safely accept ore.
     */
    @Test
    void testCargo_RectangularWithOre() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        
        bogie.assignCargo("Ore");
        assertEquals("Ore", bogie.assignedCargo);
    }

    /**
     * Test: Cylindrical bogie can safely accept coal.
     */
    @Test
    void testCargo_CylindricalWithCoal() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        
        bogie.assignCargo("Coal");
        assertEquals("Coal", bogie.assignedCargo);
    }

    /**
     * Test: Cylindrical bogie can safely accept petroleum.
     */
    @Test
    void testCargo_CylindricalWithPetroleum() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.assignedCargo);
    }

    /**
     * Test: Cylindrical bogie can safely accept grain.
     */
    @Test
    void testCargo_CylindricalWithGrain() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        
        bogie.assignCargo("Grain");
        assertEquals("Grain", bogie.assignedCargo);
    }

    /**
     * Test: Exception is a runtime exception (unchecked).
     */
    @Test
    void testCargo_ExceptionIsRuntimeException() {
        assertTrue(RuntimeException.class.isAssignableFrom(
            UseCase15TrainConsistMgmnt.CargoSafetyException.class
        ));
    }

    /**
     * Test: Multiple safe assignments in sequence.
     */
    @Test
    void testCargo_MultipleSafeAssignments() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie1 = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        UseCase15TrainConsistMgmnt.GoodsBogie bogie2 = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        UseCase15TrainConsistMgmnt.GoodsBogie bogie3 = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        
        bogie1.assignCargo("Coal");
        bogie2.assignCargo("Petroleum");
        bogie3.assignCargo("Grain");
        
        assertEquals("Coal", bogie1.assignedCargo);
        assertEquals("Petroleum", bogie2.assignedCargo);
        assertEquals("Grain", bogie3.assignedCargo);
    }

    /**
     * Test: Case-insensitive safety validation (Petroleum vs petroleum).
     */
    @Test
    void testCargo_CaseInsensitiveValidation() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        
        // Using lowercase "petroleum" should still trigger exception
        bogie.assignCargo("petroleum");
        assertNull(bogie.assignedCargo);
        assertTrue(bogie.isValidated);
    }

    /**
     * Test: Bogie toString representation.
     */
    @Test
    void testCargo_BogieToString() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie1 = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        bogie1.assignCargo("Coal");
        
        assertTrue(bogie1.toString().contains("Rectangular"));
        assertTrue(bogie1.toString().contains("Coal"));
    }

    /**
     * Test: Empty bogie toString representation.
     */
    @Test
    void testCargo_EmptyBogieToString() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        
        assertTrue(bogie.toString().contains("Cylindrical"));
        assertTrue(bogie.toString().contains("Empty"));
    }

    /**
     * Test: Reassignment after failed attempt.
     */
    @Test
    void testCargo_ReassignmentAfterFailure() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        
        // First attempt: unsafe
        bogie.assignCargo("Petroleum");
        assertNull(bogie.assignedCargo);
        
        // Second attempt: safe
        bogie.assignCargo("Coal");
        assertEquals("Coal", bogie.assignedCargo);
    }

    /**
     * Test: Multiple failures do not affect system stability.
     */
    @Test
    void testCargo_MultipleSafetyFailures() {
        UseCase15TrainConsistMgmnt.GoodsBogie bogie = 
            new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        
        // Multiple unsafe attempts
        bogie.assignCargo("Petroleum");
        assertNull(bogie.assignedCargo);
        
        bogie.assignCargo("Petroleum");
        assertNull(bogie.assignedCargo);
        
        bogie.assignCargo("Petroleum");
        assertNull(bogie.assignedCargo);
        
        // Finally succeeds with safe cargo
        bogie.assignCargo("Ore");
        assertEquals("Ore", bogie.assignedCargo);
    }
}
