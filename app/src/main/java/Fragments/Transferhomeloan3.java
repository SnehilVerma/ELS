package Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.elsapp.els.R;

public class Transferhomeloan3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_transferhomeloan3,container,false);
        ImageView info = (ImageView) view.findViewById(R.id.info);
        final CoordinatorLayout cl = (CoordinatorLayout) view.findViewById(R.id.cl);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(cl, "Total of minor repairs, interiors, fitting & painting", Snackbar.LENGTH_LONG);

                snackbar.show();
            }
        });
        return view;
    }


}
