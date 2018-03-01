import java.math.BigInteger;

public class FibonacciPerimeter {

    public static void main(String[] args) {
        System.out.println(perimeter(BigInteger.valueOf(5)));
    }

    public static BigInteger perimeter(BigInteger n) {
        BigInteger f = BigInteger.valueOf(1);
        BigInteger s = BigInteger.valueOf(1);
        BigInteger result = BigInteger.valueOf(2);

        n = n.subtract(result);

        while (n.compareTo(BigInteger.valueOf(0)) != -1) {
            s = s.add(f);
            f = s.subtract(f);
            result = result.add(s);
            n = n.subtract(BigInteger.valueOf(1));
        }

        return result.multiply(BigInteger.valueOf(4));
    }
}
