package shapecalcser;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Radwane
 */
public class Server extends Thread {

    private ServerSocket serverSocket, serverSocket2;
    String file = "Shapes.boss";

    public Server() throws IOException {
        serverSocket = new ServerSocket(8888);
    }

    public void run() {

        try {
            while (true) {

                LinkedList<Shape> shapes = null;

                Socket serverO = serverSocket.accept();
                Socket serverI = serverSocket.accept();

                ObjectInputStream OinputFromClient = new ObjectInputStream(serverI.getInputStream());
                DataInputStream DinputFromClient = new DataInputStream(serverO.getInputStream());

                try {

                    System.out.println("Server: Waiting for client on port " + serverSocket.getLocalPort() + "...");
                    System.out.println("Server: Just connected to " + serverO.getRemoteSocketAddress());
                    System.out.println("Server: Just connected to " + serverI.getRemoteSocketAddress());

                    shapes = (LinkedList<Shape>) OinputFromClient.readObject();

                    String Choice = DinputFromClient.readUTF();
                    serializeStudents(shapes, file);

                    if (Choice.contains("Send")) {
                        
                        LinkedList<Shape> Nshapes = deserialize(file);
                        System.out.println(Nshapes);
                        ObjectOutputStream OtoClient = new ObjectOutputStream(serverI.getOutputStream());
                        OtoClient.writeObject(Nshapes);
                        OtoClient.flush();
                    }
                    ;
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    public static void serializeStudents(LinkedList<Shape> shapes, String file) {
        FileOutputStream fileOut;
        try {

            fileOut = new FileOutputStream(file, true);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(shapes);
            out.close();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        return;
    }

    public static LinkedList<Shape> deserialize(String file) throws IOException, ClassNotFoundException {
        LinkedList<Shape> Nshapes = null;
        ObjectInputStream in = null;
        try {

            FileInputStream fileIn = new FileInputStream(file);
            in = new ObjectInputStream(fileIn);
            Nshapes = (LinkedList<Shape>) in.readObject();
            Shape readobj = null;
            readobj = (Shape) in.readObject();

            do {
                readobj = (Shape) in.readObject();
                if (readobj != null) {
                    Nshapes.add(readobj);
                }
            } while (readobj != null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (in != null) {
            in.close();
        }
        return Nshapes;
    }

    public static void main(String[] args) {

        try {
            Thread t = new Server();
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
