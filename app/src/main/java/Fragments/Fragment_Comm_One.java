package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.elsapp.els.R;

/**
 * Created by snehil on 21/6/17.
 */

public class Fragment_Comm_One extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comm_one,container,false);

        Spinner spinner=(Spinner)view.findViewById(R.id.spinner);

        String[] items = new String[]{"Permanent","Current Residential","Office"};
        ArrayAdapter<String> d_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,items);
        spinner.setAdapter(d_adapter);


        Spinner res_category=(Spinner)view.findViewById(R.id.res_category);

        String[] items2 = new String[]{"Owned","Rented","Company Provided"};
        ArrayAdapter<String> d_adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,items2);
        res_category.setAdapter(d_adapter2);

        AppCompatEditText et1=(AppCompatEditText)view.findViewById(R.id.p_line1);
        AppCompatEditText et2=(AppCompatEditText)view.findViewById(R.id.p_line2);
        AppCompatEditText et3=(AppCompatEditText)view.findViewById(R.id.p_line3);
        AppCompatEditText et4=(AppCompatEditText)view.findViewById(R.id.date_res);

        AppCompatEditText et5=(AppCompatEditText)view.findViewById(R.id.c_line1);
        AppCompatEditText et6=(AppCompatEditText)view.findViewById(R.id.c_line2);
        AppCompatEditText et7=(AppCompatEditText)view.findViewById(R.id.c_line3);
        AppCompatEditText et8=(AppCompatEditText)view.findViewById(R.id.date_res2);

        Spinner res_category2=(Spinner)view.findViewById(R.id.res_category2);

        String[] items3 = new String[]{"Owned","Rented","Company Provided"};
        ArrayAdapter<String> d_adapter3 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,items3);
        res_category2.setAdapter(d_adapter3);











        return view;
    }
}
