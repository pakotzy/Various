import java.util.function.Function;

public class StaticMethodReference {
    public static void main(String[] args) {
        System.out.println(printLambda(StaticLambdaUtils::watLambda));
    }

    private static String printLambda(Function<String, String> fn) {
        return fn.apply("Like this?");
    }
}

class StaticLambdaUtils {
    public static String watLambda(String s) {
        return s;
    }
}
