package com.elsapp.els;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import Fragments.VehSelect;

public class VehicleSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_select);

        Toolbar toolbar = (Toolbar)findViewById(R.id.veh_toolbar);
        setSupportActionBar(toolbar);
        ViewPager viewPager = (ViewPager)findViewById(R.id.veh_pager);
        setUpViewPager(viewPager);


    }

    public void setUpViewPager(ViewPager ViewPager) {

        VehicleSelect.ViewPagerAdapter adapter = new VehicleSelect.ViewPagerAdapter(getSupportFragmentManager());
        //adapter.addFragment(new VehSelect(), "VehSelect");
        //adapter.addFragment(new PrefCar(), "PrefCar");
        //adapter.addFragment(new Gender(),"Gender");
        //adapter.addFragment(new Profession(), "Profession");
        //adapter.addFragment(new NumAndEmail(), "NumAndEmail");
        ViewPager.setAdapter(adapter);
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
