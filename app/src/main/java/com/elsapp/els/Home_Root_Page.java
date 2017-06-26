package com.elsapp.els;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import Utility.SessionManager;

/**
 * Created by snehil on 26/6/17.
 */

public class Home_Root_Page extends BaseActivity {

    Button ib1;
    Button ib2;
    Button ib3;
    Button ib4;
    Button continue_btn;
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_root);


        ib1 = (Button) findViewById(R.id.ib1);
        ib2 = (Button) findViewById(R.id.ib2);
        ib3 = (Button) findViewById(R.id.ib3);
        ib4 = (Button) findViewById(R.id.ib4);
        continue_btn=(Button)findViewById(R.id.continue_btn);
        context=this;

        String purpose=SessionManager.getStringFromPreferences(this,"homepurpose");
        Toast.makeText(getApplicationContext(),purpose,Toast.LENGTH_SHORT).show();



        ib1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ib1.setHighlightColor(Color.RED);
            }
        });


        ib2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ib1.setHighlightColor(Color.RED);
            }
        });


        ib3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ib1.setHighlightColor(Color.RED);
            }
        });


        ib4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ib1.setHighlightColor(Color.RED);
            }
        });

        continue_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SessionManager.getStringFromPreferences(context,"homepurpose").equals("pidentifiedprop")){
                    Intent i=new Intent(context,Details_Loan_Home.class);
                    i.putExtra("purpose","1");
                    startActivity(i);

                }else if(SessionManager.getStringFromPreferences(context,"hompurpose").equals("renovateflat")){
                    Intent i=new Intent(context,Details_Loan_Home.class);
                    i.putExtra("purpose","2");
                    startActivity(i);


                }else if(SessionManager.getStringFromPreferences(context,"hompurpose").equals("constructhouse")){
                    Intent i=new Intent(context,Details_Loan_Home.class);
                    i.putExtra("purpose","3");
                    startActivity(i);


                }else if(SessionManager.getStringFromPreferences(context,"hompurpose").equals("transferloan")){
                    Intent i=new Intent(context,Details_Loan_Home.class);
                    i.putExtra("purpose","4");
                    startActivity(i);

                }

            }
        });

    }
}
