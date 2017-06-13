package com.elsapp.els;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Fragments.City;
import Fragments.DOB;
import Fragments.Gender;
import Fragments.VehIntro;
import Fragments.VehSelect;
import Transformer.PagerTransformer;
import Utility.SessionManager;


public class CarLoanActivity extends AppCompatActivity {

    QEC_Model[] layouts = new QEC_Model[]{
            new QEC_Model(R.layout.fragment_veh_type),
            new QEC_Model(R.layout.fragment_car_type)
    };


    private ViewPager viewPager;
    public CarLoanActivity.ViewPagerAdapter adapter;


    @RequiresApi(api = Build.VERSION_CODES.N)
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

    public ViewPager getViewPager(){
        return viewPager;
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setUpViewPager(ViewPager viewPager) {
        adapter = new CarLoanActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new VehIntro(),"VehIntro");
        adapter.addFragment(new City(), "City");
        adapter.addFragment(new Gender(),"Gender");
        adapter.addFragment(new DOB(),"Date of Birth");
        adapter.addFragment(new VehSelect(), "VehSelect");
       //adapter.addFragment(new NumAndEmail(), "NumAndEmail");



        viewPager.setAdapter(adapter);

    }

    public ViewPagerAdapter getCurrAdapter(){
        return adapter;

    }


    public  class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public final List<Fragment> mFragmentList = new ArrayList<>();
        public final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }


        @Override
        public int getItemPosition(Object object) {
            return adapter.POSITION_NONE;
        }


        @Override
        public Fragment getItem(int position) {
            //MODIFY THE LOGIC


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






        public void remFragment(Fragment fragment,String title){
        //    mFragmentList.remove(fragment);

            int p=0;
            /*
            for(String x : mFragmentTitleList){

                if(x.equals(title)) {
                    p=mFragmentTitleList.indexOf(x);
                    break;
                }


            }
            */

            //Toast.makeText(getApplicationContext(),title+' '+ p,Toast.LENGTH_SHORT ).show();
            mFragmentList.remove(fragment);
            mFragmentTitleList.remove(title);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }


    }

}
