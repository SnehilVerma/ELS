package com.elsapp.els;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.elsapp.els.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.ForgotPasswordRequestModel;
import Model.ForgotPasswordResponseModel;
import Model.LoginRequest;
import Model.LoginResponseModel;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgetPasswordActivity extends AppCompatActivity {
    TextInputLayout TextInput_etUserName;
    EditText etUserName;
    Button btnok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        TextInput_etUserName = (TextInputLayout) findViewById(R.id.TextInput_etUserName);
        etUserName = (EditText) findViewById(R.id.etUserName);
        btnok = (Button) findViewById(R.id.btnok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isMandatory()){
                    ForgotPassword();
                   
                }
            }
        });

    }

    private void ForgotPassword()
    {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ForgotPasswordResponseModel> call = apiService.IForgotPassword(new ForgotPasswordRequestModel(
                etUserName.getText().toString()));

        call.enqueue(new Callback<ForgotPasswordResponseModel>() {
            @Override
            public void onResponse(Call<ForgotPasswordResponseModel>call, Response<ForgotPasswordResponseModel> response) {
                if(response.isSuccessful())
                {
                    if(response.body()!=null)
                    {

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
            public void onFailure(Call<ForgotPasswordResponseModel>call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Please Check Network connection",Toast.LENGTH_SHORT).show();

            }
        });
    }
    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    boolean isMandatory()
    {

        clearErrorMassage();
        if (TextUtils.isEmpty(etUserName.getText().toString())){

            etUserName.setFocusable(true);
            etUserName.setFocusableInTouchMode(true);
            etUserName.setError(getString(R.string.Mandatory));
            etUserName.requestFocus();
            return false;
        }
        else  if(emailValidator(etUserName.getText().toString().trim())==false){
            etUserName.setFocusable(true);
            etUserName.setFocusableInTouchMode(true);
            etUserName.setError(getString(R.string.ValidateEmail));
            etUserName.requestFocus();
            return false;

        }


        return true;
    }
    void clearErrorMassage(){

        etUserName.setError(null);
    }
}
