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
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller{
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
    TableColumn<Film, Boolean> favouriteColumn = new TableColumn<>("Favorit");
    @FXML
    TableColumn<Film, Boolean> checkboxColumn = new TableColumn<>("Checkbox");
    @FXML
    ComboBox<Integer> yearComboBox = new ComboBox<>();

    public void setUpEverything(){
        categoriesComboBox.getItems().addAll("Action","Abenteuer", "Animation", "Drama", "Familie", "Fantasie",
                "Historie", "Horror", "Kriegsfilm", "Krimi", "Komödie", "Liebesfilm", "Science Fiction");
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

    }

    @FXML
    private void initialize(){
        setUpEverything();
    }
}





