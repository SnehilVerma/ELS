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
 * Created by snehil on 20/6/17.
 */

public class Communication extends Fragment {


    VerticalViewPager verticalViewPager;
    TextView textView;
    Communication.ViewPagerAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_communication, container, false);

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
                //textView.setText(String.valueOf(verticalViewPager.getCurrentItem()+1)+"/"+"3");
                textView.setText(String.valueOf(position+1)+"/"+String.valueOf(adapter.getCount()));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        return view;


    }



    private void setupViewPager(ViewPager viewPager) {
        adapter=new Communication.ViewPagerAdapter(getChildFragmentManager());

        //adapter.addFragment(new Communication(), "Communication");
        adapter.addFragment(new Fragment_Comm_One(), "Fragment_Comm_One");
        adapter.addFragment(new Fragment_Comm_Two(), "Fragment_Comm_Two");
        //TODO: UNcomment the below line when in full production flow.
      //if(SessionManager.getStringFromPreferences(getContext(),"employment_type").equals("Self_Employed")){
            adapter.addFragment(new Fragment_Comm_Three(),"Fragment_Comm_Three");

        //}
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
