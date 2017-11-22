package shapecalcser;

/**
 *
 * @author Radwane
 */
public abstract class TwoDShapes extends Shape implements java.io.Serializable {

    public TwoDShapes(String name, int noOfSides) {
        super(name, noOfSides);
    }

    public abstract double getArea();

    public abstract double getPerimeter();

}
