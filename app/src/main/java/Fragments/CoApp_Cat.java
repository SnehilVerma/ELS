package Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 14/6/17.
 */

public class CoApp_Cat extends Fragment {
    private Context context;
    private String loantype;
    private ViewGroup viewGroup;
    private CarLoanActivity.ViewPagerAdapter adapter;
    private HomeLoan.ViewPagerAdapter adapter1;
    private ViewPager viewPager;
    ProgressBar pb;
    TextView progress;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_coapp_cat, container, false);


        TextView tv1=(TextView)view.findViewById(R.id.retired_np);
        TextView tv2=(TextView)view.findViewById(R.id.self_pro);
        TextView tv3=(TextView)view.findViewById(R.id.salary);
        TextView tv7=(TextView)view.findViewById(R.id.salaryprof);
        TextView tv4=(TextView)view.findViewById(R.id.self);
        TextView tv5=(TextView)view.findViewById(R.id.retired_pensioner);
        TextView tv6=(TextView)view.findViewById(R.id.homemaker);
        loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
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
                        adapter.addFragment(new Retired_NP(), "Retired_NPone");
                        adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                else {
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
                        adapter1.addFragment(new Retired_NP(), "Retired_NPone");
                        adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                pb.setProgress(85);
                progress.setText(85+"");

            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
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
                        adapter.addFragment(new Self_Employed(), "Self_Employedone");
                        adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                else {
                    adapter1 = ((HomeLoan) getActivity()).getCurrAdapter();
                    viewPager = ((HomeLoan) getActivity()).getViewPager();
                    pb = ((HomeLoan)getActivity()).getPb();
                    progress = ((HomeLoan)getActivity()).getprogresstv();
                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < adapter1.mFragmentList.size()) {
                        adapter1.mFragmentList.subList(index, adapter1.mFragmentList.size()).clear();
                        adapter1.mFragmentTitleList.subList(index, adapter1.mFragmentTitleList.size()).clear();
                        adapter1.notifyDataSetChanged();


                    }
                    adapter1.addFragment(new Self_Employed(), "Self_Employedone");
                    adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                pb.setProgress(85);
                progress.setText(85+"");
            }
        });

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
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
                        adapter.addFragment(new Salaried(), "Salariedone");
                        adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                else {
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
                        adapter1.addFragment(new Salaried(), "Salariedone");
                        adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                pb.setProgress(85);
                progress.setText(85+"");

            }
        });
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    pb = ((CarLoanActivity)getActivity()).getPb();
                    progress = ((CarLoanActivity)getActivity()).getprogresstv();
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < adapter.mFragmentList.size()) {
                        adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                        adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                        adapter.notifyDataSetChanged();



                    }
                        adapter.addFragment(new Salaried(), "Salariedone");
                        adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                else {
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
                        adapter1.addFragment(new Salaried(), "Salariedone");
                        adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }

                pb.setProgress(85);
                progress.setText(85+"");
            }
        });

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    pb = ((CarLoanActivity)getActivity()).getPb();
                    progress = ((CarLoanActivity)getActivity()).getprogresstv();
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < adapter.mFragmentList.size()) {
                        adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                        adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                        adapter.notifyDataSetChanged();



                    }
                        adapter.addFragment(new Self_Employed(), "Self_Employedone");
                        adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                else {
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
                        adapter1.addFragment(new Self_Employed(), "Self_Employedone");
                        adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                pb.setProgress(85);
                progress.setText(85+"");
            }
        });

        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    pb = ((CarLoanActivity)getActivity()).getPb();
                    progress = ((CarLoanActivity)getActivity()).getprogresstv();
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < adapter.mFragmentList.size()) {
                        adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                        adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                        adapter.notifyDataSetChanged();



                    }
                        adapter.addFragment(new Retired_P(), "Retired_Pone");
                        adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                else {
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
                        adapter1.addFragment(new Retired_P(), "Retired_Pone");
                        adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                pb.setProgress(85);
                progress.setText(85+"");
            }
        });


        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loantype.equals("CarLoanActivity")) {
                    adapter = ((CarLoanActivity) getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity) getActivity()).getViewPager();
                    pb = ((CarLoanActivity)getActivity()).getPb();
                    progress = ((CarLoanActivity)getActivity()).getprogresstv();

                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < adapter.mFragmentList.size()) {
                        adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                        adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                        adapter.notifyDataSetChanged();


                    }
                    adapter.addFragment(new Homemaker(), "Homemaker");
                    adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                else

                {
                    adapter1 = ((HomeLoan) getActivity()).getCurrAdapter();
                    viewPager = ((HomeLoan) getActivity()).getViewPager();
                    pb = ((HomeLoan)getActivity()).getPb();
                    progress = ((HomeLoan)getActivity()).getprogresstv();
                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < adapter1.mFragmentList.size()) {
                        adapter1.mFragmentList.subList(index, adapter1.mFragmentList.size()).clear();
                        adapter1.mFragmentTitleList.subList(index, adapter1.mFragmentTitleList.size()).clear();
                        adapter1.notifyDataSetChanged();


                    }
                    adapter1.addFragment(new Homemaker(), "Homemaker");
                    adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }

                pb.setProgress(85);
                progress.setText(85+"");
            }
        });


        return view;
    }
}
