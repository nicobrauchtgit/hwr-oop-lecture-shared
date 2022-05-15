package hwr.oop.examples.polymorphism.subtyp;

public interface Circle extends Shape, Comparable<Circle> {

    @Override
    default int getNumberOfSides() { return 0; }

    default double getDistinctAngles() {
        return 360.0;
    }

    @Override
    default int compareTo(Circle o) {
        return Double.compare(getAreaSize(), o.getAreaSize());
    }
}
