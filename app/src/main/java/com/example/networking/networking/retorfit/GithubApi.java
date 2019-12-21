package com.example.networking.networking.retorfit;

import com.example.networking.model.Githuber;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubApi {

    @GET("/users")
    Call<List<Githuber>> getAllUsers();

}
