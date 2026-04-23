/**
 * ================================================================
 * MAIN CLASS – UseCase10TrainConsistMgmnt
 * ================================================================
 *
 * Use Case 10: Count Total Seats in Train
 *
 * Description:
 * This class aggregates seating capacity of all bogies
 * into a single total using Stream reduce().
 *
 * At this stage, the application:
 * - Creates bogie list
 * - Maps bogies to capacity
 * - Reduces values into total
 * - Displays total seat count
 *
 * This maps aggregation logic using reduce().
 *
 * @author Developer
 * @version 10.0
 */

import java.util.List;
import java.util.ArrayList;

public class UseCase10TrainConsistMgmnt {

    // Reusing Bogie model
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("=============================================");
        System.out.println();

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Display bogies
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        System.out.println();

        // ---- AGGREGATE USING REDUCE ----
        // map() extracts capacity field from Bogie object
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity of Train: " + totalSeats);
        System.out.println();

        System.out.println("UC10 aggregation completed...");
    }
}
