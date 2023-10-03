package com.example.todotasktvview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {
    @GET("usertask")
        //on below line we are creating a method to post our data.
    Call<List<RetroUserTask>> getAllUserTask( );
}
