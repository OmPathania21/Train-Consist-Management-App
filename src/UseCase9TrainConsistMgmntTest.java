import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class UseCase9TrainConsistMgmntTest {

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("AC Chair", 56));

        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertEquals(2, grouped.size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 70));

        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(1, grouped.size());
        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("AC Chair", 56));

        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, grouped.size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();

        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));

        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(1, grouped.size());
        assertTrue(grouped.containsKey("Sleeper"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("AC Chair", 56));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("First Class", 24));

        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 70));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("AC Chair", 56));

        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(1, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        int originalSize = bogies.size();

        bogies.stream().collect(Collectors.groupingBy(b -> b.name));

        assertEquals(originalSize, bogies.size());
    }
}
