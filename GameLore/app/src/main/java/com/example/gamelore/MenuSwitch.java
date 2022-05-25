package com.example.gamelore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MenuSwitch extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        Intent intent = new Intent(getApplicationContext(), SecondMenu.class);

        switch (item.getItemId()){
            case R.id.planets:
                intent.putExtra("id", "planets");
                startActivity(intent);
                return true;
            case R.id.characters:
                intent.putExtra("id", "characters");
                startActivity(intent);
                return true;
            case R.id.objects:
                intent.putExtra("id", "objects");
                startActivity(intent);
                return true;
            case R.id.abilities:
                intent.putExtra("id", "abilities");
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
