package Fragments;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.elsapp.els.R;
import com.wooplr.spotlight.SpotlightView;
import com.wooplr.spotlight.utils.SpotlightListener;
import com.wooplr.spotlight.utils.SpotlightSequence;

import Utility.SessionManager;

/**
 * Created by sibby on 9/6/17.
 */

public class HomeInto extends Fragment {
    SpotlightView spotlightView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_home_intro, container, false);
        SessionManager.putStringInPreferences(getContext(),"null","city");
        SessionManager.putStringInPreferences(getContext(),"null","gender");
        SessionManager.putStringInPreferences(getActivity(),"null","car_type");
        SessionManager.putStringInPreferences(getActivity(),"null","bike_type");

        final ImageView slide = (ImageView) view.findViewById(R.id.slide);
        slide.setVisibility(View.INVISIBLE);
        spotlightView = new SpotlightView.Builder(getActivity())
                .introAnimationDuration(400)
                .enableRevealAnimation(true)
                .performClick(true)
                .fadeinTextDuration(400)
                .headingTvColor(Color.parseColor("#E0F2F1"))
                .headingTvSize(26)
                .headingTvText("Slide")
                .subHeadingTvColor(Color.parseColor("#f0f0f0"))
                .subHeadingTvSize(18)
                .subHeadingTvText("Open the drawer\nfor extra options")
                .maskColor(Color.parseColor("#dc000000"))
                .target(slide)
                .lineAnimDuration(400)
                .lineAndArcColor(Color.parseColor("#349999"))
                .dismissOnTouch(true)
                .dismissOnBackPress(true)
                .enableDismissAfterShown(true)
                .usageId("slide") //UNIQUE ID
                .show();

        spotlightView.setListener(new SpotlightListener() {
            @Override
            public void onUserClicked(String s) {
                slide.setVisibility(View.INVISIBLE);
            }
        });
        return view;

    }
}
