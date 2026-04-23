/**
 * ================================================================
 * MAIN CLASS – UseCase6TrainConsistMgmt
 * ================================================================
 *
 * Use Case 6: Map Bogie to Capacity (HashMap)
 *
 * Description:
 * This class associates each bogie with its seating or load
 * capacity using a key-value mapping structure.
 *
 * At this stage, the application:
 * - Creates a bogie-capacity mapping
 * - Stores bogies as keys and capacities as values
 * - Iterates through the map entries
 * - Displays bogie and capacity information
 *
 * This maps lookup-based access using HashMap.
 *
 * @author Developer
 * @version 6.0
 */

import java.util.Map;
import java.util.HashMap;

public class UseCase6TrainConsistMgmt {
    
    public static void main(String[] args) {
        
        // Display section header
        System.out.println("=============================================");
        System.out.println(" UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("=============================================");
        System.out.println();
        
        // HashMap stores data in key-value format
        Map<String, Integer> capacityMap = new HashMap<>();
        
        // ---- INSERT bogie capacities ----
        // put() inserts a bogie name (key) and its capacity (value)
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);
        
        // Display bogie capacity details
        System.out.println("Bogie Capacity Details:");
        
        // ---- ITERATE through the map ----
        // entrySet() provides a view of all key-value pairs
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            String bogie = entry.getKey();
            Integer capacity = entry.getValue();
            System.out.println(bogie + " -> " + capacity);
        }
        System.out.println();
        
        System.out.println("UC6 bogie-capacity mapping completed...");
    }
}
