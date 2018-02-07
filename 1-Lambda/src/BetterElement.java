public class BetterElement {
    public static void main(String[] args) {
        System.out.println(ElementUtils.betterElement("One", "Two", ((e1, e2) -> e1.length() > e2.length())));
        System.out.println(ElementUtils.betterElement(1, 2, (e1, e2) -> e1 > e2));
    }
}

interface TwoElementPredicate <T> {
    boolean isBetter(T e1, T e2);
}

class ElementUtils {
    private ElementUtils(){}

    static <T> T betterElement(T e1, T e2, TwoElementPredicate<T> fn) {
        return fn.isBetter(e1, e2) ? e1 : e2;
    }
}
