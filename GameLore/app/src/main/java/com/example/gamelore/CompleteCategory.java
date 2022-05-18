package com.example.gamelore;

import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

public class CompleteCategory {
    private String id;
    private String name;
    private String description;
    private Boolean is_locked;
    private String image_url;
    private String character;
    private String arena;

    public CompleteCategory(JSONObject objectJason) throws JSONException {
        this.id = objectJason.getString("id");
        this.name = objectJason.getString("name");
        this.description = objectJason.getString("description");
        this.is_locked = objectJason.getBoolean("is_locked");
        this.image_url = objectJason.getString("image_url");
        if(character!= null){
            this.character = objectJason.getString("character");
        }else {
            this.character = "";
        }
        if(arena!= null) {
            this.arena = objectJason.getString("arena");
        }else {
            this.arena = "";
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Nullable
    public Boolean getIs_locked() {
        return is_locked;
    }

    public String getImage_url() {
        return image_url;
    }

    @Nullable
    public String getCharacter() {
        return character;
    }

    @Nullable
    public String getArena() {
        return arena;
    }
}
