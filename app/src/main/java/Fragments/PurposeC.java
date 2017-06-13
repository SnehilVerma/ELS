package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.CarLoanActivity.ViewPagerAdapter;
import com.elsapp.els.R;



public class PurposeC extends Fragment {
    Button personal,business;

    ViewPagerAdapter ad;
    ViewPager viewPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View x = inflater.inflate(R.layout.fragment_car_purpose, container, false);
        personal = (Button) x.findViewById(R.id.pers);
        business =(Button) x.findViewById(R.id.buss);

        ad=((CarLoanActivity)getActivity()).getCurrAdapter();
        viewPager = ((CarLoanActivity)getActivity()).getViewPager();



        personal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.mFragmentList.add(new PrefCar());
                ad.mFragmentTitleList.add("PrefCar");
                ad.notifyDataSetChanged();
            }
        });

        business.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.mFragmentList.add(new PrefCar());
                ad.mFragmentTitleList.add("PrefCar");
                ad.notifyDataSetChanged();
            }
        });




        return x;
    }





}
