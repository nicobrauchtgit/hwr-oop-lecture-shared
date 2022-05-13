package hwr.oop.examples.polymorphism.subtyp;

public class Parallelogram implements Quadrangle{
    private final double sideA;

    private final double sideB;

    private final double smallAngle;

    public Parallelogram(double sideA,double sideB, double smallAngle) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.smallAngle = smallAngle;
    }

    @Override
    public double getPerimeterLength() {
        return 2 * (sideA + sideB);
    }

    @Override
    public double getAreaSize() {
        return sideA * sideB * Math.sin(Math.toRadians(smallAngle));
    }

    @Override
    public double[] getDistinctAngles() {
        return new double[]{smallAngle, 180 - smallAngle};
    }
}
