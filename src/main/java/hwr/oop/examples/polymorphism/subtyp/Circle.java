package hwr.oop.examples.polymorphism.subtyp;

public class Circle extends ImplementedEllipse{
    private final double radius;

    public Circle(double radius) {
        super(radius, radius);
        this.radius = radius;
    }

    @Override
    public double getPerimeterLength(){
        return 2 * Math.PI * radius;
    }
}
