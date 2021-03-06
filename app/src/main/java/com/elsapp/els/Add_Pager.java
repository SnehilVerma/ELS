package com.elsapp.els;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Fragments.Additional_one;
import Fragments.Additional_three;
import Fragments.Additional_two;
import Utility.VerticalViewPager;

public class Add_Pager extends AppCompatActivity {

    VerticalViewPager verticalViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pager);
        getSupportActionBar().hide();
        verticalViewPager = (VerticalViewPager)findViewById(R.id.viewpager);
        setupViewPager(verticalViewPager);

    }

    public void setupViewPager(VerticalViewPager upViewPager) {
        Add_Pager.ViewPagerAdapter adapter = new Add_Pager.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Additional_one(),"additionalone");
        adapter.addFragment(new Additional_two(),"additionaltwo");
        adapter.addFragment(new Additional_three(),"additionalthree");
        upViewPager.setAdapter(adapter);
    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {

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
