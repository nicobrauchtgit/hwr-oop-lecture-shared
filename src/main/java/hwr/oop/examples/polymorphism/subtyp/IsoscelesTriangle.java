package hwr.oop.examples.polymorphism.subtyp;

public class IsoscelesTriangle implements Triangle{
    private final double isoscelesSide;
    private final double singleAngle;
    private final double singleSide;

    public IsoscelesTriangle(double isoscelesSide, double singleAngle) {
        this.isoscelesSide = isoscelesSide;
        this.singleAngle = singleAngle;
        this.singleSide = 2 * isoscelesSide * Math.sin(Math.toRadians(singleAngle) / 2);
    }

    @Override
    public double getPerimeterLength() {
        return 2 * isoscelesSide + singleSide;
    }

    @Override
    public double getAreaSize() {
        return singleSide / 2 * Math.sqrt(Math.pow(isoscelesSide, 2) - Math.pow(singleSide, 2) / 4);
    }

    @Override
    public double[] getDistinctAngles() {
        return new double[singleAngle, ((180.0 - singleAngle) / 2.0)];
    }
}
