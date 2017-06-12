package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.elsapp.els.R;



public class PurposeC extends Fragment {
    Button personal,business;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View x = inflater.inflate(R.layout.fragment_car_purpose, container, false);
        personal = (Button) x.findViewById(R.id.pers);
        business =(Button) x.findViewById(R.id.buss);
        return x;
    }





}
