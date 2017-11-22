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
class Interact implements Runnable {

    LinkedList<Shape> _shapes;
    String _type;

    public Interact(LinkedList<Shape> shapes, String type) {

        _shapes = shapes;
        _type = type;
        run();
    }

    @Override
    public void run() {

        ObjectOutputStream OOtoServer = null;
        DataOutputStream DOtoServer = null;
        ObjectInputStream OOfromServer = null;

        try {
            Thread.sleep(3000);
            Socket Objconnect = new Socket("127.0.0.1", 8888);
            Socket Outconnect = new Socket("127.0.0.1", 8888);

            OOtoServer = new ObjectOutputStream(Outconnect.getOutputStream());

            OOtoServer.writeObject(_shapes);
            DOtoServer = new DataOutputStream(Objconnect.getOutputStream());
            if (!_type.contains("Send")) {

                DOtoServer.writeUTF("Send");

                OOfromServer = new ObjectInputStream(Outconnect.getInputStream());

                LinkedList<Shape> Nshapes = (LinkedList<Shape>) OOfromServer.readObject();
                switch (_type) {
                    case "Send":
                        break;
                    case "Triangle":
                        for (Shape shape : Nshapes) {
                            if (shape instanceof Triangle) {
                                System.out.println("Triangle name is: " + shape.getName());
                                System.out.println("Triangle area is: " + ((Triangle) shape).getArea());
                                System.out.println("Triangle periemeter is: " + ((Triangle) shape).getPerimeter());
                                System.out.println("Triangle diagnol: " + ((Triangle) shape).getDiagnal());
                            }
                        }
                        break;
                    case "Circle":
                        for (Shape shape : Nshapes) {
                            if (shape instanceof Circle) {
                                System.out.println("Circle name: " + shape.getName());
                                System.out.println("Circle area is: " + ((Circle) shape).getArea());
                                System.out.println("Circle periemeter is: " + ((Circle) shape).getPerimeter());
                                System.out.println("Circle diameter is: " + ((Circle) shape).getDiameter());
                            }
                        }
                        break;
                    case "Rectangle":
                        for (Shape shape : Nshapes) {
                            if (shape instanceof Rectangle) {
                                System.out.println("Rectangle name: " + shape.getName());
                                System.out.println("Rectangle area: " + ((Rectangle) shape).getArea());
                                System.out.println("Rectangle perimeter is: " + ((Rectangle) shape).getPerimeter());
                            }
                        }
                        break;
                    case "Sphere":
                        for (Shape shape : Nshapes) {
                            if (shape instanceof Sphere) {
                                System.out.println("Sphere name: " + shape.getName());
                                System.out.println("Sphere volume is: " + ((Sphere) shape).getVolume());
                                System.out.println("Sphere surface area is: " + ((Sphere) shape).getSurfaceArea());
                                System.out.println("Sphere diameter is: " + ((Sphere) shape).getDiameter());
                            }
                        }
                        break;
                    case "Cylinder":
                        for (Shape shape : Nshapes) {
                            if (shape instanceof Cylinder) {
                                System.out.println("Cylinder name: " + shape.getName());
                                System.out.println("Volume volume is: " + ((Cylinder) shape).getVolume());
                                System.out.println("Sphere Surface area is: " + ((Cylinder) shape).getSurfaceArea());
                                System.out.println("Sphere diameter is: " + ((Cylinder) shape).getDiameter());
                                System.out.println("Sphere height is: " + ((Cylinder) shape).getHeight());
                            }
                        }
                        break;
                    case "All":
                        for (Shape shape : Nshapes) {
                            if (shape instanceof Triangle) {
                                System.out.println(shape.getName());
                                System.out.println(((Triangle) shape).getArea());
                                System.out.println(((Triangle) shape).getPerimeter());
                                System.out.println(((Triangle) shape).getDiagnal());
                            } else if (shape instanceof Circle) {
                                System.out.println(shape.getName());
                                System.out.println(((Circle) shape).getArea());
                                System.out.println(((Circle) shape).getPerimeter());
                                System.out.println(((Circle) shape).getDiameter());
                            } else if (shape instanceof Rectangle) {
                                System.out.println(shape.getName());
                                System.out.println(((Rectangle) shape).getArea());
                                System.out.println(((Rectangle) shape).getPerimeter());
                            } else if (shape instanceof Sphere) {
                                System.out.println(shape.getName());
                                System.out.println(((Sphere) shape).getVolume());
                                System.out.println(((Sphere) shape).getSurfaceArea());
                                System.out.println(((Sphere) shape).getDiameter());
                            } else if (shape instanceof Cylinder) {
                                System.out.println(shape.getName());
                                System.out.println(((Cylinder) shape).getVolume());
                                System.out.println(((Cylinder) shape).getSurfaceArea());
                                System.out.println(((Cylinder) shape).getDiameter());
                                System.out.println(((Cylinder) shape).getHeight());
                            }
                        }
                        break;
                    default:
                        System.out.println("");

                }

            } else {
                DOtoServer.writeUTF("Don't Send");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

}
