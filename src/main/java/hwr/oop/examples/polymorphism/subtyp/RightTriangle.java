package hwr.oop.examples.polymorphism.subtyp;

public class RightTriangle implements Triangle{

    private final double sideA;
    private final double sideB;
    private final double hypotenuse;

    RightTriangle(double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
        hypotenuse = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    }
    @Override
    public double getPerimeterLength() {
        return sideA + sideB + hypotenuse;
    }

    @Override
    public double getAreaSize() {
        return sideA * sideB / 2.0;
    }

    @Override
    public double[] getDistinctAngles() {
        return new double[] {Math.asin(sideA / hypotenuse), Math.asin(sideB / hypotenuse), 90};
    }
}













