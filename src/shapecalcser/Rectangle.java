package shapecalcser;
/**
 *
 * @author Radwane
 */
public class Rectangle extends TwoDShapes implements java.io.Serializable {
    
    private  double _height;
    private  double _width;
    
    public Rectangle(double height, double width, String name) {
        super(name, 4);
        _height = height;
        _width = width;
    }

    @Override
    public double getArea() {
        return _height * _width;
    }

    @Override
    public double getPerimeter() {
        return 2*(_height + _width);
    }
    
    
}
