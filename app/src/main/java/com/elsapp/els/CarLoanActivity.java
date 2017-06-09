package com.elsapp.els;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import Fragments.CarType;
import Fragments.Gender;
import Fragments.PrefCar;


public class CarLoanActivity extends AppCompatActivity {


    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_loan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        setUpViewPager(viewPager);

    }



    private void setUpViewPager(ViewPager viewPager) {
        CarLoanActivity.ViewPagerAdapter adapter = new CarLoanActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CarType(), "CarType");
        adapter.addFragment(new PrefCar(), "PrefCar");
        adapter.addFragment(new Gender(),"Gender");
        //adapter.addFragment(new Profession(), "Profession");
        //adapter.addFragment(new NumAndEmail(), "NumAndEmail");
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
