package Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.elsapp.els.R;

public class Transferhomeloan2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_transferhomeloan2,container,false);
        RadioGroup radioGroup= (RadioGroup) view.findViewById(R.id.radgrp);
        final LinearLayout l21 = (LinearLayout) view.findViewById(R.id.l21);
        final LinearLayout l22 = (LinearLayout) view.findViewById(R.id.l22);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(i == R.id.flat) {
                    l21.setVisibility(View.VISIBLE);
                    l22.setVisibility(View.INVISIBLE);

                } else {
                    l22.setVisibility(View.VISIBLE);
                    l21.setVisibility(View.INVISIBLE);

                }
            }
        });

        RadioButton flat = (RadioButton) view.findViewById(R.id.flat);
        RadioButton house = (RadioButton) view.findViewById(R.id.house);




        return view;
    }


}
