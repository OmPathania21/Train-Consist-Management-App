import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Pattern;

public class UseCase11TrainConsistMgmntTest {

    private final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    @Test
    void testRegex_ValidTrainID() {
        String input = "TRN-1234";
        assertTrue(Pattern.matches(TRAIN_ID_REGEX, input));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(Pattern.matches(TRAIN_ID_REGEX, "TRAIN12"));
        assertFalse(Pattern.matches(TRAIN_ID_REGEX, "TRN12A"));
        assertFalse(Pattern.matches(TRAIN_ID_REGEX, "1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        String input = "PET-AB";
        assertTrue(Pattern.matches(CARGO_CODE_REGEX, input));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(Pattern.matches(CARGO_CODE_REGEX, "PET-ab"));
        assertFalse(Pattern.matches(CARGO_CODE_REGEX, "PET123"));
        assertFalse(Pattern.matches(CARGO_CODE_REGEX, "AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(Pattern.matches(TRAIN_ID_REGEX, "TRN-123"));
        assertFalse(Pattern.matches(TRAIN_ID_REGEX, "TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(Pattern.matches(CARGO_CODE_REGEX, "PET-aB"));
        assertFalse(Pattern.matches(CARGO_CODE_REGEX, "PET-12"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(Pattern.matches(TRAIN_ID_REGEX, ""));
        assertFalse(Pattern.matches(CARGO_CODE_REGEX, ""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        // matches() checks the entire string
        assertFalse(Pattern.matches(TRAIN_ID_REGEX, "TRN-1234 EXTRA"));
        assertFalse(Pattern.matches(CARGO_CODE_REGEX, "PET-AB-CD"));
    }
}
