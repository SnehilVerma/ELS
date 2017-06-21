package com.elsapp.els.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.elsapp.els.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class HomeLoanDetails1 extends AppCompatActivity {


    RadioGroup radioGroupCredai;
    LinearLayout linLayYesNo;
    Button btnNext;
    Button btnDtofMembership;
    EditText etBuilderAddress;
    EditText etMemberShipNumber, etDateOfMemberShip;
    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener DtofMembershipDialog;
   /* LinearLayout LayoutAppend;
    View InflatedLayout = null;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_loan_details1);
       // getSupportActionBar().hide();

        radioGroupCredai = (RadioGroup) findViewById(R.id.radioGroupCredai);
        linLayYesNo = (LinearLayout) findViewById(R.id.linLayYesNo);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnDtofMembership = (Button) findViewById(R.id.btnDtofMembership);
        etBuilderAddress = (EditText) findViewById(R.id.etBuilderAddress);
        etMemberShipNumber = (EditText) findViewById(R.id.etMemberShipNumber);
        etDateOfMemberShip = (EditText) findViewById(R.id.etDateOfMemberShip);
        etDateOfMemberShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(HomeLoanDetails1.this, DtofMembershipDialog, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        DtofMembershipDialog = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                BindDtOfMemberShip();
            }
        };
        //LayoutAppend = (LinearLayout) findViewById(R.id.LayoutAppend);

        MaterialBetterSpinner mdSpinnerProperty = (MaterialBetterSpinner) findViewById(R.id.spinnerProperty);
        MaterialBetterSpinner mdSpinnerBuilder = (MaterialBetterSpinner) findViewById(R.id.spinnerBuilder);
        MaterialBetterSpinner mdSpinnerConstitution = (MaterialBetterSpinner) findViewById(R.id.spinnerConstitution);


        ArrayAdapter<String> arrayAdapter0 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.SelectProperty));
        mdSpinnerProperty.setAdapter(arrayAdapter0);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.SelectBuilderName));
        mdSpinnerBuilder.setAdapter(arrayAdapter1);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.SelectConstitution));
        mdSpinnerConstitution.setAdapter(arrayAdapter2);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeLoanDetails1.this, HomeLoanDetails2.class);
                startActivity(intent);
            }

        });
        radioGroupCredai.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroupCredai.findViewById(checkedId);
                int index = radioGroupCredai.indexOfChild(radioButton);
                // Add logic here
                if(index!=-1) {
                    switch (index) {
                        case 0: // first button
                            linLayYesNo.setVisibility(View.VISIBLE);

                            break;
                        case 1: // secondbutton
                            linLayYesNo.setVisibility(View.INVISIBLE);
                            break;
                    }
                }
            }
        });
    }

    private void BindDtOfMemberShip() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        etDateOfMemberShip.setText(sdf.format(myCalendar.getTime()));
    }

    public void clearSelectedDate(View view) {
        switch (view.getId()) {
            case R.id.btnDtofMembership:
                etDateOfMemberShip.setText("");
                break;
        }
    }
}