package Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.elsapp.els.R;
import com.wooplr.spotlight.SpotlightView;
import com.wooplr.spotlight.utils.SpotlightListener;

import Utility.SessionManager;

/**
 * Created by sibby on 12/6/17.
 */

public class VehIntro extends Fragment {
    SpotlightView spotlightView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_vehicle_intro, container, false);
        SessionManager.putStringInPreferences(getActivity(),"null","vehicle_type");
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
                .subHeadingTvText("Slide to open\nthe next page")
                .maskColor(Color.parseColor("#dc000000"))
                .target(slide)
                .lineAnimDuration(400)
                .lineAndArcColor(Color.parseColor("#349999"))
                .dismissOnTouch(true)
                .dismissOnBackPress(true)
                .enableDismissAfterShown(true)
                .usageId("slide1") //UNIQUE ID
                .show();
       /* if(spotlightView.getVisibility() == View.VISIBLE){
            slide.setVisibility(View.VISIBLE);
            Toast.makeText(getActivity(),"hi1",Toast.LENGTH_LONG).show();
        }*/
        spotlightView.setListener(new SpotlightListener() {
            @Override
            public void onUserClicked(String s) {
                slide.setVisibility(View.INVISIBLE);
            }
        });
        if(spotlightView.getRootView().isShown()){
            slide.setVisibility(View.VISIBLE);
            //Toast.makeText(getActivity(),"hi",Toast.LENGTH_LONG).show();
        }
        /*TextView t2 = (TextView) view.findViewById(R.id.next);
        final ViewPager viewPager = ((HomeLoan)getActivity()).getViewPager();
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });*/

        return view;

    }
}
