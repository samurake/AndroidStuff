package corporation.chiriestudio.starbuzzapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

/*
This is a ListActivity.
It does not need a xml.
The adapter gives it the TextView it needs.
 */


//This activity "extends ListActivity", used for this purpose of the app.
public class DrinkCategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*An array adapter is a type of adapter that’s used to bind arrays to views.
        You can use it with any subclass of the AdapterView class, which means you can use it with both list views and spinners.
        In our case, we’re going to use an array adapter to display data from the Drink.drinks array in the list view.*/


        //Getting the listView from the drink class.
        //Strong relation with the intent of the TopLevelActivity.
        //I think it works because of the type if this activity.
        ListView listDrink = getListView();

        //Defining an Array Adapter.
        //First argument is the context(the current activity).
        //Second argument defines the way the layout will be generated. I think it can be made into a custom layout.
        //"android.R.layout.simple_list_item_1" represents a standard layout type from android.
        //This is the layout that your Activity will receive.
        //Third argument is used to access the array you want to convert.
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<Drink>(
                this,
                android.R.layout.simple_list_item_1,
                Drink.drinks);

        //This is how you set the adapter.
        /*Behind the scenes, the array adapter takes each item in the array, converts it to a String using its toString() method and puts
        each result into a text view. It then displays each text view as a single row in the list view. */
        listDrink.setAdapter(listAdapter);

    }


    //In a ListActivity type you don't have to define a listener for the purpose of clickable list elements.
    //You just have to @Override the onListItemClick method for this.
    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id)
    {
        Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);

        //The ".EXTR_DRINKNO" is a public static final String variable defined in the next activity.
        //(int) id is for the index of the drink in the Drink.drinks.
        intent.putExtra(DrinkActivity.EXTRA_DRINKNO, (int) id);
        startActivity(intent);
    }
}
