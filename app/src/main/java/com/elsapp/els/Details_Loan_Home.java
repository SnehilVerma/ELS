package com.elsapp.els;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Fragments.Communication;
import Fragments.Identified_Home;
import Fragments.Land_Purchase;
import Fragments.LoanRepayment;
import Fragments.Personal;
import Fragments.Repair_Renov;
import Fragments.Transfer_Home_loan;


/**
 * Created by snehil on 21/6/17.
 */

public class Details_Loan_Home extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    String purpose;
    private int icons[]={R.drawable.transferloan,R.drawable.communication,R.drawable.loanspecific,R.drawable.loanrepay
            ,R.drawable.additional};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details_loan);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        purpose=getIntent().getStringExtra("purpose");
        setupViewPager(viewPager);


        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.setupWithViewPager(viewPager);
        setupIcons(tabLayout);



    }



    private void setupViewPager(ViewPager viewPager) {
        Details_Loan_Home.ViewPagerAdapter adapter=new Details_Loan_Home.ViewPagerAdapter(getSupportFragmentManager());
        if(purpose.equals("1")){
            adapter.addFragment(new Identified_Home(), "Identified_Home");

        }else if(purpose.equals("2")){
            adapter.addFragment(new Repair_Renov(),"Repair_Renov");

        }else if(purpose.equals("3")){
            adapter.addFragment(new Land_Purchase(),"Land_Purchase");

        }else{
            adapter.addFragment(new Transfer_Home_loan(),"Transfer_Home_Loan");
        }

        adapter.addFragment(new Personal(),"Personal");
        adapter.addFragment(new Communication(),"Communication");
        adapter.addFragment(new LoanRepayment(), "LoanRepayment");
        viewPager.setAdapter(adapter);

    }


    private void setupIcons(TabLayout tabLayout){


        /*
        TextView textView=new TextView(this);
        textView.setText("TRANSFER LOAN");
        textView.setCompoundDrawablesWithIntrinsicBounds(0,icons[0],0,0);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100, 100);
        params.setMargins(0,0,0,0);
        textView.setLayoutParams(params);
        */
        View v= LayoutInflater.from(this).inflate(R.layout.tab_item,null);
        TextView textView=(TextView)v.findViewById(R.id.tab_text);
        ImageView imageView=(ImageView)v.findViewById(R.id.tab_image);

        if(purpose.equals("1")){
            imageView.setImageResource(icons[0]);
            textView.setText("PURCHASE PROPERTY");
            tabLayout.getTabAt(0).setCustomView(v);
        }
        else if(purpose.equals("2")){
            imageView.setImageResource(icons[0]);
            textView.setText("RENOVATE PROPERTY");
            tabLayout.getTabAt(0).setCustomView(v);

        }
        else if(purpose.equals("3")){
            imageView.setImageResource(icons[0]);
            textView.setText("CONSTRUCTION OF HOUSE");
            tabLayout.getTabAt(0).setCustomView(v);
        }
        else if(purpose.equals("4")){
            imageView.setImageResource(icons[0]);
            textView.setText("TRANSFER LOAN");
            tabLayout.getTabAt(0).setCustomView(v);


        }



        View v2= LayoutInflater.from(this).inflate(R.layout.tab_item,null);
        TextView textView2=(TextView)v2.findViewById(R.id.tab_text);
        ImageView imageView2=(ImageView)v2.findViewById(R.id.tab_image);
        imageView2.setImageResource(icons[1]);
        textView2.setText("PERSONAL");
        tabLayout.getTabAt(1).setCustomView(v2);


        //tabLayout.getTabAt(0).setIcon(icons[0]);
        View v3= LayoutInflater.from(this).inflate(R.layout.tab_item,null);
        TextView textView3=(TextView)v3.findViewById(R.id.tab_text);
        ImageView imageView3=(ImageView)v3.findViewById(R.id.tab_image);
        imageView3.setImageResource(icons[2]);
        textView3.setText("COMMUNICATION");
        tabLayout.getTabAt(2).setCustomView(v3);


        View v4= LayoutInflater.from(this).inflate(R.layout.tab_item,null);
        TextView textView4=(TextView)v4.findViewById(R.id.tab_text);
        ImageView imageView4=(ImageView)v4.findViewById(R.id.tab_image);
        imageView4.setImageResource(icons[3]);
        textView4.setText("LOAN REPAYMENT");
        tabLayout.getTabAt(3).setCustomView(v4);





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

    public ViewPager getViewPager(){
        return viewPager;
    }
}
