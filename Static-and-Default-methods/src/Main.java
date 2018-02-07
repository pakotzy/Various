import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EquilateralTriangle et = new EquilateralTriangle(5);
        Square sq = new Square(6);

        System.out.print("Total sides: ");
        System.out.println(RegularPolygon.totalSides(et, sq));

        System.out.print("Perimeter: ");
        System.out.println(et.getPerimeter() + ", " + sq.getPerimeter());

        System.out.print("Interior angle: ");
        System.out.println(et.getInteriorAngle() + ", " + sq.getInteriorAngle());
    }
}

interface RegularPolygon {
    int getNumSides();

    int getSideLength();

    static int totalSides(RegularPolygon... rps) {
        return Arrays.stream(rps).mapToInt(RegularPolygon::getNumSides).sum();
    }

    default int getPerimeter() {
        return getSideLength() * getNumSides();
    }

    default double getInteriorAngle() {
        return (getNumSides()-2)*Math.PI/getNumSides();
    }
}

class EquilateralTriangle implements RegularPolygon {
    int mSideLength;

    EquilateralTriangle(int sideLength) {
        mSideLength = sideLength;
    }

    public int getNumSides() {
        return 3;
    }

    public int getSideLength() {
        return mSideLength;
    }
}

class Square implements RegularPolygon {
    int mSideLength;

    public Square(int sideLength) {
        mSideLength = sideLength;
    }

    @Override
    public int getNumSides() {
        return 4;
    }

    @Override
    public int getSideLength() {
        return mSideLength;
    }
}

