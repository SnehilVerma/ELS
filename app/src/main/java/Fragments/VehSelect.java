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

import static com.elsapp.els.R.id.im1;

/**
 * Created by Rishi on 6/9/2017.
 */

public class VehSelect extends Fragment {


    ViewPagerAdapter ad;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_veh_type, container, false);


        ImageButton ib1=(ImageButton)view.findViewById(im1);
        ImageButton ib2=(ImageButton)view.findViewById(R.id.im2);

        ad=((CarLoanActivity)getActivity()).getCurrAdapter();
        viewPager = ((CarLoanActivity)getActivity()).getViewPager();


        ib1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.mFragmentList.add(new BikeType());
                ad.mFragmentTitleList.add("CarType");
                ad.notifyDataSetChanged();

            }
        });


        ib2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                ad.mFragmentList.add(new CarType());
                ad.mFragmentTitleList.add("BikeType");
                ad.notifyDataSetChanged();

            }
        });



        return view;
    }
}
