public class SomeMath {
    public Integer doAddition(Integer a, Integer b) {
        if (a > 999) {
            throw new IllegalArgumentException();
        }
        return a + b;
    }
}
