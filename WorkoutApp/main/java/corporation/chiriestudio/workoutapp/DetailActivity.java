package corporation.chiriestudio.workoutapp;

import android.app.Activity;
import android.os.Bundle;

public class DetailActivity extends Activity {

    //Simple deff of a static variable used for pass-by.
    public static final String EXTRA_WORKOUT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Defining the fragment in this activity.
        WorkoutDetailFragment workoutDetailFragment = (WorkoutDetailFragment) getFragmentManager().findFragmentById(R.id.detail_frag);

        //Getting the workout id from the intent pass-by.
        int workoutID = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);

        //Setting the id in the fragment.
        workoutDetailFragment.setWorkoutId(workoutID);

    }
}
