import javax.rmi.CORBA.Util;
import java.util.Arrays;

public class BasicLambdas {
    public static void main(String[] args) {
        String[] array = {"One", "Two", "Three", "Four", "Five", "Six"};

        // Shortest to longest
        Arrays.sort(array, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.asList(array));

        // Longest to shortest
        Arrays.sort(array, (o1, o2) -> o2.length() - o1.length());
        System.out.println(Arrays.asList(array));

        // Alphabetically by the first character only
        Arrays.sort(array, ((o1, o2) -> o1.charAt(0) - o2.charAt(0)));
        System.out.println(Arrays.asList(array));

        // Same as before but with static helper method
        Arrays.sort(array, (o1, o2) -> Utils.sort(o1.charAt(0), o2.charAt(0)));
        System.out.println(Arrays.asList(array));
    }
}

class Utils {
    private Utils(){}

    static int sort(int o1, int o2) {
        return o1 - o2;
    }
}
