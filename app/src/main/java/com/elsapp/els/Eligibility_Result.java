package com.elsapp.els;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Model.Register;
import Model.RegisterRequestModel;
import Model.SendOtpForLoginRequest;
import Model.SendOtpForLoginResponse;
import Utility.SessionManager;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by snehil on 14/6/17.
 */

public class Eligibility_Result extends AppCompatActivity {
    String fname ;
    String mname;
    String lname;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility);

        TextView tv=(TextView)findViewById(R.id.eligible);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Toast.makeText(getApplicationContext(),"here", Toast.LENGTH_LONG).show();
        String ela= SessionManager.getStringFromPreferences(getApplicationContext(),"eligible_loan_amount");
        //Float amount=Float.parseFloat(ela);

        tv.setText(ela);
        final EditText mob=(EditText)findViewById(R.id.mob);
        final EditText email=(EditText)findViewById(R.id.email);
        final EditText etname = (EditText) findViewById(R.id.name);
        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                String city = SessionManager.getStringFromPreferences(getApplicationContext(),"city");
                String dob = SessionManager.getStringFromPreferences(getApplicationContext(),"DOB");
                final String contactnumber = mob.getText().toString();
                String username = email.getText().toString();
                String name = etname.getText().toString();
                String[] nameparts = name.split(" ");
                if(nameparts.length == 1) {
                    fname = name;
                    mname = "";
                    lname = "";
                }
                else if(nameparts.length == 2){
                    fname = nameparts[0];
                    mname = "";
                    lname = nameparts[1];
                }
                else{
                    fname = nameparts[0];
                    mname = nameparts[1];
                    lname = nameparts[2];
                }
                String g = SessionManager.getStringFromPreferences(getApplicationContext(),"gender");
                String gender;
                if(g.equals("Male")){
                    gender = "M";
                }
                else{
                    gender = "F";
                }
                SessionManager.putStringInPreferences(getApplicationContext(),contactnumber,"contact_no");
                SessionManager.putStringInPreferences(getApplicationContext(),username,"username");
                RegisterRequestModel registerRequestModel = new RegisterRequestModel(username,fname,mname,lname,gender,String.valueOf("1"),city,contactnumber,dob,contactnumber);
                Call<Register> call = apiService.IRegistration(registerRequestModel);
                call.enqueue(new Callback<Register>() {
                    @Override
                    public void onResponse(Call<Register> call, Response<Register> response) {
                        if(response.body() != null){
                            //Toast.makeText(getApplicationContext(),response.body().getToken().toString(),Toast.LENGTH_SHORT).show();
                            SessionManager.putStringInPreferences(getApplicationContext(),response.body().getToken(),"token");
                            sendotp(contactnumber);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "empty", Toast.LENGTH_SHORT).show();
                            sendotp(contactnumber);
                        }
                    }

                    @Override
                    public void onFailure(Call<Register> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT).show();
                    }
                });
            }


        });
        


    }
    void sendotp(String contactnumber){
        ApiInterface apiInterface = new ApiClient().getClient().create(ApiInterface.class);
        SendOtpForLoginRequest sendOtpForLoginRequest = new SendOtpForLoginRequest();
        sendOtpForLoginRequest.setContactNo(contactnumber);
        Call<SendOtpForLoginResponse> otpcall = apiInterface.SendOtp(sendOtpForLoginRequest);
        otpcall.enqueue(new Callback<SendOtpForLoginResponse>() {
            @Override
            public void onResponse(Call<SendOtpForLoginResponse> call, Response<SendOtpForLoginResponse> response) {
                if (response.body()!=null)
                    //Toast.makeText(getApplicationContext(),response.body().getResponse(),Toast.LENGTH_SHORT).show();
                {
                    final Dialog dialog = new Dialog(Eligibility_Result.this);
                    dialog.setContentView(R.layout.custom_otp_dialog);
                    Button b = (Button) dialog.findViewById(R.id.btn_yes);
                    dialog.show();
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Eligibility_Result.this,OTP.class);
                            startActivity(intent);
                        }
                    });
                }
                else
                    Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<SendOtpForLoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_SHORT).show();

            }
        });

    }



}
