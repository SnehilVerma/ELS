package Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 14/6/17.
 */

public class CoApp_Cat extends Fragment {
    private Context context;
    private String loantype;
    private ViewGroup viewGroup;
    private CarLoanActivity.ViewPagerAdapter adapter;
    private HomeLoan.ViewPagerAdapter adapter1;
    private ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_coapp_cat, container, false);


        TextView tv1=(TextView)view.findViewById(R.id.retired_np);
        TextView tv2=(TextView)view.findViewById(R.id.self_pro);
        TextView tv3=(TextView)view.findViewById(R.id.salary);
        TextView tv4=(TextView)view.findViewById(R.id.self);
        TextView tv5=(TextView)view.findViewById(R.id.retired_pensioner);
        TextView tv6=(TextView)view.findViewById(R.id.homemaker);
        loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    int flag=0;
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();

                    for(String x : adapter.mFragmentTitleList){
                        if(x.equals("Retired NonPensioner")){
                            flag=1;
                            break;
                        }
                        else if(x.equals(("Self Employed Professional"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self Employed Professional");
                        }
                        else if(x.equals(("Salaried"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Salaried");
                        }
                        else if(x.equals(("Self Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self Employed");
                        }
                        else if(x.equals(("Retired Pensioner"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired Pensioner");
                        }
                        else if(x.equals(("Homemaker"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter.addFragment(new Retired_NP(), "Retired NonPensioner");
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

                    for(String x : adapter1.mFragmentTitleList){
                        if(x.equals("Retired NonPensioner")){
                            flag=1;
                            break;
                        }
                        else if(x.equals(("Self Employed Professional"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self Employed Professional");
                        }
                        else if(x.equals(("Salaried"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Salaried");
                        }
                        else if(x.equals(("Self Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self Employed");
                        }
                        else if(x.equals(("Retired Pensioner"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired Pensioner");
                        }
                        else if(x.equals(("Homemaker"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter1.addFragment(new Retired_NP(), "Retired NonPensioner");
                        adapter1.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                    int flag=0;

                    for(String x : adapter.mFragmentTitleList){
                        if(x.equals("Self Employed Professional")){
                            flag=1;
                            break;
                        }
                        else if(x.equals(("Retired NonPensioner"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired NonPensioner");
                        }
                        else if(x.equals(("Salaried"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Salaried");
                        }
                        else if(x.equals(("Self Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self Employed");
                        }
                        else if(x.equals(("Retired Pensioner"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired Pensioner");
                        }
                        else if(x.equals(("Homemaker"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter.addFragment(new Self_Employed(), "Self Employed Professional");
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

                    for(String x : adapter1.mFragmentTitleList){
                        if(x.equals("Self Employed Professional")){
                            flag=1;
                            break;
                        }
                        else if(x.equals(("Retired NonPensioner"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired NonPensioner");
                        }
                        else if(x.equals(("Salaried"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Salaried");
                        }
                        else if(x.equals(("Self Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self Employed");
                        }
                        else if(x.equals(("Retired Pensioner"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired Pensioner");
                        }
                        else if(x.equals(("Homemaker"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter1.addFragment(new Self_Employed(), "Self Employed Professional");
                        adapter1.notifyDataSetChanged();
                    }
                    else {
                        Toast.makeText(getContext(), "Already added next fragment", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                    int flag=0;

                    for(String x : adapter.mFragmentTitleList){
                        if(x.equals("Salaried")){
                            flag=1;
                            break;
                        }
                        else if(x.equals(("Self Employed Professional"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self Employed Professional");
                        }
                        else if(x.equals(("Retired NonPensioner"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired NonPensioner");
                        }
                        else if(x.equals(("Self Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self Employed");
                        }
                        else if(x.equals(("Retired Pensioner"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired Pensioner");
                        }
                        else if(x.equals(("Homemaker"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter.addFragment(new Salaried(), "Salaried");
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

                    for(String x : adapter1.mFragmentTitleList){
                        if(x.equals("Salaried")){
                            flag=1;
                            break;
                        }
                        else if(x.equals(("Self Employed Professional"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self Employed Professional");
                        }
                        else if(x.equals(("Retired NonPensioner"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired NonPensioner");
                        }
                        else if(x.equals(("Self Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self Employed");
                        }
                        else if(x.equals(("Retired Pensioner"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired Pensioner");
                        }
                        else if(x.equals(("Homemaker"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter1.addFragment(new Salaried(), "Salaried");
                        adapter1.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                    int flag=0;

                    for(String x : adapter.mFragmentTitleList){
                        if(x.equals("Self Employed")){
                            flag=1;
                            break;
                        }
                        else if(x.equals(("Self Employed Professional"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self Employed Professional");
                        }
                        else if(x.equals(("Salaried"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Salaried");
                        }
                        else if(x.equals(("Retired NonPensioner"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired NonPensioner");
                        }
                        else if(x.equals(("Retired Pensioner"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired Pensioner");
                        }
                        else if(x.equals(("Homemaker"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter.addFragment(new Self_Employed(), "Self Employed");
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

                    for(String x : adapter1.mFragmentTitleList){
                        if(x.equals("Self Employed")){
                            flag=1;
                            break;
                        }
                        else if(x.equals(("Self Employed Professional"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self Employed Professional");
                        }
                        else if(x.equals(("Salaried"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Salaried");
                        }
                        else if(x.equals(("Retired NonPensioner"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired NonPensioner");
                        }
                        else if(x.equals(("Retired Pensioner"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired Pensioner");
                        }
                        else if(x.equals(("Homemaker"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter1.addFragment(new Self_Employed(), "Self Employed");
                        adapter1.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                    int flag=0;

                    for(String x : adapter.mFragmentTitleList){
                        if(x.equals("Retired Pensioner")){
                            flag=1;
                            break;
                        }
                        else if(x.equals(("Self Employed Professional"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self Employed Professional");
                        }
                        else if(x.equals(("Salaried"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Salaried");
                        }
                        else if(x.equals(("Self Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self Employed");
                        }
                        else if(x.equals(("Retired NonPensioner"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired NonPensioner");
                        }
                        else if(x.equals(("Homemaker"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter.addFragment(new Retired_P(), "Retired Pensioner");
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

                    for(String x : adapter1.mFragmentTitleList){
                        if(x.equals("Retired Pensioner")){
                            flag=1;
                            break;
                        }
                        else if(x.equals(("Self Employed Professional"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self Employed Professional");
                        }
                        else if(x.equals(("Salaried"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Salaried");
                        }
                        else if(x.equals(("Self Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self Employed");
                        }
                        else if(x.equals(("Retired NonPensioner"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired NonPensioner");
                        }
                        else if(x.equals(("Homemaker"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Homemaker");
                        }

                    }
                    if(flag==0) {
                        adapter1.addFragment(new Retired_P(), "Retired Pensioner");
                        adapter1.notifyDataSetChanged();
                    }
                    else{
                        Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();

                    int flag=0;

                    for(String x : adapter.mFragmentTitleList){
                        if(x.equals("Homemaker")){
                            flag=1;
                            break;
                        }
                        else if(x.equals(("Self Employed Professional"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self Employed Professional");
                        }
                        else if(x.equals(("Salaried"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Salaried");
                        }
                        else if(x.equals(("Self Employed"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Self Employed");
                        }
                        else if(x.equals(("Retired Pensioner"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired Pensioner");
                        }
                        else if(x.equals(("Retired NonPensioner"))){
                            adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter.mFragmentTitleList.remove("Retired NonPensioner");
                        }

                    }
                    if(flag==0) {
                        adapter.addFragment(new Homemaker(), "Homemaker");
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

                    for(String x : adapter1.mFragmentTitleList){
                        if(x.equals("Homemaker")){
                            flag=1;
                            break;
                        }
                        else if(x.equals(("Self Employed Professional"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self Employed Professional");
                        }
                        else if(x.equals(("Salaried"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Salaried");
                        }
                        else if(x.equals(("Self Employed"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Self Employed");
                        }
                        else if(x.equals(("Retired Pensioner"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired Pensioner");
                        }
                        else if(x.equals(("Retired NonPensioner"))){
                            adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                            adapter1.mFragmentTitleList.remove("Retired NonPensioner");
                        }

                    }
                    if(flag==0) {
                        adapter1.addFragment(new Homemaker(), "Homemaker");
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
