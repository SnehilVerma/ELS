package Fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.elsapp.els.R;

import Utility.VerticalViewPager;

public class Transferhomeloan3 extends Fragment {


    VerticalViewPager verticalViewPager;
    View view;
    EditText et1,et2,et3,et4,et5,et6,et7,et8,et9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_transferhomeloan3,container,false);

        Transfer_Home_loan transfer_home_loan=(Transfer_Home_loan)this.getParentFragment();
        verticalViewPager=transfer_home_loan.getVerticalViewPager();

        et1=(EditText)view.findViewById(R.id.loan);
        et2=(EditText)view.findViewById(R.id.rateofint);
        et3=(EditText)view.findViewById(R.id.loandate);
        et4=(EditText)view.findViewById(R.id.tenure);
        et5=(EditText)view.findViewById(R.id.loanrepay);
        et6=(EditText)view.findViewById(R.id.emi);
        et7=(EditText)view.findViewById(R.id.outbal);
        et8=(EditText)view.findViewById(R.id.takeoverbal);
        et9=(EditText)view.findViewById(R.id.addamount);



        verticalViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 3) {
                    if (et1.getText().length() == 0 || et2.getText().length() == 0 || et3.getText().length() == 0 || et4.getText().length() == 0
                            || et5.getText().length() == 0 || et6.getText().length() == 0 || et7.getText().length() == 0 || et8.getText().length() == 0
                            || et9.getText().length() == 0) {
                        Snackbar snackbar = Snackbar.make(view,"Enter all loan details",Snackbar.LENGTH_SHORT);
                        snackbar.show();
                        verticalViewPager.setCurrentItem(2);

                    }

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }


}
