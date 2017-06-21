package com.elsapp.els.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.elsapp.els.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeLoanDetails2 extends AppCompatActivity {

    RadioGroup radioGroupTypeofTrans;
    RadioGroup radioGroupWhoIsSeller;
    RadioGroup radioGroupLandType;
    Button btnNext;
    EditText etAreaOfFlat;
    EditText etCostOfHome_Flat;
    EditText etExptDtofConstruction;
    EditText etExptDtofPossession;
    Button btnExptDtofConstruction;
    Button btnExptDtofPossession;
    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener ExptDtofConstruction;
    DatePickerDialog.OnDateSetListener ExptDtofPossession;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_loan_details2);
        // getSupportActionBar().hide();
        etAreaOfFlat = (EditText) findViewById(R.id.etAreaOfFlat);
        etCostOfHome_Flat = (EditText) findViewById(R.id.etCostOfHome_Flat);

        etCostOfHome_Flat.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(18,2)});

        etExptDtofConstruction = (EditText) findViewById(R.id.etExptDtofConstruction);
        etExptDtofPossession = (EditText) findViewById(R.id.etExptDtofPossession);

        btnExptDtofConstruction = (Button) findViewById(R.id.btnExptDtofConstruction);
        btnExptDtofPossession = (Button) findViewById(R.id.btnExptDtofPossession);

        etExptDtofConstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(HomeLoanDetails2.this, ExptDtofConstruction, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        etExptDtofPossession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(HomeLoanDetails2.this, ExptDtofPossession, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        final LinearLayout linLayWhoIsSeller = (LinearLayout) findViewById(R.id.linLayWhoIsSeller);
        radioGroupTypeofTrans = (RadioGroup) findViewById(R.id.radioGroupTypeofTrans);
        radioGroupWhoIsSeller = (RadioGroup) findViewById(R.id.radioGroupWhoIsSeller);
        radioGroupLandType = (RadioGroup) findViewById(R.id.radioGroupLandType);


        MaterialBetterSpinner materialDesignSpinner0 = (MaterialBetterSpinner) findViewById(R.id.spinner_location_property);


        ArrayAdapter<String> arrayAdapter0 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.SelectProperty));
        materialDesignSpinner0.setAdapter(arrayAdapter0);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeLoanDetails2.this, HomeLoanDetails3.class);
                startActivity(intent);
            }
        });
        ExptDtofConstruction = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                BindExptDtofConstruction();
            }
        };

        ExptDtofPossession = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                BindExptDtofPossession();
            }
        };

        radioGroupTypeofTrans.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroupTypeofTrans.findViewById(checkedId);
                int index = radioGroupTypeofTrans.indexOfChild(radioButton);
                // Add logic here
                if(index!=-1) {
                    switch (index) {
                        case 0: // first button
                            linLayWhoIsSeller.setVisibility(View.INVISIBLE);
                            break;
                        case 1: // secondbutton RESALE
                            linLayWhoIsSeller.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            }
        });

        radioGroupWhoIsSeller.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroupWhoIsSeller.findViewById(checkedId);
                int index = radioGroupWhoIsSeller.indexOfChild(radioButton);
                // Add logic here
                if (index != -1) {
                    switch (index) {
                        case 0: // first button
                            Toast.makeText(getApplicationContext(), (index) + "", Toast.LENGTH_SHORT).show();

                            break;
                        case 1: // secondbutton RESALE
                            Toast.makeText(getApplicationContext(), (index) + "", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
        });

        radioGroupLandType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroupLandType.findViewById(checkedId);
                int index = radioGroupLandType.indexOfChild(radioButton);
                // Add logic here
                if (index != -1) {
                    switch (index) {
                        case 0: // first button
                            Toast.makeText(getApplicationContext(), (index) + "", Toast.LENGTH_SHORT).show();

                            break;
                        case 1: // secondbutton RESALE
                            Toast.makeText(getApplicationContext(), (index) + "", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
        });
    }

    private void BindExptDtofPossession() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        etExptDtofPossession.setText(sdf.format(myCalendar.getTime()));
    }

    private void BindExptDtofConstruction() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        etExptDtofConstruction.setText(sdf.format(myCalendar.getTime()));
    }

    public void clearSelectedDate(View view) {
        switch (view.getId()) {
            case R.id.btnExptDtofConstruction:
                etExptDtofConstruction.setText("");
                break;

            case R.id.btnExptDtofPossession:
                etExptDtofPossession.setText("");
                break;
        }
    }
    public class DecimalDigitsInputFilter implements InputFilter {

        Pattern mPattern;

        public DecimalDigitsInputFilter(int digitsBeforeZero,int digitsAfterZero) {
            mPattern=Pattern.compile("[0-9]{0," + (digitsBeforeZero-1) + "}+((\\.[0-9]{0," + (digitsAfterZero-1) + "})?)||(\\.)?");
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

            Matcher matcher=mPattern.matcher(dest);
            if(!matcher.matches())
                return "";
            return null;
        }

    }
}

