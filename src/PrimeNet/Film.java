package PrimeNet;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Film {
    private SimpleStringProperty title;
    private SimpleIntegerProperty year;
    private SimpleBooleanProperty checkbox;

    public Film(String title, int year, boolean checkbox ){
        this.title = new SimpleStringProperty(title);
        this.year = new SimpleIntegerProperty(year);
        this.checkbox = new SimpleBooleanProperty(checkbox) ;
    }


    public boolean isCheckbox() {
        return checkbox.get();
    }

    public SimpleBooleanProperty checkboxProperty() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox.set(checkbox);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public int getYear() {
        return year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }
}
