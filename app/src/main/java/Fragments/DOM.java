package Fragments;

import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.CarLoanActivity.ViewPagerAdapter;
import com.elsapp.els.R;

/**
 * Created by Rishi on 6/13/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class DOM extends Fragment {

    EditText month;
    EditText year;
    int flag=0;
    int gflag=0;

    ViewPager viewPager;
    ViewPagerAdapter ad;

    Calendar myCalender = Calendar.getInstance();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dom,container,false);

        //month = (EditText) view.findViewById(R.id.monthtxt);
        //year=(EditText)view.findViewById(R.id.yeartxt);

        Spinner spin_month=(Spinner)view.findViewById(R.id.spin_month);
        Spinner spin_year=(Spinner)view.findViewById(R.id.spin_year);


        ad=((CarLoanActivity)getActivity()).getCurrAdapter();
        viewPager = ((CarLoanActivity)getActivity()).getViewPager();


        String[] items = new String[]{"No Selection","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        ArrayAdapter<String> d_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,items);
        spin_month.setAdapter(d_adapter);
        String[] items2 = new String[]{"No Selection","2017","2016","2015","2014"};
        ArrayAdapter<String> d_adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,items2);
        spin_year.setAdapter(d_adapter2);


        spin_month.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String check=adapterView.getSelectedItem().toString();
                if(check.equals("No Selection")) {
                    flag = 0;
                }
                else{
                    flag=1;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spin_year.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //   year.setText(adapterView.getSelectedItem().toString());
                String check = adapterView.getSelectedItem().toString();
                if (check.equals("No Selection")) {
                    gflag=0;

                }
                else{
                    if (flag == 0) {
                        Toast.makeText(getContext(), "Choose month first", Toast.LENGTH_SHORT).show();
                    } else {
                        gflag = 1;


                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Button b1=(Button)view.findViewById(R.id.b1);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag==1 && gflag==1) {



                    //TODO:SET SESSION MANAGER FOR MONTH AND YEAR
                    int index=(viewPager.getCurrentItem())+1;
                    if(index<ad.mFragmentList.size()) {

                        ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                        ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                        ad.notifyDataSetChanged();

                    }

                    ad.mFragmentList.add(new PrefCar());
                    ad.mFragmentTitleList.add("PrefCar");
                    ad.notifyDataSetChanged();

                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                }
                else{
                    Toast.makeText(getContext(),"All fields are mandatory",Toast.LENGTH_SHORT).show();

                }

            }
        });











        return view;
    }
}
