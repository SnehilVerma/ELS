package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
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

        String[] items = new String[]{"","Permanent","Current Residential","Office"};
        ArrayAdapter<String> d_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,items);
        spinner.setAdapter(d_adapter);



        Spinner res_category=(Spinner)view.findViewById(R.id.res_category);

        String[] items2 = new String[]{"Owned","Rented","Company Provided"};
        ArrayAdapter<String> d_adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,items2);
        res_category.setAdapter(d_adapter2);

        final AppCompatEditText et1=(AppCompatEditText)view.findViewById(R.id.p_line1);
        final AppCompatEditText et2=(AppCompatEditText)view.findViewById(R.id.p_line2);
        final AppCompatEditText et3=(AppCompatEditText)view.findViewById(R.id.p_line3);
        final AppCompatEditText et4=(AppCompatEditText)view.findViewById(R.id.date_res);



        final AppCompatEditText et5=(AppCompatEditText)view.findViewById(R.id.c_line1);
        final AppCompatEditText et6=(AppCompatEditText)view.findViewById(R.id.c_line2);
        final AppCompatEditText et7=(AppCompatEditText)view.findViewById(R.id.c_line3);
        final AppCompatEditText et8=(AppCompatEditText)view.findViewById(R.id.date_res2);



        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){

                    et1.setEnabled(true);
                    et2.setEnabled(true);
                    et3.setEnabled(true);
                    et4.setEnabled(true);

                }else if(i==2){

                    et5.setEnabled(true);
                    et6.setEnabled(true);
                    et7.setEnabled(true);
                    et8.setEnabled(true);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        CheckBox checkBox=(CheckBox)view.findViewById(R.id.checkbox);


        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b==true){
                    et5.setEnabled(true);
                    et6.setEnabled(true);
                    et7.setEnabled(true);
                    et8.setEnabled(true);

                    et5.setText(et1.getText().toString());
                    et6.setText(et2.getText().toString());
                    et7.setText(et3.getText().toString());
                    et8.setText(et4.getText().toString());


                }else if(b==false){
                    et5.setText("");
                    et6.setText("");
                    et7.setText("");
                    et8.setText("");


                }


            }
        });









        Spinner res_category2=(Spinner)view.findViewById(R.id.res_category2);

        String[] items3 = new String[]{"Owned","Rented","Company Provided"};
        ArrayAdapter<String> d_adapter3 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,items3);
        res_category2.setAdapter(d_adapter3);











        return view;
    }
}
