package com.example.gamelore;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    private List<SimpleCategory> allTheData;
    private Activity activity;

    public MenuRecyclerViewAdapter(List<SimpleCategory> dataSet, Activity activity){
        this.allTheData = dataSet;
        this.activity = activity;
    }

    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_menu_view_holder, parent, false);
        return new MenuViewHolder(view);
    }

    public void onBindViewHolder( MenuViewHolder holder, int position){
        SimpleCategory dataInPositionToBeRendered = allTheData.get(position);
        holder.showData(dataInPositionToBeRendered, activity);
    }

    @Override
    public int getItemCount() {
        return allTheData.size();
    }
}
