import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> tStringList = Arrays.asList("One","Two","Three","Four", "Five", "Six");
        List<Integer> tIntegerList = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println("Predicate!");
        System.out.println(Utils.allMatches(tStringList, e -> e.contains("o")));
        System.out.println(Utils.allMatches(tStringList, e -> e.length() > 3));
        System.out.println(Utils.allMatches(tIntegerList, e -> e > 2));

        System.out.println("\nFunction!");
        System.out.println(Utils.transformedList(tStringList, e -> e.toLowerCase()));
        System.out.println(Utils.transformedList(tStringList, e -> e.concat(" Hundred")));
        System.out.println(Utils.transformedList(tIntegerList, e -> e + 100));
        System.out.println(Utils.transformedList(tStringList, e -> e.length()));
    }
}

class Utils {
    static <T> List<T> allMatches(List<T> list, Predicate<T> fn) {
        List<T> matches = new ArrayList<>();

        for (T element : list) {
            if (fn.test(element)) {
                matches.add(element);
            }
        }

        return matches;
    }

    static <T, R> List<R> transformedList(List<T> list, Function<T, R> fn) {
        List<R> transformed = new ArrayList<>();

        for (T element : list) {
            transformed.add(fn.apply(element));
        }

        return transformed;
    }
}
