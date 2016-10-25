package com.itst.onebutton.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by samur on 19.03.2016.
 */
public interface StackOverflowService {

    @GET("/2.2/search?site=stackoverflow")
    Call<SearchResponse> search(@Query("intitle") String query);
}
