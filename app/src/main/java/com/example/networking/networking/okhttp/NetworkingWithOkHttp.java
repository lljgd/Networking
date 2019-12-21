package com.example.networking.networking.okhttp;

import android.util.Log;

import com.example.networking.model.Githuber;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkingWithOkHttp {
    public static List<Githuber> makeRequest() {
        // Request
        Request request = new Request.Builder()
                .url("https://api.github.com/users")
                .build();

        // Execute request

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);

        String stringResponse = null;

        try {
            Response response = call.execute();
            stringResponse = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.e("asdfsa", stringResponse);

        // Parse response

        Type crimesListType = new TypeToken<List<Githuber>>(){}.getType();
        List<Githuber> result = new Gson().fromJson(stringResponse, crimesListType);

        return result;
    }
}
