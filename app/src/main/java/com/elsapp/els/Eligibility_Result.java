package com.elsapp.els;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Model.Register;
import Model.RegisterRequestModel;
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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility);

        TextView tv=(TextView)findViewById(R.id.eligible);


        Toast.makeText(getApplicationContext(),"here", Toast.LENGTH_LONG).show();
        String ela= SessionManager.getStringFromPreferences(getApplicationContext(),"eligible_loan_amount");
        //Float amount=Float.parseFloat(ela);

        tv.setText(ela);
        final EditText mob=(EditText)findViewById(R.id.mob);
        final EditText email=(EditText)findViewById(R.id.email);
        final EditText firstname = (EditText) findViewById(R.id.firstname);
        final EditText middlename = (EditText) findViewById(R.id.middlename);
        final EditText lastname = (EditText) findViewById(R.id.lastname);
        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                //Intent intent = new Intent(Eligibility_Result.this,Overall_Qec.class);
                //startActivity(intent);
=======
                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                String city = SessionManager.getStringFromPreferences(getApplicationContext(),"city");
                String dob = SessionManager.getStringFromPreferences(getApplicationContext(),"DOB");
                String contactnumber = mob.getText().toString();
                String username = email.getText().toString();
                String fname = firstname.getText().toString();
                String mname = middlename.getText().toString();
                String lname = lastname.getText().toString();
                String g = SessionManager.getStringFromPreferences(getApplicationContext(),"gender");
                String gender;
                if(g.equals("Male")){
                    gender = "M";
                }
                else{
                    gender = "F";
                }
                RegisterRequestModel registerRequestModel = new RegisterRequestModel(username,fname,mname,lname,gender,String.valueOf("1"),city,contactnumber,dob,contactnumber);
                Call<Register> call = apiService.IRegistration(registerRequestModel);
                call.enqueue(new Callback<Register>() {
                    @Override
                    public void onResponse(Call<Register> call, Response<Register> response) {
                        if(response.body() != null){
                            Toast.makeText(getApplicationContext(),response.body().getToken().toString(),Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "empty", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Register> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT).show();
                    }
                });
                Intent intent = new Intent(Eligibility_Result.this,Overall_Qec.class);
                startActivity(intent);
>>>>>>> 84f54e72c6811625ad6bb389b0a74828cd298f95
            }
        });
        




    }
}
