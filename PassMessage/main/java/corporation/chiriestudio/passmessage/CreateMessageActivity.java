package corporation.chiriestudio.passmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.content.Intent.ACTION_SEND;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }
    public void onSendMessage(View view){
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        /*Use this to intent to the next Activity in the application
        //Create the intent of the application
        Intent intent = new Intent(this, ReceiveMessageActivity.class);

        //Puts the text we want to pass using putExtra. ReceiveMessageActivity.EXTRA_MESSAGE is
        //a public static final String defined in the next Layout(where the intent goes)
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);
        */

        //Use this to intent to the other apps Activityes
        //Creating the intent using actions(see docs)
        Intent intent = new Intent(Intent.ACTION_SEND);

        //This tells Android that you want the activity to be able to handle data with a
        //MIME data-type of “text/plain”, and also tells it what the text is.
        //These are defined in every app's AndroidManifest.xml.
        intent.setType("plane/text");

        //"Intent.EXTRA_TEXT" is a public member of Intent class made public.
        //You can use "intent.EXTRA_TEXT" but it calls a warning.
        //Warning caused by static variable changing.
        intent.putExtra(Intent.EXTRA_TEXT, messageText);


        //Here you create a chooserIntent that ask Android to choose the intended app every time.
        //By default you can choose just one time an app then it becomes default.
        //You can set an additional dialogue for the choosing page. Defined as parameter.
        String chooserTitle = getString(R.string.chooser);
        Intent chooserIntent = Intent.createChooser(intent,chooserTitle);

        //Same as the thing upper.
        //intent.putExtra(Intent.EXTRA_SUBJECT, messageText);
        //startActivity(intent);

        startActivity(chooserIntent);
    }
}
