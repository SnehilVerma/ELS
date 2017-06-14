package Fragments;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.elsapp.els.R;

import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.N)
public class CoAPP extends Fragment {
    EditText Name,Phone,Age;
    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener dates = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            calendar.set(Calendar.YEAR, i);
            calendar.set(Calendar.MONTH, i1);
            calendar.set(Calendar.DAY_OF_MONTH, i2);
            mylabel();

        }
    };




    public CoAPP() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View x = inflater.inflate(R.layout.fragment_co_ap, container, false);
        Name = (EditText) x.findViewById(R.id.name);
        Phone = (EditText) x.findViewById(R.id.phone);
        Age = (EditText) x.findViewById(R.id.age);
        EditText relationship = (EditText) x.findViewById(R.id.relationship);

        Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getActivity(), dates, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        return x;
    }

    private void mylabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        Age.setText(sdf.format(calendar.getTime()));
    }
    }







