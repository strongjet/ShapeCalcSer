package shapecalcser;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

/**
 *
 * @author Radwane
 */
public class Interact {

    LinkedList<Shape> _shapes;
    String _type;

    public Interact(LinkedList<Shape> shapes, String type) {

        _shapes = shapes;
        _type = type;
        main();

    }

    public void main() {

        ObjectOutputStream OOtoServer = null;
        DataOutputStream DOtoServer = null;
        ObjectInputStream OOfromServer = null;

        try {
            Socket Objconnect = new Socket("127.0.0.1", 8888);
            Socket Outconnect = new Socket("127.0.0.1", 8888);

            OOtoServer = new ObjectOutputStream(Outconnect.getOutputStream());

            OOtoServer.writeObject(_shapes);
            DOtoServer = new DataOutputStream(Objconnect.getOutputStream());
            if (!_type.contains("Send")) {
                
                
                DOtoServer.writeUTF("Send");

                LinkedList<Shape> _Nshapes;
                OOfromServer = new ObjectInputStream(Outconnect.getInputStream());


                LinkedList<Shape> Nshapes = (LinkedList<Shape>) OOfromServer.readObject();
                
            } else {
                DOtoServer.writeUTF("Don't Send");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

}
