package shapecalcser;
import java.util.LinkedList;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Radwane
 */
public class Interface extends Application {

    LinkedList<Shape> shapes = new LinkedList();

    @Override
    public void start(Stage primaryStage) {

        final String instruction = "   Welcome to the 2D and 3D shapes calculator"
                + "\n   To start off with please select either 2D or 3D\n   Otherwise you can exit";

        Label main_info = createLabel(instruction);

        final Label author = createLabel("By M00566185");
        final Button btn2D = createButton("2 Dimensional");
        final Button btn3D = createButton("3 Dimensional");
        final Button exit = createButton("   Exit   ");

        BorderPane border = new BorderPane();
        border.setTop(main_info);
        border.setCenter(addGridPane(author, btn2D, btn3D, exit));

        exit.setOnAction((ActionEvent event1) -> {
            primaryStage.hide();
        });

        btn2D.setOnAction((ActionEvent event) -> {

            final String[] btnLabels = {"Right Angle Triangle", "       Circle       ", "       Rectangle         ",
                "       Square     ", "   Regular Polygon   "};

            final String[] Variables = {"Area,Base (Side A),Height (Side B),Side C,Perimeter,null",
                "Area,Circumference,Diameter,Radius,null,null",
                "Area,Periemeter,Side A,Side B,null,null",
                "Area,Periemeter,Side,null,null,null",
                "Area,Perimeter,Number of edges,Side,Alpha,null"};

            final String Title = "2D Shapes";

            navigation(primaryStage, btnLabels, Variables, Title);
        });

        btn3D.setOnAction((ActionEvent event) -> {

            final String[] btnLabels = {"        Cone        ", "        Cube        ", "       Cylinder         ",
                "       Sphere     ", "     Tetrahedron     "};

            final String[] Variables = {"Surface Area,Volume,Radius,Diameter,Height,null null",
                "Surface Area,Volume,Side,null,null,null",
                "Surface Area,Volume,Radius,Diameter,Height,null",
                "Surface Area,Volume,Radius,Diameter,null,null",
                "Surface Area,Volume,Side,null,null,null"};

            final String Title = "3D Shapes";

            navigation(primaryStage, btnLabels, Variables, Title);

        });

        primaryStage.sizeToScene();
        Scene scene = new Scene(border, 480, 250);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Shapes");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public GridPane addGridPane(Label author, Button btn2D, Button btn3D, Button exit) {

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(2);
        grid.add(btn2D, 1, 1);
        grid.add(btn3D, 2, 1);
        grid.add(exit, 1, 2);
        grid.add(author, 2, 2);

        return grid;
    }

    private void navigation(Stage primaryStage, String[] btnLabels, String[] Variables, String Title) {

        Stage stage = new Stage();
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 430, 150);
        final Button btn_1 = createButton(btnLabels[0]);
        final Button btn_2 = createButton(btnLabels[1]);
        final Button btn_3 = createButton(btnLabels[2]);
        final Button btn_4 = createButton(btnLabels[3]);
        final Button btn_5 = createButton(btnLabels[4]);
        final Button Back = createButton("  Back    ");

        root.add(btn_1, 1, 0);
        root.add(btn_2, 2, 0);
        root.add(btn_3, 1, 1);
        root.add(btn_4, 2, 1);
        root.add(btn_5, 1, 3);
        root.add(Back, 2, 3);

        root.setHgap(10);
        root.setVgap(2);

        Back.setOnAction((ActionEvent event1) -> {
            stage.hide();
            primaryStage.show();
        });
        btn_1.setOnAction((ActionEvent event1) -> {
            stage.hide();
            createStage(btnLabels[0], Variables[0], stage);
        });
        btn_2.setOnAction((ActionEvent event1) -> {
            stage.hide();
            createStage(btnLabels[1], Variables[1], stage);
        });
        btn_3.setOnAction((ActionEvent event1) -> {
            stage.hide();
            createStage(btnLabels[2], Variables[2], stage);
        });
        btn_4.setOnAction((ActionEvent event1) -> {
            stage.hide();
            createStage(btnLabels[3], Variables[3], stage);
        });
        btn_5.setOnAction((ActionEvent event1) -> {
            stage.hide();
            createStage(btnLabels[4], Variables[4], stage);
        });
        stage.setTitle(Title);
        primaryStage.hide();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    private Button createButton(String text) {
        Button button = new Button(text);
        GridPane.setFillHeight(button, true);
        GridPane.setFillWidth(button, true);
        GridPane.setHgrow(button, Priority.ALWAYS);
        GridPane.setVgrow(button, Priority.ALWAYS);
        button.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        return button;
    }

