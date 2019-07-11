package com.entrerprise.sani.toolboxcarousel.fragments.VideoPlayer;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.entrerprise.sani.toolboxcarousel.R;


public class VideoPlayerView extends Fragment implements VideoPlayerContract.View{
    private String videoUrl = null;
    private LinearLayout linearLayout = null;
    private OnFragmentInteractionListener mListener;
    private ProgressDialog progDailog;
    private VideoPlayerPresenter videoPlayerPresenter;

    public VideoPlayerView() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        videoPlayerPresenter = new VideoPlayerPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_video_player, container, false);
        linearLayout =  (LinearLayout) v.findViewById(R.id.linear_layout_video);
        Bundle bundle = getArguments();
        videoUrl = bundle.getString("video_url");
        onViewIsReady();
        return v;
    }

    @Override
    public void onViewIsReady() {
        if (videoUrl!=null && !videoUrl.isEmpty())
            showVideoPlayer();
        else
            showVideoUnabled();
    }


    private void showVideoPlayer(){
        showLoadingVideoDialog();
        VideoView videoView = new VideoView(getActivity());
        linearLayout.addView(videoView);
        linearLayout.setGravity(Gravity.CENTER);
        videoView.setVideoURI(Uri.parse(videoUrl));
        videoView.requestFocus();
        videoView.start();
        MediaController mediaController = new MediaController(getActivity());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                dismissLoadingVideoDialog();
            }
        });
    }

    private void showVideoUnabled() {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.unable_video_resource);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        textView.setTextColor(getActivity().getResources().getColor(R.color.white));
        linearLayout.addView(textView);
        linearLayout.setGravity(Gravity.CENTER);
        textView.setGravity(Gravity.CENTER);
    }


    private void showLoadingVideoDialog(){
        progDailog = ProgressDialog.show(
                getActivity(),
                getActivity().getString(R.string.please_wait),
                getActivity().getString(R.string.retrieving_data),
                true);
    }

    private void dismissLoadingVideoDialog(){
        progDailog.dismiss();
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
