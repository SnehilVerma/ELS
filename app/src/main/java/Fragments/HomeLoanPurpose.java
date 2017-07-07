package Fragments;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
    ImageView ib1,ib2,ib3,ib4;
    ImageView construct,repair,identified,tranfer;
    String pur;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home_loanpurpose,container,false);

        final ProgressBar pb = ((HomeLoan)getActivity()).getPb();
        final TextView progress = ((HomeLoan)getActivity()).getprogresstv();
        ib1 = (ImageView) view.findViewById(R.id.ib1);
        ib2 = (ImageView) view.findViewById(R.id.ib2);
        ib3 = (ImageView) view.findViewById(R.id.ib3);
        ib4 = (ImageView) view.findViewById(R.id.ib4);
        ad = ((HomeLoan)getActivity()).getCurrAdapter();
        viewPager = ((HomeLoan)getActivity()).getViewPager();
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pur = "pidentifiedprop";
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
                pur = "renovateflat";
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
                pur = "constructhouse";
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

                pur = "transferloan";
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
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("homepurpose",pur);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null) {
            String x = savedInstanceState.getString("homepurpose");
            Drawable xyz = getResources().getDrawable(R.drawable.buttonstyle);
            try {
                if (x.equals("pidentifiedprop")) {
                    ib1.setBackground(xyz);
                } else if (x.equals("renovateflat")) {
                    ib2.setBackground(xyz);
                } else if (x.equals("constructhouse")) {
                    ib3.setBackground(xyz);
                } else {
                    ib4.setBackground(xyz);
                }
            }catch (Exception e){

            }
        }

    }

}
