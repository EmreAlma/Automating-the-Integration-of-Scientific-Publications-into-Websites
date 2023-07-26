package com.example.pubsync.model;

import com.google.gson.annotations.SerializedName;

public class Time{

    @SerializedName("@unit")
    private String unit;

    @SerializedName("text")
    private String text;

    public void setUnit(String unit){
        this.unit = unit;
    }

    public String getUnit(){
        return unit;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
}