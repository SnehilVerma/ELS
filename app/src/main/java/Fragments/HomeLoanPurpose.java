package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by Rishi on 6/12/2017.
 */

public class HomeLoanPurpose extends Fragment {
    ViewPager viewPager;
    HomeLoan.ViewPagerAdapter ad;

    Button construct,repair,identified,tranfer;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home_loanpurpose,container,false);

        final ProgressBar pb = ((HomeLoan)getActivity()).getPb();
        final TextView progress = ((HomeLoan)getActivity()).getprogresstv();
        Button ib1 = (Button) view.findViewById(R.id.ib1);
        Button ib2 = (Button) view.findViewById(R.id.ib2);
        Button ib3 = (Button) view.findViewById(R.id.ib3);
        Button ib4 = (Button) view.findViewById(R.id.ib4);
        ad = ((HomeLoan)getActivity()).getCurrAdapter();
        viewPager = ((HomeLoan)getActivity()).getViewPager();
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {
                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();


                }


                SessionManager.putStringInPreferences(getActivity(),"pidentifiedprop","homepurpose");
                ad.addFragment(new HomePropCost(), "HomePropCost");
                ad.notifyDataSetChanged();

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                pb.setProgress(40);

                progress.setText(String.valueOf(40));
            }
        });
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {
                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();

                    //sessionManager.putStringInPreferences(getActivity(),text.toString(),"city");


                }

                SessionManager.putStringInPreferences(getActivity(),"renovateflat","homepurpose");

                ad.addFragment(new HomePropCost(), "HomePropCost");
                ad.notifyDataSetChanged();

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                pb.setProgress(40);

                progress.setText(String.valueOf(40));
            }
        });
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {
                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();

                    //sessionManager.putStringInPreferences(getActivity(),text.toString(),"city");


                }

                SessionManager.putStringInPreferences(getActivity(),"constructhouse","homepurpose");

                ad.addFragment(new HomePropCost(), "HomePropCost");
                ad.notifyDataSetChanged();

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                pb.setProgress(40);

                progress.setText(String.valueOf(40));
            }
        });
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {
                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();

                    //sessionManager.putStringInPreferences(getActivity(),text.toString(),"city");


                }

                SessionManager.putStringInPreferences(getActivity(),"transferloan","homepurpose");

                ad.addFragment(new HomePropCost(), "HomePropCost");
                ad.notifyDataSetChanged();

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                pb.setProgress(40);

                progress.setText(String.valueOf(40));
            }
        });





        return view;
    }
}
