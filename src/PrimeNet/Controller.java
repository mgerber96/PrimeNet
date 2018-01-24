package PrimeNet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public ComboBox<String> categories;
    public TableColumn Filmtitel;
    public TableColumn Jahr;
    public TableColumn Fav;
    public TableColumn Merken;
    public Label LabelStatus;
    public PasswordField TextPassword;
    public TextField TextUserName;
    public TableColumn Kategorie;

    //Die Combobox mit Kategorien füllen
    public void fillCombo(){
        categories.getItems().addAll("Action","Abenteuer", "Animation", "Drama", "Familie", "Fantasie",
                "Historie", "Horror", "Kriegsfilm", "Krimi", "Komödie", "Liebesfilm", "Science Fiction");
    }


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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}





