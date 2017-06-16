package Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

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


        ImageView male = (ImageView) view.findViewById(R.id.malecheck);
        ImageView female = (ImageView) view.findViewById(R.id.femalecheck);
        Button others=(Button) view.findViewById(R.id.others);

        ad = ((HomeLoan)getActivity()).getCurrAdapter();
        viewPager = ((HomeLoan)getActivity()).getViewPager();


        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SessionManager.putStringInPreferences(getActivity(),"Male","gender");
                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {
                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();




                }


                ad.addFragment(new DOB(), "DOB");
                ad.notifyDataSetChanged();
                Log.d("1", SessionManager.getStringFromPreferences(getContext(),"gender").toString());

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);


            }
        });


        female.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionManager.putStringInPreferences(getActivity(),"Female","gender");
                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {
                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();




                }


                ad.addFragment(new DOB(), "DOB");
                ad.notifyDataSetChanged();
                Log.d("1", SessionManager.getStringFromPreferences(getContext(),"gender").toString());
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

            }
        });


        others.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                SessionManager.putStringInPreferences(getActivity(),"Others","gender");

                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {
                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();




                }


                ad.addFragment(new DOB(), "DOB");
                ad.notifyDataSetChanged();
                Log.d("1", SessionManager.getStringFromPreferences(getContext(),"gender").toString());

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

            }


        });


        return view;

    }


}
