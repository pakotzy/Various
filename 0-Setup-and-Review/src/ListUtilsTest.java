import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtilsTest {
    public static void main(String[] args) {
        String[] example = new String[]{"One", "Two", "Three", "Four", "Five"};
        System.out.println(ListUtils.lastEntry(example));

        List<String> listExample = new ArrayList<>(Arrays.asList(example));
        System.out.println(ListUtils.lastEntry(listExample));
    }
}
