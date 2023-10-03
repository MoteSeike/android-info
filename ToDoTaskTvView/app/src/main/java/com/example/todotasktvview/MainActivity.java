package com.example.todotasktvview;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import java.net.URI;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends FragmentActivity {
    ListView superListView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        superListView = findViewById(R.id.superListView);
//        URI serverUri = URI.create("ws://http://54.179.12.215:3005/usertask");
//        MyWebSocketClient webSocketClient = new MyWebSocketClient(serverUri);
//        webSocketClient.connect();
//
//// To send a message to the server
//        webSocketClient.send("Hello, server!");
        getSuperHeroes();
    }

    private void getSuperHeroes() {
        GetDataService service= RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<RetroUserTask>> call = service.getAllUserTask();
        call.enqueue(new Callback<List<RetroUserTask>>() {
            @Override
            public void onResponse(Call<List<RetroUserTask>> call, Response<List<RetroUserTask>> response) {
                List<RetroUserTask> myheroList = response.body();
//                RetroUserTask [] oneHeroes = new String[myheroList.size()];
//                for (int i = 0; i < myheroList.size(); i++) {
//                    oneHeroes[i] = myheroList.get(i).getUserName();
//                }
                Log.i("Name",myheroList.get(0).getUserName());

               // superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));
                CustomViewAdapter numbersArrayAdapter = new CustomViewAdapter(getApplicationContext(),myheroList.size(), myheroList);
                ListView customListView = findViewById(R.id.superListView);

                // set the numbersViewAdapter for ListView
                superListView.setAdapter(numbersArrayAdapter);
            }

            @Override
            public void onFailure(Call<List<RetroUserTask>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
                Log.d("Error",t.getMessage());
            }

        });
    }
}