/**
 * ================================================================
 * MAIN CLASS – UseCase7TrainConsistMgmt
 * ================================================================
 *
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 *
 * Description:
 * This class sorts passenger bogies based on their seating
 * capacity using a custom Comparator for business logic ordering.
 *
 * At this stage, the application:
 * - Creates bogie objects with properties
 * - Stores them in a list
 * - Applies custom sorting logic
 * - Displays sorted results for planning
 *
 * This maps custom ordering using Comparator.
 *
 * @author Developer
 * @version 7.0
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UseCase7TrainConsistMgmt {
    
    // ---- Inner Bogie class to model passenger bogies ----
    static class Bogie {
        String name;
        int capacity;
        
        // Constructor
        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
        
        // toString for display
        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }
    
    public static void main(String[] args) {
        
        // Display section header
        System.out.println("=============================================");
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("=============================================");
        System.out.println();
        
        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();
        
        // ---- ADD bogie objects ----
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        
        // Display before sorting
        System.out.println("Before Sorting:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }
        System.out.println();
        
        // ---- SORT using Comparator ----
        // Comparator.comparingInt() defines sorting based on capacity
        Collections.sort(bogies, Comparator.comparingInt(b -> b.capacity));
        
        // Display after sorting
        System.out.println("After Sorting by Capacity:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }
        System.out.println();
        
        System.out.println("UC7 sorting completed...");
    }
}
