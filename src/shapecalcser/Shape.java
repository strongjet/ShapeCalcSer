package shapecalcser;

/**
 *
 * @author Radwane
 */
public abstract class Shape implements java.io.Serializable {

    private int noOfSides;
    private String name;

    public Shape(String name, int noOfSides) {
        this.name = name;
        this.noOfSides = noOfSides;
    }

    public String getName() {
        return name;
    }

    public int getNoOfSides() {
        return noOfSides;
    }
}
