package Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

/**
 * Created by sibby on 9/6/17.
 */

public class HomePropLoc extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_home_proploc, container, false);


        CheckBox mumbai = (CheckBox)view.findViewById(R.id.mumbai);
        CheckBox delhi = (CheckBox) view.findViewById(R.id.delhi);
        ImageView others = (ImageView) view.findViewById(R.id.others);
        TextView t1 = (TextView) view.findViewById(R.id.prev);
        TextView t2 = (TextView) view.findViewById(R.id.next);
        EditText editothers = (EditText) view.findViewById(R.id.editothers);
        final ViewPager viewPager = ((HomeLoan)getActivity()).getViewPager();
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });
        return view;

    }
}
