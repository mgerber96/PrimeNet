package PrimeNet;

import javafx.beans.property.SimpleBooleanProperty;

public class Film {
    private String title;
    private int year;
    private boolean favourite;
    private SimpleBooleanProperty checkbox;

    public Film(String title, int year, boolean favourite, boolean checkbox ){
        this.title = title;
        this.year = year;
        this.favourite = favourite;
        this.checkbox = new SimpleBooleanProperty(checkbox) ;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public boolean isFavourite(){
        return favourite;
    }

    public void setFavourite(boolean favourite){
        this.favourite = favourite;
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
}
