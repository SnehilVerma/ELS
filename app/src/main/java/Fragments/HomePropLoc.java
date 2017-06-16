package Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 9/6/17.
 */

public class HomePropLoc extends Fragment {
    ViewPager viewPager;
    HomeLoan.ViewPagerAdapter ad;
    CheckBox mumbai;
    CheckBox delhi;
    EditText editothers;
    String text;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_home_proploc, container, false);


        mumbai = (CheckBox)view.findViewById(R.id.mumbai);
        delhi = (CheckBox) view.findViewById(R.id.delhi);
        ImageView others = (ImageView) view.findViewById(R.id.others);
        TextView t1 = (TextView) view.findViewById(R.id.prev);
        TextView t2 = (TextView) view.findViewById(R.id.next);
        Button b1 = (Button)  view.findViewById(R.id.button);
        editothers = (EditText) view.findViewById(R.id.editothers);
        ad = ((HomeLoan)getActivity()).getCurrAdapter();
        viewPager = ((HomeLoan)getActivity()).getViewPager();
        mumbai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                boolean check2=delhi.isChecked();


                if(b==true && check2==false){
                    mumbai.setChecked(true);
                    delhi.setChecked(false);


                    editothers.setText("Mumbai");
                    String text=editothers.getText().toString();
                    //SessionManager.putStringInPreferences(getActivity(),text.toString(),"homeproploc");


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
                    //SessionManager.putStringInPreferences(getActivity(),text.toString(),"homeproploc");


                }


                //Toast.makeText(getContext(),""+b+"   "+ check2,Toast.LENGTH_SHORT).show();



            }
        });

        delhi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                boolean check=mumbai.isChecked();
                if(b==true && check==false){
                    mumbai.setChecked(false);
                    delhi.setChecked(true);
                    editothers.setText("Delhi");
                    String text=editothers.getText().toString();
                    //SessionManager.putStringInPreferences(getActivity(),text.toString(),"homeproploc");

                }else if(b==false && check==false){
                    mumbai.setChecked(false);
                    delhi.setChecked(false);
                    editothers.setText("None");

                }else if(b==true && check==true){
                    mumbai.setChecked(false);
                    delhi.setChecked(true);
                    editothers.setText("Delhi");
                    String text=editothers.getText().toString();
                    //SessionManager.putStringInPreferences(getActivity(),text.toString(),"homeproploc");

                }






            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = editothers.getText().toString();
                if(text == null){
                    Toast.makeText(getActivity(),"Enter the fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    SessionManager.putStringInPreferences(getActivity(), text.toString(), "homeproploc");
                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad.mFragmentList.size()) {
                        ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                        ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                        ad.notifyDataSetChanged();


                    }
                    ad.addFragment(new HomeLoanPurpose(), "HomeLoanPurpose");
                    ad.notifyDataSetChanged();
                }

            }
        });
        final ViewPager viewPager = ((HomeLoan)getActivity()).getViewPager();
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });
        return view;

    }
}
