import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class RevRot {

    public static void main(String[] args) {
        System.out.println(revRot("21113111131", 5) + " - 3111211131");
    }

    public static String revRot(String str, int sz) {
        StringBuilder result = new StringBuilder("");

        if (sz <= 0 || str.isEmpty() || sz > str.length()) {
            return result.toString();
        }

        ArrayList<String> arList = new ArrayList<>();
        for (int i = 0; i < str.length()/sz; i++) {
            int start = i * sz;
            int end = start + sz;
            arList.add(str.substring(start, end));
        }

        StringBuilder tStr;
        for (int i = 0; i < arList.size(); i++) {
            tStr = new StringBuilder(arList.get(i));
            int sum = 0;
            for (int j = 0; j < tStr.length(); j++) {
                sum += Integer.parseInt(tStr.substring(j, j+1));
            }
            System.out.println(sum);
            if (sum % 2 == 0) {
                tStr.reverse();
                System.out.println(tStr.toString());
            } else {
                tStr = new StringBuilder(tStr.substring(1) + tStr.charAt(0));
            }
            result.append(tStr);
        }

        return result.toString();
    }
}