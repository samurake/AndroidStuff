package corporation.chiriestudio.simplecalculator;

import android.app.Notification;
import android.app.NotificationManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    //Math Manager
    public String sign = "";
    public String total = "";
    public Double tempDouble, tempDouble2;

    //Credits Notification Manager
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

        //Number Keys
        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);

        //Clear and Equal
        Button clearbutton = (Button) findViewById(R.id.cButton);
        Button equalbutton = (Button) findViewById(R.id.equalButton);

        //Operations Button
        Button plusbutton = (Button) findViewById(R.id.plusButton);
        Button minusbutton = (Button) findViewById(R.id.minusButton);
        Button mulbutton = (Button) findViewById(R.id.mulButton);
        Button divbutton = (Button) findViewById(R.id.divButton);


        //Buttons Listeners
        button0.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                    TextView output = (TextView) findViewById(R.id.editText);
                if(total == null)
                {
                    output.append("0");
                } else {
                    total = null;
                    output.setText("");
                    output.append("0");
                }
            }
        });

        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                if(total == null)
                {
                    output.append("1");
                } else {
                    total = null;
                    output.setText("");
                    output.append("1");
                }
            }
        });

        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                if(total == null)
                {
                    output.append("2");
                } else {
                    total = null;
                    output.setText("");
                    output.append("2");
                }
            }
        });

        button3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                if(total == null)
                {
                    output.append("3");
                } else {
                    total = null;
                    output.setText("");
                    output.append("3");
                }
            }
        });

        button4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                if(total == null)
                {
                    output.append("4");
                } else {
                    total = null;
                    output.setText("");
                    output.append("4");
                }
            }
        });

        button5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                if(total == null)
                {
                    output.append("5");
                } else {
                    total = null;
                    output.setText("");
                    output.append("5");
                }
            }
        });

        button6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                if(total == null)
                {
                    output.append("6");
                } else {
                    total = null;
                    output.setText("");
                    output.append("6");
                }
            }
        });

        button7.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                if(total == null)
                {
                    output.append("7");
                } else {
                    total = null;
                    output.setText("");
                    output.append("7");
                }
            }
        });

        button8.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                if(total == null)
                {
                    output.append("8");
                } else {
                    total = null;
                    output.setText("");
                    output.append("8");
                }
            }
        });

        button9.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                if(total == null)
                {
                    output.append("9");
                } else {
                    total = null;
                    output.setText("");
                    output.append("9");
                }
            }
        });

        clearbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                output.setText("");
                total = "";
                sign = "";

            }
        });


        equalbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                tempDouble2 = Double.parseDouble(output.getText().toString());

                if(sign == "+")
                {
                    total = Double.toString(tempDouble + tempDouble2);
                    output.setText(total);
                }
                else if(sign == "-")
                {
                    total = Double.toString(tempDouble - tempDouble2);
                    output.setText(total);
                }
                else if(sign == "*")
                {
                    total = Double.toString(tempDouble * tempDouble2);
                    output.setText(total);
                }
                else if(sign == "/")
                {
                    if(tempDouble2 == 0)
                    {
                        output.setText("Cannot divide by Zero!");
                    }
                    else {
                        total = Double.toString(tempDouble * tempDouble2);
                        output.setText(total);
                    }
                }
                tempDouble = null;
                tempDouble2 = null;
                sign = "";
            }
        });


        plusbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                if(!(output.getText().toString().matches(""))) {
                    tempDouble = Double.parseDouble(output.getText().toString());
                    output.setText("");
                    sign = "+";
                }
            }
        });


        minusbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                if(!(output.getText().toString().matches(""))) {
                    tempDouble = Double.parseDouble(output.getText().toString());
                    output.setText("");
                    sign = "-";
                }
            }
        });


        mulbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                if(!(output.getText().toString().matches(""))) {
                    tempDouble = Double.parseDouble(output.getText().toString());
                    output.setText("");
                    sign = "*";
                }
            }
        });


        divbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView output = (TextView) findViewById(R.id.editText);
                if(!(output.getText().toString().matches(""))) {
                    tempDouble = Double.parseDouble(output.getText().toString());
                    output.setText("");
                    sign = "/";
                }
            }
        });


        //Credits Button
        Button creditsbutton = (Button) findViewById(R.id.creditsButton);
        creditsbutton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CreateNotification();
                }
            }
        );


        //Exit Button
        Button exitbutton = (Button) findViewById(R.id.exitButton);
        exitbutton.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            }
        );

    }
}
