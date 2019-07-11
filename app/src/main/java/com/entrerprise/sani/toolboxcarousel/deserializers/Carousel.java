package com.entrerprise.sani.toolboxcarousel.deserializers;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Carousel {

    @SerializedName("title")
    private String title;
    @SerializedName("type")
    private String type;
    @SerializedName("Items")
    private ArrayList<Item> items;

    public Carousel(String title, String type, ArrayList<Item> items) {
        this.title = title;
        this.type = type;
        this.items = items;
    }


    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
