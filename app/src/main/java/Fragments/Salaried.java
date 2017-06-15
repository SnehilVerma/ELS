package Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 9/6/17.
 */

public class Salaried extends Fragment{


    Button b1;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_salaried, container, false);

        final EditText gmincome = (EditText) view.findViewById(R.id.gmincome);
        final EditText msalary = (EditText) view.findViewById(R.id.msalary);
        final EditText emi = (EditText) view.findViewById(R.id.emi);
        gmincome.setText("00");
        msalary.setText("00");
        emi.setText("00");
        TextView t1 = (TextView) view.findViewById(R.id.prev);
        TextView t2 = (TextView) view.findViewById(R.id.next);
        b1=(Button)view.findViewById(R.id.button);


        final ImageView i1 = (ImageView) view.findViewById(R.id.i1);
        ImageView i2 = (ImageView) view.findViewById(R.id.i2);
        //ImageView i3 = (ImageView) view.findViewById(R.id.i3);4
        final CoordinatorLayout cl = (CoordinatorLayout) view.findViewById(R.id.cl);
        final LinearLayout layout = (LinearLayout) view.findViewById(R.id.layout);


        gmincome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if ((Float.parseFloat(gmincome.getText().toString()) > 999999.99) || ((Float.parseFloat(gmincome.getText().toString()) < 0))) {
                    gmincome.setError("entered value not accepted");
                } else {
                    Snackbar snackbar = Snackbar
                            .make(cl, "You have stated gross salary as " + gmincome.getText().toString(), Snackbar.LENGTH_LONG);

                    snackbar.show();
                }
                if(!hasFocus){
                    hideKeyboard();
                }
            }


    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(gmincome.getWindowToken(), 0);
//        Toast.makeText(getContext(),gmincome.getText().toString(),Toast.LENGTH_SHORT).show();

    }


        });
        msalary.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if ((Float.parseFloat(msalary.getText().toString()) > 999999.99) || ((Float.parseFloat(msalary.getText().toString()) < 0))) {
                    msalary.setError("entered value not accepted");
                }
                else{
                    Snackbar snackbar = Snackbar
                            .make(cl, "You have stated gross salary as "+msalary.getText().toString(), Snackbar.LENGTH_LONG);

                    snackbar.show();
                }
                if(!hasFocus){
                    hideKeyboard();
                }
            }
            private void hideKeyboard() {
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(gmincome.getWindowToken(), 0);
            }
        });


        emi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if ((Float.parseFloat(msalary.getText().toString()) > 999999.99) || ((Float.parseFloat(msalary.getText().toString()) < 0))) {
                    msalary.setError("entered value not accepted");
                }
                if(!hasFocus){
                    hideKeyboard();
                }
            }
            private void hideKeyboard() {
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(gmincome.getWindowToken(), 0);
            }
        });
        /*if((Float.parseFloat(gmincome.getText().toString())>999999.99)||((Float.parseFloat(gmincome.getText().toString())<0))){
            gmincome.setError("entered value not accepted");
        }*/
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(cl, "Your Total Salary", Snackbar.LENGTH_LONG);

                snackbar.show();
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(cl, "Your Salary excluding all deductions", Snackbar.LENGTH_LONG);

                snackbar.show();
            }
        });



        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String gross=gmincome.getText().toString();
                String takeaway=msalary.getText().toString();
                String existing_emi=emi.getText().toString();
                if(gross.equals("00")|| takeaway.equals("00")|| existing_emi.equals("00")||gross.equals("")|| takeaway.equals("")|| existing_emi.equals("")){
                    Snackbar snackbar = Snackbar
                            .make(cl, "Please fill all details", Snackbar.LENGTH_LONG);

                    snackbar.show();

                }
                else{

                    SessionManager.putStringInPreferences(getContext(),gross,"gross_salary");
                    SessionManager.putStringInPreferences(getContext(),takeaway,"net_salary");
                    SessionManager.putStringInPreferences(getContext(),existing_emi,"existing_emi");


                }
            }
        });

        return view;

    }
}
