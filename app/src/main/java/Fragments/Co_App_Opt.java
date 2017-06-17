package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
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
    ProgressBar pb;
    TextView progress;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_co_app_opt, container, false);
        loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");
        final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radiogroup);
        //final RadioButton yes = (RadioButton) view.findViewById(R.id.yes);
        //final RadioButton no = (RadioButton) view.findViewById(R.id.no);
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
                    //yes.setChecked(true);
                    if(loantype.equals("Home")){
                        adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                        viewPager = ((HomeLoan)getActivity()).getViewPager();
                        pb = ((HomeLoan)getActivity()).getPb();
                        progress = ((HomeLoan)getActivity()).getprogresstv();
                            int index = (viewPager.getCurrentItem()) + 1;
                            if (index < adapter1.mFragmentList.size()) {
                                adapter1.mFragmentList.subList(index, adapter1.mFragmentList.size()).clear();
                                adapter1.mFragmentTitleList.subList(index, adapter1.mFragmentTitleList.size()).clear();
                                adapter1.notifyDataSetChanged();



                            }
                            adapter1.addFragment(new CoAPP(), "CoApp");
                            adapter1.notifyDataSetChanged();
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }
                    else {
                        adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                        viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                        pb = ((CarLoanActivity)getActivity()).getPb();
                        progress = ((CarLoanActivity)getActivity()).getprogresstv();
                            int index = (viewPager.getCurrentItem()) + 1;
                            if (index < adapter.mFragmentList.size()) {
                                adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                                adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                                adapter.notifyDataSetChanged();



                            }
                            adapter.addFragment(new CoAPP(), "CoApp");
                            adapter.notifyDataSetChanged();
                            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }
                    pb.setProgress(75);
                    progress.setText(75+"");
                }
                else{
                    //no.setChecked(true);
                    if(loantype.equals("Home")){
                        adapter1 = ((HomeLoan)getActivity()).getCurrAdapter();
                        viewPager = ((HomeLoan)getActivity()).getViewPager();
                        pb = ((HomeLoan)getActivity()).getPb();
                        progress = ((HomeLoan)getActivity()).getprogresstv();
                                int index = (viewPager.getCurrentItem()) + 1;
                                if (index < adapter1.mFragmentList.size()) {
                                    adapter1.mFragmentList.subList(index, adapter1.mFragmentList.size()).clear();
                                    adapter1.mFragmentTitleList.subList(index, adapter1.mFragmentTitleList.size()).clear();
                                    adapter1.notifyDataSetChanged();



                                }
                        adapter1.addFragment(new Requested_Loan(), "Requested_Loan");
                        adapter1.notifyDataSetChanged();
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                            }
                    else {
                        adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                        viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                        pb = ((CarLoanActivity)getActivity()).getPb();
                        progress = ((CarLoanActivity)getActivity()).getprogresstv();
                                int index = (viewPager.getCurrentItem()) + 1;
                                if (index < adapter.mFragmentList.size()) {
                                    adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                                    adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                                    adapter.notifyDataSetChanged();



                                }
                       adapter.mFragmentList.add(new Requested_Loan());
                        adapter.mFragmentTitleList.add("Requested_Loan");
                        adapter.notifyDataSetChanged();
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    }
                    pb.setProgress(90);
                    progress.setText(90+"");
                }
                // checkedId is the RadioButton selected
            }
        });

        return view;

    }
}
