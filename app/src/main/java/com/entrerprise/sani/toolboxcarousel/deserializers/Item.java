package com.entrerprise.sani.toolboxcarousel.deserializers;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;
    @SerializedName("video")
    public String video;

    public Item(String title, String url, String video) {
        this.title = title;
        this.url = url;
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getVideo() {
        return video;
    }
}
