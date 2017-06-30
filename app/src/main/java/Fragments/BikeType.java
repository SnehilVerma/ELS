package Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.CarLoanActivity.ViewPagerAdapter;
import com.elsapp.els.R;

import Utility.SessionManager;

import static Utility.SessionManager.putStringInPreferences;

/**
 * Created by snehil on 13/6/17.
 */

public class BikeType extends Fragment {





    ViewPagerAdapter ad;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_bike_type, container, false);



        ImageView im1=(ImageView) view.findViewById(R.id.im1);
        ImageView im2=(ImageView)view.findViewById(R.id.im2);
        final ProgressBar pb = ((CarLoanActivity)getActivity()).getPb();
        final TextView progress = ((CarLoanActivity)getActivity()).getprogresstv();

        ad=((CarLoanActivity)getActivity()).getCurrAdapter();
        viewPager = ((CarLoanActivity)getActivity()).getViewPager();




        im1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                SessionManager.putStringInPreferences(getActivity(),"MotorCycle","bike_type");


                int index=(viewPager.getCurrentItem())+1;
                if(index<ad.mFragmentList.size()) {

                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();

                }


                ad.addFragment(new PrefBike(), "PrefBike");
                ad.notifyDataSetChanged();

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                pb.setProgress(30);

                progress.setText(String.valueOf(30));




            }
        });

        im2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                putStringInPreferences(getActivity(),"Scooter","bike_type");


                int index=(viewPager.getCurrentItem())+1;
                if(index<ad.mFragmentList.size()) {

                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();

                }


                ad.addFragment(new PrefBike(), "PrefBike");
                ad.notifyDataSetChanged();

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                pb.setProgress(30);

                progress.setText(String.valueOf(30));




            }
        });

        return view;

    }

}

