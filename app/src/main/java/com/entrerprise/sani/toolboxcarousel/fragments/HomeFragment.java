package com.entrerprise.sani.toolboxcarousel.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.entrerprise.sani.toolboxcarousel.R;
import com.entrerprise.sani.toolboxcarousel.adapter.CarouselAdapter;
import com.entrerprise.sani.toolboxcarousel.adapter.PosterCarouselAdapter;
import com.entrerprise.sani.toolboxcarousel.adapter.ThumbCarouselAdapter;
import com.entrerprise.sani.toolboxcarousel.deserializers.Carousel;
import com.entrerprise.sani.toolboxcarousel.deserializers.Item;
import com.entrerprise.sani.toolboxcarousel.utils.GsonDeseralizer;
import com.entrerprise.sani.toolboxcarousel.utils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<Carousel> carousels ;
    private LinearLayout linearLayout;
    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carousels = GsonDeseralizer.deserealizeCarouselArray("Movies.json", getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        linearLayout = (LinearLayout) view.findViewById(R.id.linear_layout);
        initializeUI();
        return view;
    }



    private void initializeUI() {
        for (int i=0; i < carousels.size(); i++){
            Carousel carousel = carousels.get(i);
            CarouselAdapter carouselAdapter = null;
            if (carousel.getType().equals("poster")){
                carouselAdapter  = new PosterCarouselAdapter(carousel.getItems(),getActivity());
            } else {
                carouselAdapter = new ThumbCarouselAdapter(carousel.getItems(),getActivity());
            }
            addNewCarousel(carouselAdapter);
        }

    }

    private void addNewCarousel(CarouselAdapter carouselAdapter){
        RecyclerView recyclerView = new RecyclerView(getActivity());
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.WRAP_CONTENT);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(carouselAdapter);
        recyclerView.setLayoutParams(layoutParams);
        linearLayout.addView(recyclerView);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
