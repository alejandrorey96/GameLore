package com.example.gamelore;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;

    public MenuViewHolder(@NonNull View itemView){
        super(itemView);
        textView = itemView.findViewById(R.id.text_category);
    }

    public void showData(SimpleCategory data, Activity activity){
        textView.setText(data.getName());
        textView.setText(data.getId());
    }

}