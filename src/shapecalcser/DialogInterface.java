package shapecalcser;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Radwane
 */
public class DialogInterface {

    DialogInterface() {
        MainMenu();
    }

    private void MainMenu() {
                Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Main Menu");
        alert.setHeaderText("Main Menu");
        alert.setContentText("Choose your option.");

        ButtonType btn2D = new ButtonType("2D Shapes");
        ButtonType btn3D = new ButtonType("3D Shapes");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(btn2D, btn3D, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == btn2D) {
            // ... user chose "One"
        } else if (result.get() == btn3D) {
            // ... user chose "Two"
        }
    }
}
