public class SortingUtils {

    // Finds $symbol inside the $word
    public static int charAt(String word, char symbol) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == symbol) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}
