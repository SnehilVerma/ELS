package com.elsapp.els.Activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.elsapp.els.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class HomeLoanDetails3 extends AppCompatActivity {

    EditText etOccupancyCertIssuedDate;
    Button btnOccupancyCertIssuedDate;

    RadioGroup radioGroupOccupancyStatusOfBuilding;
    RadioGroup radioGroupOccCertIssued;
    RadioGroup radioGroupRWACreationStatus;

    EditText etOccupancyLetterIssuingAuthority, etOccupancyLetterReferenceNo;
    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener OccupancyCertIssuedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_loan_details3);
        // getSupportActionBar().hide();
        btnOccupancyCertIssuedDate = (Button) findViewById(R.id.btnOccupancyCertIssuedDate);


        radioGroupOccupancyStatusOfBuilding = (RadioGroup) findViewById(R.id.radioGroupOccupancyStatusOfBuilding);
        radioGroupOccCertIssued = (RadioGroup) findViewById(R.id.radioGroupOccCertIssued);
        radioGroupRWACreationStatus = (RadioGroup) findViewById(R.id.radioGroupRWACreationStatus);

        etOccupancyCertIssuedDate = (EditText) findViewById(R.id.etOccupancyCertIssuedDate);

        etOccupancyLetterIssuingAuthority = (EditText) findViewById(R.id.etOccupancyLetterIssuingAuthority);
        etOccupancyLetterReferenceNo = (EditText) findViewById(R.id.etOccupancyLetterReferenceNo);

        etOccupancyCertIssuedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(HomeLoanDetails3.this, OccupancyCertIssuedDate, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        OccupancyCertIssuedDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                BindOccupancyCertIssuedDate();
            }
        };

        radioGroupOccupancyStatusOfBuilding.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroupOccupancyStatusOfBuilding.findViewById(checkedId);
                int index = radioGroupOccupancyStatusOfBuilding.indexOfChild(radioButton);
                if(index!=-1)
                {
                    // Add logic here
                    switch (index) {
                        case 0: // firstbutton
                            Toast.makeText(getApplicationContext(), (index)+"", Toast.LENGTH_SHORT).show();
                            break;
                        case 1: // secondbutton
                            Toast.makeText(getApplicationContext(), (index)+"", Toast.LENGTH_SHORT).show();
                            break;
                        case 2: // thirdbutton
                            Toast.makeText(getApplicationContext(), (index)+"", Toast.LENGTH_SHORT).show();
                            break;
                        case 3: // fourthbutton
                            Toast.makeText(getApplicationContext(), (index)+"", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
        });


        radioGroupOccCertIssued.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroupOccCertIssued.findViewById(checkedId);
                int index = radioGroupOccCertIssued.indexOfChild(radioButton);
                if(index!=-1) {
                    // Add logic here
                    switch (index) {
                        case 0: // firstbutton
                            Toast.makeText(getApplicationContext(), "YES" + (index), Toast.LENGTH_SHORT).show();
                            break;
                        case 1: // secondbutton
                            Toast.makeText(getApplicationContext(), "NO" + (index), Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
        });
        radioGroupRWACreationStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroupRWACreationStatus.findViewById(checkedId);
                int index = radioGroupRWACreationStatus.indexOfChild(radioButton);
                // Add logic here
                if(index!=-1) {
                    switch (index) {
                        case 0: // firstbutton
                            Toast.makeText(getApplicationContext(), "YES" + (index), Toast.LENGTH_SHORT).show();
                            break;
                        case 1: // secondbutton
                            Toast.makeText(getApplicationContext(), "NO" + (index), Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
        });
    }

    private void BindOccupancyCertIssuedDate()
    {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        etOccupancyCertIssuedDate.setText(sdf.format(myCalendar.getTime()));
    }


    public void clearSelectedDate(View view)
    {
        switch (view.getId()) {
            case R.id.btnOccupancyCertIssuedDate:
                etOccupancyCertIssuedDate.setText("");
                break;


        }
    }
}
