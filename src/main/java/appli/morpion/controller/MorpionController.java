package appli.morpion.controller;

import appli.morpion.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;

public class MorpionController implements Initializable {
    private int[][][] testVictoire = {
            { {0,0},{0,1},{0,2} },
            { {1,0},{1,1},{1,2} },
            { {2,0},{2,1},{2,2} },
            { {0,0},{1,1},{1,2} }
    };

    @FXML
    private Label playerName;
    private final String joueur1;
    private final String joueur2;

    @FXML
    private ListView<String> fieldlist;

    @FXML
    private GridPane maGrid;

    @FXML
    private Label case00;

    @FXML
    private Label case01;

    @FXML
    private Label case02;

    @FXML
    private Label case10;

    @FXML
    private Label case11;

    @FXML
    private Label case12;

    @FXML
    private Label case20;

    @FXML
    private Label case21;

    @FXML
    private Label case22;

    public MorpionController(String joueur1, String joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerName.setText(joueur1);
    }

    @FXML
    void onHelloButtonClick() {
        HelloApplication.changeScene("morpion", new MorpionController(joueur2,joueur1));
    }

    @FXML
    void onClickLabel(MouseEvent event) {
        Label lbl = (Label) event.getSource();
        if (playerName.getText().equals(joueur1)){
            if (lbl.getText().equals("")){
                lbl.setText("x");
                fieldlist.getItems().add(joueur1);
                if (checkVictory("x")){
                    fieldlist.getItems().add("Victoire de "+joueur2);
                } else {
                    playerName.setText(joueur2);
                }
            }
            else {
                fieldlist.getItems().add(joueur1+" a fait une erreur.");
            }
        }
        else if (playerName.getText().equals(joueur2)){
            if (lbl.getText().equals("")){
                lbl.setText("o");
                fieldlist.getItems().add(joueur2);
                if (checkVictory("o")){
                    fieldlist.getItems().add("Victoire de "+joueur2);
                } else {
                    playerName.setText(joueur1);
                }
            }
            else {
                fieldlist.getItems().add(joueur2+" a fait une erreur.");
            }
        }
    }

    private Label getNodeFromGridPane(int col, int row){
        for (Node node : maGrid.getChildren()){
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row){
                return (Label) node;
            }
        }
        return null;
    }

    private boolean checkVictory(String str){
        if (case00.getText().equals(str) && case01.getText().equals(str) && case02.getText().equals(str)){
            return true;
        }
        else if (case10.getText().equals(str) && case11.getText().equals(str) && case12.getText().equals(str)){
            return true;
        }
        else if (case20.getText().equals(str) && case21.getText().equals(str) && case22.getText().equals(str)){
            return true;
        }
        else if (case00.getText().equals(str) && case10.getText().equals(str) && case20.getText().equals(str)){
            return true;
        }
        else if (case01.getText().equals(str) && case11.getText().equals(str) && case21.getText().equals(str)){
            return true;
        }
        else if (case02.getText().equals(str) && case12.getText().equals(str) && case22.getText().equals(str)){
            return true;
        }
        else if (case00.getText().equals(str) && case11.getText().equals(str) && case22.getText().equals(str)){
            return true;
        }
        else return case02.getText().equals(str) && case11.getText().equals(str) && case20.getText().equals(str);
    }
}