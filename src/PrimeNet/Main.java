package PrimeNet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {



    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage LoginforPrimeNet) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        LoginforPrimeNet.setTitle("Login for PrimeNet");
        LoginforPrimeNet.setScene(new Scene(root, 300  , 300));
        LoginforPrimeNet.show();


    }
}
