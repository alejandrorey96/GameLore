package com.example.gamelore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SecondMenu extends AppCompatActivity {

    /*private final String planetURL = "https://raw.githubusercontent.com/alejandrorey96/GameLore/master/GameLore/data/categories/planets.json";
    private final String characterURL = "https://raw.githubusercontent.com/alejandrorey96/GameLore/master/GameLore/data/categories/characters.json";
    private final String objectURL = "https://raw.githubusercontent.com/alejandrorey96/GameLore/master/GameLore/data/categories/objects.json";
    private final String abilityURL = "https://raw.githubusercontent.com/alejandrorey96/GameLore/master/GameLore/data/categories/abilities.json";
    private String url = "";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_menu);

        RecyclerView recyclerView = findViewById(R.id.recycler_view2);
        Activity activity = this;

        String valor = getIntent().getExtras().getString("id");
        Toast.makeText(activity, valor, Toast.LENGTH_SHORT).show();

        String url = "https://raw.githubusercontent.com/alejandrorey96/GameLore/master/GameLore/data/categories/"+valor+".json";

        /*switch (valor){
            case "planets": url=planetURL;
                break;
            case "characters": url=characterURL;
                break;
            case "objects": url=objectURL;
                break;
            case "abilities": url=abilityURL;
                break;
        }*/

        JsonObjectRequest categoryRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        List<CompleteCategory> categoryList = null;
                        try {
                            JSONArray categoryArray = response.getJSONArray(valor);
                            categoryList = new ArrayList<>();

                            for (int i = 0; i < categoryArray.length(); i++) {

                                JSONObject object = categoryArray.getJSONObject(i);
                                CompleteCategory data = new CompleteCategory(object);
                                categoryList.add(data);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        SecondRecyclerViewAdapter adapter = new SecondRecyclerViewAdapter(categoryList, activity);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show();

                    }
                });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(categoryRequest);
    }
}