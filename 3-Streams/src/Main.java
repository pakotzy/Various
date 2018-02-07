import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        double[] dArray = new Random().doubles(100).toArray();

        long startTime = System.nanoTime();
        System.out.print(DoubleStream.of(dArray).sum());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(" - " + duration);

        startTime = System.nanoTime();
        System.out.print(DoubleStream.of(dArray).parallel().sum());
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println(" - " + duration);

        DoubleStream.generate(Math::random).limit(5).forEach(System.out::println);
        List<Double> dList = Stream.generate(Math::random).limit(10).collect(Collectors.toList());
        double[] dArray2 = DoubleStream.generate(Math::random).limit(10).toArray();
    }
}
