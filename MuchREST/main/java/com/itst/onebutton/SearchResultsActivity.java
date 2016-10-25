package com.itst.onebutton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.itst.onebutton.data.Question;
import com.itst.onebutton.data.SearchResponse;
import com.itst.onebutton.data.StackOverflowService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        Intent i = getIntent();
        String searchString = i.getStringExtra("searchString");



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        StackOverflowService service = retrofit.create(StackOverflowService.class);

        Call<SearchResponse> searchCall = service.search(searchString);
        searchCall.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                setData(response.body().items);
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Toast.makeText(SearchResultsActivity.this, "You don't have money for an Internet Connection?",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void setData(ArrayList<Question> questions){
        ListView listView = (ListView) findViewById(R.id.listView);
        SearchResultsAdaptor adaptor = new SearchResultsAdaptor(questions);
        listView.setAdapter(adaptor);
    }


}
