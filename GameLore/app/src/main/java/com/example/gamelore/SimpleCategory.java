package com.example.gamelore;

import org.json.JSONException;
import org.json.JSONObject;


public class SimpleCategory {
    private String id;
    private String name;

    public SimpleCategory(JSONObject objectJson){
        try {
            this.id = objectJson.getString("id");
            this.name= objectJson.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

}