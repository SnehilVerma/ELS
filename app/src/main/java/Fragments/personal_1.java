package Fragments;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.Toast;

import com.elsapp.els.R;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by snehil on 21/6/17.
 */

public class personal_1 extends Fragment {
    EditText fullname,personalrelname,dob;
    Spinner spin,spin2,spin3,spin4,spin5,marital;
    private String [] arrspinner,arrspinner2,arrspinner3,arrspinner4,arrspinner5,arrspinner6;
    LinearLayout singletype,jointtype,businesstype,personaltype,singlename,personalname;
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
        final View x = inflater.inflate(R.layout.fragment_personal_1, container, false);



        spin = (Spinner) x.findViewById(R.id.spin);
        spin2=(Spinner)x.findViewById(R.id.spin2);
        spin3=(Spinner)x.findViewById(R.id.spin3);
        spin4=(Spinner)x.findViewById(R.id.spin4);
        personalrelname=(EditText)x.findViewById(R.id.personal_relation_name);


        /*
        linear1 = (LinearLayout) x.findViewById(R.id.linear1);
        linear2 = (LinearLayout) x.findViewById(R.id.linear2);
        linear3 = (LinearLayout) x.findViewById(R.id.linear3);
        linear4 = (LinearLayout) x.findViewById(R.id.linear4);
        relname = (EditText) x.findViewById(R.id.namerel);
        relname2 = (EditText) x.findViewById(R.id.namerel2);
        dob = (EditText) x.findViewById(R.id.dob);
        fullname=(EditText)x.findViewById(R.id.appname);
        */
        singletype=(LinearLayout)x.findViewById(R.id.singletype);
        jointtype=(LinearLayout)x.findViewById(R.id.jointtype);
        businesstype=(LinearLayout)x.findViewById(R.id.businesstype);
        personaltype=(LinearLayout)x.findViewById(R.id.personaltype);
        singlename=(LinearLayout)x.findViewById(R.id.singlename);
        personalname=(LinearLayout)x.findViewById(R.id.namelayout);

        this.arrspinner = new String[]{
               "Not Selected", "Single", "Joint"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, arrspinner);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 2) {
                    //fullname.setVisibility(View.VISIBLE);
                    jointtype.setVisibility(View.VISIBLE);
                    singletype.setVisibility(View.INVISIBLE);
                    businesstype.setVisibility(View.INVISIBLE);
                    singlename.setVisibility(View.INVISIBLE);
                    personaltype.setVisibility(View.INVISIBLE);
                    personalname.setVisibility(View.INVISIBLE);


                } else {
                    if (i == 1) {
                    singletype.setVisibility(View.VISIBLE);
                    jointtype.setVisibility(View.INVISIBLE);
                    businesstype.setVisibility(View.INVISIBLE);
                    singlename.setVisibility(View.INVISIBLE);
                    businesstype.setVisibility(View.INVISIBLE);
                    personaltype.setVisibility(View.INVISIBLE);
                    personalname.setVisibility(View.INVISIBLE);


                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        this.arrspinner2 = new String[]{
                "Not Selected",  "Father", "Mother", "Husband"
        };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, arrspinner2);
        spin2.setAdapter(adapter2);
        spin2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>=1)
                singlename.setVisibility(View.VISIBLE);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        this.arrspinner3 = new String[]{
                "Not Selected",  "Business", "Personal"
        };
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, arrspinner3);
        spin3.setAdapter(adapter3);
        spin3.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){

                    businesstype.setVisibility(View.VISIBLE);
                    personaltype.setVisibility(View.INVISIBLE);
                    personalname.setVisibility(View.INVISIBLE);
                }
                else if(i==2){
                    personaltype.setVisibility(View.VISIBLE);
                    businesstype.setVisibility(View.INVISIBLE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        RadioGroup businessgroup=(RadioGroup)x.findViewById(R.id.businessgroup);
        businessgroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(i==R.id.guarantor){
                    Toast.makeText(getContext(),"Guarantor section added",Toast.LENGTH_SHORT).show();

                }else if(i==R.id.co_ap){

                    Toast.makeText(getContext(),"Co-Applicant section added",Toast.LENGTH_SHORT).show();
                }
            }
        });

        this.arrspinner4 = new String[]{
                "Not Selected" ,"Husband", "Wife", "Son", "Daughter"
        };
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, arrspinner4);
        spin4.setAdapter(adapter4);
        spin4.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>=1){

                    personalname.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






        /*
        this.arrspinner2 = new String[]{
              "Not Selected",  "Business", "Personal"
        };
        this.arrspinner3 = new String[]{
              "Not Selected",  "Father", "Mother", "Husband"
        };
        this.arrspinner4 = new String[]{
              "Not Selected" , "Co-Applicant", "Guarantor"
        };
        this.arrspinner5 = new String[]{
               "Not Selected" ,"Husband", "Wife", "Son", "Daughter"
        };
        this.arrspinner6 = new String[]{
              "Not Selected" , "Married", "Unmarried", "Widow"
        };
        spin2 = (Spinner) x.findViewById(R.id.type2);
        spin3 = (Spinner) x.findViewById(R.id.type3);
        spin4 = (Spinner) x.findViewById(R.id.type4);
        spin5 = (Spinner) x.findViewById(R.id.type5);
        marital = (Spinner) x.findViewById(R.id.marital);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, arrspinner);
        spin.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, arrspinner2);
        spin2.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, arrspinner3);
        spin3.setAdapter(adapter3);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, arrspinner4);
        spin4.setAdapter(adapter4);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, arrspinner5);
        spin5.setAdapter(adapter5);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, arrspinner6);
        marital.setAdapter(adapter6);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 2) {
                    fullname.setVisibility(View.VISIBLE);
                    linear1.setVisibility(View.VISIBLE);
                    linear2.setVisibility(View.GONE);
                    linear3.setVisibility(View.GONE);
                    linear4.setVisibility(View.GONE);
                    relname.setVisibility(View.GONE);
                } else {
                    if (i == 1) {
                        fullname.setVisibility(View.VISIBLE);
                        linear2.setVisibility(View.VISIBLE);
                        linear1.setVisibility(View.GONE);
                        linear3.setVisibility(View.GONE);
                        linear4.setVisibility(View.GONE);
                        relname2.setVisibility(View.GONE);


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

                if (i == 1) {
                    linear3.setVisibility(View.VISIBLE);
                    linear4.setVisibility(View.GONE);
                    //relname.setVisibility(View.VISIBLE);
                } else {
                    if (i == 2) {

                    }
                    linear3.setVisibility(View.GONE);
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
                if (i == 1 || i == 2 || i == 3) {
                    relname.setVisibility(View.VISIBLE);
                    relname2.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if ((i == 1)||(i == 2)) {

                    relname2.setVisibility(View.VISIBLE);
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
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis() - (long) 5.676e+11 - (long) 3.456e+8-(long)8.64e+7);
                dialog.show();
            }
        });

        */

        return x;


    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabel() {

        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dob.setText(sdf.format(myCalendar.getTime()));
    }
}
