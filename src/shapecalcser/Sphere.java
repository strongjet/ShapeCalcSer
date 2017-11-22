package shapecalcser;
/**
 *
 * @author Radwane
 */
public class Sphere extends ThreeDShapes implements java.io.Serializable{

    private double _radius;

    public Sphere(double radius, String name) {
        super(name, 0);
        _radius = radius;
    }

    @Override
    public double getVolume() {
        return (4 / 3) * Math.PI * Math.pow(_radius, 3);
    }

    @Override
    public double getSurfaceArea() {
        return 4 * Math.PI * _radius * _radius;
    }

    public double getDiameter() {
        return _radius / 2;
    }

}
