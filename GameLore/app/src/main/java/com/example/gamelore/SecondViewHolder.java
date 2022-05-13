package com.example.gamelore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
        loadImage(data.getImg_url(), activity);
    }

    private void cancelPreviousImageDownloadIfAny() {
    }

    private void loadImage(String img_url, Activity activity) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap image = getBitmapFromURL(img_url);
                imageView.setImageBitmap(image);
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
            Bitmap resultBitmap = BitmapFactory.decodeStream(input);
            return resultBitmap;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}