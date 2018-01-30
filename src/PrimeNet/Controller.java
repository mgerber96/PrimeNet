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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.awt.*;
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
    TableView<Product> tableofFilm = new TableView<>();
    @FXML
    TableColumn<Product, String> nameColumn = new TableColumn<>("Object");
    @FXML
    TableColumn<Product, Double> priceColumn = new TableColumn<>("Preis");
    @FXML
    TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Anzahl");


    //login with username and password
    public void Login(javafx.event.ActionEvent event) throws Exception {

        if (TextUserName.getText().equals("") &&  TextPassword.getText().equals ("") ) {

            LabelStatus.setText("Login Succesfull");

            Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            Stage PrimeNet = new Stage();
            PrimeNet.setTitle("PrimeNet");
            PrimeNet.setScene(new Scene(root, 800  , 600));
            PrimeNet.show();

        }else{ LabelStatus.setText("Login Failed");} }

    //function of the reset button in login menu
    public void Reset(javafx.event.ActionEvent event) {

        TextUserName.setText(null);
        TextPassword.setText(null);
        LabelStatus.setText("Login");
    }

    //if enter is pressed table of film will be filled
    public void onEnter(){
        System.out.println("sadfsad");
        searchField.clear();

        //nameColumn
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //priceColumn
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //quantityColumn
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        tableofFilm.setItems(getProduct());
        tableofFilm.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

    }

    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Laptop", 859.00, 20));
        products.add(new Product("Bouncy Ball", 2.49, 198));
        products.add(new Product("Toilet", 99.00, 74));
        products.add(new Product("The Notebook DVD", 19.99, 12));
        products.add(new Product("Corn", 1.49, 856));
        return products;
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





