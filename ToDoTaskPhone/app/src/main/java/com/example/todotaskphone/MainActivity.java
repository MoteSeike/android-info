package com.example.todotaskphone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    EditText username,
            reg_firstName, reg_lastName, reg_email;
    Button reg_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.reg_username);
        reg_firstName = findViewById(R.id.reg_firstName);
        reg_lastName = findViewById(R.id.reg_lastName);
        reg_email = findViewById(R.id.reg_email);
        reg_register = findViewById(R.id.reg_register);
        reg_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              postData(username.getText().toString(),reg_firstName.getText().toString(),reg_lastName.getText().toString(),reg_email.getText().toString());
            }
        });
    }

    private void postData(String name, String task,String taskDate,String description) {

        GetDataService retrofitAPI = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        // passing data from our text fields to our modal class.
        RetroUserTask modal = new RetroUserTask(name, task,taskDate,description);

        // calling a method to create a post and passing our modal class.
        Call<RetroUserTask> call = retrofitAPI.createPost(modal);

        // on below line we are executing our method.
        call.enqueue(new Callback<RetroUserTask>() {
            @Override
            public void onResponse(Call<RetroUserTask> call, Response<RetroUserTask> response) {
                // this method is called when we get response from our api.
                Toast.makeText(MainActivity.this, "Data added to API", Toast.LENGTH_SHORT).show();
                // we are getting response from our body
                // and passing it to our modal class.
                RetroUserTask responseFromAPI = response.body();

                // on below line we are getting our data from modal class and adding it to our string.
//                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName() + "\n" + "Job : " + responseFromAPI.getJob();
//
            }

            @Override
            public void onFailure(Call<RetroUserTask> call, Throwable t) {
                Log.d("Debug",t.getMessage());
                Toast.makeText(MainActivity.this, "Data added to API Failure"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}