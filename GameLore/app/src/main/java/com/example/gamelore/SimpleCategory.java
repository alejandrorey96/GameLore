package com.example.gamelore;

import org.json.JSONException;
import org.json.JSONObject;


public class SimpleCategory {
    private String name;
    private String id;

    public SimpleCategory(JSONObject objectJson){
        try {
            this.name= objectJson.getString("name");
            this.id = objectJson.getString("id");
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