package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 6/7/17.
 */

public class Self_Employed_P extends Fragment {
    CarLoanActivity.ViewPagerAdapter adapter1;
    HomeLoan.ViewPagerAdapter adapter;
    ViewPager viewPager;
    ProgressBar pb;
    TextView progress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_self_employed_prof, container, false);
        final String loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");

        final EditText taxamount = (EditText) view.findViewById(R.id.taxamount);
        final EditText emiammount = (EditText) view.findViewById(R.id.emiamount);

        Button b1 = (Button) view.findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((!taxamount.getText().toString().equals(""))) {


                    SessionManager.putStringInPreferences(getContext(), taxamount.getText().toString(), "gross_salary");
                    SessionManager.putStringInPreferences(getContext(), String.valueOf(0), "net_salary");
                    if(emiammount.getText().toString().equals("")){
                        SessionManager.putStringInPreferences(getContext(), "0", "existing_emi");
                    }
                    else {
                        SessionManager.putStringInPreferences(getContext(), emiammount.getText().toString(), "existing_emi");
                    }

                    SessionManager.putStringInPreferences(getContext(), String.valueOf(0), "coap_gross_salary");
                    SessionManager.putStringInPreferences(getContext(), String.valueOf(0), "coap_net_salary");
                    SessionManager.putStringInPreferences(getContext(), String.valueOf(0), "coap_existing_emi");


                    if (SessionManager.getStringFromPreferences(getActivity(), "flaggy").equals("0")) {
                        SessionManager.putStringInPreferences(getActivity(),"Self_Employed","incometype");
                        if (loantype.equals("Home")) {
                            pb = ((HomeLoan) getActivity()).getPb();
                            progress = ((HomeLoan) getActivity()).getprogresstv();
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
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                            pb.setProgress(70);
                            progress.setText(String.valueOf(70));
                        } else {
                            pb = ((CarLoanActivity) getActivity()).getPb();
                            progress = ((CarLoanActivity) getActivity()).getprogresstv();
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
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                            pb.setProgress(90);
                            progress.setText(String.valueOf(90));
                        }


                    } else {


                        SessionManager.putStringInPreferences(getContext(),taxamount.getText().toString(), "coap_gross_salary");
                        SessionManager.putStringInPreferences(getContext(), String.valueOf(0), "coap_net_salary");
                        if(emiammount.getText().toString().equals("")){
                            SessionManager.putStringInPreferences(getContext(), "0", "coap_existing_emi");
                        }
                        else {
                            SessionManager.putStringInPreferences(getContext(), emiammount.getText().toString(), "coap_existing_emi");
                        }
                        SessionManager.putStringInPreferences(getActivity(),"Self_Employed","incometypecoapp");



                        if (loantype.equals("Home")) {
                            pb = ((HomeLoan) getActivity()).getPb();
                            progress = ((HomeLoan) getActivity()).getprogresstv();
                            adapter = ((HomeLoan) getActivity()).getCurrAdapter();
                            viewPager = ((HomeLoan) getActivity()).getViewPager();
                            if (adapter.mFragmentList.size() > 10) {
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
                            } else {
                                int index = (viewPager.getCurrentItem()) + 1;
                                if (index < adapter.mFragmentList.size()) {
                                    adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                                    adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                                    adapter.notifyDataSetChanged();


                                }
                                adapter.addFragment(new Co_App_Opt(), "Co_App_Opt");
                                adapter.notifyDataSetChanged();
                                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                                pb.setProgress(70);
                                progress.setText(String.valueOf(70));
                            }
                        } else {
                            pb = ((CarLoanActivity) getActivity()).getPb();
                            progress = ((CarLoanActivity) getActivity()).getprogresstv();
                            adapter1 = ((CarLoanActivity) getActivity()).getCurrAdapter();
                            viewPager = ((CarLoanActivity) getActivity()).getViewPager();
                            if (adapter1.mFragmentList.size() > 10) {
                                int index = (viewPager.getCurrentItem()) + 1;
                                if (index < adapter1.mFragmentList.size()) {
                                    adapter1.mFragmentList.subList(index, adapter1.mFragmentList.size()).clear();
                                    adapter1.mFragmentTitleList.subList(index, adapter1.mFragmentTitleList.size()).clear();
                                    adapter1.notifyDataSetChanged();


                                }
                                adapter1.addFragment(new Requested_Loan(), "Requested_Loan");
                                adapter1.notifyDataSetChanged();
                                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                                pb.setProgress(90);
                                progress.setText(String.valueOf(90));
                            } else {
                                int index = (viewPager.getCurrentItem()) + 1;
                                if (index < adapter1.mFragmentList.size()) {
                                    adapter1.mFragmentList.subList(index, adapter1.mFragmentList.size()).clear();
                                    adapter1.mFragmentTitleList.subList(index, adapter1.mFragmentTitleList.size()).clear();
                                    adapter1.notifyDataSetChanged();


                                }
                                adapter1.addFragment(new Co_App_Opt(), "Co_App_Opt");
                                adapter1.notifyDataSetChanged();
                                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                                pb.setProgress(70);
                                progress.setText(String.valueOf(70));
                            }
                        }

                    }
                }
                else{
                    Toast.makeText(getActivity(),"Please enter all the details",Toast.LENGTH_SHORT).show();
                }

            }
        });
        taxamount.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                return false;
            }
        });
        return view;

    }
}
