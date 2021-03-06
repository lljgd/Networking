package com.example.networking;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.networking.adapter.GithubersAdapter;
import com.example.networking.model.Githuber;
import com.example.networking.networking.okhttp.NetworkingWithOkHttp;
import com.example.networking.networking.retorfit.NetworkingWithRetrofit;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        new InternetRequestTask().execute();
    }

    @MainThread
    private void applyGithubers(List<Githuber> githubers) {
        recyclerView.setAdapter(new GithubersAdapter(githubers));
    }

    @WorkerThread
    private List<Githuber> executeRequest() {
//        return NetworkingWithOkHttp.makeRequest();
        return NetworkingWithRetrofit.makeRequest();
    }

    private class InternetRequestTask extends AsyncTask<Void, Void, List<Githuber>> {

        @Override
        protected List<Githuber> doInBackground(Void... voids) {
            return executeRequest();
        }

        @Override
        protected void onPostExecute(List<Githuber> githubers) {
            applyGithubers(githubers);
        }
    }
}
