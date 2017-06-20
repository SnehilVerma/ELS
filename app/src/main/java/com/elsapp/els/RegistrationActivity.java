package com.elsapp.els;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.LoginRequest;
import Model.LoginResponseModel;
import Model.Register;
import Model.RegisterRequestModel;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import com.example.df393.elsapp.Model.User;

public class RegistrationActivity extends AppCompatActivity {

    TextInputLayout TextInput_etUserName, TextInput_etFirstName, TextInput_etMiddleName, TextInput_etLastName, TextInput_atUserType,
            TextInput_atCity, TextInput_etcontactNumber, TextInput_etDateOfBirth, TextInput_etpassword, TextInput_etReEnterPassword;
    EditText etUserName, etFirstName, etMiddleName, etLastName, etcontactNumber, etDateOfBirth, etpassword, etReEnterPassword;
    RadioButton rdMale, rdFemale;

    String username, first_name, middle_name, First_name, Gender, user_type, city, contact_no, dob, password;



    AutoCompleteTextView atUserType, atCity;
    Button btnRegister;
    String RdBtnGender, User_Name;
    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener DateOfBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        TextInput_etUserName = (TextInputLayout) findViewById(R.id.TextInput_etUserName);
        TextInput_etFirstName = (TextInputLayout) findViewById(R.id.TextInput_etFirstName);
        TextInput_etMiddleName = (TextInputLayout) findViewById(R.id.TextInput_etMiddleName);
        TextInput_etLastName = (TextInputLayout) findViewById(R.id.TextInput_etLastName);
        TextInput_atUserType = (TextInputLayout) findViewById(R.id.TextInput_atUserType);
        TextInput_atCity = (TextInputLayout) findViewById(R.id.TextInput_atCity);
        TextInput_etcontactNumber = (TextInputLayout) findViewById(R.id.TextInput_etcontactNumber);
        TextInput_etDateOfBirth = (TextInputLayout) findViewById(R.id.TextInput_etDateOfBirth);
        TextInput_etpassword = (TextInputLayout) findViewById(R.id.TextInput_etpassword);
        TextInput_etReEnterPassword = (TextInputLayout) findViewById(R.id.TextInput_etReEnterPassword);

        etUserName = (EditText) findViewById(R.id.etUserName);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etMiddleName = (EditText) findViewById(R.id.etMiddleName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etcontactNumber = (EditText) findViewById(R.id.etcontactNumber);
        etDateOfBirth = (EditText) findViewById(R.id.etDateOfBirth);
        etpassword = (EditText) findViewById(R.id.etpassword);
        etReEnterPassword = (EditText) findViewById(R.id.etReEnterPassword);

        atCity = (AutoCompleteTextView) findViewById(R.id.atCity);
        rdMale = (RadioButton) findViewById(R.id.rdMale);
        rdFemale = (RadioButton) findViewById(R.id.rdFemale);
        rdMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RdBtnGender = "M";
            }
        });
        rdFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RdBtnGender = "F";
            }
        });
        etUserName.setText("kamblesonali248@gmail.com");
        etMiddleName.setText("Sonali");
        etLastName.setText("Prakash");
        etFirstName.setText("wewwre");
        atCity.setText("estreds");
        etcontactNumber.setText("7045747795");
        etpassword.setText("55555");

        DateOfBirth = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                Date_Of_Birth();
            }

        };
        etDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(RegistrationActivity.this, DateOfBirth, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               if( etpassword.getText().toString().equals(etReEnterPassword.getText().toString()))
                {
                    etReEnterPassword.setError(null);
                    if(isMandatory()) {
                  /*  username=     etUserName.getText().toString();
                      first_name= etMiddleName.getText().toString();
                      middle_name=etLastName.getText().toString();
                     First_name=  etFirstName.getText().toString();
                     Gender= RdBtnGender;
                      user_type= "1";
                      city=atCity.getText().toString();
                      contact_no= etcontactNumber.getText().toString();
                      dob=        etDateOfBirth.getText().toString();
                      password=   etpassword.getText().toString();
                        //   userLogin();
                        Registration(username, first_name,middle_name,First_name,Gender,user_type,city,contact_no,dob,password);*/
                    }

                }
               else
               {

                   etReEnterPassword.setFocusable(true);
                   etReEnterPassword.setFocusableInTouchMode(true);
                   etReEnterPassword.setError(getString(R.string.Password));
                   etReEnterPassword.requestFocus();
               }
           /*     Registration("KambleSon@jhk1hju789.com", "Sonali", "P", "Kamble",
                        "F", "1", "NaviMumbai",
                        "8585857999", "2016-01-01", "123456pwd");*/
            }
        });
    }

    private void Date_Of_Birth() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        etDateOfBirth.setText(sdf.format(myCalendar.getTime()));
    }

    public boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }



    private void Registration()
    {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Register> call = apiService.IRegistration(new RegisterRequestModel(
                               etUserName.getText().toString(),
                               etFirstName.getText().toString(),
                               etMiddleName.getText().toString(),
                               etLastName.getText().toString(),
                               RdBtnGender,
                               "1",
                               atCity.getText().toString(),
                               etcontactNumber.getText().toString(),
                               etDateOfBirth.getText().toString(),
                               etpassword.getText().toString()
        )

        );

        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register>call, Response<Register> response) {
                if(response.isSuccessful())
                {
                    if(response.body()!=null)
                    {
                        Toast.makeText(getApplicationContext(), response.body().getToken(), Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "No Response", Toast.LENGTH_LONG).show();
                    }
                }//response.isSuccessful()
                else
                {
                    Toast.makeText(getApplicationContext()," Response Not Successful"+ response.errorBody(), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Register>call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Please Check Network connection",Toast.LENGTH_SHORT).show();

            }
        });
    }

    boolean isMandatory() {

        clearErrorMassage();
        if (TextUtils.isEmpty(etUserName.getText().toString())) {

            etUserName.setFocusable(true);
            etUserName.setFocusableInTouchMode(true);
            etUserName.setError(getString(R.string.Mandatory));
            etUserName.requestFocus();
            return false;
        } else if (emailValidator(etUserName.getText().toString().trim()) == false) {
            etUserName.setFocusable(true);
            etUserName.setFocusableInTouchMode(true);
            etUserName.setError(getString(R.string.ValidateEmail));
            etUserName.requestFocus();
            return false;

        } else if (TextUtils.isEmpty(etcontactNumber.getText().toString())) {
            etcontactNumber.setFocusable(true);
            etcontactNumber.setFocusableInTouchMode(true);
            etcontactNumber.setError(getString(R.string.Mandatory));
            etcontactNumber.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etDateOfBirth.getText().toString())) {
            etDateOfBirth.setFocusable(true);
            etDateOfBirth.setFocusableInTouchMode(true);
            etDateOfBirth.setError(getString(R.string.Mandatory));
            etDateOfBirth.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etpassword.getText().toString())) {
            etpassword.setFocusable(true);
            etpassword.setError(getString(R.string.Mandatory));
            etpassword.requestFocus();
            return false;
        }


        return true;
    }

    void clearErrorMassage() {
        etcontactNumber.setError(null);
        etDateOfBirth.setError(null);
        etpassword.setError(null);
        etUserName.setError(null);
    }
}
