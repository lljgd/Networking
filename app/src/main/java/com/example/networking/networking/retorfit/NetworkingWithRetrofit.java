package com.example.networking.networking.retorfit;

import com.example.networking.model.Githuber;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkingWithRetrofit {
    public static List<Githuber> makeRequest() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubApi api = retrofit.create(GithubApi.class);

        Call<List<Githuber>> call = api.getAllUsers();

        try {

            return call.execute().body();

        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
    }
}
