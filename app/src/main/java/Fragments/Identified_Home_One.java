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

public class Identified_Home_One extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_identified_one, container, false);
        final LinearLayout linearLayout=(LinearLayout)view.findViewById(R.id.layer3);


        RadioGroup radioGroup= (RadioGroup) view.findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(i == R.id.yes) {
                    linearLayout.setVisibility(View.VISIBLE);


                } else {
                    linearLayout.setVisibility(View.INVISIBLE);

                }
            }

        });




        return view;
    }


}
