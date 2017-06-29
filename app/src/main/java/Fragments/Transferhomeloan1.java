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

public class Transferhomeloan1 extends Fragment {


    VerticalViewPager verticalViewPager;
    EditText et1,et2,et3,et4;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_transferhomeloan1,container,false);

        Transfer_Home_loan transfer_home_loan=(Transfer_Home_loan)this.getParentFragment();
        verticalViewPager=transfer_home_loan.getVerticalViewPager();

        et1=(EditText)view.findViewById(R.id.nameofbank);
        et2=(EditText)view.findViewById(R.id.ifsccode);
        et3=(EditText)view.findViewById(R.id.accno);
        et4=(EditText)view.findViewById(R.id.purpose);


        verticalViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==1){

                    if(et1.getText().length()==0 || et2.getText().length()==0 || et3.getText().length()==0|| et4.getText().length()==0){
                        Snackbar snackbar = Snackbar.make(view,"Enter all bank details",Snackbar.LENGTH_SHORT);
                        snackbar.show();
                        verticalViewPager.setCurrentItem(0);


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
