public class Print {
    public static void main(String[] args) {
        test(s -> s + " Yeah");
    }

    private static void test(PrintInterface lambdaTest) {
        System.out.println(lambdaTest.foo("Lambda?") + "!");
    }
}

interface PrintInterface {
    String foo(String s);
}
