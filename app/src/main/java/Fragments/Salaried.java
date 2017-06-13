package Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.elsapp.els.R;

/**
 * Created by sibby on 9/6/17.
 */

public class Salaried extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_salaried, container, false);

        final EditText gmincome = (EditText) view.findViewById(R.id.gmincome);
        final EditText msalary = (EditText) view.findViewById(R.id.msalary);
        EditText emi = (EditText) view.findViewById(R.id.emi);
        gmincome.setText("00");
        msalary.setText("00");
        emi.setText("00");
        TextView t1 = (TextView) view.findViewById(R.id.prev);
        TextView t2 = (TextView) view.findViewById(R.id.next);
        final ImageView i1 = (ImageView) view.findViewById(R.id.i1);
        ImageView i2 = (ImageView) view.findViewById(R.id.i2);
        //ImageView i3 = (ImageView) view.findViewById(R.id.i3);
        final LinearLayout layout = (LinearLayout) view.findViewById(R.id.layout);
        gmincome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if ((Float.parseFloat(gmincome.getText().toString()) > 999999.99) || ((Float.parseFloat(gmincome.getText().toString()) < 0))) {
                    gmincome.setError("entered value not accepted");
                } else {
                    Snackbar snackbar = Snackbar
                            .make(layout, "You have stated gross salary as " + gmincome.getText().toString(), Snackbar.LENGTH_LONG);

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
        msalary.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if ((Float.parseFloat(msalary.getText().toString()) > 999999.99) || ((Float.parseFloat(msalary.getText().toString()) < 0))) {
                    msalary.setError("entered value not accepted");
                }
                else{
                    Snackbar snackbar = Snackbar
                            .make(layout, "You have stated gross salary as "+msalary.getText().toString(), Snackbar.LENGTH_LONG);

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
                        .make(layout, "Your Total Salary", Snackbar.LENGTH_LONG);

                snackbar.show();
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar
                        .make(layout, "Your Salary excluding all deductions", Snackbar.LENGTH_LONG);

                snackbar.show();
            }
        });
        /*final ViewPager viewPager = ((HomeLoan)getActivity()).getViewPager();
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });
*/
        return view;

    }
}
