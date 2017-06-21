package Fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.elsapp.els.R;


import java.util.Calendar;

/**
 * Created by snehil on 21/6/17.
 */

public class personal_1 extends Fragment {
    EditText appname,relname,relname2,dob;
    Spinner spin,spin2,spin3,spin4,spin5,marital;
    private String [] arrspinner,arrspinner2,arrspinner3,arrspinner4,arrspinner5,arrspinner6;
    LinearLayout linear1,linear2,linear3,linear4;
    Calendar myCalendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub

            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        }

    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View x = inflater.inflate(R.layout.fragment_personal, container, false);
        spin = (Spinner) x.findViewById(R.id.type);

        linear1 = (LinearLayout) x.findViewById(R.id.linear1);
        linear2 = (LinearLayout) x.findViewById(R.id.linear2);
        linear3 = (LinearLayout) x.findViewById(R.id.linear3);
        linear4 = (LinearLayout) x.findViewById(R.id.linear4);
        relname = (EditText) x.findViewById(R.id.namerel);
        relname = (EditText) x.findViewById(R.id.namerel2);
        dob = (EditText) x.findViewById(R.id.dob);
        this.arrspinner = new String[]{
                "Single", "Joint"
        };
        this.arrspinner2 = new String[]{
                "Business", "Personal"
        };
        this.arrspinner3 = new String[]{
                "Father", "Mother", "Husband"
        };
        this.arrspinner4 = new String[]{
                "Co-Applicant", "Guarantor"
        };
        this.arrspinner5 = new String[]{
                "Husband", "Wife", "Son", "Daughter"
        };
        this.arrspinner6 = new String[]{
                "Married", "Unmarried", "Widow"
        };
        spin2 = (Spinner) x.findViewById(R.id.type2);
        spin3 = (Spinner) x.findViewById(R.id.type3);
        spin4 = (Spinner) x.findViewById(R.id.type4);
        spin5 = (Spinner) x.findViewById(R.id.type5);
        marital = (Spinner) x.findViewById(R.id.marital);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, arrspinner);
        spin.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, arrspinner2);
        spin2.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, arrspinner3);
        spin3.setAdapter(adapter3);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, arrspinner4);
        spin4.setAdapter(adapter4);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, arrspinner5);
        spin5.setAdapter(adapter5);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, arrspinner6);
        marital.setAdapter(adapter6);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1) {
                    linear1.setVisibility(View.VISIBLE);
                    linear2.setVisibility(View.INVISIBLE);
                    linear3.setVisibility(View.INVISIBLE);
                    linear4.setVisibility(View.INVISIBLE);
                    relname.setVisibility(View.INVISIBLE);
                } else {
                    if (i == 0) {
                        linear2.setVisibility(View.VISIBLE);
                        linear1.setVisibility(View.INVISIBLE);
                        linear3.setVisibility(View.INVISIBLE);
                        linear4.setVisibility(View.INVISIBLE);


                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    linear3.setVisibility(View.VISIBLE);
                    linear4.setVisibility(View.INVISIBLE);
                    //relname.setVisibility(View.VISIBLE);
                } else {
                    if (i == 1) {

                    }
                    linear3.setVisibility(View.INVISIBLE);
                    linear4.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0 || i == 1 || i == 2) {
                    relname.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    //relname2.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog;
                dialog = new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis() - (long) 5.676e+11 - (long) 3.456e+8);
                dialog.show();
            }
        });

        return x;


    }
}