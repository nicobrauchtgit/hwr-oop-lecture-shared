package hwr.oop.examples.polymorphism.subtyp;

public class ImplementedEllipse implements Ellipse {

    private final double radiusA;
    private final double radiusB;

    public ImplementedEllipse(double radiusA, double radiusB) {
        this.radiusA = radiusA;
        this.radiusB = radiusB;
    }
    @Override
    public double getPerimeterLength() {
        return 2 * Math.PI * Math.sqrt(Math.pow(radiusA, 2) + Math.pow(radiusB, 2) / 2.0);
    }

    @Override
    public double getAreaSize() {
        return Math.PI * radiusA * radiusB;
    }
}
