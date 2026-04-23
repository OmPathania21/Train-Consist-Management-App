import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class UseCase10TrainConsistMgmntTest {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("AC Chair", 56));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("First Class", 24));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 70));

        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(222, totalSeats);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("B1", 100));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("B2", 200));

        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(300, totalSeats);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("B1", 50));

        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(50, totalSeats);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();

        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(0, totalSeats);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("B1", 10));

        // Verifying that map extracts the correct value
        int extracted = bogies.stream()
                .map(b -> b.capacity)
                .findFirst()
                .orElse(0);

        assertEquals(10, extracted);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        for(int i=0; i<5; i++) {
            bogies.add(new UseCase10TrainConsistMgmnt.Bogie("B"+i, 10));
        }

        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(50, totalSeats);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("B1", 72));
        int originalSize = bogies.size();

        bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(originalSize, bogies.size());
    }
}
