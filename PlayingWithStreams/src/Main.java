import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*
         * To convert something to a Stream use Stream.of(), to add one or more sources at a time
         * To convert any Collection use new method.stream()
         */
        Stream<String> stringsStream = Stream.of("One", "Two");

        Integer[] intArray = {1, 2, 3};
        Stream<Integer> arrayStream = Arrays.stream(intArray);

        ArrayList<String> arList = new ArrayList<>();
        arList.addAll(Arrays.asList("One", "Two"));
        Stream<String> listStream = arList.stream();

        /*
         * Popular command to work with Stream is .map() and .flatMap()
         * .map() performs an operation on each element of the stream, Stream<List<Integer>> -> Stream<List<Integer>>
         * .flatMap() removes one level from the hierarchy and returns new stream, Stream<List<Integer>> -> Stream<Integer>>
         * .forEach() method used for last resort operations. Like .ifPresent from Optionals. It won't return stream but actual elements
         */
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(4,5,6);
        System.out.println(".map .flatMap .forEach");
        Stream.of(numbers1, numbers2)
            .flatMap(List::stream)
                .map(x -> x * 2)
                .forEach(System.out::println);

        /*
         * .filter() - takes a 'test' function that takes a value and returns boolean.
         * So it tests every elements of the Stream and creates new Stream with the elements who passed the function
         * .negate() - reverses any expression stored in a Predicate
         * .nonNull() - tests if passed object is not null
         */
        System.out.println("\n.filter .negate .nonNull");
        Predicate<Integer> small = x -> x < 50;
        Stream.of(1,2,3,4,null,6,7,8,9,10)
            .filter(Objects::nonNull)
                .map(x -> x * 10)
                .filter(small.negate())
                .forEach(System.out::println);

        /*
         * To go back to some data structure use .collect()
         * On the way you can do such things like joining strings or filtering data
         */
        System.out.println("\n.collect");
        List<Integer> filtered = Stream.of(0, 1, 2, 3)
                .filter(num -> num < 2)
                .collect(Collectors.toList());
        System.out.println(filtered);
        String sentence = Stream.of("Who", "are", "you?")
                .collect(Collectors.joining(" "));
        System.out.println(sentence);

        /*
         * .reduce() reduces the stream to one object. Take some function where all type is the same BiFuntion<T, T, T>
         * Can use default value as first parameter, this same value will be added at the end
         */
        System.out.println("\n.reduce");
        System.out.println(Stream.of(1,2,3)
                .reduce(1, Integer::sum));

        /*
         * .sorted() used to sort the stream. It takes one BiFunction<T, T, Integer>, just like Comparator<T> which is the same
         */
        System.out.println("\n.sorted()");
        Stream.of(1,6,19,12,5,3)
                .sorted((s1, s2) -> s1 - s2)
                .forEach(System.out::println);
    }
}
