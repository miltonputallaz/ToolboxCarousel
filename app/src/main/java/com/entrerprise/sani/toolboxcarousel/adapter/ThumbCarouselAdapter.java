package com.entrerprise.sani.toolboxcarousel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.entrerprise.sani.toolboxcarousel.R;
import com.entrerprise.sani.toolboxcarousel.deserializers.Item;

import java.util.ArrayList;

public class ThumbCarouselAdapter extends CarouselAdapter{

    public ThumbCarouselAdapter(ArrayList<Item> carouselItems, Context context) {
        super(carouselItems, context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {

        View v;
        v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.thumb_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



}
