package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.elsapp.els.R;

/**
 * Created by sibby on 21/6/17.
 */

public class Additional_one extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_additional_one, container, false);
        Spinner bankname = (Spinner)view.findViewById(R.id.bankname);
        final Spinner branchname = (Spinner)view.findViewById(R.id.branchname);
        Spinner accounttype = (Spinner) view.findViewById(R.id.accounttype);
        branchname.setEnabled(false);
        String[] banks = new String[]{"No Selection"};
        ArrayAdapter<String> d_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,banks);
        bankname.setAdapter(d_adapter);
        String[] branches = new String[]{"No Selection"};
        ArrayAdapter<String > b_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,branches);
        branchname.setAdapter(b_adapter);
        bankname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                branchname.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        String[] accounts = new String[]{"No Selection","Saving Bank","Current Account","Fixed Deposit","Loan Account","Recurring Deposit"};
        ArrayAdapter<String> a_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,accounts) ;
        accounttype.setAdapter(a_adapter);
        return view;
    }

}
