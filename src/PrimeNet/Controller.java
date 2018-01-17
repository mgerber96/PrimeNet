package PrimeNet;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.awt.*;

public class Controller {

    public ComboBox<String> Kategorien;
    @FXML
    private javafx.scene.control.Label LabelStatus;
    @FXML
    private javafx.scene.control.TextField TextUserName;
    @FXML
    private javafx.scene.control.TextField TextPassword;




    //Methode zur Anmeldung
    public void Login(javafx.event.ActionEvent event) throws Exception {

        if (TextUserName.getText().equals("") &&  TextPassword.getText().equals ("") ) {

            LabelStatus.setText("Login Succesfull");

            Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            Main.PrimeNet.setTitle("PrimeNet");
            Main.PrimeNet.setScene(new Scene(root, 800  , 600));
            Main.PrimeNet.show();

        }else{ LabelStatus.setText("Login Failed");} }

        //Methode für Reset-Button
        public void Reset(javafx.event.ActionEvent event) {

        TextUserName.setText(null);
        TextPassword.setText(null);
        LabelStatus.setText("Login");

    }



    public void DropdownMenü(ActionEvent event) {

        Kategorien.getItems().addAll("1", "2 ");


    }
}




