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

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by snehil on 9/6/17.
 */

public class Self_Employed extends Fragment {
    CarLoanActivity.ViewPagerAdapter adapter1;
    HomeLoan.ViewPagerAdapter adapter;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_self_employed, container, false);
        final String loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");

        EditText taxamount = (EditText) view.findViewById(R.id.taxamount);
        EditText emiammount = (EditText) view.findViewById(R.id.emiamount);

        Button b1 = (Button) view.findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SessionManager.getStringFromPreferences(getActivity(), "flaggy").equals("0")) {
                    if (loantype.equals("HomeLoan")) {
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
                    } else {
                        adapter1 = ((CarLoanActivity) getActivity()).getCurrAdapter();
                        viewPager = ((CarLoanActivity) getActivity()).getViewPager();
                        int index = (viewPager.getCurrentItem()) + 1;
                        if (index < adapter1.mFragmentList.size()) {
                            adapter1.mFragmentList.subList(index, adapter1.mFragmentList.size()).clear();
                            adapter1.mFragmentTitleList.subList(index, adapter1.mFragmentTitleList.size()).clear();
                            adapter1.notifyDataSetChanged();



                        }
                        adapter1.addFragment(new Co_App_Opt(), "Co_App_Opt");
                        adapter1.notifyDataSetChanged();
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }


                }
                else{
                    if (loantype.equals("HomeLoan")) {
                        adapter = ((HomeLoan) getActivity()).getCurrAdapter();
                        viewPager = ((HomeLoan) getActivity()).getViewPager();
                        int index = (viewPager.getCurrentItem()) + 1;
                        if (index < adapter.mFragmentList.size()) {
                            adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                            adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                            adapter.notifyDataSetChanged();



                        }
                        adapter.addFragment(new Requested_Loan(), "Requested_Loan");
                        adapter.notifyDataSetChanged();
                    } else {
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
                    }

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
