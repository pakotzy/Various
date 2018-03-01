import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortTheOdd {
    public static void main(String[] args) {
        sortArray(new int[]{5, 3, 2, 8, 1, 4});
    }

    public static int[] sortArray(int[] array) {
        if (array.length == 0) return array;

        List<Integer> oddList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] != 0) {
                int buffer = array[i];
                array[i] = Integer.MIN_VALUE;
                oddList.add(buffer);
            }
        }

        oddList.sort(Comparator.comparingInt(e -> e));

        int srtd = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == Integer.MIN_VALUE) {
                array[i] = oddList.get(srtd);
                srtd++;
            }
        }

        return array;
    }
}
