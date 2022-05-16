package hwr.oop.examples.polymorphism.subtyp;

public interface Ellipse extends Shape, Comparable<ImplementedEllipse> {

    @Override
    default int getNumberOfSides() { return (int)Double.POSITIVE_INFINITY; }

    default double getDistinctAngles() {
        return 360.0;
    }

    @Override
    default int compareTo(ImplementedEllipse o) {
        return Double.compare(getAreaSize(), o.getAreaSize());
    }
}
