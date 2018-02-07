public class Sum {
    public static void main(String[] args) {
        TriFunction<SumHelper, Integer, Integer, Integer> anon = SumHelper::doSum;
        System.out.println(anon.apply(new SumHelper(), 1, 2));

        TriFunction<SumHelper, String, String, Integer> anonStr = SumHelper::doSum;
        System.out.println(anonStr.apply(new SumHelper(), "1", "2"));
    }
}

@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

class SumHelper {
    Integer doSum(Integer a1, Integer a2) {
        return a1 + a2;
    }

    Integer doSum(String a1, String a2) {
        return Integer.parseInt(a1) + Integer.parseInt(a2);
    }
}
