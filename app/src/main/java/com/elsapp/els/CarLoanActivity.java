package com.elsapp.els;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Fragments.City;
import Fragments.VehIntro;
import Transformer.PagerTransformer;
import Utility.SessionManager;


public class CarLoanActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    ProgressBar pb;
    TextView progress;
    Boolean doublebackpresstoexit;

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
        progress = (TextView)findViewById(R.id.progress);
        pb = (ProgressBar) findViewById(R.id.pb);
        pb.setProgress(0);
        SessionManager.putStringInPreferences(CarLoanActivity.this,"0","pos");
        setSupportActionBar(toolbar);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/roboto.ttf");

        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPager.setPageTransformer(true,new PagerTransformer());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        doublebackpresstoexit = false;
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
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(doublebackpresstoexit){
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                System.exit(0);
                return;
            }
            this.doublebackpresstoexit = true;
            Toast.makeText(this,"Press BACK again to exit",Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doublebackpresstoexit = false;
                }
            },2000);
            //super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loan_selec, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
       /* Fragment newFragment;
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();*/


        int id = item.getItemId();
        if(id==R.id.nav_login){
            Intent intent = new Intent(CarLoanActivity.this,LogInActivity.class);
            startActivity(intent);

        }
        if(id == R.id.nav_QVC){
            Intent intent = new Intent(CarLoanActivity.this,LoanSelec.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public ViewPager getViewPager(){
        return viewPager;
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setUpViewPager(ViewPager viewPager) {
        adapter = new CarLoanActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new VehIntro(),"VehIntro");
        adapter.addFragment(new City(), "City");



        viewPager.setAdapter(adapter);

    }

    public ViewPagerAdapter getCurrAdapter(){
        return adapter;

    }
    public TextView getprogresstv(){ return progress; }
    public ProgressBar getPb(){
        return pb;
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
