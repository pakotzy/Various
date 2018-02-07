import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        System.out.println(words.stream().reduce("", String::concat).toUpperCase());

        System.out.println(words.stream().map(String::toUpperCase).reduce(String::concat).get());

        System.out.println(words.stream().reduce((e1, e2) -> e1 + ", " + e2).get());

        System.out.println(words.stream().mapToInt(String::length).sum());

        System.out.println(words.stream().filter(e -> e.contains("h")).count());
    }
}
