package com.entrerprise.sani.toolboxcarousel.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public final class JsonUtils {

    private JsonUtils() {
    }

    public static  String inputStreamToString(Context context, String fileName) {
        String json = null;
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

}
