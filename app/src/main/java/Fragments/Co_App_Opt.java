package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 14/6/17.
 */

public class Co_App_Opt extends Fragment {
    private ViewPager viewPager;
    private CarLoanActivity.ViewPagerAdapter adapter;
    private HomeLoan.ViewPagerAdapter adapter1;
    private String loantype;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_co_app_opt, container, false);
        loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");
        final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //Toast.makeText(getActivity(), String.valueOf(checkedId),Toast.LENGTH_SHORT).show();
                int id1 = radioGroup.getCheckedRadioButtonId();
                //Toast.makeText(getActivity(), String.valueOf(id1),Toast.LENGTH_SHORT).show();
                View radiobutton = radioGroup.findViewById(id1);
                int idx = radioGroup.indexOfChild(radiobutton);
                //Toast.makeText(getActivity(), String.valueOf(idx),Toast.LENGTH_SHORT).show();
                if(idx == 0){
                    if(loantype.equals("HomeLoan")){
                        adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                        viewPager = ((HomeLoan)getActivity()).getViewPager();
                        int flag=0;
                        for(int y = 0;y< adapter1.mFragmentTitleList.size();y++) {
                            if (adapter1.mFragmentTitleList.get(y).equals("CoApp")) {
                                flag = 1;
                                break;
                            }
                        }
                        if(flag == 0){
                            adapter1.addFragment(new CoAPP(), "CoApp");
                            adapter1.notifyDataSetChanged();
                            adapter1.addFragment(new CoApp_Cat(), "CoAppCat");
                            adapter1.notifyDataSetChanged();
                        }
                        else{
                            Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                        viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                        int flag=0;
                        for(int y = 0;y< adapter.mFragmentTitleList.size();y++) {
                            if (adapter.mFragmentTitleList.get(y).equals("CoApp")) {
                                flag = 1;
                                break;
                            }
                        }
                        if(flag == 0){
                            adapter.addFragment(new CoAPP(), "CoApp");
                            adapter.notifyDataSetChanged();
                            adapter.addFragment(new CoApp_Cat(), "CoAppCat");
                            adapter.notifyDataSetChanged();
                        }
                        else{
                            Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else{
                    if(loantype.equals("HomeLoan")){
                        adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                        viewPager = ((HomeLoan)getActivity()).getViewPager();
                        for(int y = 0;y< adapter1.mFragmentTitleList.size();y++) {
                            if (adapter1.mFragmentTitleList.get(y).equals("CoApp")) {
                                adapter1.mFragmentList.remove(viewPager.getCurrentItem()+2);
                                adapter1.mFragmentTitleList.remove("CoAppCat");
                                adapter1.notifyDataSetChanged();
                                adapter1.mFragmentList.remove(viewPager.getCurrentItem()+1);
                                adapter1.mFragmentTitleList.remove("CoApp");
                                adapter1.notifyDataSetChanged();
                                break;
                            }
                        }
                    }
                    else {
                        adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                        viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                        for(int y = 0;y< adapter.mFragmentTitleList.size();y++) {
                            if (adapter.mFragmentTitleList.get(y).equals("CoApp")) {
                                adapter.mFragmentList.remove(viewPager.getCurrentItem()+2);
                                adapter.mFragmentTitleList.remove("CoAppCat");
                                adapter.notifyDataSetChanged();
                                adapter.mFragmentList.remove(viewPager.getCurrentItem()+1);
                                adapter.mFragmentTitleList.remove("CoApp");
                                adapter.notifyDataSetChanged();
                                break;
                            }
                        }
                        adapter.mFragmentList.add(new Requested_Loan());
                        adapter.mFragmentTitleList.add("Requested_Loan");
                        adapter.notifyDataSetChanged();
                    }
                }
                // checkedId is the RadioButton selected
            }
        });

        return view;

    }
}
