import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToCamelCase {
    public static void main(String[] args) {
        System.out.println(toCamelCase("Wall_Blue_north_down_river_Street_Ninja_Yellow_Black_Samurai_up"));
    }

    static String toCamelCase(String s) {
        Matcher m = Pattern.compile("[_-](\\w)").matcher(s);
        StringBuffer sb = new StringBuffer();

        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        m.appendTail(sb);

        return sb.toString();
    }

    static String toCamelCaseNoob(String s){
        StringBuilder sb = new StringBuilder();

        for (String word : s.contains("-") ? s.split("-") : s.split("_")) {
            sb.append(sb.length() > 0 ? word.replaceFirst("\\w", String.valueOf(word.charAt(0)).toUpperCase()) : word);
        }

        return sb.toString();
    }

    static String toCamelCaseStream(String s) {
        String[] words = s.split("[-_]");

        return Arrays.stream(words, 1, words.length)
                .map(e -> e.substring(0,1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }
}
