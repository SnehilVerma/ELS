package com.elsapp.els;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import Adapter.CustomGrid;
import Utility.SessionManager;

public class LoanSelec extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
   // FragmentManager mFragmentManager;


    private String loantype;
    GridView grid;
    String[] loans = {"vehicle","education","Home","gold"};
    int[] pic_loans = {

            R.drawable.vehicleloan,
            R.drawable.education,
            R.drawable.homeloan,
            R.drawable.goldloan



    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_selec);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        CustomGrid adapter = new CustomGrid(LoanSelec.this, pic_loans);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(position==1){
                    Intent i=new Intent(LoanSelec.this,CarLoanActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    loantype = "Vehicle";
                    SessionManager.putStringInPreferences(getApplicationContext(),loantype,"loantype");
                    SessionManager.putStringInPreferences(getApplicationContext(),"0","flaggy");
                    startActivity(i);
                }
                else if(position==0){
                    Intent i=new Intent(LoanSelec.this,HomeLoan.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    loantype = "Home";
                    SessionManager.putStringInPreferences(getApplicationContext(),loantype,"loantype");
                    SessionManager.putStringInPreferences(getApplicationContext(),"0","flaggy");
                    startActivity(i);

                }

            }
        });





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
            Intent intent = new Intent(LoanSelec.this,LogInActivity.class);
            startActivity(intent);

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
