package com.entrerprise.sani.toolboxcarousel.fragments.VideoPlayer;

public class VideoPlayerPresenter implements VideoPlayerContract.Presenter{
    private VideoPlayerView videoPlayerView;

    public VideoPlayerPresenter(VideoPlayerView videoPlayerView) {
        this.videoPlayerView = videoPlayerView;
    }
}
