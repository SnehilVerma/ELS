package Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

/**
 * Created by snehil on 9/6/17.
 */

public class Gender extends Fragment {
    HomeLoan.ViewPagerAdapter ad;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_gender, container, false);


        ImageView male = (ImageView) view.findViewById(R.id.male);
        ImageView female = (ImageView) view.findViewById(R.id.female);
        CheckBox malecheck = (CheckBox) view.findViewById(R.id.malecheck);
        CheckBox femalecheck = (CheckBox) view.findViewById(R.id.femalecheck);
        ad = ((HomeLoan)getActivity()).getCurrAdapter();
        viewPager = ((HomeLoan)getActivity()).getViewPager();

        Button b1 = (Button) view.findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {
                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();

                    //sessionManager.putStringInPreferences(getActivity(),text.toString(),"city");


                }


                ad.addFragment(new DOB(), "DOB");
                ad.notifyDataSetChanged();
                //Log.d("1", editothers.getText().toString());
            }
        });
        return view;

    }


}
