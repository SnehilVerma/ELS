package com.elsapp.els;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by snehil on 14/6/17.
 */

public class Eligibility_Result extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eligibility);


        Toast.makeText(getApplicationContext(),"here", Toast.LENGTH_LONG).show();
        EditText name=(EditText)findViewById(R.id.name);
        EditText mob=(EditText)findViewById(R.id.mob);
        EditText email=(EditText)findViewById(R.id.email);


        




    }
}
