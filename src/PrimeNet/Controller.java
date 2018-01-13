package PrimeNet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Controller {

    public javafx.scene.control.TextField Text12345;
    @FXML
    private javafx.scene.control.Label LabelStatus;
    @FXML
    private javafx.scene.control.TextField TextUserName;
    @FXML
    private javafx.scene.control.TextField TextPassword;

    public void Login(javafx.event.ActionEvent) throws Exception {

        if (TextUserName.getText().equals("user") &&  TextPassword.getText().equals ("user") ) {

            LabelStatus.setText("Login Succesfull");

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            primaryStage.setTitle("PrimeNet");
            primaryStage.setScene(new Scene(root, 800  , 600));
            primaryStage.show();


        }else{
            LabelStatus.setText("Login Failed");
        }
    }





}
