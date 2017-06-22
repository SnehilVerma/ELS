package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.elsapp.els.R;

/**
 * Created by snehil on 21/6/17.
 */

public class Fragment_Comm_Two extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_comm_two,container,false);


        Spinner res_category=(Spinner)view.findViewById(R.id.res_category);

        String[] items = new String[]{"Owned","Rented","Company Provided"};
        ArrayAdapter<String> d_adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,items);
        res_category.setAdapter(d_adapter2);

        AppCompatEditText et1=(AppCompatEditText)view.findViewById(R.id.o_line1);
        AppCompatEditText et2=(AppCompatEditText)view.findViewById(R.id.o_line2);
        AppCompatEditText et3=(AppCompatEditText)view.findViewById(R.id.o_line3);
        AppCompatEditText et4=(AppCompatEditText)view.findViewById(R.id.date_res);

        AppCompatEditText et5=(AppCompatEditText)view.findViewById(R.id.p_no);
        AppCompatEditText et6=(AppCompatEditText)view.findViewById(R.id.c_no);
        AppCompatEditText et7=(AppCompatEditText)view.findViewById(R.id.o_no);
        AppCompatEditText et8=(AppCompatEditText)view.findViewById(R.id.oe_no);


        Button b1=(Button)view.findViewById(R.id.b1);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO: STORE THE FIELDS FILLED IN SHARED PREFERENCES / SQLITE.

            }
        });






        return view;
    }
}
