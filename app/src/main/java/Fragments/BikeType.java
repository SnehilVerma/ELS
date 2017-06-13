package Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.CarLoanActivity.ViewPagerAdapter;
import com.elsapp.els.R;

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



        ImageButton im1=(ImageButton) view.findViewById(R.id.im1);
        ImageButton im2=(ImageButton)view.findViewById(R.id.im2);

        ad=((CarLoanActivity)getActivity()).getCurrAdapter();
        viewPager = ((CarLoanActivity)getActivity()).getViewPager();




        im1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                //TESTING

                //ad.addFragment(new Gender(), "Gender");
                //ad.notifyDataSetChanged();


                ad.mFragmentList.add(new DOB());
                ad.mFragmentTitleList.add("DOB");
                ad.notifyDataSetChanged();



            }
        });

        im2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                ad.mFragmentList.remove(viewPager.getCurrentItem()+1);
                ad.mFragmentTitleList.remove("DOB");


                ad.mFragmentList.add(new Gender());
                ad.mFragmentTitleList.add("Gender");
                // ad.notifyDataSetChanged();




            }
        });

        return view;

    }

}

