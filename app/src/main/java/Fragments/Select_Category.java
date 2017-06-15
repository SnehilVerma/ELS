package Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
    private ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_select_cat, container, false);



        // CHHUTIYA TEST . REMOVE AFTER CHECIKING
        //String[] s=new String[4];
        //s[0]=SessionManager.getStringFromPreferences(getContext(),"loan_type");
        //s[1]=SessionManager.getStringFromPreferences(getContext(),"car_type");
        //s[2]=SessionManager.getStringFromPreferences(getContext(),"city_car");

       // Toast.makeText(getContext(),""+s[0]+" "+s[1]+ " "+ s[2],Toast.LENGTH_SHORT).show();



        TextView tv1=(TextView)view.findViewById(R.id.retired_np);
        TextView tv2=(TextView)view.findViewById(R.id.self_pro);
        TextView tv3=(TextView)view.findViewById(R.id.salary);
        TextView tv4=(TextView)view.findViewById(R.id.self);
        TextView tv5=(TextView)view.findViewById(R.id.retired_pensioner);
        TextView tv6=(TextView)view.findViewById(R.id.homemaker);
        loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");

        tv1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    int flag=0;
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();

                    for(int y = 0;y<adapter.mFragmentTitleList.size();y++){
                        //Toast.makeText(getActivity(),adapter.mFragmentTitleList.get(y),Toast.LENGTH_SHORT).show();
                        if(adapter.mFragmentTitleList.get(y).equals("Retired_NP")){
                            flag=1;
                            break;
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentTitleList.remove("Self_Employed");
                            Toast.makeText(getActivity(),"removing",Toast.LENGTH_SHORT).show();
                            adapter.notifyDataSetChanged();
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Salaried"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Salaried");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Retired_P"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired_P");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Homemaker"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter.addFragment(new Retired_NP(), "Retired_NP");
                        adapter.addFragment(new Co_App_Opt(), "CoAppOpt");
                        adapter.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                    viewPager = ((HomeLoan)getActivity()).getViewPager();
                    int flag=0;

                    for(int y = 0;y<adapter1.mFragmentTitleList.size();y++){
                        if(adapter1.mFragmentTitleList.get(y).equals("Retired_NP")){
                            flag=1;
                            break;
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Salaried"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Salaried");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Retired_P"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired_P");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Homemaker"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter1.addFragment(new Retired_NP(), "Retired_NP");
                        adapter1.addFragment(new Co_App_Opt(), "CoAppOpt");
                        adapter1.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        tv2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                    int flag=0;

                    for(int y = 0;y<adapter.mFragmentTitleList.size();y++){
                        if(adapter.mFragmentTitleList.get(y).equals("Self_Employed")){
                            flag=1;
                            break;
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Retired_NP"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired_NP");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Salaried"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Salaried");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Retired_P"))) {
                            adapter.mFragmentList.remove(viewPager.getCurrentItem() + 2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem() + 1);
                            adapter.mFragmentTitleList.remove("Retired_P");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Homemaker"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter.addFragment(new Self_Employed(), "Self_Employed");
                        adapter.addFragment(new Co_App_Opt(), "CoAppOpt");
                        adapter.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                    viewPager = ((HomeLoan)getActivity()).getViewPager();
                    int flag=0;

                    for(int y = 0;y<adapter1.mFragmentTitleList.size();y++){
                        if(adapter1.mFragmentTitleList.get(y).equals("Self_Employed")){
                            flag=1;
                            break;
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Retired_NP"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired_NP");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Salaried"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Salaried");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Retired_P"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired_P");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Homemaker"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter1.addFragment(new Self_Employed(), "Self_Employed");
                        adapter1.addFragment(new Co_App_Opt(), "CoAppOpt");
                        adapter1.notifyDataSetChanged();
                    }
                    else {
                        Toast.makeText(getContext(), "Already added next fragment", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tv3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                    int flag=0;

                    for(int y = 0;y<adapter.mFragmentTitleList.size();y++){
                        if(adapter.mFragmentTitleList.get(y).equals("Salaried")){
                            flag=1;
                            break;
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Retired_NP"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired_NP");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Retired_P"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired_P");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Homemaker"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter.addFragment(new Salaried(), "Salaried");
                        adapter.addFragment(new Co_App_Opt(), "CoAppOpt");
                        adapter.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                    viewPager = ((HomeLoan)getActivity()).getViewPager();
                    int flag=0;

                    for(int y = 0;y<adapter1.mFragmentTitleList.size();y++){
                        if(adapter1.mFragmentTitleList.get(y).equals("Salaried")){
                            flag=1;
                            break;
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Retired_NP"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired_NP");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Retired_P"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired_P");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Homemaker"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter1.addFragment(new Salaried(), "Salaried");
                        adapter1.addFragment(new Co_App_Opt(), "CoAppOpt");
                        adapter1.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        tv4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                    int flag=0;

                    for(int y = 0;y<adapter.mFragmentTitleList.size();y++){
                        if(adapter.mFragmentTitleList.get(y).equals("Self_Employed")){
                            flag=1;
                            break;
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Salaried"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Salaried");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Retired_NP"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired_NP");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Retired_P"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired_P");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Homemaker"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter.addFragment(new Self_Employed(), "Self_Employed");
                        adapter.addFragment(new Co_App_Opt(), "CoAppOpt");
                        adapter.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                    viewPager = ((HomeLoan)getActivity()).getViewPager();
                    int flag=0;

                    for(int y = 0;y<adapter1.mFragmentTitleList.size();y++){
                        if(adapter1.mFragmentTitleList.get(y).equals("Self_Employed")){
                            flag=1;
                            break;
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Salaried"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Salaried");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Retired_NP"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired_NP");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Retired_P"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired_P");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Homemaker"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter1.addFragment(new Self_Employed(), "Self_Employed");
                        adapter1.addFragment(new Co_App_Opt(), "CoAppOpt");
                        adapter1.notifyDataSetChanged();
                    }
                   else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tv5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                    int flag=0;

                    for(int y = 0;y<adapter.mFragmentTitleList.size();y++){
                        if(adapter.mFragmentTitleList.get(y).equals("Retired_P")){
                            flag=1;
                            break;
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self_Employed");

                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Salaried"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Salaried");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Retired_NP"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired_NP");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Homemaker"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter.addFragment(new Retired_P(), "Retired_P");
                        adapter.addFragment(new Co_App_Opt(), "CoAppOpt");
                        adapter.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                    viewPager = ((HomeLoan)getActivity()).getViewPager();
                    int flag=0;

                    for(int y = 0;y<adapter1.mFragmentTitleList.size();y++){
                        if(adapter1.mFragmentTitleList.get(y).equals("Retired_P")){
                            flag=1;
                            break;
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Salaried"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Salaried");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Retired_NP"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired_NP");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Homemaker"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter1.addFragment(new Retired_P(), "Retired_P");
                        adapter1.addFragment(new Co_App_Opt(), "CoAppOpt");
                        adapter1.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        tv6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();

                    int flag=0;

                    for(int y = 0;y<adapter.mFragmentTitleList.size();y++){
                        if(adapter.mFragmentTitleList.get(y).equals("Homemaker")){
                            flag=1;
                            break;
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Salaried"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Salaried");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Retired_P"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired_P");
                        }
                        else if(adapter.mFragmentTitleList.get(y).equals(("Retired_NP"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter.mFragmentTitleList.remove("CoAppOpt");
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired_NP");
                        }

                    }
                    if(flag==0) {
                        adapter.addFragment(new Homemaker(), "Homemaker");
                        adapter.addFragment(new Co_App_Opt(), "CoAppOpt");
                        adapter.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                    viewPager = ((HomeLoan)getActivity()).getViewPager();
                    int flag=0;

                    for(int y = 0;y<adapter1.mFragmentTitleList.size();y++){
                        if(adapter1.mFragmentTitleList.get(y).equals("Homemaker")){
                            flag=1;
                            break;
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Salaried"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Salaried");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Self_Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self_Employed");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Retired_P"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired_P");
                        }
                        else if(adapter1.mFragmentTitleList.get(y).equals(("Retired_NP"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                            adapter1.mFragmentTitleList.remove("CoAppOpt");
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired_NP");
                        }

                    }
                    if(flag==0) {
                        adapter1.addFragment(new Homemaker(), "Homemaker");
                        adapter1.addFragment(new Co_App_Opt(), "CoAppOpt");
                        adapter1.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



        return view;
    }
}
