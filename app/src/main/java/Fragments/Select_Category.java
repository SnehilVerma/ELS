package Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by snehil on 12/6/17.
 */

public class Select_Category extends Fragment {
    private Context context;
    private String loantype;
    private ViewGroup viewGroup;
    private CarLoanActivity.ViewPagerAdapter adapter;
    private HomeLoan.ViewPagerAdapter adapter1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_select_cat, container, false);


        TextView tv1=(TextView)view.findViewById(R.id.retired_np);
        TextView tv2=(TextView)view.findViewById(R.id.self_pro);
        TextView tv3=(TextView)view.findViewById(R.id.salary);
        TextView tv4=(TextView)view.findViewById(R.id.self);
        TextView tv5=(TextView)view.findViewById(R.id.retired_pensioner);
        TextView tv6=(TextView)view.findViewById(R.id.homemaker);
        loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");
        Toast.makeText(getActivity(),loantype,Toast.LENGTH_SHORT).show();

        tv1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    viewGroup = ((CarLoanActivity) getActivity()).getViewPager();
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    adapter.addFragment(new Retired_NP(), "Retired NonPensioner");
                    adapter.notifyDataSetChanged();
                }
                else {
                    adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                    adapter1.addFragment(new Retired_NP(), "Retired NonPensioner");
                    adapter1.notifyDataSetChanged();
                }

            }
        });

        tv2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    viewGroup = ((CarLoanActivity) getActivity()).getViewPager();
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    adapter.addFragment(new Retired_NP(), "Self Employed Professional");
                    adapter.notifyDataSetChanged();
                }
                else {
                    adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                    adapter1.addFragment(new Retired_NP(), "Self Employed Professional");
                    adapter1.notifyDataSetChanged();
                }
            }
        });

        tv3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    viewGroup = ((CarLoanActivity) getActivity()).getViewPager();
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    adapter.addFragment(new Salaried(), "Salaried");
                    adapter.notifyDataSetChanged();
                }
                else {
                    adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                    adapter1.addFragment(new Salaried(), "Salaried");
                    adapter1.notifyDataSetChanged();
                }

            }
        });

        tv4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    viewGroup = ((CarLoanActivity) getActivity()).getViewPager();
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    adapter.addFragment(new Self_Employed(), "Self Employed");
                    adapter.notifyDataSetChanged();
                }
                else {
                    adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                    adapter1.addFragment(new Self_Employed(), "Self Employed");
                    adapter1.notifyDataSetChanged();
                }
            }
        });

        tv5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    viewGroup = ((CarLoanActivity) getActivity()).getViewPager();
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    adapter.addFragment(new Retired_P(), "Retired Pensioner");
                    adapter.notifyDataSetChanged();
                }
                else {
                    adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                    adapter1.addFragment(new Retired_P(), "Retired Pensioner");
                    adapter1.notifyDataSetChanged();
                }
            }
        });


        tv6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    viewGroup = ((CarLoanActivity) getActivity()).getViewPager();
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    adapter.addFragment(new Retired_NP(), "Homemaker");
                    adapter.notifyDataSetChanged();
                }
                else {
                    adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                    adapter1.addFragment(new Retired_NP(), "Homemaker");
                    adapter1.notifyDataSetChanged();
                }

            }
        });



        return view;
    }
}
