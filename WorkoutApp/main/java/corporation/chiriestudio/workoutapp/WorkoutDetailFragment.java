package corporation.chiriestudio.workoutapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    //Defining the workoutId so Android will know what user-choice to pass-by.
    private long workoutId;

    //It is called when Android needs the fragment's layout.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Recover the bundle from screen tilt.
        if(savedInstanceState != null)
        {
            workoutId = savedInstanceState.getLong("workoutId");
        }

        // Inflate the layout for this fragment
        // This is the way it works.
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }


    //You can see a better explanation in the documentation about fragments lifecycle.
    //Override of the start function.
    @Override
    public void onStart(){
        super.onStart();

        //Fragments usually don't have a view so we use this to get the view.
        View view = getView();

        //A simple check to pass-by nullptr-exception.
        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int) workoutId];
            title.setText(workout.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }


    //Used to save the instance after the use.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putLong("workoutId", workoutId);
    }

    //Simple set function for the id we pass in this app.
    public void setWorkoutId(long id)
    {
        this.workoutId=id;
    }

}
