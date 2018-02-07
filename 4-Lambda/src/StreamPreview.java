import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamPreview {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "bye", "hello", "goodbye");
        String s1 = words.stream()
                .filter(word -> word.charAt(0) == 'h')
                .findFirst()
                .orElse(null);
        System.out.println(s1);
        String s2 = words.stream()
                .filter(word -> word.length() > 2)
                .findFirst()
                .orElse(null);
        System.out.println(s2);
        String s3 = words.stream()
                .filter(FunctionUtils.allPassPredicate(word -> word.charAt(0) == 'h', word -> word.length() > 2))
                .findFirst()
                .orElse(null);
        System.out.println(s3);
        System.out.println(FunctionUtils.firstAllMatch(words.stream(), word -> word.charAt(0) == 'h', word -> word.length() > 2));
        System.out.println(FunctionUtils.firstAnyMatch(words.stream(), word -> word.charAt(0) == 'h', word -> word.length() > 2));
    }
}

class FunctionUtils {
    static <T> Predicate<T> allPassPredicate(Predicate<T>... condts) {
        Predicate<T> r = e -> true;

        for (Predicate<T> cond : condts) {
            r = r.and(cond);
        }

        return r;
    }

    static <T> T firstAllMatch(Stream<T> stream, Predicate<T>... condts) {
        return stream.filter(allPassPredicate(condts))
                .findFirst()
                .orElse(null);
    }

    static <T> Predicate<T> anyPassPredicate(Predicate<T>... condts) {
        Predicate<T> r = e -> true;

        for (Predicate<T> cond : condts) {
            r = r.or(cond);
        }

        return r;
    }

    static <T> T firstAnyMatch(Stream<T> stream, Predicate<T>... condts) {
        return stream.filter(anyPassPredicate(condts))
                .findFirst()
                .orElse(null);
    }
}
