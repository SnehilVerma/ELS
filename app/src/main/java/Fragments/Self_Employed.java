package Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.elsapp.els.R;

/**
 * Created by snehil on 9/6/17.
 */

public class Self_Employed extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_self_employed, container, false);

        EditText taxamount = (EditText) view.findViewById(R.id.taxamount);
        EditText emiammount = (EditText) view.findViewById(R.id.emiamount);

        Button b1 = (Button) view.findViewById(R.id.button);
        taxamount.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                return false;
            }
        });
        return view;

    }
}
