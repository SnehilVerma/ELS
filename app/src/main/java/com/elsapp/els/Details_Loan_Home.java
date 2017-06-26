package com.elsapp.els;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import Fragments.Communication;
import Fragments.Identified_Home;
import Fragments.Land_Purchase;
import Fragments.LoanRepayment;

import Fragments.Personal;
import Fragments.Repair_Renov;

import Fragments.LoanSpecific;
import Fragments.Transfer_Home_loan;


/**
 * Created by snehil on 21/6/17.
 */

public class Details_Loan_Home extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    String purpose;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details_loan);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        purpose=getIntent().getStringExtra("purpose");


    }



    private void setupViewPager(ViewPager viewPager) {
        Details_Loan_Home.ViewPagerAdapter adapter=new Details_Loan_Home.ViewPagerAdapter(getSupportFragmentManager());
        if(purpose.equals("1")){
            adapter.addFragment(new Identified_Home(), "Identified_Home");

        }else if(purpose.equals("2")){
            adapter.addFragment(new Repair_Renov(),"Repair_Renov");

        }else if(purpose.equals("3")){
            adapter.addFragment(new Land_Purchase(),"Land_Purchase");

        }else{
            //adapter.addFragment();

        }

        adapter.addFragment(new Personal(),"Personal");
        adapter.addFragment(new Communication(),"Communication");
        adapter.addFragment(new LoanRepayment(), "LoanRepayment");
        adapter.addFragment(new Transfer_Home_loan(), "TransferHomeLoan");
        viewPager.setAdapter(adapter);

    }



    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return mFragmentTitleList.get(position);

        }
    }
}
