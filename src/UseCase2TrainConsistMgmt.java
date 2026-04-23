/**
 * ================================================================
 * MAIN CLASS – UseCase2TrainConsistMgmt
 * ================================================================
 *
 * Use Case 2: Add Passenger Bogies to Train
 *
 * Description:
 * This class demonstrates how passenger bogies can be
 * managed dynamically using ArrayList operations.
 *
 * At this stage, the application:
 * - Adds new bogies to the train
 * - Removes existing bogies
 * - Checks for bogie availability
 * - Displays the final consist
 *
 * This maps CRUD operations using ArrayList.
 *
 * @author Developer
 * @version 2.0
 */

import java.util.List;
import java.util.ArrayList;

public class UseCase2TrainConsistMgmt {
    
    public static void main(String[] args) {
        
        // Display section header
        System.out.println("=============================================");
        System.out.println(" UC2 - Add Passenger Bogies to Train");
        System.out.println("=============================================");
        System.out.println();
        
        // Create an ArrayList to hold passenger bogies
        List<String> passengerBogies = new ArrayList<>();
        
        // ---- CREATE (Add bogies) ----
        // add() attaches a new bogie to the train
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        
        // Display after adding
        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies : " + passengerBogies);
        System.out.println();
        
        // ---- DELETE (Remove bogies) ----
        // remove() detaches a bogie from the train
        passengerBogies.remove("AC Chair");
        
        // Display after removing
        System.out.println("After Removing 'AC Chair':");
        System.out.println("Passenger Bogies : " + passengerBogies);
        System.out.println();
        
        // ---- READ (Check availability) ----
        // contains() checks if a bogie exists in the consist
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        
        System.out.println("Checking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + hasSleeper);
        System.out.println();
        
        // Final state display
        System.out.println("Final Train Passenger Consist:");
        System.out.println(passengerBogies);
        System.out.println();
        
        System.out.println("UC2 operations completed successfully...");
    }
}
