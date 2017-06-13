package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.CarLoanActivity.ViewPagerAdapter;
import com.elsapp.els.R;



public class PurposeC extends Fragment {
    Button personal,business;

    ViewPagerAdapter ad;
    ViewPager viewPager;
    int vpsize;
    //int gflag;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View x = inflater.inflate(R.layout.fragment_car_purpose, container, false);
        personal = (Button) x.findViewById(R.id.pers);
        business =(Button) x.findViewById(R.id.buss);

        ad=((CarLoanActivity)getActivity()).getCurrAdapter();
        viewPager = ((CarLoanActivity)getActivity()).getViewPager();
        vpsize=ad.mFragmentList.size();
        //gflag=viewPager.getCurrentItem();



        personal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

//                gflag=1;


                int flag=0;

                for(String x : ad.mFragmentTitleList){
                    if(x.equals("PrefCar")){
                        flag=1;
                        break;
                    }

                }
                if(flag==0) {

                    ad.mFragmentList.add(new PrefCar());
                    ad.mFragmentTitleList.add("PrefCar");
                    ad.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                }



            }
        });

        business.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                //gflag=1;
                int flag=0;

                for(String x : ad.mFragmentTitleList){
                    if(x.equals("PrefCar")){
                        flag=1;
                        break;
                    }

                }
                if(flag==0) {

                    ad.mFragmentList.add(new PrefCar());
                    ad.mFragmentTitleList.add("PrefCar");
                    ad.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                }

            }
        });


        //CHECK IF THE USER HAS SELECTED ANY OPTION.
        viewPager.addOnPageChangeListener(new OnPageChangeListener() {



            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {



            }

            @Override
            public void onPageSelected(int position) {



            }

            @Override
            public void onPageScrollStateChanged(int state) {

                /*

                if(vpsize==ad.mFragmentList.size()){
                    Toast.makeText(getContext(),"Please choose one option",Toast.LENGTH_SHORT).show();

                }
                */



            }
        });



        return x;
    }





}
