package com.example.gamelore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class SecondViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;
    private final ImageView imageView;

    public SecondViewHolder(@NonNull View itemView){
        super(itemView);
        textView =  itemView.findViewById(R.id.second_text_view);
        imageView = itemView.findViewById(R.id.second_image_view);
    }

    public void showData(CompleteCategory data, Activity activity){
        textView.setText(data.getName());
        cancelPreviousImageDownloadIfAny();
        loadImage(data.getImage_url(),this.imageView,activity);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap image = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                Intent intent= new Intent (activity,DetailActivity.class);
                intent.putExtra("name", data.getName());
                intent.putExtra("description", data.getDescription());
                intent.putExtra("arena", data.getArena());
                intent.putExtra("character", data.getCharacter());
                intent.putExtra("is_locked", data.getIs_locked());
                intent.putExtra("image_url", data.getImage_url());
                activity.startActivity(intent);
            }
        });
    }

    private void cancelPreviousImageDownloadIfAny() {
    }

    private void loadImage(String img_url, ImageView imageView, Activity activity) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap image = getBitmapFromURL(img_url);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(image);
                    }
                });
            }
        });
        thread.start();
    }

    private Bitmap getBitmapFromURL(String urlString){
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}