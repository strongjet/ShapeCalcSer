package shapecalcser;
/**
 *
 * @author Radwane
 */
public class Triangle extends TwoDShapes implements java.io.Serializable{

    private double _height;
    private double _width;

    public Triangle(double height, double width, String name) {
        super(name, 3);
        _height = height;
        _width = width;
    }

    @Override
    public double getArea() {
        return (_height * _width) * 2;
    }

    @Override
    public double getPerimeter() {
        return (_height + _width) + Math.sqrt((_height * _height) + (_width * _width));
    }

    public double getDiagnal() {
        return Math.sqrt((_width * _width) + (_height * _height));
    }
}
