import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class UseCase12TrainConsistMgmntTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Open", "Coal"));

        boolean isSafe = bogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        assertTrue(isSafe);
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Coal"));

        boolean isSafe = bogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        assertFalse(isSafe);
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Open", "Grain"));
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Box", "Coal"));

        boolean isSafe = bogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        assertTrue(isSafe);
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new UseCase12TrainConsistMgmnt.GoodsBogie("Cylindrical", "Grain"));

        boolean isSafe = bogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        assertFalse(isSafe);
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<UseCase12TrainConsistMgmnt.GoodsBogie> bogies = new ArrayList<>();

        boolean isSafe = bogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        assertTrue(isSafe); // allMatch on empty stream is true
    }
}
