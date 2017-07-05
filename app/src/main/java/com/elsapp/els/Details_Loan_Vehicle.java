package com.elsapp.els;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import Fragments.Additional;
import Fragments.Communication;
import Fragments.LoanRepayment;
import Fragments.LoanSpecific;
import Fragments.Personal;

/**
 * Created by snehil on 20/6/17.
 */

public class Details_Loan_Vehicle extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int icons[]={R.drawable.personal,R.drawable.communication,R.drawable.loanspecific,R.drawable.loanrepay
    ,R.drawable.additional};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details_loan);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);


        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        setupIcons(tabLayout);



    }



    private void setupViewPager(ViewPager viewPager) {
        Details_Loan_Vehicle.ViewPagerAdapter adapter=new Details_Loan_Vehicle.ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Personal(), "Personal");
        adapter.addFragment(new Communication(), "Communication");
        adapter.addFragment(new LoanSpecific(), "LoanSpecific");
        adapter.addFragment(new LoanRepayment(), "LoanRepayment");
        adapter.addFragment(new Additional(), "Additional");
        viewPager.setAdapter(adapter);

    }

    private void setupIcons(TabLayout tabLayout){

        tabLayout.getTabAt(0).setIcon(icons[0]);
        tabLayout.getTabAt(1).setIcon(icons[1]);
        tabLayout.getTabAt(2).setIcon(icons[2]);
        tabLayout.getTabAt(3).setIcon(icons[3]);
        tabLayout.getTabAt(4).setIcon(icons[4]);

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
