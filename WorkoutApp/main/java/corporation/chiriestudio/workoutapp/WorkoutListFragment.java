package corporation.chiriestudio.workoutapp;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {


    //Used to define this fragment listener in the main activity.
    interface WorkoutListListener{
        void itemClicked(long id);
    };

    private WorkoutListListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Creating a String to store our values.
        String[] names = new String[Workout.workouts.length];
        for(int i=0; i<names.length; i++)
        {
            names[i]=Workout.workouts[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(),android.R.layout.simple_list_item_1,names);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    //Bugfix;
    //Because of the newer versions of Android.
    //By this function you pass the activity into listener.
    //At first listener is null.
    //NULLPTREXCEPTION ERROR if you don't do this first.
    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        //WTF!?
        //if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            this.listener = (WorkoutListListener) activity;
        //}
    }

    //Overriding the listener's interface function using this event.
    //We can use this because it is a ListFragment.
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        if(listener != null)
        {
            listener.itemClicked(id);
        }
    }
}
