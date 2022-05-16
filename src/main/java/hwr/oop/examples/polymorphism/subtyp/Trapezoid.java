package hwr.oop.examples.polymorphism.subtyp;

public class Trapezoid implements Quadrangle {

    private final RightTriangle leftTriangle;
    private final double top;
    private final double height;
    private final RightTriangle rightTriangle;

    public Trapezoid(double basisLengthLeft, double height, double top, double basisLengthRight) {
        this.leftTriangle = new RightTriangle(basisLengthLeft, height);
        this.height = height;
        this.top = top;
        this.rightTriangle = new RightTriangle(basisLengthRight, height);
    }
    @Override
    public double[] getDistinctAngles() {
        return new double[]{leftTriangle.getDistinctAngles()[0], leftTriangle.getDistinctAngles()[1] + 90,
                            rightTriangle.getDistinctAngles()[0], rightTriangle.getDistinctAngles()[1] + 90};
    }

    @Override
    public double getPerimeterLength() {
        return leftTriangle.getPerimeterLength() - height + rightTriangle.getPerimeterLength() - height + 2 * top ;
    }

    @Override
    public double getAreaSize() {
        return leftTriangle.getAreaSize() + rightTriangle.getAreaSize() + 2 * height * top;
    }
}
