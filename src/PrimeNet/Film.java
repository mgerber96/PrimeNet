package PrimeNet;

public class Film {
    private String title;
    private int year;
    private boolean favourite;

    public Film(String title, int year, boolean favourite){
        this.title = title;
        this.year = year;
        this.favourite = favourite;
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
}
