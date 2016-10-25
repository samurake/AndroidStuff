package com.itst.onebutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * ITst Android training March 2016
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void search(View v){
        EditText searchText = (EditText) findViewById(
                                            R.id.search_text);
        String searchString = searchText.getText().toString();

        Intent i = new Intent(MainActivity.this,
                SearchResultsActivity.class);
        i.putExtra("searchString", searchString);
        startActivity(i);
    }
}
