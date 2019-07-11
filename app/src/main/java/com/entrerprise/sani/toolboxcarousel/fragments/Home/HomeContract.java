package com.entrerprise.sani.toolboxcarousel.fragments.Home;

import com.entrerprise.sani.toolboxcarousel.adapter.CarouselAdapter;
import com.entrerprise.sani.toolboxcarousel.deserializers.Carousel;

import java.util.ArrayList;

public interface HomeContract {

    interface View {
        void onViewIsReady();
    }

    interface Presenter {
        ArrayList<CarouselAdapter> getCarouseAdapters();
    }
}
