package com.example.gamelore;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SecondRecyclerViewAdapter extends RecyclerView.Adapter<SecondViewHolder> {

    private List<CompleteCategory> allTheData;
    private Activity activity;

    public SecondRecyclerViewAdapter(List<CompleteCategory> dataSet, Activity activity){
        this.allTheData = dataSet;
        this.activity = activity;
    }

    @NonNull
    public SecondViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_second_view_holder, parent, false);
        return new SecondViewHolder((view));
    }

    public void  onBindViewHolder(SecondViewHolder holder, int position){
        CompleteCategory dataInPositionToBeRendered = allTheData.get(position);
        holder.showData(dataInPositionToBeRendered, activity);
    }

    @Override
    public int getItemCount() {
        return allTheData.size();
    }
}
