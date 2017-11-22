package shapecalcser;

/**
 *
 * @author Radwane
 */
public abstract class ThreeDShapes extends Shape implements java.io.Serializable {

    public ThreeDShapes(String name, int noOfSides) {
        super(name, noOfSides);
    }

    public abstract double getVolume();
    
    public abstract double getSurfaceArea();
  
}
