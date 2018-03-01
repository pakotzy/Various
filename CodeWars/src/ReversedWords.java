public class ReversedWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("I like eating"));
    }

    public static String reverseWords(String str){
        StringBuilder rSb = new StringBuilder();
        int wordStart = 0;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i)) || i+1 == str.length()) {
                if (i+1 == str.length()) {
                    i += 1;
                }
                rSb.insert(0, " " + str.substring(wordStart, i));
                wordStart = i+1;
            }
        }

        rSb.delete(0, 1);

        return rSb.toString();
    }

    /*public static String reverseWords(String str){
        //write your code here...
        List Words = Arrays.asList(str.split(" "));
        Collections.reverse(Words);
        return String.join(" ", Words);
    }*/

    /*public static String reverseWords(String str){
        return Arrays.stream(str.split(" ")).reduce((x, y) -> y+" "+x).get();
    }*/
}
