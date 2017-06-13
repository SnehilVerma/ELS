package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.elsapp.els.R;

/**
 * Created by snehil on 9/6/17.
 */

public class Retired_P extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_retired, container, false);


        EditText mpension = (EditText) view.findViewById(R.id.mpension);
        EditText emiamount = (EditText) view.findViewById(R.id.emiamount);
        return view;

    }
}