    private Label createLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-font: 22 arial;");

        return label;
    }

    private void createStage(String title, String names, Stage Pstage) {
        Stage stage = new Stage();
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 380, 260);

        final TextField a = new TextField();
        final TextField b = new TextField();
        final TextField c = new TextField();
        final TextField d = new TextField();
        final TextField e = new TextField();
        final TextField f = new TextField();

        if (names.split(",")[3].equals("null")) {
            d.setDisable(true);
            e.setDisable(true);
            f.setDisable(true);
        } else if (names.split(",")[4].equals("null")) {
            e.setDisable(true);

            f.setDisable(true);
        } else if (names.split(",")[5].equals("null")) {
            f.setDisable(true);
        }

        final Label aa = createLabel(names.split(",")[0]);
        final Label bb = createLabel(names.split(",")[1]);
        final Label cc = createLabel(names.split(",")[2]);
        final Label dd = createLabel(names.split(",")[3]);
        final Label ee = createLabel(names.split(",")[4]);
        final Label ff = createLabel(names.split(",")[5]);

        final Button Calculate = createButton("   Calculate   ");
        final Button Clear = createButton("   Clear      ");
        final Button Send_Recieve = createButton("Send/Recieve");
        final Button Back = createButton("      Back       ");

        root.add(a, 2, 1);
        root.add(b, 2, 2);
        root.add(c, 2, 3);
        root.add(d, 2, 4);
        root.add(e, 2, 5);
        root.add(f, 2, 6);

        root.add(aa, 1, 1);
        root.add(bb, 1, 2);
        root.add(cc, 1, 3);
        root.add(dd, 1, 4);
        root.add(ee, 1, 5);
        root.add(ff, 1, 6);

        root.add(Calculate, 2, 7);
        root.add(Clear, 1, 7);
        root.add(Send_Recieve, 1, 8);
        root.add(Back, 2, 8);

        Calculate.setOnAction((ActionEvent event) -> {

            String formating = "^([0-9]+\\.?[0-9]*|[0-9]*\\.[0-9]+)$";
            String name;
            switch (title) {
                case "Right Angle Triangle":
                    if (b.getText().matches(formating) && c.getText().matches(formating)) {
                        name = Input_Message();
                        Triangle triangle = new Triangle(Double.parseDouble(b.getText()), Double.parseDouble(c.getText()), name);
                        shapes.add(triangle);
                        a.setText(String.valueOf(triangle.getArea()));
                        e.setText(String.valueOf(triangle.getPerimeter()));
                        d.setText(String.valueOf(triangle.getDiagnal()));

                    } else {
                        Input_Error_msg();
                    }
                    break;
                case "       Circle       ":
                    if (d.getText().matches(formating)) {
                        name = Input_Message();
                        Circle circle = new Circle(Double.parseDouble(d.getText()), name);
                        shapes.add(circle);
                        a.setText(String.valueOf(circle.getArea()));
                        b.setText(String.valueOf(circle.getPerimeter()));
                        c.setText(String.valueOf(circle.getDiameter()));
                    } else {
                        Input_Error_msg();
                    }
                    break;
                case "       Rectangle         ":
                    if (c.getText().matches(formating) && d.getText().matches(formating)) {
                        name = Input_Message();
                        Rectangle rectangle = new Rectangle(Double.parseDouble(c.getText()), Double.parseDouble(d.getText()), name);
                        shapes.add(rectangle);
                        a.setText(String.valueOf(rectangle.getArea()));
                        b.setText(String.valueOf(rectangle.getPerimeter()));
                    } else {
                        Input_Error_msg();
                    }
                    break;
                case "       Square     ":
                    if (c.getText().matches(formating)) {
                        name = Input_Message();
                        Rectangle rectangle = new Rectangle(Double.parseDouble(c.getText()), Double.parseDouble(c.getText()), name);
                        shapes.add(rectangle);
                        a.setText(String.valueOf(rectangle.getArea()));
                        b.setText(String.valueOf(rectangle.getPerimeter()));
                    } else {
                        Input_Error_msg();
                    }
                    break;
                case "       Cylinder         ":
                    if (c.getText().matches(formating) && e.getText().matches(formating)) {
                        name = Input_Message();
                        Cylinder cylinder = new Cylinder(Double.parseDouble(c.getText()), Double.parseDouble(e.getText()), name);
                        shapes.add(cylinder);
                        a.setText(String.valueOf(cylinder.getSurfaceArea()));
                        b.setText(String.valueOf(cylinder.getVolume()));
                        d.setText(String.valueOf(cylinder.getDiameter()));
                        e.setText(String.valueOf(cylinder.getHeight()));

                    } else {
                        Input_Error_msg();
                    }
                    break;
                case "       Sphere     ":
                    if (c.getText().matches(formating)) {
                        name = Input_Message();
                        Sphere sphere = new Sphere(Double.parseDouble(d.getText()), name);
                        shapes.add(sphere);
                        a.setText(String.valueOf(sphere.getSurfaceArea()));
                        b.setText(String.valueOf(sphere.getVolume()));
                        d.setText(String.valueOf(sphere.getDiameter()));
                    } else {
                        Input_Error_msg();
                    }
                    break;
            }
        });

        Back.setOnAction((ActionEvent event) -> {
            stage.hide();
            Pstage.show();
        });
        Clear.setOnAction((ActionEvent event) -> {
            a.clear();
            b.clear();
            c.clear();
            d.clear();
            e.clear();
            f.clear();
        });

        Send_Recieve.setOnAction((ActionEvent event) -> {

            String Selection = ConfirmationDialog();

            if (Selection.matches("null")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Nothing happening here!");
                alert.setHeaderText(null);
                alert.setContentText("Nothing happened, shapes were not sent to the server.");
                alert.showAndWait();
            } else if (Selection.matches("Send")) {
                Interact client = new Interact(shapes, "Send");
                shapes = new LinkedList();
            } else if (Selection.matches("Triangle")) {
                Interact client = new Interact(shapes, "Triangle");
                shapes = new LinkedList();
            } else if (Selection.matches("Circle")) {
                Interact client = new Interact(shapes, "Circle");
                shapes = new LinkedList();
            } else if (Selection.matches("Rectangle")) {
                Interact client = new Interact(shapes, "Rectangle");
                shapes = new LinkedList();
            } else if (Selection.matches("Sphere")) {
                Interact client = new Interact(shapes, "Sphere");
                shapes = new LinkedList();
            } else if (Selection.matches("Cylinder")) {
                Interact client = new Interact(shapes, "Cylinder");
                shapes = new LinkedList();
            } else if (Selection.matches("All")) {
                Interact client = new Interact(shapes, "All");
                shapes = new LinkedList();
            }
        });

        root.setHgap(10);
        root.setVgap(2);
        Pstage.hide();
        stage.setTitle(title);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    private String ConfirmationDialog() {

        String Selection = "null";

        Alert alert = new Alert(AlertType.CONFIRMATION);

        alert.setTitle("Send/Recieve Shape");
        alert.setHeaderText("Do you want to send and recieve shapes from server");
        alert.setContentText("Press cancel if you JUST want to send shapes to the server");

        Optional<ButtonType> choice1 = alert.showAndWait();
        if (choice1.get() == ButtonType.OK) {

            alert.setTitle("Shapes Selection");
            alert.setHeaderText("Please select the shapes you want to recieve");
            alert.setContentText("Choose your option.");

            ButtonType All = new ButtonType("All");
            ButtonType Triangle_btn = new ButtonType("Triangle");
            ButtonType Circle_btn = new ButtonType("Circle");
            ButtonType Rectangle_btn = new ButtonType("Rectangle");
            ButtonType Sphere_btn = new ButtonType("Sphere");
            ButtonType Cylinder_btn = new ButtonType("Cylinder");
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(All, Triangle_btn, Circle_btn, Rectangle_btn, Sphere_btn, Cylinder_btn, buttonTypeCancel);

            Optional<ButtonType> choice2 = alert.showAndWait();
            if (choice2.get() == All) {
                Selection = ("All");
            } else if (choice2.get() == Triangle_btn) {
                Selection = ("Triangle");
            } else if (choice2.get() == Circle_btn) {
                Selection = ("Circle");
            } else if (choice2.get() == Rectangle_btn) {
                Selection = ("Rectangle");
            } else if (choice2.get() == Sphere_btn) {
                Selection = ("Sphere");
            } else if (choice2.get() == Cylinder_btn) {
                Selection = ("Cylinder");
            }
        } else {
            Selection = "Send";
        }
        return Selection;
    }

    private void Input_Error_msg() {

        JOptionPane.showMessageDialog(new JFrame(), "Your input(s) is not valid!",
                "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    private String Input_Message() {
        JFrame frame = new JFrame("1");
        String input = JOptionPane.showInputDialog(
                frame,
                "What do you want to name your shape:",
                "Please enter a name",
                JOptionPane.WARNING_MESSAGE
        );
        return input;
    } 

    public static void main(String[] args) {
        launch(args);
    }

}
