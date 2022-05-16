package hwr.oop.examples.polymorphism.subtyp;

public class EquilateralTriangle implements Triangle{

    private final double side;

    EquilateralTriangle(double side) {
        this.side = side;
    }
    @Override
    public double getPerimeterLength() {
        return 3 * side;
    }

    @Override
    public double getAreaSize() {
        return Math.pow(side, 2) * Math.sqrt(3) / 4;
    }

    @Override
    public double[] getDistinctAngles() {
        return new double[]{60};
    }
}
