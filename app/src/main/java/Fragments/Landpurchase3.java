package Fragments;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.elsapp.els.R;


public class Landpurchase3 extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_landpurchase3, container, false);
        RadioGroup radioGroup= (RadioGroup) view.findViewById(R.id.radgrp5);
        final LinearLayout l21 = (LinearLayout) view.findViewById(R.id.layer3);
        final LinearLayout l22 = (LinearLayout) view.findViewById(R.id.layer4);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(i == R.id.yes) {
                    l21.setVisibility(View.VISIBLE);
                    l22.setVisibility(View.INVISIBLE);

                } else {
                    l22.setVisibility(View.VISIBLE);
                    l21.setVisibility(View.INVISIBLE);

                }
            }
        });
        return view;
    }
}
