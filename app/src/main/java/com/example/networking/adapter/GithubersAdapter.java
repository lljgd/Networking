package com.example.networking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networking.model.Githuber;
import com.example.networking.R;

import java.util.List;

public class GithubersAdapter extends RecyclerView.Adapter<GithuberViewHolder> {

    private List<Githuber> githubers;

    public GithubersAdapter(List<Githuber> githubers) {
        this.githubers = githubers;
    }

    @NonNull
    @Override
    public GithuberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_githuber, parent, false);
        return new GithuberViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GithuberViewHolder holder, int position) {
        holder.bindTo(githubers.get(position));
    }

    @Override
    public int getItemCount() {
        return githubers.size();
    }
}

