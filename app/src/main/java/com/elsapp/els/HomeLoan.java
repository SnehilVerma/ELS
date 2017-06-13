package com.elsapp.els;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import Fragments.City;

import Fragments.CoAPP;
import Fragments.HomeLoanPurpose;
import Fragments.DOB;
import Fragments.Gender;
import Fragments.HomeInto;
import Fragments.HomeLoanPurpose;
import Fragments.HomePropCost;
import Fragments.HomePropLoc;
import Fragments.Select_Category;
import Transformer.PagerTransformer;

public class HomeLoan extends AppCompatActivity {
    private ViewPager viewPager;
    private HomeLoan.ViewPagerAdapter adapter;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_loan);

        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPager.setPageTransformer(true,new PagerTransformer());
        /*viewPager.setAdapter(new QEC_adapter(this));
        switch(viewPager.getCurrentItem()){
            case(1):
                ImageView others = (ImageView) findViewById(R.id.others);
                others.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),"bla bla",Toast.LENGTH_SHORT).show();
                    }
                });
        }*/

        setUpViewPager(viewPager);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setUpViewPager(ViewPager viewPager) {
        adapter = new HomeLoan.ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new HomeInto(), "Intro");
        adapter.addFragment(new City(), "City");
        adapter.addFragment(new Gender(), "Gender");
        adapter.addFragment(new DOB(), "Date of Birth");
        adapter.addFragment(new HomePropLoc(), "Property Location");
        adapter.addFragment(new HomeLoanPurpose(), "Purpose of Loan");
        adapter.addFragment(new HomePropCost(), "Property Cost");
        adapter.addFragment(new Select_Category(), "Select Category");
        viewPager.setAdapter(adapter);
    }
    public HomeLoan.ViewPagerAdapter getCurrAdapter(){
        return adapter;

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
    public ViewPager getViewPager(){
        return viewPager;
    }
}
