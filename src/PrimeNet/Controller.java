package PrimeNet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.awt.*;

public class Controller {

    @FXML
    private javafx.scene.control.Label LabelStatus;
    @FXML
    private javafx.scene.control.TextField TextUserName;
    @FXML
    private javafx.scene.control.TextField TextPassword;

    public void Login(javafx.event.ActionEvent event) throws Exception {

        if (TextUserName.getText().equals("user") &&  TextPassword.getText().equals ("user") ) {

            LabelStatus.setText("Login Succesfull");

            Stage PrimeNet = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            PrimeNet.setTitle("PrimeNet");
            PrimeNet.setScene(new Scene(root, 800  , 600));
            PrimeNet.show();




        }else{
            LabelStatus.setText("Login Failed");
        }


    }

    public void Reset(javafx.event.ActionEvent event) {

        TextUserName.setText(null);
        TextPassword.setText(null);
    }




}
