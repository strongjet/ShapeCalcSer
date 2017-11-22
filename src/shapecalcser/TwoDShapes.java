package shapecalcser;

/**
 *
 * @author Radwane
 */
public abstract class TwoDShapes extends Shape {

    public TwoDShapes(String name, int noOfSides) {
        super(name, noOfSides);
    }

    public abstract double getArea();

    public abstract double getPerimeter();

}
