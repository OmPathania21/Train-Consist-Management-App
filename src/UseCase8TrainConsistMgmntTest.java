import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class UseCase8TrainConsistMgmntTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("High", 80));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("Low", 40));

        // Threshold 70
        List<UseCase8TrainConsistMgmnt.Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(1, filtered.size());
        assertEquals("High", filtered.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("Exact", 70));

        // Threshold 70
        List<UseCase8TrainConsistMgmnt.Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("Low", 60));

        // Threshold 70
        List<UseCase8TrainConsistMgmnt.Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("B1", 80));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("B2", 90));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("B3", 50));

        // Threshold 60
        List<UseCase8TrainConsistMgmnt.Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(2, filtered.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("B1", 50));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("B2", 40));

        // Threshold 60
        List<UseCase8TrainConsistMgmnt.Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("B1", 70));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("B2", 80));

        // Threshold 60
        List<UseCase8TrainConsistMgmnt.Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(2, filtered.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();

        // Threshold 60
        List<UseCase8TrainConsistMgmnt.Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("B1", 70));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("B2", 50));

        int originalSize = bogies.size();

        // Threshold 60
        bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(originalSize, bogies.size());
        assertEquals("B1", bogies.get(0).name);
        assertEquals(70, bogies.get(0).capacity);
        assertEquals("B2", bogies.get(1).name);
        assertEquals(50, bogies.get(1).capacity);
    }
}
