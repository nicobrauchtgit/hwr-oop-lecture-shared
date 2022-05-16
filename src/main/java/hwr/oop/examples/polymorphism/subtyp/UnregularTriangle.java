package hwr.oop.examples.polymorphism.subtyp;

public class UnregularTriangle implements Triangle{
    private final double sideA;
    private final double sideB;
    private final double angleC;
    private final double sideC;
    private final double angleA;

    public UnregularTriangle(double sideA, double sideB, double enclosedAngle) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.angleC = enclosedAngle;
        sideC = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2) - 2 * sideA + sideB * Math.cos(Math.toRadians(enclosedAngle)));
        angleA = (sideA * Math.sin(Math.toRadians(enclosedAngle))) / sideC;
            }
    @Override
    public double getPerimeterLength() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getAreaSize() {
        double s = this.getPerimeterLength() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double[] getDistinctAngles() {
        return new double[]{angleC, angleA, 180 - angleA - angleC};
    }
}
