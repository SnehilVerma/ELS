package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.elsapp.els.R;

import Adapter.GridAdapter;

/**
 * Created by snehil on 9/6/17.
 */

public class PrefCar extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_car_pref, container, false);
        GridView gridView=(GridView)view.findViewById(R.id.gridview);
        gridView.setAdapter(new GridAdapter(getContext()));

        return view;

    }



}
