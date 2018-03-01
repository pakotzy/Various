public class BattleShipFieldValidator {
    private static int[][] battleField = {          {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                                                    {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                                                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                                    {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                                    {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                                                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    private static int[][] battleFieldFalse = {     {1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                                                    {1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                                                    {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                                                    {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                                                    {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                                    {0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
                                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    public static void main(String[] args) {
        System.out.println(BattleField.fieldValidator(battleField));
        BattleField.reset();
        System.out.println(BattleField.fieldValidator(battleFieldFalse));
    }
}

class BattleField {
    private static final int TAKEN = 2;
    private static final int FAILED = 10;

    private static int[][] field = new int[10][10];
    private static int bs, cru, destr, sub;

    public static void reset() {
        bs = cru = destr = sub = 0;
    }

    public static boolean fieldValidator(int[][] input) {
        reset();
        field = input;

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (field[y][x] == 1) {
                    if (!validateShip(checkAround(y, x))) return false;
                }
            }
        }

        return bs + cru + destr + sub == 10;
    }

    static int[] checkAround(int y, int x) {
        int hLength = 0;
        int vLength = 0;

        if (x != 9) {
            switch (field[y][x+1]) {
                case 1: hLength++;
                    hLength += checkAround(y, x+1)[1];
                    field[y][x+1] = TAKEN;
                    break;
                case TAKEN: return new int[]{y, FAILED};
            }
        }

        if (y != 9) {
            switch (field[y+1][x]) {
                case 1: vLength++;
                    vLength += checkAround(y+1, x)[0];
                    field[y+1][x] = TAKEN;
                    break;
                case TAKEN: return new int[]{FAILED, x};
            }
        }

        if (y != 9 && x != 9) {
            switch (field[y+1][x+1]) {
                case 1:
                case TAKEN:
                    return new int[]{FAILED, FAILED};
            }
        }

        if (y != 0 && x != 9) {
            switch (field[y-1][x+1]) {
                case 1:
                case TAKEN:
                    return new int[]{FAILED, FAILED};
            }
        }

        return new int[]{vLength, hLength};
    }

    static boolean validateShip(int[] dim) {
        if (dim[0] > 3 || dim[1] > 3) return false;
        if (dim[0] > 0 && dim[1] > 0) return false;

        switch (dim[0] + dim[1]) {
            case 0: return ++sub <= 4;
            case 1: return ++destr <= 3;
            case 2: return ++cru <= 2;
            case 3: return ++bs <= 1;
        }

        return true;
    }
}