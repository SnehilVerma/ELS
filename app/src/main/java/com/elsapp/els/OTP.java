package com.elsapp.els;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import Model.VerifyOTP;
import Model.VerifyOTPRequestModel;
import Utility.SessionManager;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                VerifyOTPRequestModel verifyOTPRequestModel = new VerifyOTPRequestModel();
                verifyOTPRequestModel.setContact_no(SessionManager.getStringFromPreferences(getApplicationContext(),"contact_no"));
                verifyOTPRequestModel.setOtp(otpone.getText().toString());
                Call<VerifyOTP> call = apiService.IVerify(verifyOTPRequestModel);
                call.enqueue(new Callback<VerifyOTP>() {
                    @Override
                    public void onResponse(Call<VerifyOTP> call, Response<VerifyOTP> response) {
                        if(response.body() != null){
                            Toast.makeText(getApplicationContext(),response.body().getResponse(),Toast.LENGTH_SHORT).show();
                            lemail.setVisibility(View.VISIBLE);
                            lpass.setVisibility(View.VISIBLE);
                            emailid.setText(SessionManager.getStringFromPreferences(getApplicationContext(),"username"));
                            pass.setText(SessionManager.getStringFromPreferences(getApplicationContext(),"contact_no"));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"empty",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<VerifyOTP> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
