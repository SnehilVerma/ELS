package Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.elsapp.els.R;

/**
 * Created by snehil on 9/6/17.
 */

public class Gender extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_gender, container, false);


        ImageView male = (ImageView) view.findViewById(R.id.male);
        ImageView female = (ImageView) view.findViewById(R.id.female);

        return view;

    }


}
