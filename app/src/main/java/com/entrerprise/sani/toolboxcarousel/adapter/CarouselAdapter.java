package com.entrerprise.sani.toolboxcarousel.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.entrerprise.sani.toolboxcarousel.MainActivity;
import com.entrerprise.sani.toolboxcarousel.R;
import com.entrerprise.sani.toolboxcarousel.deserializers.Item;
import com.entrerprise.sani.toolboxcarousel.fragments.VideoPlayerFragment;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public abstract class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.ViewHolder> {

    private ArrayList<Item> carouselItems;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView movie_name;
        private ImageView movie_image;
        public ViewHolder(final View itemView) {
            super(itemView);
            movie_name = (TextView) itemView.findViewById(R.id.movie_name);
            movie_image = (ImageView) itemView.findViewById(R.id.movie_image);

        }
    }


    public CarouselAdapter(ArrayList<Item> carouselItems, Context context) {
        this.carouselItems = carouselItems;
        this.context = context;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Item item = carouselItems.get(position);
        holder.movie_image.setImageDrawable(null);
        Picasso.get().load(item.getUrl())
                .networkPolicy(NetworkPolicy.NO_CACHE,NetworkPolicy.NO_STORE)
                .memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE)
                .fit()
                .noFade()
                .into(holder.movie_image);

        holder.movie_name.setText(item.getTitle());

        final String video_url = item.getVideo();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVideoPlayer(video_url);
            }
        });

    }


    @Override
    public int getItemCount() {
        return carouselItems.size();
    }

    private void goToVideoPlayer(String url){
        Bundle bundle = new Bundle();
        bundle.putString("video_url",url);
        VideoPlayerFragment vpf = new VideoPlayerFragment();
        vpf.setArguments(bundle);
        MainActivity activity = ((MainActivity) this.context);
        FragmentManager fragmentManager= activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,vpf).addToBackStack(null);
        transaction.commit();
    }
}