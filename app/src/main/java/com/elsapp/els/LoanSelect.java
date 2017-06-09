package com.elsapp.els;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

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
                Toast.makeText(LoanSelect.this,"Hello",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
