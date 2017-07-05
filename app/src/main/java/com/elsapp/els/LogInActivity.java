package com.elsapp.els;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.LoginRequest;
import Model.LoginResponseModel;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class
LogInActivity extends AppCompatActivity {
    TextInputLayout textLayout_Email,textLayout_Passowrd;
    EditText etpassword,etemail;
    TextView tvForgotPassword,tvRegister;

    Button btnSign,btnRegister,btnnosign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        getSupportActionBar().hide();
        textLayout_Email = (TextInputLayout) findViewById(R.id.textLayout_Email);
        textLayout_Passowrd = (TextInputLayout) findViewById(R.id.textLayout_Passowrd);
        etpassword = (EditText) findViewById(R.id.etpassword);
        etemail = (EditText) findViewById(R.id.etemail);
        btnSign = (Button) findViewById(R.id.btnSign);
        etemail.setText("d2ktechcloud@gmail.com");
        etpassword.setText("miswak365");
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isMandatory()){
                    userLogin();
                }

            }
        });
        btnnosign = (Button)findViewById(R.id.btnnosign);
        btnnosign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: testing phase

                //Intent i = new Intent(LogInActivity.this,Details_Loan_Home.class);
                Intent i = new Intent(LogInActivity.this,Home_Root_Page.class);
                startActivity(i);
            }
        });
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        tvForgotPassword = (TextView) findViewById(R.id.tvForgotPassword);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogInActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogInActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
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
        if (TextUtils.isEmpty(etemail.getText().toString())){

            etemail.setFocusable(true);
            etemail.setFocusableInTouchMode(true);
            etemail.setError(getString(R.string.Mandatory));
            etemail.requestFocus();
            return false;
        }
        else  if(emailValidator(etemail.getText().toString().trim())==false){
            etemail.setFocusable(true);
            etemail.setFocusableInTouchMode(true);
            etemail.setError(getString(R.string.ValidateEmail));
            etemail.requestFocus();
            return false;

        }


        else if (TextUtils.isEmpty(etpassword.getText().toString())){
            etpassword.setFocusable(true);
            etpassword.setError(getString(R.string.Mandatory));
            etpassword.requestFocus();
            return false;
        }


        return true;
    }
    void clearErrorMassage(){

        etemail.setError(null);
        etpassword.setError(null);
    }

    private void userLogin()
    {

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword(etpassword.getText().toString());
        loginRequest.setUsername(etemail.getText().toString());
        Call<LoginResponseModel> call = apiService.IAuthenticate(loginRequest);

        call.enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel>call, Response<LoginResponseModel> response) {
                if(!(response.body().equals(null))){
                    Intent intent=new Intent(LogInActivity.this,LoanSelec.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(getApplicationContext(),"Check Your UserID/Password",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponseModel>call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Please Check Network connection",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
