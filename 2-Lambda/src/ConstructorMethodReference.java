import java.util.function.Function;

public class ConstructorMethodReference {
    public static void main(String[] args) {
        Function<String, Integer> f = Integer::new;
        System.out.println(f.apply("1"));
    }
}
