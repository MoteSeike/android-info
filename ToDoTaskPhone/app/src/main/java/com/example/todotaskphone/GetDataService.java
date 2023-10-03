package com.example.todotaskphone;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GetDataService {
    @POST("usertask")
        //on below line we are creating a method to post our data.
    Call<RetroUserTask> createPost(@Body RetroUserTask dataModal);
}
