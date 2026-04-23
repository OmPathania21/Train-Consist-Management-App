/**
 * ================================================================
 * MAIN CLASS – UseCase5TrainConsistMgmt
 * ================================================================
 *
 * Use Case 5: Preserve Insertion Order of Bogies
 *
 * Description:
 * This class maintains the exact attachment order of bogies
 * while also enforcing uniqueness using LinkedHashSet.
 *
 * At this stage, the application:
 * - Attaches bogies in order
 * - Preserves insertion sequence
 * - Avoids duplicate bogies
 * - Displays final train formation
 *
 * This maps ordered uniqueness using LinkedHashSet.
 *
 * @author Developer
 * @version 5.0
 */

import java.util.Set;
import java.util.LinkedHashSet;

public class UseCase5TrainConsistMgmt {
    
    public static void main(String[] args) {
        
        // Display section header
        System.out.println("=============================================");
        System.out.println(" UC5 - Preserve Insertion Order of Bogies");
        System.out.println("=============================================");
        System.out.println();
        
        // LinkedHashSet preserves order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();
        
        // ---- ATTACH bogies ----
        // add() inserts bogies in the formation
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        
        // Attempt to attach duplicate (will be ignored)
        formation.add("Sleeper");  // Duplicate entry
        
        // Display final formation
        System.out.println("Final Train Formation:");
        System.out.println(formation);
        System.out.println();
        
        // Display note about LinkedHashSet behavior
        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println();
        
        System.out.println("UC5 formation setup completed...");
    }
}
