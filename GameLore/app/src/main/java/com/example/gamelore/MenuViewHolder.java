package com.example.gamelore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MenuViewHolder extends RecyclerView.ViewHolder{

    private String id;
    private final TextView textView;
    private final View menuViewHolder;

    public MenuViewHolder(@NonNull View itemView){
        super(itemView);
        textView = itemView.findViewById(R.id.text_category);
        menuViewHolder = (View) itemView.findViewById(R.id.menu_view_holder);
    }

    public void showData(SimpleCategory data, Activity activity){
        textView.setText(data.getName());
        this.id = data.getId();
        menuViewHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity.getApplicationContext(), SecondMenu.class);
                intent.putExtra("id", id);
                activity.startActivity(intent);
            }
        });
    }
}