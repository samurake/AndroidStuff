package corporation.chiriestudio.myfirstcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button startButton = (Button) findViewById(R.id.startButton);
        Button exitButton = (Button) findViewById(R.id.exitButton);

        startButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent("percentageCalculator");
                    startActivity(intent);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                finish();
            }
        });
    }

}
