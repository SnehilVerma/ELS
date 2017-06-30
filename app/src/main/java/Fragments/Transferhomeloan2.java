package Fragments;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.elsapp.els.R;

import Utility.VerticalViewPager;

public class Transferhomeloan2 extends Fragment {


    VerticalViewPager verticalViewPager;
    int flag=0;

    EditText et1,et2,et3,et4,et5;
    EditText et6,et7,et8,et9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view;
        view = inflater.inflate(R.layout.fragment_transferhomeloan2,container,false);
        RadioGroup radioGroup= (RadioGroup) view.findViewById(R.id.radgrp);
        final LinearLayout l21 = (LinearLayout) view.findViewById(R.id.l21);
        final LinearLayout l22 = (LinearLayout) view.findViewById(R.id.l22);


        et1=(EditText)view.findViewById(R.id.propname);
        et2=(EditText)view.findViewById(R.id.buildername);
        et3=(EditText)view.findViewById(R.id.address);
        et4=(EditText)view.findViewById(R.id.posdate);
        et5=(EditText)view.findViewById(R.id.flatarea);

        et6=(EditText)view.findViewById(R.id.propadd);
        et7=(EditText)view.findViewById(R.id.datecompl);
        et8=(EditText)view.findViewById(R.id.arealand);
        et9=(EditText)view.findViewById(R.id.areabuildup);


        Transfer_Home_loan transfer_home_loan=(Transfer_Home_loan)this.getParentFragment();
        verticalViewPager=transfer_home_loan.getVerticalViewPager();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(i == R.id.flat) {
                    flag=1;
                    l21.setVisibility(View.VISIBLE);
                    l22.setVisibility(View.INVISIBLE);

                } else {
                    flag=2;
                    l22.setVisibility(View.VISIBLE);
                    l21.setVisibility(View.INVISIBLE);

                }
            }
        });

        RadioButton flat = (RadioButton) view.findViewById(R.id.flat);
        RadioButton house = (RadioButton) view.findViewById(R.id.house);


        verticalViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==2){
                    if(flag==0){
                        Snackbar snackbar = Snackbar.make(view,"Choose one option",Snackbar.LENGTH_SHORT);
                        snackbar.show();
                        verticalViewPager.setCurrentItem(1);
                    }else if(flag==1){

                    if(et1.getText().length()==0 || et2.getText().length()==0 || et3.getText().length()==0|| et4.getText().length()==0 || et5.getText().length()==0 ){
                        Snackbar snackbar = Snackbar.make(view,"Enter all flat details",Snackbar.LENGTH_SHORT);
                        snackbar.show();
                        verticalViewPager.setCurrentItem(1);
                            }

                    }else if(flag==2){
                        if(et6.getText().length()==0 || et7.getText().length()==0 || et8.getText().length()==0|| et9.getText().length()==0  ) {
                            Snackbar snackbar = Snackbar.make(view,"Enter all house details",Snackbar.LENGTH_SHORT);
                            snackbar.show();
                            verticalViewPager.setCurrentItem(1);

                        }


                    }


                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




        return view;
    }


}
