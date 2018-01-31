package PrimeNet;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Film {
    private  SimpleBooleanProperty favourite;
    private SimpleStringProperty title;
    private SimpleIntegerProperty year;
    private SimpleBooleanProperty remember;

    public Film(boolean favourite, String title, int year, boolean remember){
        this.favourite = new SimpleBooleanProperty(favourite);
        this.title = new SimpleStringProperty(title);
        this.year = new SimpleIntegerProperty(year);
        this.remember = new SimpleBooleanProperty(remember) ;
    }


    public boolean getRemember() {
        return remember.get();
    }

    public SimpleBooleanProperty rememberProperty() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember.set(remember);
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

    public boolean isFavourite() {
        return favourite.get();
    }

    public SimpleBooleanProperty favouriteProperty() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite.set(favourite);
    }
}
