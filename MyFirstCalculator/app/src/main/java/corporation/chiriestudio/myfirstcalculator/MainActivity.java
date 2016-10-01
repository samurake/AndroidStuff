package corporation.chiriestudio.myfirstcalculator;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //Start Point;
    public void CreateNotification(){
        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this);
        nBuilder.setContentTitle("Created by samurake!");
        nBuilder.setContentText("All rights reserved!");
        nBuilder.setSmallIcon(R.drawable.ic_stat_name);

        Notification notification = nBuilder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.notify(1,notification);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView textView;
        final EditText percentageView;
        final EditText numberView;
        final TextView statusView;

        textView = (TextView) findViewById(R.id.textView);
        percentageView = (EditText) findViewById(R.id.percentageView);
        numberView = (EditText) findViewById(R.id.numberView);
        statusView = (EditText) findViewById(R.id.statusView);

        Button calcButton = (Button) findViewById(R.id.calcButton);
        Button notificationButton = (Button) findViewById(R.id.creditsButton);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String verificationOne = (String)percentageView.getText().toString();
                String verificationTwo = (String)numberView.getText().toString();
                if(!(verificationOne.matches("") || verificationTwo.matches("") || (verificationOne.matches("") && verificationTwo.matches("")))) {
                    float percentage = Float.parseFloat(percentageView.getText().toString());
                    float dec = percentage / 100;
                    float total = dec * Float.parseFloat(numberView.getText().toString());
                    textView.setText(Float.toString(total));
                    statusView.setText("Good Job!");
                    percentageView.setText("");
                    numberView.setText("");
                } else
                {
                   Toast error = (Toast) Toast.makeText(getApplicationContext(),"No numbers entered!", Toast.LENGTH_SHORT);
                    //error.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
                    error.show();
                    statusView.setText("Try Again!");
                }
            }
        });

        notificationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                CreateNotification();
            }
        });
        //End Point;

    }

}
