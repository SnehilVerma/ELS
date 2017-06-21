package com.elsapp.els;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import Fragments.Communication;
import Fragments.LoanRepayment;
import Fragments.LoanSpecific;
import Utility.VerticalViewPager;

/**
 * Created by snehil on 20/6/17.
 */

public class TestVertical extends BaseActivity {


    VerticalViewPager verticalViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_vertical);

        verticalViewPager=(VerticalViewPager)findViewById(R.id.viewpager);

        setupViewPager(verticalViewPager);









    }



    private void setupViewPager(ViewPager viewPager) {
        TestVertical.ViewPagerAdapter adapter=new TestVertical.ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Communication(), "Communication");
        adapter.addFragment(new LoanSpecific(), "LoanSpecific");
        adapter.addFragment(new LoanRepayment(), "LoanRepayment");
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
