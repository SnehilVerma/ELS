package com.elsapp.els;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Fragments.CarType;
import Fragments.City;
import Fragments.DOB;
import Fragments.Gender;
import Fragments.PrefCar;
import Fragments.Retired_P;
import Fragments.Self_Employed;
import Transformer.PagerTransformer;
import Utility.SessionManager;


public class CarLoanActivity extends AppCompatActivity {


    private ViewPager viewPager;
    public CarLoanActivity.ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_loan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        SessionManager.putStringInPreferences(CarLoanActivity.this,"0","pos");
        setSupportActionBar(toolbar);
        TextView tv=(TextView)findViewById(R.id.tv1);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/roboto.ttf");
        tv.setTypeface(font);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPager.setPageTransformer(true,new PagerTransformer());
        //viewPager.setCurrentItem();

        /*
        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        */



        setUpViewPager(viewPager);

    }



    private void setUpViewPager(ViewPager viewPager) {
        CarLoanActivity.ViewPagerAdapter adapter = new CarLoanActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new City(), "City");
        adapter.addFragment(new Gender(), "Gender");
        adapter.addFragment(new DOB(), "DOB");
        adapter.addFragment(new CarType(), "CarType");
        /*adapter.addFragment(new PrefCar(), "PrefCar");
        adapter.addFragment(new Retired_P(), "Retired_Pensioner");
        adapter.addFragment(new Self_Employed(), "Self_Employed");*/
      //  adapter.addFragment(new PrefCar(), "PrefCar");
       // adapter.addFragment(new Gender(),"Gender");
        //adapter.addFragment(new DOB(),"Date of Birth");
        //adapter.addFragment(new Retired_P(), "Retired_Pensioner");
        //adapter.addFragment(new Self_Employed(), "Self_Employed");

        viewPager.setAdapter(adapter);
    }

    public ViewPagerAdapter getCurrAdapter(){
        return adapter;

    }


    public  class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            //MODIFY THE LOGIC

            String pos= SessionManager.getStringFromPreferences(CarLoanActivity.this,"pos");
            int p=Integer.parseInt(pos);

//            viewPager.setCurrentItem(p);
            /*
            if(p==1){
                Fragment f=new DOB();
                return f;

            }else if(p==2){
                Fragment f=new Gender();
                return f;

            }*/

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
