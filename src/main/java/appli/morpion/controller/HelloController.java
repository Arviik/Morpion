package appli.morpion.controller;

import appli.morpion.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField TextFieldJ1;

    @FXML
    private TextField TextFieldJ2;

    @FXML
    private Label welcomeText11;

    @FXML
    private Label welcomeText111;

    @FXML
    void onHelloButtonClick() {
        System.out.println(TextFieldJ1.getText()+" VS "+TextFieldJ2.getText());
        HelloApplication.changeScene("morpion", new MorpionController(TextFieldJ1.getText(),TextFieldJ2.getText()));
    }
}