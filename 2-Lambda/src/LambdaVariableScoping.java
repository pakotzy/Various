import java.util.ArrayList;
import java.util.function.Function;

public class LambdaVariableScoping {
    private static String line = "I ";

    public static void main(String[] args) {
        /*Lambda can modify only instance variables
        * Lambda can use only final or effectively final variables*/
        System.out.println(modify(s -> line + "don't "));
        line += "like.";
        System.out.println(line);

        /*But you can modify inner parts of complex classes like lists or UI elements, etc.
        * Because externally their reference doesn't change*/
        ArrayList<String> arlist = new ArrayList<>();
        System.out.println(modifyList(arlist, s -> s.add("Whoa!")));
    }

    static String modify(Function<String, String> fn) {
        return fn.apply("");
    }

    static boolean modifyList(ArrayList<String> arlist, Function<ArrayList<String>, Boolean> fn) {
        return fn.apply(arlist);
    }
}
