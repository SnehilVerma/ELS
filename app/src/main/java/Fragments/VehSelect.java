package Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.CarLoanActivity.ViewPagerAdapter;
import com.elsapp.els.R;

import Utility.SessionManager;

import static com.elsapp.els.R.id.im1;

/**
 * Created by Rishi on 6/9/2017.
 */

public class VehSelect extends Fragment {


    ViewPagerAdapter ad;
    ViewPager viewPager;
    int tflag=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_veh_type, container, false);
        final SessionManager sessionManager=new SessionManager();
        final ProgressBar pb = ((CarLoanActivity)getActivity()).getPb();
        final TextView progress = ((CarLoanActivity)getActivity()).getprogresstv();

        ImageButton ib1=(ImageButton)view.findViewById(im1);
        ImageButton ib2=(ImageButton)view.findViewById(R.id.im2);
        if(sessionManager.getStringFromPreferences(getActivity(),"vehicle_type").equals("Bike")){
            ib1.setBackgroundColor(Color.GREEN);
        }
        else if(sessionManager.getStringFromPreferences(getActivity(),"vehicle_type").equals("Car")){
            ib2.setBackgroundColor(Color.GREEN);
        }

        ad=((CarLoanActivity)getActivity()).getCurrAdapter();
        viewPager = ((CarLoanActivity)getActivity()).getViewPager();


        ib1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                sessionManager.putStringInPreferences(getActivity(),"Bike","vehicle_type");
                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {
                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();
                }



                ad.addFragment(new BikeType(), "BikeType");
                ad.notifyDataSetChanged();
                Log.d("1", SessionManager.getStringFromPreferences(getContext(),"vehicle_type"));


                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                pb.setProgress(30);

                progress.setText(String.valueOf(30));




            }
        });


        ib2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                sessionManager.putStringInPreferences(getActivity(),"Car","vehicle_type");
                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {
                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();
                }



                ad.addFragment(new CarType(), "CarType");
                ad.notifyDataSetChanged();
                Log.d("1", SessionManager.getStringFromPreferences(getContext(),"vehicle_type"));

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                pb.setProgress(30);

                progress.setText(String.valueOf(30));



            }
        });



        return view;
    }

}
