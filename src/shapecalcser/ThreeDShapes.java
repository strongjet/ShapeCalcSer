package shapecalcser;

/**
 *
 * @author Radwane
 */
public abstract class ThreeDShapes extends Shape {

    public ThreeDShapes(String name, int noOfSides) {
        super(name, noOfSides);
    }

    public abstract double getVolume();
    
    public abstract double getSurfaceArea();
  
}
