/**
 * ================================================================
 * MAIN CLASS – UseCase4TrainConsistMgmt
 * ================================================================
 *
 * Use Case 4: Maintain Ordered Bogie Consist
 *
 * Description:
 * This class models the physical chaining of train bogies
 * using LinkedList for ordered operations.
 *
 * At this stage, the application:
 * - Adds bogies in sequence
 * - Inserts bogies at specific positions
 * - Removes bogies from front and rear
 * - Displays updated train structure
 *
 * This maps positional operations using LinkedList.
 *
 * @author Developer
 * @version 4.0
 */

import java.util.List;
import java.util.LinkedList;

public class UseCase4TrainConsistMgmt {
    
    public static void main(String[] args) {
        
        // Display section header
        System.out.println("=============================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist");
        System.out.println("=============================================");
        System.out.println();
        
        // Create a LinkedList
        // LinkedList maintains insertion order and allows fast inserts
        List<String> trainConsist = new LinkedList<>();
        
        // ---- ADD bogies in sequence ----
        // add() attaches bogies to the end of the train
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");
        
        // Display initial consist
        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);
        System.out.println();
        
        // ---- INSERT at specific position ----
        // add(index, element) inserts a bogie in the middle
        trainConsist.add(2, "Pantry Car");
        
        // Display after insertion
        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist);
        System.out.println();
        
        // ---- REMOVE from front and rear ----
        // removeFirst() detaches the engine
        // removeLast() detaches the guard coach
        ((LinkedList<String>) trainConsist).removeFirst();
        ((LinkedList<String>) trainConsist).removeLast();
        
        // Display after removal
        System.out.println("After Removing First and Last Bogie:");
        System.out.println(trainConsist);
        System.out.println();
        
        System.out.println("UC4 ordered consist operations completed...");
    }
}
