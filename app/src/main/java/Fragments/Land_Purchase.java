package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elsapp.els.R;

import java.util.ArrayList;
import java.util.List;

import Utility.VerticalViewPager;

/**
 * Created by snehil on 26/6/17.
 */

public class Land_Purchase extends Fragment {


    VerticalViewPager verticalViewPager;
    TextView textView;
    Land_Purchase.ViewPagerAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.land_purchase_home, container, false);

        textView=(TextView)view.findViewById(R.id.page_number);
        verticalViewPager=(VerticalViewPager)view.findViewById(R.id.viewpager);

        setupViewPager(verticalViewPager);
        textView.setText(String.valueOf(1)+"/"+String.valueOf(adapter.getCount()));

        verticalViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                textView.setText(String.valueOf(position+1)+"/"+String.valueOf(adapter.getCount()));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        return view;


    }



    private void setupViewPager(ViewPager viewPager) {
        adapter=new Land_Purchase.ViewPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new LandPurchase1(), "Landpurchase1");
        adapter.addFragment(new Landpurchase2(), "Landpurchase2");
        adapter.addFragment(new Landpurchase3(),"Landpurchase3");


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
