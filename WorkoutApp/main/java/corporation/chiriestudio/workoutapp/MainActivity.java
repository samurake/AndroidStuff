package corporation.chiriestudio.workoutapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.view.View;


//Using an interface for the fragment to communicate with this activity.
public class MainActivity extends AppCompatActivity
                            implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Overriding the interface itemClicked function.
    @Override
    public void itemClicked(long id)
    {

        //Getting the view to be checked if we are on phone or tablet.
        View fragmentContainer = findViewById(R.id.fragment_container);

        //Checking the view. If not null, use fragment transaction for tablet.
        //Else we use phone and we make an intent to another app.
        if(fragmentContainer != null)
        {
            //Defining the fragment we want to put.
            WorkoutDetailFragment details = new WorkoutDetailFragment();

            //Getting the FragmentTransaction component from FragmentManager.
            //Starting the transaction.
            FragmentTransaction ft = getFragmentManager().beginTransaction();

            //Setting the id in the workout as the id given from the user.
            //This is the id of the element that is clicked.
            details.setWorkoutId(id);

            //This two lines work together. It replaces the fragment with another one.
            //Then adds it to the back stack.
            ft.replace(R.id.fragment_container, details);
            ft.addToBackStack(null);

            //The way the transition is made. There are different pre-defined ways.
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

            //It is the finish way for the transaction.
            //Comment this and the transaction will not work.
            ft.commit();
        }
        else
        {
            //Simple intent with a pass-by parameter.
            Intent intent = new Intent(this,DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int)id);
            startActivity(intent);
        }

    }
}
