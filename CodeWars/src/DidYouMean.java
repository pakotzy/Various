public class DidYouMean {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary(new String[]{"python", "java", "ruby", "php", "javascript", "coffeescript"});
        System.out.println("java " + dictionary.findMostSimilar("heaven"));
    }
}

class Dictionary {

    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String to) {
        int distance = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < words.length; i++) {
            char[] bigger = to.length() - words[i].toCharArray().length > 0 ? to.toCharArray() : words[i].toCharArray();
            char[] smaller = to.length() - words[i].toCharArray().length <= 0 ? to.toCharArray() : words[i].toCharArray();

            int tmpDist = bigger.length;

            for (int j = 0; j <= bigger.length - smaller.length; j++) {
                for (int k = 0; k < smaller.length; k++) {
                    tmpDist -= bigger[k+j] == smaller[k] ? 1 : 0;
                }

                if (tmpDist == 0) return words[i];
            }

            if (distance > tmpDist) {
                distance = tmpDist;
                index = i;
            }
        }

        return words[index];
    }
}
