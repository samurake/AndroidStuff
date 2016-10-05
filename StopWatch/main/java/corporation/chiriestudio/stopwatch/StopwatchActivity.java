package corporation.chiriestudio.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


//You can find more info about this script in the Android Bullet Points folder.
public class StopwatchActivity extends AppCompatActivity {

    //Seconds for the watch.
    public int seconds;
    //Is it running or not?
    public boolean running;
    //Boolean for onStop() and onRestart() method.
    //It is used for onPause() and onResume() method.
    //The purpose of both the functions is the same.
    public boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        //At first running of the app this instance is null.
        //After saving the instance by overriding onSaveInstanceState(parameter) with the parameter as the current bundler savedInstanceState carry some data.
        //This if checks to resume the saved data from the bundler to it's actual place.
        //Used this for keeping the variables flux going.
        //It fixes tilt the screen problem when display is oriented from portrait to landscape and Android calls onDestroy() and onCreate() again.
        if(savedInstanceState != null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }

        //Called this in onCreate to run the selected code located in runTimer() method.
        runTimer();
    }


    //Called this to save the data in case of onDestroy().
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
        savedInstanceState.putBoolean("wasRunning",wasRunning);
    }

    //Function for starting the watch.
    public void onClickStart(View view){
        running = true;
    }

    //Function for stopping the watch.
    public void onClickStop(View view){
        running = false;
    }

    //Function to reset the watch.
    public void onClickReset(View view){
        running = false;
        seconds = 0;
    }

    /*
    //Override on the onStop() app lifecycle
    @Override
    protected void onStop()
    {
        super.onStop();
        wasRunning = running;
        running = false;
    }


    //Override on the onStart() app lifecycle
    @Override
    protected void onStart()
    {
        super.onStart();
        if(wasRunning)
        {
            running = true;
        }
    }
    */

    ///*

    //Override on the onPause() app lifecycle
    @Override
    protected void onPause()
    {
        super.onPause();
        wasRunning = running;
        running = false;
    }


    //Override on the onResume() app lifecycle
    @Override
    protected void onResume()
    {
        super.onResume();
        if(wasRunning)
        {
            running = true;
        }
    }
    //*/


    //runTimer() method to create a timer on a thread.
    //Used handlers because Android cannot access the main thread.
    //Handlers are usefully because you can time the running of your code.
    //This is made by using postDelayed() function below.
    //In this case we run the code on a thread by a delay of 1000 milliseconds(1 second).
    private void runTimer() {
        final TextView textView = (TextView) findViewById(R.id.time_view);

        //Creating the Handler.
        final Handler handler = new Handler();

        //Using handler.post() function, it requires wrapping the code inside a Runnable() object.
        //Used this handler to post the code.
        handler.post(new Runnable(){
            @Override
            public void run(){
                int hours = seconds/3600;
                int minutes = (seconds%60)/60;
                int secs = seconds%60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                textView.setText(time);
                if(running)
                {
                    seconds++;
                }

                //Used handler.postDelayed() for the Runnable object specifying the delay in milliseconds.
                //Used this to post the code again in a specified delay.
                handler.postDelayed(this,1000);
            }
        });
    }
}
