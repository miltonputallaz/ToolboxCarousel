package com.entrerprise.sani.toolboxcarousel.utils;

import android.content.Context;

import com.entrerprise.sani.toolboxcarousel.deserializers.Carousel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public final class GsonDeseralizer {

    private GsonDeseralizer() {
    }

    public static ArrayList<Carousel> deserealizeCarouselArray(String filename, Context context){
        Gson gson = new GsonBuilder().create();
        String myJson= JsonUtils.inputStreamToString(context,filename);
        Type founderListType = new TypeToken<ArrayList<Carousel>>(){}.getType();

        return gson.fromJson(myJson, founderListType);
    }
}
