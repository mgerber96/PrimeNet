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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label LabelStatus;
    @FXML
    public PasswordField TextPassword;
    @FXML
    public TextField TextUserName;
    @FXML
    ComboBox<String> categories;
    @FXML
    TextField searchField = new TextField();
    @FXML
    TableView<Film> tableofFilm = new TableView<>();
    @FXML
    TableColumn<Film, String> titleColumn = new TableColumn<>("Film");
    @FXML
    TableColumn<Film, Integer> yearColumn = new TableColumn<>("Jahr");
    @FXML
    TableColumn<Film, Boolean> favouriteColumn = new TableColumn<>("Favorit");


    //login with username and password
    public void Login(javafx.event.ActionEvent event) throws Exception {

        if (TextUserName.getText().equals("") &&  TextPassword.getText().equals ("") ) {

            LabelStatus.setText("Login Succesfull");

            Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            Stage PrimeNet = new Stage();
            PrimeNet.setTitle("PrimeNet");
            PrimeNet.setScene(new Scene(root, 800  , 600));
            PrimeNet.show();
            Main.Login.close();

        }else{ LabelStatus.setText("Login Failed");} }

    //function of the reset button in login menu
    public void Reset(javafx.event.ActionEvent event) {

        TextUserName.setText(null);
        TextPassword.setText(null);
        LabelStatus.setText("Login");
    }

    //if enter is pressed table of film will be filled
    public void onEnter(){
        System.out.println("it works");
        searchField.clear();

        //titleColumn
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //yearColumn
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        //favouriteColumn
        favouriteColumn.setCellValueFactory(new PropertyValueFactory<>("favourite"));

        tableofFilm.setItems(getFilm());
        tableofFilm.getColumns().addAll(titleColumn, yearColumn, favouriteColumn);
    }

    public ObservableList<Film> getFilm(){
        ObservableList<Film> films = FXCollections.observableArrayList();
        films.add(new Film("Legend of Tarzan", 2016, true));
        films.add(new Film("Zoomania", 2017, false));
        films.add(new Film("Batman v Superman", 2016, false));
        films.add(new Film("Suicide Squad", 2016, false));
        films.add(new Film("Teenage Mutant Ninja Turtles", 2016, true));
        return films;
    }

    //fill comboBox categories
    public void handle(){
        categories.getItems().addAll("Action","Abenteuer", "Animation", "Drama", "Familie", "Fantasie",
                "Historie", "Horror", "Kriegsfilm", "Krimi", "Komödie", "Liebesfilm", "Science Fiction");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}





