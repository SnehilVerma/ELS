package Fragments;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import java.security.spec.ECField;

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
    ImageView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    TextView progress;
    String selcat;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_coapp_cat, container, false);


        tv1=(ImageView) view.findViewById(R.id.retired_np);
        tv2=(ImageView)view.findViewById(R.id.self_pro);
        tv3=(ImageView)view.findViewById(R.id.salary);
        tv7=(ImageView)view.findViewById(R.id.salaryprof);
        tv4=(ImageView)view.findViewById(R.id.self);
        tv5=(ImageView)view.findViewById(R.id.retired_pensioner);
        tv6=(ImageView)view.findViewById(R.id.homemaker);
        loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selcat = "Retired_NPone";
                SessionManager.putStringInPreferences(getActivity(),"Retired_NPone","coappemp");
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
                selcat = "Self_Employedone";
                SessionManager.putStringInPreferences(getActivity(),"Self_Employedone","coappemp");
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
                        adapter.addFragment(new Self_Employed_P(), "Self_Employedone");
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
                    adapter1.addFragment(new Self_Employed_P(), "Self_Employedone");
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
                selcat = "Salariedone";
                SessionManager.putStringInPreferences(getActivity(),"Salariedone","coappemp");
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
                selcat = "Salariedone";
                SessionManager.putStringInPreferences(getActivity(),"Salariedone","coappemp");
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
                        adapter.addFragment(new Salaried_P(), "Salariedone");
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
                        adapter1.addFragment(new Salaried_P(), "Salariedone");
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
                selcat = "Self_Employedone";
                SessionManager.putStringInPreferences(getActivity(),"Self_Employedone","coappemp");
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
                selcat = "Retired_Pone";
                SessionManager.putStringInPreferences(getActivity(),"Retired_Pone","coappemp");
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
                selcat = "Homemaker";
                SessionManager.putStringInPreferences(getActivity(),"Homemaker","coappemp");
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
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("employment_type",selcat);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null) {
            String x = savedInstanceState.getString("employment_type");
            try {
                if (x.equals("Retired_NPone")) {
                    tv1.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else if (x.equals("Self_Employed_Pone")) {
                    tv2.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else if (x.equals("Salariedone")) {
                    tv3.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else if (x.equals("Self_Employedone")) {
                    tv4.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else if (x.equals("Retired_Pone")) {
                    tv5.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else if (x.equals("Homemaker")) {
                    tv6.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else if (x.equals("SalariedProfone")) {
                    tv7.setBackgroundColor(Color.parseColor("#3f8f98"));
                }
            }catch (Exception e){

            }

        }

    }
}
