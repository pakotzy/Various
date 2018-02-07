import java.util.Arrays;

public class Time {
    public static void main(String[] args) {
        for (int i = 3; i<8; i++) {
            int size = (int) Math.pow(10, i);
            System.out.printf("Sorting array of length %,d.%n", size);
            TimingUtils.timeOp(() -> sortArray(size));
        }
    }

    static void sortArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        Arrays.sort(array, (o1, o2) -> o1.hashCode()-o2.hashCode());
    }
}

interface Op {
    void runOp();
}

class TimingUtils {
    private static final double ONE_BILLION = 1_000_000_000;

    public static void timeOp(Op operation) {
        long startTime = System.nanoTime();
        operation.runOp();
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime)/ONE_BILLION;
        System.out.printf("\t Elapsed time: %.3f seconds.%n", elapsedTime);
    }
}
