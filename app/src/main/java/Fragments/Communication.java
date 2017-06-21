package Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.elsapp.els.Comm_Pager;
import com.elsapp.els.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by snehil on 20/6/17.
 */

public class Communication extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_communication, container, false);

        Button b1=(Button)view.findViewById(R.id.b2);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),Comm_Pager.class);
                startActivity(i);

            }
        });

//        verticalViewPager=(VerticalViewPager)view.findViewById(R.id.viewpager);

  //      setupViewPager(verticalViewPager);

        return view;


    }

    private void setupViewPager(ViewPager viewPager) {
        Communication.ViewPagerAdapter adapter=new Communication.ViewPagerAdapter(getFragmentManager());

        //adapter.addFragment(new Communication(), "Communication");
        adapter.addFragment(new LoanSpecific(), "LoanSpecific");
        adapter.addFragment(new LoanRepayment(), "LoanRepayment");
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
