package shapecalcser;

import java.io.IOException;
import javafx.application.Application;
import java.util.Scanner;

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

    public static void main(String[] args) throws IOException {
        //Server s = new Server();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Lauch Program in:\n 1. Console\n 2. Dialog Only\n "
                + "3. GUI\nType either 1 for option 1, 2 for option 2 or anything for option 3 ");
        String choice = input.nextLine();
        if (choice.matches("1")) {

        } else if (choice.matches("2")){
            
        DialogInterface DI = new DialogInterface();

        }
        else {
            Application.launch(Interface.class);
        }

    }
}
