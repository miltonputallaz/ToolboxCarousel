package com.entrerprise.sani.toolboxcarousel.fragments.Home;

import com.entrerprise.sani.toolboxcarousel.adapter.CarouselAdapter;
import com.entrerprise.sani.toolboxcarousel.adapter.PosterCarouselAdapter;
import com.entrerprise.sani.toolboxcarousel.adapter.ThumbCarouselAdapter;
import com.entrerprise.sani.toolboxcarousel.deserializers.Carousel;
import com.entrerprise.sani.toolboxcarousel.utils.GsonDeseralizer;

import java.util.ArrayList;

public class HomePresenter  implements HomeContract.Presenter {
    HomeView homeView;
    private ArrayList<Carousel> carousels ;
    private ArrayList<CarouselAdapter> adaptersCollection;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
    }

    private ArrayList<Carousel> getCarousels() {
        return GsonDeseralizer.deserealizeCarouselArray("Movies.json", homeView.getContext());
    }

    @Override
    public ArrayList<CarouselAdapter> getCarouseAdapters() {
        adaptersCollection = new ArrayList<>();
        carousels = getCarousels();
        for (int i=0; i < carousels.size(); i++){
            Carousel carousel = carousels.get(i);
            CarouselAdapter carouselAdapter = null;
            if (carousel.getType().equals("poster")){
                carouselAdapter  = new PosterCarouselAdapter(carousel.getItems(),homeView.getActivity());
            } else {
                carouselAdapter = new ThumbCarouselAdapter(carousel.getItems(),homeView.getActivity());
            }
            adaptersCollection.add(carouselAdapter);
        }

        return adaptersCollection;

    }
}
