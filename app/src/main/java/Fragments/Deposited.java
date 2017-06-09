package Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.elsapp.els.R;

import Adapter.GridAdapter;


public class Deposited extends Fragment {


    public Deposited() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View x = inflater.inflate(R.layout.fragment_deposited,container,false);
        GridView gridView=(GridView)x.findViewById(R.id.gridviews);
        gridView.setAdapter(new GridAdapter(getContext()));
        // Inflate the layout for this fragment
        return x;
    }

}

