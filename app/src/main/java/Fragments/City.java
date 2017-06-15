package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 9/6/17.
 */

public class City extends Fragment {

    CheckBox delhi;
    CheckBox mumbai;

    private CarLoanActivity.ViewPagerAdapter ad;
    private HomeLoan.ViewPagerAdapter ad2;
    private ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_city, container, false);
        mumbai = (CheckBox) view.findViewById(R.id.mumbai);
        delhi= (CheckBox) view.findViewById(R.id.delhi);
        ImageView others = (ImageView) view.findViewById(R.id.others);
        final EditText editothers = (EditText) view.findViewById(R.id.editothers);


        final SessionManager sessionManager=new SessionManager();


        String type=SessionManager.getStringFromPreferences(getContext(),"loantype");
        if(type.equals("CarLoanActivity")) {
            ad = ((CarLoanActivity) getActivity()).getCurrAdapter();
            viewPager = ((CarLoanActivity) getActivity()).getViewPager();
        }
        else if(type.equals("HomeLoan")){
            ad2 = ((HomeLoan)getActivity()).getCurrAdapter();
            viewPager = ((HomeLoan)getActivity()).getViewPager();

        }






        mumbai.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                boolean check2=delhi.isChecked();
                if(b==true && check2==false){
                    mumbai.setChecked(true);
                    delhi.setChecked(false);
                    editothers.setText("Mumbai");
                }else if(b==false && check2==false){
                    mumbai.setChecked(false);
                    delhi.setChecked(false);
                    editothers.setText("None");

                }else if(b==true && check2==true){
                    mumbai.setChecked(true);
                    delhi.setChecked(false);
                    editothers.setText("Mumbai");

                }
                //Toast.makeText(getContext(),""+b+"   "+ check2,Toast.LENGTH_SHORT).show();



            }
        });

        delhi.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                boolean check=mumbai.isChecked();
                if(b==true && check==false){
                    mumbai.setChecked(false);
                    delhi.setChecked(true);
                    editothers.setText("Delhi");
                }else if(b==false && check==false){
                    mumbai.setChecked(true);
                    delhi.setChecked(true);
                    editothers.setText("None");

                }else if(b==true && check==true){
                    mumbai.setChecked(false);
                    delhi.setChecked(true);
                    editothers.setText("Delhi");
                }



            }
        });



        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

              //  sessionManager.putStringInPreferences(getActivity(),editothers.getText().toString(),"city_car");
               // Log.d("1",editothers.getText().toString());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

                //Toast.makeText(getContext(),""+editothers.getText().toString(),Toast.LENGTH_SHORT).show();


            }
        });





        return view;

    }










}
