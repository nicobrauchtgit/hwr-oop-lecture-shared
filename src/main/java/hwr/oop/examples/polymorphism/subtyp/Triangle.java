package hwr.oop.examples.polymorphism.subtyp;

public interface Triangle extends Shape, Comparable<Triangle>{

    @Override
    default int getNumberOfSides() { return 3; }

    double[] getDistinctAngles();

    @Override
    default int compareTo(Triangle o) {
        return Double.compare(getAreaSize(), o.getAreaSize());
    }
}

