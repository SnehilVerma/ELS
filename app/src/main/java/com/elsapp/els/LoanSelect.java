package com.elsapp.els;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import Adapter.CustomGrid;

public class LoanSelect extends AppCompatActivity {


    GridView grid;
    String[] loans = {"Home","vehicle","Gold","Education","Con-Durable"};
    int[] pic_loans = {

            R.drawable.home,
            R.drawable.vehicle,
            R.drawable.gold,
            R.drawable.education,
            R.drawable.con_dur



    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_select);

        CustomGrid adapter = new CustomGrid(LoanSelect.this, loans, pic_loans);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                        if(position==1){
                            Intent i=new Intent(LoanSelect.this,CarLoanActivity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                        }
                        else if(position==0){
                            Intent i=new Intent(LoanSelect.this,HomeLoan.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);

                        }

            }
        });




    }
}
