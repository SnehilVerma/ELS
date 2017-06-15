package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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

        Button b1=(Button)view.findViewById(R.id.b1);


        final SessionManager sessionManager=new SessionManager();


        final String type=SessionManager.getStringFromPreferences(getContext(),"loantype");
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
                    String text=editothers.getText().toString();
                    sessionManager.putStringInPreferences(getActivity(),text.toString(),"city_car");


                    int flag=0;

                    //TEST DATA.




                    //Toast.makeText(getContext(),index+"" + ad.mFragmentList.size(), Toast.LENGTH_LONG).show();

                    /*
                    if(index<ad.mFragmentList.size()) {

                        ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                        ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();




                    }*/

                    //Toast.makeText(getContext(),ad.mFragmentList.size()+" ",Toast.LENGTH_SHORT).show();

                    //ad.mFragmentList.add(new VehLoanCost());
                    //ad.mFragmentTitleList.add("VehLoanCost");
                   // ad.notifyDataSetChanged();







                }else if(b==false && check2==false){
                    mumbai.setChecked(false);
                    delhi.setChecked(false);
                    editothers.setText("None");

                }else if(b==true && check2==true){
                    mumbai.setChecked(true);
                    delhi.setChecked(false);
                    editothers.setText("Mumbai");
                    String text=editothers.getText().toString();
                    sessionManager.putStringInPreferences(getActivity(),text.toString(),"city_car");


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
                    String text=editothers.getText().toString();
                    sessionManager.putStringInPreferences(getActivity(),text.toString(),"city_car");

                }else if(b==false && check==false){
                    mumbai.setChecked(false);
                    delhi.setChecked(false);
                    editothers.setText("None");

                }else if(b==true && check==true){
                    mumbai.setChecked(false);
                    delhi.setChecked(true);
                    editothers.setText("Delhi");
                    String text=editothers.getText().toString();
                    sessionManager.putStringInPreferences(getActivity(),text.toString(),"city_car");

                }






            }
        });


        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=editothers.getText().toString();
                if(type.equals("CarLoanActivity")) {
                    if (text == null) {

                        Toast.makeText(getContext(), "Fill city info.", Toast.LENGTH_SHORT).show();
                    } else {


                        sessionManager.putStringInPreferences(getActivity(), text.toString(), "city_car");

                        int index = (viewPager.getCurrentItem()) + 1;
                        if (index < ad.mFragmentList.size()) {

                            ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                            ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                            ad.notifyDataSetChanged();

                        }


                        ad.addFragment(new VehSelect(), "VehSelect");
                        ad.notifyDataSetChanged();
                        Log.d("1", editothers.getText().toString());

                    }
                }
                else{
                    if (text == null) {

                        Toast.makeText(getContext(), "Fill city info.", Toast.LENGTH_SHORT).show();
                    } else {


                        sessionManager.putStringInPreferences(getActivity(), text.toString(), "city_car");

                        int index = (viewPager.getCurrentItem()) + 1;
                        if (index < ad2.mFragmentList.size()) {

                            ad2.mFragmentList.subList(index, ad2.mFragmentList.size()).clear();
                            ad2.mFragmentTitleList.subList(index, ad2.mFragmentTitleList.size()).clear();
                            ad2.notifyDataSetChanged();

                        }


                        ad2.addFragment(new Gender(), "Gender");
                        ad2.addFragment(new DOB(), "DOB");
                        ad2.addFragment(new HomePropLoc(), "HomePropLoc");
                        ad2.addFragment(new HomeLoanPurpose(), "HomeLoanPurpose");
                        ad2.addFragment(new HomePropCost(), "HomePropCost");
                        ad2.notifyDataSetChanged();
                        Log.d("1", editothers.getText().toString());

                    }
                }
            }
        });







        return view;

    }










}
