package corporation.chiriestudio.starbuzzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/*
This is the Activity that allows the user to navigate through the top of the App.
It contains a listView that has an adapter attached to it.
The reason of the adapter is that you can click on the items of the list.
The adapter has an intent that will go to the next activity.
The next activity is a List Activity.
 */


public class TopLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        /*
        You can only use the android:onClick attribute in activity layouts for buttons, or any views that are subclasses of Button such as CheckBoxes and RadioButtons.
        The ListView class isn’t a subclass of Button, so using the android:onClick attribute won’t work. That’s why you have to implement your own listener
         */

        //Defining the adapter. Defining a listener for this.
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
        {
            //Doing onItemClick method for the adapter.
            //"AdapterView<?> listView" is the item that is clicked.
            //Rest of them give you more about which item was clicked in the list view.
            //Such as the item view and it's position.
            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {
                //The first element of the listView is always represented by position 0.
                //This app defines only the first category called Drinks.
                //If you want other things to be defined you have to make it yourself.
                if(position == 0)
                {
                    //Creating an intent to the next stage of the App.
                    Intent intent = new Intent(TopLevelActivity.this,DrinkCategoryActivity.class);
                    startActivity(intent);
                }
            }
        };


        //Defining the list.
        ListView listView = (ListView) findViewById(R.id.list_options);
        //Attaching the listener on the listView.
        listView.setOnItemClickListener(itemClickListener);
    }
}
