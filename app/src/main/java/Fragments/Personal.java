package Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.elsapp.els.R;
import com.elsapp.els.personal_pager;

import java.util.ArrayList;
import java.util.List;

import Utility.VerticalViewPager;

public class Personal extends Fragment {
    VerticalViewPager verticalViewPager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       final View view = inflater.inflate(R.layout.activity_personal_pager,container,false);
     /*Button   b2 = (Button) view.findViewById(R.id.b2);
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(getActivity(),personal_pager.class);
               startActivity(i);

           }
       });*/ verticalViewPager=(VerticalViewPager)view.findViewById(R.id.viewpager);

        setupViewPager(verticalViewPager);


        return view;


    }

    private void setupViewPager(ViewPager viewPager) {
        Personal.ViewPagerAdapter adapter=new Personal.ViewPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new personal_1(), "Personal_One");
        adapter.addFragment(new personl_2(), "Personal_Two");
        adapter.addFragment(new personal_3(), "Personal_Three");
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