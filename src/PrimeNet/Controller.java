package PrimeNet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    public Label Labelmoviename;
    @FXML
    ComboBox<String> categoriesComboBox;
    @FXML
    TextField searchField = new TextField();
    TableView<Film> originalTableofFilm = new TableView();
    @FXML
    TableView<Film> tableofFilm = new TableView<>();
    @FXML
    TableColumn<Film, String> titleColumn = new TableColumn<>("Film");
    @FXML
    TableColumn<Film, Integer> yearColumn = new TableColumn<>("Jahr");
    @FXML
    TableColumn<Film, Boolean> checkboxColumn = new TableColumn<>("Checkbox");
    ComboBox<Integer> yearComboBox = new ComboBox<>();



    //login with username and password
    public void Login(javafx.event.ActionEvent event) throws Exception {

        if (TextUserName.getText().equals("") &&  TextPassword.getText().equals ("") ) {

            LabelStatus.setText("Login Succesfull");

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

    //if enter is pressed table of film will be filled
    public void onEnter() {

        tableofFilm.setEditable(true);
        System.out.println("it works");
        searchField.clear();

        //titleColumn
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        //yearColumn
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        //checkboxColumn
        checkboxColumn.setCellValueFactory(new PropertyValueFactory<>("checkbox"));
        checkboxColumn.setCellFactory(CheckBoxTableCell.forTableColumn(checkboxColumn));
        checkboxColumn.setEditable(true);


        originalTableofFilm.setItems(getFilm());
        tableofFilm.setItems(getFilm());
        tableofFilm.getColumns().addAll(titleColumn, yearColumn, checkboxColumn);



        /*//detect double click on item
        tableofFilm.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent doubleclick) {
                if (doubleclick.isPrimaryButtonDown() && doubleclick.getClickCount() == 2) {
                    Labelmoviename.setText()}

            }
        });*/
    }


    public ObservableList<Film> getFilm() {
        ObservableList<Film> films = FXCollections.observableArrayList();
        films.add(new Film("Legend of Tarzan", 2016, false));
        films.add(new Film("Zoomania", 2017, false));
        films.add(new Film("Batman v Superman", 2016, false));
        films.add(new Film("Suicide Squad", 2016, false));
        films.add(new Film("Teenage Mutant Ninja Turtles", 2016, false));
        return films;
    }

    //fill yearComboBox
    public void fillyearComboBox(){
        yearComboBox.getItems().addAll(2015,2016,2017);
        yearComboBox.setOnAction(e -> filterTableView(yearComboBox.getValue()));
    }

    //filter tableView list according to selected year
    public void filterTableView(int i){
        ObservableList<Film> allFilms, selectedYearFilms;
        allFilms = originalTableofFilm.getItems();
        selectedYearFilms = FXCollections.observableArrayList();
        for (Film s : allFilms){
            if (s.getYear() == i){
                selectedYearFilms.add(s);
            }
        }
        tableofFilm.setItems(selectedYearFilms);
    }

    //fill categoriesComboBox
    public void fillcategoriesComboBox(){
        categoriesComboBox.getItems().addAll("Action","Abenteuer", "Animation", "Drama", "Familie", "Fantasie",
                "Historie", "Horror", "Kriegsfilm", "Krimi", "Komödie", "Liebesfilm", "Science Fiction");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

}





