package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 9/6/17.
 */

public class HomeInto extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_home_intro, container, false);
        SessionManager.putStringInPreferences(getContext(),"null","city");
        SessionManager.putStringInPreferences(getContext(),"null","gender");
        SessionManager.putStringInPreferences(getActivity(),"null","car_type");
        SessionManager.putStringInPreferences(getActivity(),"null","bike_type");


        return view;

    }
}
