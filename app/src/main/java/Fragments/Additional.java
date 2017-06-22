package Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elsapp.els.R;

import java.util.ArrayList;
import java.util.List;

import Utility.VerticalViewPager;


public class Additional extends Fragment {

    VerticalViewPager verticalViewPager;
    TextView textView;
    Additional.ViewPagerAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.activity_add_pager, container, false);

       /* Button b1=(Button)view.findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),Add_Pager.class);
                startActivity(i);

            }
        });*/

        verticalViewPager = (VerticalViewPager)view.findViewById(R.id.viewpager);
        setupViewPager(verticalViewPager);
        textView=(TextView)view.findViewById(R.id.page_number);
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



    public void setupViewPager(VerticalViewPager upViewPager) {
        adapter= new Additional.ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Additional_one(),"additionalone");
        adapter.addFragment(new Additional_two(),"additionaltwo");
        adapter.addFragment(new Additional_three(),"additionalthree");
        upViewPager.setAdapter(adapter);
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
}
