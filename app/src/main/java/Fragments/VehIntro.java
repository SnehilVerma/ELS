package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elsapp.els.R;

/**
 * Created by sibby on 12/6/17.
 */

public class VehIntro extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_vehicle_intro, container, false);

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