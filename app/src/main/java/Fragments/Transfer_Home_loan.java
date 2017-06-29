package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elsapp.els.R;

import java.util.ArrayList;
import java.util.List;

import Utility.VerticalViewPager;

/**
 * Created by sibby on 26/6/17.
 */

public class Transfer_Home_loan extends Fragment{

    VerticalViewPager verticalViewPager;
    TextView textView;
    Transfer_Home_loan.ViewPagerAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.transfer_homeloan, container, false);

        textView=(TextView)view.findViewById(R.id.page_number);
        verticalViewPager=(VerticalViewPager)view.findViewById(R.id.viewpager);



        setupViewPager(verticalViewPager);
        textView.setText(String.valueOf(1)+"/"+String.valueOf(adapter.getCount()));

        verticalViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
        adapter=new Transfer_Home_loan.ViewPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new Transferhomeloan1(), "Transfer_Home_One");
        adapter.addFragment(new Transferhomeloan2(), "Transfer_Home_Two");
        adapter.addFragment(new Transferhomeloan3(), "Transfer_Home_Three");
        adapter.addFragment(new Transferhomeloan4(), "Transfer_Home_Four");


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

    //return viewpager instance.
    public VerticalViewPager getVerticalViewPager(){
        return verticalViewPager;

    }
}
