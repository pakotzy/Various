import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PerformanceCalculation {
    public static void main(String[] args) {
        Instant start = Instant.now();
        List<Integer> intList = Stream.iterate(0, i -> i + 1).limit(50000).collect(Collectors.toList());
        intList.sort((e1, e2) -> e2 - e1);
        Instant end = Instant.now();
        Duration dur = Duration.between(start, end);
        System.out.println(dur.toMillis());

        start = Instant.now();
        List<Integer> intListOld = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            intListOld.add(i);
        }
        intListOld.sort((e1, e2) -> e2 - e1);
        end = Instant.now();
        dur = Duration.between(start, end);
        System.out.println(dur.toMillis());
    }
}
