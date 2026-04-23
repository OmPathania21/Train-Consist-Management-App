/**
 * ================================================================
 * MAIN CLASS – UseCase11TrainConsistMgmnt
 * ================================================================
 *
 * Use Case 11: Validate Train ID and Cargo Code
 *
 * Description:
 * This class validates input formats using Regular Expressions.
 *
 * At this stage, the application:
 * - Accepts Train ID input
 * - Accepts Cargo Code input
 * - Applies regex validation
 * - Displays validation result
 *
 * This maps format validation logic using Pattern matching.
 *
 * @author Developer
 * @version 11.0
 */

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UseCase11TrainConsistMgmnt {

    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code ");
        System.out.println("=============================================");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        // Accept input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // ---- DEFINE REGEX RULES ----
        String trainIdRegex = "TRN-\\d{4}";
        String cargoCodeRegex = "PET-[A-Z]{2}";

        // Compile and match Train ID
        Pattern trainIdPattern = Pattern.compile(trainIdRegex);
        Matcher trainIdMatcher = trainIdPattern.matcher(trainId);
        boolean isTrainIdValid = trainIdMatcher.matches();

        // Compile and match Cargo Code
        Pattern cargoCodePattern = Pattern.compile(cargoCodeRegex);
        Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCode);
        boolean isCargoCodeValid = cargoCodeMatcher.matches();

        // Display results
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);
        System.out.println();

        System.out.println("UC11 validation completed...");
    }
}
