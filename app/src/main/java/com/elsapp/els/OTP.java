package com.elsapp.els;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import Utility.SessionManager;

public class OTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        final EditText otpone = (EditText) findViewById(R.id.otp);
        final Button verify = (Button) findViewById(R.id.verify);
        final LinearLayout lemail = (LinearLayout) findViewById(R.id.lemailid);
        final LinearLayout lpass = (LinearLayout) findViewById(R.id.lpass);
        final TextView emailid = (TextView) findViewById(R.id.emailid);
        final TextView pass = (TextView) findViewById(R.id.pass);
        String pur = SessionManager.getStringFromPreferences(getApplicationContext(),"homepurpose");
        final String sel;
        if(pur.equals("pidentifiedprop")){
            sel = "1";
        }
        else if(pur.equals("renovateflat")){
            sel = "2";
        }
        else if(pur.equals("constructhouse")){
            sel = "3";
        }
        else{
            sel = "4";
        }
        final String loan = SessionManager.getStringFromPreferences(getApplicationContext(),"loantype");
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loan.equals("Home")){
                    Intent intent = new Intent(OTP.this,Details_Loan_Home.class);
                    intent.putExtra("purpose",sel);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(OTP.this,Details_Loan_Vehicle.class);
                    startActivity(intent);
                }
            }
        });
        // comment out to use the atp
        /*verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                VerifyOTPRequestModel verifyOTPRequestModel = new VerifyOTPRequestModel();
                verifyOTPRequestModel.setContact_no(SessionManager.getStringFromPreferences(getApplicationContext(),"contact_no"));
                verifyOTPRequestModel.setOtp(otpone.getText().toString());
                Call<VerifyOTP> call = apiService.getOTP(verifyOTPRequestModel);
                call.enqueue(new Callback<VerifyOTP>() {
                    @Override
                    public void onResponse(Call<VerifyOTP> call, Response<VerifyOTP> response) {
                        if (response.body() != null){
                            Toast.makeText(getApplicationContext(),response.body().getResponse(),Toast.LENGTH_SHORT).show();
                            lemail.setVisibility(View.VISIBLE);
                            lpass.setVisibility(View.VISIBLE);
                            emailid.setText(SessionManager.getStringFromPreferences(getApplicationContext(),"username"));
                            pass.setText(SessionManager.getStringFromPreferences(getApplicationContext(),"contact_no"));
                        }
                        else if(response.code() == 400){
                            Toast.makeText(getApplicationContext(),response.errorBody().toString(),Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<VerifyOTP> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });*/
    }
}
