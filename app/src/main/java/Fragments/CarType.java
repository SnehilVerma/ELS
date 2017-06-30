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

/**
 * Created by snehil on 8/6/17.
 */

public class CarType extends Fragment {


    ViewPagerAdapter ad;
    ViewPager viewPager;
    int tflag=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_car_type, container, false);


        final ProgressBar pb = ((CarLoanActivity)getActivity()).getPb();
        final TextView progress = ((CarLoanActivity)getActivity()).getprogresstv();

        ImageView im1=(ImageView) view.findViewById(R.id.im1);
        ImageView im2=(ImageView) view.findViewById(R.id.im2);



        final SessionManager sessionManager=new SessionManager();
        ad=((CarLoanActivity)getActivity()).getCurrAdapter();
        viewPager = ((CarLoanActivity)getActivity()).getViewPager();




        im1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

            sessionManager.putStringInPreferences(getActivity(),"New","car_type");


                int index=(viewPager.getCurrentItem())+1;
                if(index<ad.mFragmentList.size()) {

                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();

                }


                ad.addFragment(new PrefCar(), "PrefCar");
                ad.notifyDataSetChanged();

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                pb.setProgress(40);

                progress.setText(String.valueOf(40));


            }
        });

        im2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                sessionManager.putStringInPreferences(getActivity(),"Old","car_type");


                int index=(viewPager.getCurrentItem())+1;
                if(index<ad.mFragmentList.size()) {

                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();

                }


                ad.addFragment(new DOM(), "DOM");
                ad.notifyDataSetChanged();

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                pb.setProgress(40);

                progress.setText(String.valueOf(40));



            }
        });




        return view;

    }

}
