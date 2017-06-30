package Fragments;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.elsapp.els.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import static com.elsapp.els.R.id.city;
import static com.elsapp.els.R.id.res_category;

/**
 * Created by snehil on 21/6/17.
 */

public class Fragment_Comm_One extends Fragment {

    AppCompatEditText et4;
    AppCompatEditText et8;
    int flag=0;

    ArrayList<String> states;

    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub

            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            updateLabel();
        }

    };





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_comm_one,container,false);

        Spinner spinner=(Spinner)view.findViewById(R.id.spinner);

        String[] items = new String[]{"","Permanent","Current Residential","Office"};
        ArrayAdapter<String> d_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,items);
        spinner.setAdapter(d_adapter);


        states=new ArrayList<>(Arrays.asList("Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh",
                "Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka",
                "Kerala","Madya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Orissa" +
                        "Punjab","Rajasthan","Sikkim","Tamil Nadu","Tripura","Uttaranchal","Uttar Pradesh","West Bengal"
                ,"Andaman and Nicobar Islands","Chandigarh","Dadar and Nagar Haveli","Daman and Diu",
                "Delhi","Lakshadeep","Pondicherry"));



        Spinner res_category=(Spinner)view.findViewById(R.id.res_category);

        String[] items2 = new String[]{"Owned","Rented","Company Provided"};
        ArrayAdapter<String> d_adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,items2);
        res_category.setAdapter(d_adapter2);

        final AppCompatEditText et1=(AppCompatEditText)view.findViewById(R.id.p_line1);
        final AutoCompleteTextView et2=(AutoCompleteTextView) view.findViewById(R.id.p_line2);

        final ArrayAdapter<String> adapterone = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line, states);
        et2.setAdapter(adapterone);

        final AppCompatEditText et3=(AppCompatEditText)view.findViewById(R.id.p_line3);
        et4=(AppCompatEditText)view.findViewById(R.id.date_res);



        final AppCompatEditText et5=(AppCompatEditText)view.findViewById(R.id.c_line1);

        final AutoCompleteTextView et6=(AutoCompleteTextView) view.findViewById(R.id.c_line2);
        et6.setAdapter(adapterone);


        final AppCompatEditText et7=(AppCompatEditText)view.findViewById(R.id.c_line3);
        et8=(AppCompatEditText)view.findViewById(R.id.date_res2);



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
                    et5.setEnabled(false);
                    et6.setEnabled(false);
                    et7.setEnabled(false);
                    et8.setEnabled(false);

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





        et4.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                flag=1;

                DatePickerDialog dialog;
                dialog=new DatePickerDialog(getActivity(),date , myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                dialog.show();
            }
        });

        et8.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View view) {
                flag=2;
                DatePickerDialog dialog;
                dialog=new DatePickerDialog(getActivity(),date , myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                dialog.show();
            }
        });




        et2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String state=adapterView.getItemAtPosition(i).toString();
                et2.setText(state);
                et2.setFocusable(false);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        et6.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String state=adapterView.getItemAtPosition(i).toString();
                et6.setText(state);
                et6.setFocusable(false);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabel() {

        String myFormat = "ddMMyyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        if(flag==1)
        et4.setText(sdf.format(myCalendar.getTime()));
        else if(flag==2)
        et8.setText(sdf.format(myCalendar.getTime()));

    }
}
