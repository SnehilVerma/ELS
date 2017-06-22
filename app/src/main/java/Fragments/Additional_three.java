package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.elsapp.els.R;

/**
 * Created by sibby on 21/6/17.
 */

public class Additional_three extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_additional_three, container, false);
        Spinner creditor = (Spinner) view.findViewById(R.id.creditor);
        EditText loan = (EditText) view.findViewById(R.id.loan);
        EditText outstanding = (EditText) view.findViewById(R.id.outstanding);
        String[] creditors = new String[]{"Loan from Bank","Any other Bank"};
        ArrayAdapter<String> c_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,creditors);
        return view;

    }

}
