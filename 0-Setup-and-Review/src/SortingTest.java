import java.util.Arrays;

public class SortingTest {
    public static void main(String[] args) {
        String[] example = new String[]{"One", "Two", "Three", "Four", "Five", "Six"};

        // Shortest to longest
        Arrays.sort(example, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.asList(example));

        // Longest to shortest
        Arrays.sort(example, (o1, o2) -> o2.length() - o1.length());
        System.out.println(Arrays.asList(example));

        // Alphabetically by the first character only
        Arrays.sort(example, ((o1, o2) -> o1.charAt(0) - o2.charAt(0)));
        System.out.println(Arrays.asList(example));

        // Strings that contain "e" first
        Arrays.sort(example, ((o1, o2) -> SortingUtils.charAt(o1, 'e') - SortingUtils.charAt(o2, 'e')));
        System.out.println(Arrays.asList(example));
    }
}
