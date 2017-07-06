package Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 6/7/17.
 */

public class Salaried_P extends Fragment {
    HomeLoan.ViewPagerAdapter adapter;
    ViewPager viewPager;
    CarLoanActivity.ViewPagerAdapter adapter1;
    ProgressBar pb;
    TextView progress;


    Button b1;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_salaried_prof, container, false);

        final EditText gmincome = (EditText) view.findViewById(R.id.gmincome);
        final EditText msalary = (EditText) view.findViewById(R.id.msalary);
        final EditText emi = (EditText) view.findViewById(R.id.emi);
        final String loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");
        b1=(Button)view.findViewById(R.id.button);
        TextInputLayout tw1 = (TextInputLayout) view.findViewById(R.id.tw1);
        TextInputLayout tw2 = (TextInputLayout) view.findViewById(R.id.tw2);
        TextInputLayout tw3 = (TextInputLayout) view.findViewById(R.id.tw3);
        tw1.setErrorEnabled(true);
        tw2.setErrorEnabled(true);
        tw3.setErrorEnabled(true);
        tw1.setError("    Your Total Salary");
        tw2.setError("    Your Salary excluding all deductions");
        tw3.setError("    ");
        final CoordinatorLayout cl = (CoordinatorLayout) view.findViewById(R.id.cl);


        gmincome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!gmincome.getText().toString().equals("")) {
                    if ((Float.parseFloat(gmincome.getText().toString()) > 999999999) || ((Float.parseFloat(gmincome.getText().toString()) < 0))) {
                        gmincome.setError("entered value not accepted");
                    } else {
                        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());

                        dlgAlert.setMessage("You have stated gross salary as "+ gmincome.getText().toString());
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();
                    }
                    if (!hasFocus) {
                        //hideKeyboard();
                    }
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
                if(!(msalary.getText().toString().equals(""))) {
                    if ((Float.parseFloat(msalary.getText().toString()) > 999999.99) || ((Float.parseFloat(msalary.getText().toString()) < 0))) {
                        msalary.setError("entered value not accepted");
                    } else {
                        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());

                        dlgAlert.setMessage("You have stated gross salary as "+ msalary.getText().toString());
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();
                    }
                    if (!hasFocus) {
                        //hideKeyboard();
                    }
                }
            }
            private void hideKeyboard() {
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(gmincome.getWindowToken(), 0);
            }
        });


        /*emi.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if ((Float.parseFloat(msalary.getText().toString()) > 999999999) || ((Float.parseFloat(msalary.getText().toString()) < 0))) {
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
        });*/
        /*if((Float.parseFloat(gmincome.getText().toString())>999999.99)||((Float.parseFloat(gmincome.getText().toString())<0))){
            gmincome.setError("entered value not accepted");
        }*/



        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {



                String gross=gmincome.getText().toString();
                String takeaway=msalary.getText().toString();
                String existing_emi=emi.getText().toString();
                if(gross.equals("")|| takeaway.equals("")){
                    Snackbar snackbar = Snackbar
                            .make(cl, "Please fill all details", Snackbar.LENGTH_LONG);

                    snackbar.show();

                }
                else {

                    SessionManager.putStringInPreferences(getContext(), gross, "gross_salary");
                    SessionManager.putStringInPreferences(getContext(), takeaway, "net_salary");
                    if(existing_emi.equals("")){
                        SessionManager.putStringInPreferences(getContext(), "0", "existing_emi");

                    }
                    else {
                        SessionManager.putStringInPreferences(getContext(), existing_emi, "existing_emi");
                    }

                    SessionManager.putStringInPreferences(getContext(), String.valueOf(0), "coap_gross_salary");
                    SessionManager.putStringInPreferences(getContext(), String.valueOf(0), "coap_net_salary");
                    SessionManager.putStringInPreferences(getContext(), String.valueOf(0), "coap_existing_emi");

                    if (SessionManager.getStringFromPreferences(getActivity(), "flaggy").equals("0")) {
                        SessionManager.putStringInPreferences(getActivity(),"Salaried","incometype");

                        if (loantype.equals("Home")) {


                            pb = ((HomeLoan)getActivity()).getPb();
                            progress = ((HomeLoan)getActivity()).getprogresstv();

                            adapter = ((HomeLoan) getActivity()).getCurrAdapter();
                            viewPager = ((HomeLoan) getActivity()).getViewPager();
                            int index = (viewPager.getCurrentItem()) + 1;
                            if (index < adapter.mFragmentList.size()) {
                                adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                                adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                                adapter.notifyDataSetChanged();



                            }
                            adapter.addFragment(new Co_App_Opt(), "Co_App_Opt");
                            adapter.notifyDataSetChanged();
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                            pb.setProgress(70);
                            progress.setText(String.valueOf(70));
                        } else {
                            pb = ((CarLoanActivity)getActivity()).getPb();
                            progress = ((CarLoanActivity)getActivity()).getprogresstv();
                            adapter1 = ((CarLoanActivity) getActivity()).getCurrAdapter();
                            viewPager = ((CarLoanActivity) getActivity()).getViewPager();
                            int index = (viewPager.getCurrentItem()) + 1;
                            if (index < adapter1.mFragmentList.size()) {
                                adapter1.mFragmentList.subList(index, adapter1.mFragmentList.size()).clear();
                                adapter1.mFragmentTitleList.subList(index, adapter1.mFragmentTitleList.size()).clear();
                                adapter1.notifyDataSetChanged();



                            }
                            adapter1.addFragment(new Requested_Loan(), "Requested_Loan");
                            adapter1.notifyDataSetChanged();
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                            pb.setProgress(90);
                            progress.setText(String.valueOf(90));
                        }


                    }

                    else{

                        SessionManager.putStringInPreferences(getContext(), gross, "coap_gross_salary");
                        SessionManager.putStringInPreferences(getContext(), takeaway, "coap_net_salary");
                        if(existing_emi.equals("")){
                            SessionManager.putStringInPreferences(getContext(),"0" , "coap_existing_emi");
                        }
                        else {
                            SessionManager.putStringInPreferences(getContext(), existing_emi, "coap_existing_emi");
                        }
                        SessionManager.putStringInPreferences(getActivity(),"Salaried","incometypecoapp");


                        if (loantype.equals("Home")) {


                            pb = ((HomeLoan)getActivity()).getPb();
                            progress = ((HomeLoan)getActivity()).getprogresstv();

                            adapter = ((HomeLoan) getActivity()).getCurrAdapter();
                            viewPager = ((HomeLoan) getActivity()).getViewPager();
                            if(adapter.mFragmentList.size()>10) {

                                int index = (viewPager.getCurrentItem()) + 1;
                                if (index < adapter.mFragmentList.size()) {
                                    adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                                    adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                                    adapter.notifyDataSetChanged();


                                }
                                adapter.addFragment(new Requested_Loan(), "Requested_Loan");
                                adapter.notifyDataSetChanged();
                                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                                pb.setProgress(90);
                                progress.setText(String.valueOf(90));
                            }
                            else{
                                int index = (viewPager.getCurrentItem()) + 1;
                                if (index < adapter.mFragmentList.size()) {
                                    adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                                    adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                                    adapter.notifyDataSetChanged();



                                }
                                adapter.addFragment(new Co_App_Opt(), "Co_App_Opt");
                                adapter.notifyDataSetChanged();
                                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                                pb.setProgress(70);
                                progress.setText(String.valueOf(70));
                            }
                        }

                    }
                }
            }
        });

        return view;

    }

}
