public class TortoiseRacing {
    public static void main(String[] args) {
        for (int i : race(820, 850, 550)) {
            System.out.print(i + " ");
        }
    }

    public static int[] race(int v1, int v2, int g) {
        if (v1 >= v2) {
            return null;
        } else {
            Float hours = new Float(g) / (v2 - v1);
            Float minutes = (hours - hours.intValue()) * 60;
            Float seconds = (minutes - minutes.intValue()) * 60;

            return new int[]{hours.intValue(), minutes.intValue(), seconds.intValue()};
        }
    }
}
