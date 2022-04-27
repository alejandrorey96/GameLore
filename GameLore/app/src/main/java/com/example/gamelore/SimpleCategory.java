package com.example.gamelore;

import org.json.JSONException;
import org.json.JSONObject;


public class SimpleCategory {
    private String id;
    private String name;

    public SimpleCategory(JSONObject objectJson) throws JSONException {
        this.id = objectJson.getString("id");
        this.name= objectJson.getString("name");
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}