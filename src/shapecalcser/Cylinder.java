package shapecalcser;
/**
 *
 * @author Radwane
 */
public class Cylinder extends ThreeDShapes implements java.io.Serializable {

    private double _radius;
    private double _height;

    public Cylinder(double radius, double height, String name) {
        super(name, 3);
        _radius = radius;
        _height = height;
    }

    @Override
    public double getVolume() {
        return Math.PI * (_radius * _radius) * _height;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * Math.PI * _radius * _height + 2 * Math.PI * (_radius * _radius);
    }

    public double getDiameter() {
        return _radius / 2;
    }

    public double getHeight() {
        double volume = getVolume();
        return volume / (Math.PI * _radius * _radius);
    }
}
