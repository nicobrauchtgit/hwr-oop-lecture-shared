package hwr.oop.examples.polymorphism.subtyp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShapesTest {

    @Nested
    class SquareTest {
        @Test
        void square_IsPolymorphicType() {
            Shape square = new Square(42);
            assertThat(square)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Rectangle.class)
                    .isInstanceOf(Square.class);
        }

        @Test
        void squareIsRectangle_ButRectangleIsNoSquare() {
            Shape square = new Square(42);
            Shape rectangle = new Rectangle(13, 37);
            assertThat(square).isInstanceOf(Rectangle.class);
            assertThat(rectangle).isNotInstanceOf(Square.class);
        }

        @Test
        void square_GetPerimeterLength_IsFourTimesProvidedSize() {
            Shape square = new Square(42);
            double perimeterLength = square.getPerimeterLength();
            assertThat(perimeterLength).isEqualTo(4 * 42);
        }

        @Test
        void square_GetAreaSize_IsSideLengthSquared() {
            Shape square = new Square(42);
            double areaSize = square.getAreaSize();
            assertThat(areaSize).isEqualTo(42 * 42);
        }

        @Test
        void square_GetNumberOfSides_ReturnsFour() {
            Shape square = new Square(42);
            int numberOfSides = square.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(4);
        }
    }

    @Nested
    class RectangleTest {
        @Test
        void rectangle_IsPolymorphicType() {
            Rectangle rectangle = new Rectangle(42, 1337);
            assertThat(rectangle)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Rectangle.class);
        }

        @Test
        void rectangle_GetPerimeterLength_IsFourTimesProvidedSize() {
            Shape rectangle = new Rectangle(42, 1337);
            double perimeterLength = rectangle.getPerimeterLength();
            assertThat(perimeterLength).isEqualTo(42 + 42 + 1337 + 1337);
        }

        @Test
        void rectangle_GetAreaSize_IsSideLengthSquared() {
            Shape rectangle = new Rectangle(1337, 42);
            double areaSize = rectangle.getAreaSize();
            assertThat(areaSize).isEqualTo(42 * 1337);
        }

        @Test
        void rectangle_GetNumberOfSides_ReturnsFour() {
            Shape rectangle = new Rectangle(42, 1337);
            int numberOfSides = rectangle.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(4);
        }

        @Test
        void quadrangle_comparable() {
            Comparable<Quadrangle> first = new Rectangle(1, 2);
            Comparable<Quadrangle> second = new Rectangle(1, 2);

        }
    }

    @Nested
    class ParallelogramTest {

        @Test
        void parallelogram_IsPolymorphicType() {
            Parallelogram parallelogram = new Parallelogram(5, 6, 48.9);
            assertThat(parallelogram)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Parallelogram.class);
        }

        @Test
        void parallelogram_GetNumberOfSides_ReturnsFour() {
            Shape parallelogram = new Parallelogram(5, 6, 48.9);
            int numberOfSides = parallelogram.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(4);
        }

        @Test
        void parallelogram_exist() {
            Shape parallelogram = new Parallelogram(3, 9.428, 45);
            assertThat(Math.round(parallelogram.getAreaSize())).isEqualTo(20);
            assertThat(parallelogram.getPerimeterLength()).isEqualTo(24.856);

        }

    }

    @Nested
    class TrapezoidTest {

        @Test
        void trapezoid_IsPolymorphicType() {
            Trapezoid trapezoid = new Trapezoid(5.0, 6.0, 4.0, 4.0);
            assertThat(trapezoid)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Trapezoid.class);
        }
    }

    @Nested
    class CircleTest {

        @Test
        void circle_IsPolymorphicType() {
            Circle circle = new Circle(5.0);
            assertThat(circle)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Ellipse.class)
                    .isInstanceOf(Circle.class);
        }
    }

    @Nested
    class EllipseTest {
        @Test
        void ellipse_IsPolymorphicType() {
            Ellipse ellipse = new ImplementedEllipse(3.0, 4.0);
            assertThat(ellipse)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Ellipse.class);
        }
    }

    @Nested
    class RhombusTest {
        @Test
        void rhombus_IsPolymorphicType() {
            Rhombus rhombus = new Rhombus(3.0, 56);
            assertThat(rhombus)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Parallelogram.class)
                    .isInstanceOf(Rhombus.class);
        }
    }
}
