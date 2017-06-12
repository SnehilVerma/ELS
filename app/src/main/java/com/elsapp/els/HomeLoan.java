package com.elsapp.els;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import Adapter.QEC_adapter;
import Transformer.PagerTransformer;

public class HomeLoan extends AppCompatActivity {
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_loan);

        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPager.setPageTransformer(true,new PagerTransformer());
        viewPager.setAdapter(new QEC_adapter(this));
        //setUpViewPager(viewPager);
    }
    /*private void setUpViewPager(ViewPager viewPager) {
        HomeLoan.ViewPagerAdapter adapter = new HomeLoan.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Homeloanslide1(), "1");
        adapter.addFragment(new Homeloanslide2(), "2");
        adapter.addFragment(new Homeloanslide3(), "3");
        adapter.addFragment(new Homeloanslide4(), "4");
        adapter.addFragment(new Homeloanslide5(), "5");
        adapter.addFragment(new Homeloanslide6(), "6");
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
    }*/
}
