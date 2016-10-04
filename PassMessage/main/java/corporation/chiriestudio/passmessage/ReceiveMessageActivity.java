package corporation.chiriestudio.passmessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ReceiveMessageActivity extends AppCompatActivity {

    // This is the name of the extra value we're passing in the intent
    public static final String EXTRA_MESSAGE="message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        //Getting the intent.
        Intent intent = getIntent();

        //Getting the message of it using getStringExtra(value) where value is above
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);

        //Catching the TextView
        TextView messageView = (TextView) findViewById(R.id.message);

        //Setting the text.
        messageView.setText(messageText);
    }

}
