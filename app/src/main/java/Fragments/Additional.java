package Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.elsapp.els.Add_Pager;
import com.elsapp.els.Comm_Pager;
import com.elsapp.els.R;

import Utility.VerticalViewPager;


public class Additional extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_additional, container, false);

        Button b1=(Button)view.findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Before Intent",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getContext(),Add_Pager.class);
                startActivity(i);

            }
        });



        return view;
    }
}
