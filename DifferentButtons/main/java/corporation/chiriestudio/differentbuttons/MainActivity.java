package corporation.chiriestudio.differentbuttons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static corporation.chiriestudio.differentbuttons.R.id.textView;

/*
Most of the work in this app is in activity_main.xml.
There you can find a method on Scroll Implementing by using a relative layout in a linear layout.
Then you can find how a scroll works. Great thing.
Below is the code for different types of button.
To do: Add an image view.
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClickToggler(View view)
    {
        //Toggle Button has more options in the XML.
        //This is the simple code on how to interact with it.
        ToggleButton button = (ToggleButton) findViewById(R.id.toggleButton);
        TextView textView = (TextView) findViewById(R.id.textView);
        Boolean toggled =  button.isChecked();
        if(toggled)
        {
            textView.setText("TB: It is ON");
        }
        else
        {
            textView.setText("TB: It is OFF");
        }
    }

    public void onSwitchOnOff(View view)
    {
        //Switch Button has more options in the XML.
        //This is the simple code on how to interact with it.
        Switch swbutton = (Switch) findViewById(R.id.switch1);
        TextView textView = (TextView) findViewById(R.id.textView);
        Boolean toggled = swbutton.isChecked();
        if(toggled)
        {
            textView.setText("SB: It is ON");
        }
        else
        {
            textView.setText("SB: It is OFF");
        }
    }

    public void onCheckBoxChecked(View view)
    {
        CheckBox check1button = (CheckBox) findViewById(R.id.checkBox);
        //This is the method to check a CheckBox button from different checkboxes.
        //This checkboxes have the same onClick function(onCheckBoxChecked)
        Boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId())
        {
            case R.id.checkBox:
            {
                if(checked)
                {
                    Toast.makeText(this,"You just checked CheckBox1!",Toast.LENGTH_SHORT).show();
                }else
                {
                    //nothing
                }
                break;
            }
            case R.id.checkBox2:
            {
                if(checked)
                {
                    Toast.makeText(this,"You just checked CheckBox1!",Toast.LENGTH_LONG).show();
                }else
                {
                    //nothing
                }
                break;
            }
        }

    }

    public void onRadioBoxChecked(View view)
    {
        RadioGroup radio = (RadioGroup) findViewById(R.id.radiogroup);
        TextView textView = (TextView) findViewById(R.id.textView);
        //With RadioBox you can limit the user for just one choice.
        //You have to add the Radio Boxes in a RadioGroup. See XML.
        //Here is the method by id to do this.
        int id = radio.getCheckedRadioButtonId();
        switch(id)
        {
            case R.id.radioButton:
                textView.setText("Choice 3 only selected!");
                break;

            case R.id.radioButton2:
                textView.setText("Choice 4 only selected!");
                break;
        }
    }

    public void onTeaServeIntent(View view)
    {
        //Just some intent remembering.
        Intent intent = new Intent(this,ServeTeaActivity.class);
        startActivity(intent);
    }
}
