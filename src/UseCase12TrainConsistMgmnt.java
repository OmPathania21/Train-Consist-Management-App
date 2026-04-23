/**
 * ================================================================
 * MAIN CLASS – UseCase12TrainConsistMgmnt
 * ================================================================
 *
 * Use Case 12: Safety Compliance Check for Goods Bogies
 *
 * Description:
 * This class enforces domain safety rules on goods bogies.
 *
 * At this stage, the application:
 * - Creates goods bogie list
 * - Converts list into stream
 * - Applies safety validation rule
 * - Checks compliance using allMatch()
 * - Displays safety status
 *
 * This maps real-world cargo safety rules using Streams.
 *
 * @author Developer
 * @version 12.0
 */

import java.util.List;
import java.util.ArrayList;

public class UseCase12TrainConsistMgmnt {

    // Goods Bogie model
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("=============================================\n");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        // Display goods bogies
        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie bogie : goodsBogies) {
            System.out.println(bogie);
        }
        System.out.println();

        // ---- SAFETY COMPLIANCE CHECK USING ALLMATCH ----
        // Rule: Cylindrical bogies must only carry Petroleum
        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("Safety Compliance Status: " + isSafe);
        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }
        System.out.println();

        System.out.println("UC12 safety validation completed...");
    }
}
