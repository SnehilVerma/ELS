package Fragments;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.elsapp.els.R;

/**
 * Created by snehil on 26/6/17.
 */

public class Identified_Home_Two extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_identified_two, container, false);
        RadioGroup radioGroup=(RadioGroup)view.findViewById(R.id.radiogroup);
        final LinearLayout linearLayout=(LinearLayout)view.findViewById(R.id.layer4);


        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(i==R.id.resale){
                    linearLayout.setVisibility(View.VISIBLE);

                }else{
                    linearLayout.setVisibility(View.INVISIBLE);

                }
            }
        });

        return view;
    }


}