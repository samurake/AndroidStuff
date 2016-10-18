package corporation.chiriestudio.starbuzzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static corporation.chiriestudio.starbuzzapp.R.id.image;

public class DrinkActivity extends AppCompatActivity {


    //The string containing the choice of the preferred drink from DrinkCategoryActivity
    public static final String EXTRA_DRINKNO = "drinkNO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        //Create a new drink object to retrieve the choosen object
        int drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKNO);
        Drink drink = Drink.drinks[drinkNo];


        //Set the image of the drink
        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceID());
        photo.setContentDescription(drink.getName());


        //Set the name of the drink
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(drink.getName());

        //Set the description of the drink
        TextView description = (TextView) findViewById(R.id.description);
        name.setText(drink.getDescription());

    }
}
