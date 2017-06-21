package com.elsapp.els;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import Fragments.Fragment_Comm_One;
import Fragments.personal;
import Utility.VerticalViewPager;

/**
 * Created by snehil on 21/6/17.
 */

public class Comm_Pager extends BaseActivity {


    VerticalViewPager verticalViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm_pager);


        verticalViewPager=(VerticalViewPager)findViewById(R.id.viewpager);

        setupViewPager(verticalViewPager);





    }

    private void setupViewPager(ViewPager viewPager) {
        Comm_Pager.ViewPagerAdapter adapter=new Comm_Pager.ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Fragment_Comm_One(), "Fragment_Comm_One");
        adapter.addFragment(new personal(), "Fragment_Comm_Two");
        //adapter.addFragment(new LoanRepayment(), "LoanRepayment");
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
