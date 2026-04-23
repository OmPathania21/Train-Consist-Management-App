/**
 * ================================================================
 * MAIN CLASS – UseCase13TrainConsistMgmnt
 * ================================================================
 *
 * Use Case 13: Performance Comparison (Loops vs Streams)
 *
 * Description:
 * This class compares the execution time of loop-based
 * logic versus stream-based logic using System.nanoTime().
 *
 * At this stage, the application:
 * - Prepares bogie collection
 * - Measures loop-based filtering
 * - Measures stream-based filtering
 * - Displays execution times
 * - Compares results
 *
 * This maps performance benchmarking logic.
 *
 * @author Developer
 * @version 13.0
 */

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class UseCase13TrainConsistMgmnt {

    // Bogie model
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("=============================================\n");

        // Create large dataset for better benchmarking
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 24));
        }

        System.out.println("Processing " + bogies.size() + " bogies...\n");

        // ---- LOOP-BASED FILTERING ----
        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // ---- STREAM-BASED FILTERING ----
        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // Display results
        System.out.println("Loop-Based Filtering Result Count: " + loopFiltered.size());
        System.out.println("Loop Execution Time: " + loopTime + " ns");
        System.out.println();

        System.out.println("Stream-Based Filtering Result Count: " + streamFiltered.size());
        System.out.println("Stream Execution Time: " + streamTime + " ns");
        System.out.println();

        System.out.println("UC13 benchmarking completed...");
    }
}
