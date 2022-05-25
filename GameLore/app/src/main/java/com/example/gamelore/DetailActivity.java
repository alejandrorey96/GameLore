package com.example.gamelore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends MenuSwitch {

    AppCompatActivity activity = new AppCompatActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String vName = getIntent().getExtras().getString("name");
        String vImage = getIntent().getExtras().getString("image_url");
        String vDescription = getIntent().getExtras().getString("description");
        String vArena = getIntent().getExtras().getString("arena");
        String vCharacter = getIntent().getExtras().getString("character");
        Boolean vIs_locked  = getIntent().getExtras().getBoolean("is_locked");

        if(vIs_locked!= false) {
            TextView name = findViewById(R.id.name);
            name.setText(vName);
            ImageView image = findViewById(R.id.image_from_url);
            GetImage picture = new GetImage();
            picture.loadImage(vImage,image,activity);
            TextView description = findViewById(R.id.description);
            description.setText(vDescription);
            TextView other = findViewById(R.id.other);
            if (vArena != "") {
                other.setText(vArena);
            } else if (vCharacter != "") {
                other.setText(vCharacter);
            } else {
                other.setText("");
            }
        }else{
            Toast.makeText(this, "You didn't discover this yet. Unlock it in-game first to see the content.", Toast.LENGTH_SHORT).show();
        }

    }

}