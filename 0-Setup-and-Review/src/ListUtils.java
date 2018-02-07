import java.util.List;

public class ListUtils {
    private ListUtils(){}

    public static <T> T lastEntry(T[] input) {
        return input[input.length-1];
    }

    public static <T> T lastEntry(List<T> input) {
        return input.get(input.size()-1);
    }
}