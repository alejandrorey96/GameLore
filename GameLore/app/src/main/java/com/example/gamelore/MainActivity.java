package com.example.gamelore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String url = "https://raw.githubusercontent.com/alejandrorey96/GameLore/master/GameLore/data/categories.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        Activity activity = this;


        JsonObjectRequest categoryRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        List<SimpleCategory> categoryList = null;
                        try {
                            JSONArray categoryArray = response.getJSONArray("categories");
                            categoryList = new ArrayList<>();

                            for (int i = 0; i < categoryArray.length(); i++) {

                                JSONObject category = categoryArray.getJSONObject(i);
                                SimpleCategory data = new SimpleCategory(category);
                                categoryList.add(data);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        MenuRecyclerViewAdapter adapter = new MenuRecyclerViewAdapter(categoryList, activity);
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