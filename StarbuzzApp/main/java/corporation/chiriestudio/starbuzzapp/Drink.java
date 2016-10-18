package corporation.chiriestudio.starbuzzapp;

/**
 * Created by samur on 11.10.2016.
 * This class is used to define drink as an object.
 * Code from it used in other Activities.
 */

public class Drink {

    //Characteristics of drink object
    private String name;
    private String description;
    private int imageResourceID;

    //Constructor
    public Drink(String name, String description, int imageResourceID){
        this.name = name;
        this.description = description;
        this.imageResourceID = imageResourceID;
    }

    //An array of drinks where you can define how many you want using the constructor.
    public static final Drink[] drinks = {
        new Drink("Coffe", "It has a great taste over all of them", R.drawable.coffe),
        new Drink("Macho", "It is something special from our store", R.drawable.macho),
        new Drink("Filter", "Blended with a fine filter, the best choice from our store", R.drawable.kaffe)
    };

    //getName function used in code
    public String getName(){
        return name;
    }

    //getDescription function used in code
    public String getDescription(){
        return description;
    }

    //getImageResource function used in conde
    public int getImageResourceID(){
        return imageResourceID;
    }

    //This is used for the drinks ArrayAdapter in DrinkCategoryActivity.
    //It shows the name of the drink in a List Activity.
    //This is the String representation of a Drink name.
    public String toString(){
        return this.name;
    }
}
