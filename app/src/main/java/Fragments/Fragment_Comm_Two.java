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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.elsapp.els.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by snehil on 21/6/17.
 */

public class Fragment_Comm_Two extends Fragment {


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


    AppCompatEditText et4;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_comm_two,container,false);


//        Spinner res_category=(Spinner)view.findViewById(R.id.res_category);

        AppCompatEditText et1=(AppCompatEditText)view.findViewById(R.id.o_line1);
        AppCompatEditText et2=(AppCompatEditText)view.findViewById(R.id.o_line2);
        AppCompatEditText et3=(AppCompatEditText)view.findViewById(R.id.o_line3);
        et4=(AppCompatEditText)view.findViewById(R.id.date_res);

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


        et4.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {



                DatePickerDialog dialog;
                dialog=new DatePickerDialog(getActivity(),date , myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                dialog.show();
            }
        });






        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabel() {

        String myFormat = "ddMMyyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            et4.setText(sdf.format(myCalendar.getTime()));

    }
}
