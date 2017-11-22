package shapecalcser;

/**
 *
 * @author Radwane
 */
public class Circle extends TwoDShapes implements java.io.Serializable {

    private double _radius;
    
    public Circle(double radius, String name) {
        super(name, 0);
        _radius = radius;
    }

    
    public double getArea() {
        return Math.PI * (_radius * _radius);
    }
  
    public double getPerimeter() {
        return 2 * Math.PI * _radius;
    }
    
    public double getDiameter() {
        return _radius / 2;
    }    

}
