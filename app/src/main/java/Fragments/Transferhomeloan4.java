package Fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.elsapp.els.Details_Loan_Home;
import com.elsapp.els.R;

import Utility.VerticalViewPager;

/**
 * Created by sibby on 26/6/17.
 */

public class Transferhomeloan4 extends Fragment {


    VerticalViewPager verticalViewPager;
    ViewPager viewPager;
    View view;
    EditText et1,et2,et3,et4,et5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_transferhomeloan4,container,false);

        Button b=(Button)view.findViewById(R.id.butnext);


        Transfer_Home_loan transfer_home_loan=(Transfer_Home_loan)this.getParentFragment();
        verticalViewPager=transfer_home_loan.getVerticalViewPager();

        viewPager=((Details_Loan_Home)getActivity()).getViewPager();


        et1=(EditText)view.findViewById(R.id.branchdep);
        et2=(EditText)view.findViewById(R.id.datedep);
        et3=(EditText)view.findViewById(R.id.subregoff);
        et4=(EditText)view.findViewById(R.id.datemort);
        et5=(EditText)view.findViewById(R.id.secdetails);

        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().length() == 0 || et2.getText().length() == 0 || et3.getText().length() == 0 || et4.getText().length() == 0 || et5.getText().length() == 0) {
                    Snackbar snackbar = Snackbar.make(view, "Enter all Mortagage details", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                    verticalViewPager.setCurrentItem(3);
                }else{

                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                }
            }
        });



        return view;
    }
}
