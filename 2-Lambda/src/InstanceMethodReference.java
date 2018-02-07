import java.util.function.BiFunction;
import java.util.function.Function;

public class InstanceMethodReference {
    public static void main(String[] args) {
        InstanceLambdaUtils ilu = new InstanceLambdaUtils();
        print(ilu, InstanceLambdaUtils::requestLambda);
        printBi(ilu, "Ye?", InstanceLambdaUtils::requestLambda);
    }

    static void print(InstanceLambdaUtils ilu, Function<InstanceLambdaUtils, String> fn) {
        System.out.println(fn.apply(ilu));
    }

    static void printBi(InstanceLambdaUtils ilu, String line, BiFunction<InstanceLambdaUtils, String, String> fn) {
        System.out.println(fn.apply(ilu, line));
    }
}

class InstanceLambdaUtils {
    String requestLambda() {
        return "WUT? HOW?";
    }

    String requestLambda(String s) {
        return s;
    }
}
