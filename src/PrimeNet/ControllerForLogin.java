package PrimeNet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ControllerForLogin {

    @FXML
    public Label LabelStatus;
    @FXML
    public PasswordField TextPassword;
    @FXML
    public TextField TextUserName;

    //login with username and password
    public void Login(javafx.event.ActionEvent event) throws Exception {

        if (TextUserName.getText().equals("") &&  TextPassword.getText().equals ("") ) {

            LabelStatus.setText("Login Successful");
            Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            Stage PrimeNet = new Stage();
            PrimeNet.setTitle("PrimeNet");
            PrimeNet.setScene(new Scene(root, 800, 600));
            PrimeNet.show();
            Main.Login.close();
        }else {
            LabelStatus.setText("Login Failed");
        }
    }

    //function of the reset button in login menu
    public void Reset(javafx.event.ActionEvent event) {
        TextUserName.setText(null);
        TextPassword.setText(null);
        LabelStatus.setText("Login");
    }


}





