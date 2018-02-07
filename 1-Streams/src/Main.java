import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "qq", "hellqou");

        words.stream().forEach(System.out::println);
        words.stream().map(String::toUpperCase).forEach(System.out::println);
        words.stream().filter(e -> e.contains("l")).forEach(System.out::println);
        System.out.println(words.stream().map(String::toUpperCase).filter(e -> e.length()<4)
                .filter(e -> e.contains("E") || e.contains("Q"))
                .findFirst()
                .orElse(""));

        Function<String, String> toUpperCase = e -> {
            System.out.println("Mapping - " + e);
            return e.toUpperCase();
        };
        Predicate<String> filterByLenght = e -> {
            System.out.println("Filtering by length - " + e);
            return e.length()<4;
        };
        BiPredicate<String, String> filterBySymbol = (e, u) -> {
            System.out.println("Filtering word - " + e + " by symbol - " + u);
            return e.contains(u);
        };
        System.out.println(words.stream().map(toUpperCase).filter(filterByLenght)
                .filter(e -> filterBySymbol.test(e,"H") || filterBySymbol.test(e, "Q"))
                .findFirst()
                .orElse(""));
        String[] upperCasedArrayFromStream = words.stream().map(String::toUpperCase).toArray(String[]::new);
    }
}

class StringUtils {
    static String map(String e) {
        System.out.println("Mapping - " + e);
        return e.toUpperCase();
    }

    static boolean filter(String e, Predicate<String> fn) {
        System.out.println("Filtering - " + e);
        return fn.test(e);
    }
}
