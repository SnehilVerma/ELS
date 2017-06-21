package com.elsapp.els;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.elsapp.els.R;

import java.util.ArrayList;
import java.util.List;

import Fragments.Fragment_Comm_One;
import Fragments.personal_1;
import Fragments.personl_2;
import Utility.VerticalViewPager;

public class personal_pager extends AppCompatActivity {
    VerticalViewPager verticalViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_pager);
        verticalViewPager=(VerticalViewPager)findViewById(R.id.viewpager);

        setupViewPager(verticalViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        personal_pager.ViewPagerAdapter adapter=new personal_pager.ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new personal_1(), "Personal_One");
        adapter.addFragment(new personl_2(), "Personal_Two");
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
