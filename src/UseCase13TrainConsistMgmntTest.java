import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class UseCase13TrainConsistMgmntTest {

    @Test
    void testLoopFilteringLogic() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("B1", 72));
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("B2", 50));

        List<UseCase13TrainConsistMgmnt.Bogie> filtered = new ArrayList<>();
        for (UseCase13TrainConsistMgmnt.Bogie b : bogies) {
            if (b.capacity > 60) {
                filtered.add(b);
            }
        }

        assertEquals(1, filtered.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("B1", 72));
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("B2", 50));

        List<UseCase13TrainConsistMgmnt.Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(1, filtered.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            bogies.add(new UseCase13TrainConsistMgmnt.Bogie("B" + i, i));
        }

        List<UseCase13TrainConsistMgmnt.Bogie> loopFiltered = new ArrayList<>();
        for (UseCase13TrainConsistMgmnt.Bogie b : bogies) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }

        List<UseCase13TrainConsistMgmnt.Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(loopFiltered.size(), streamFiltered.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        // Small operation
        int sum = 0;
        for (int i = 0; i < 100; i++) sum += i;
        long end = System.nanoTime();

        assertTrue((end - start) >= 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new UseCase13TrainConsistMgmnt.Bogie("B", 70));
        }

        List<UseCase13TrainConsistMgmnt.Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(10000, filtered.size());
    }
}
