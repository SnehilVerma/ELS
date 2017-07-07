package Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by snehil on 12/6/17.
 */

public class Select_Category extends Fragment {
    private Context context;
    private String loantype;
    private ViewGroup viewGroup;
    private CarLoanActivity.ViewPagerAdapter adapter;
    private HomeLoan.ViewPagerAdapter adapter1;
    private ViewPager viewPager;
    ProgressBar pb;
    ImageView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    String sel;
    TextView progress;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_select_cat, container, false);



        // CHHUTIYA TEST . REMOVE AFTER CHECIKING
        //String[] s=new String[4];
        //s[0]=SessionManager.getStringFromPreferences(getContext(),"loan_type");
        //s[1]=SessionManager.getStringFromPreferences(getContext(),"car_type");
        //s[2]=SessionManager.getStringFromPreferences(getContext(),"city_car");

       // Toast.makeText(getContext(),""+s[0]+" "+s[1]+ " "+ s[2],Toast.LENGTH_SHORT).show();



        tv1=(ImageView)view.findViewById(R.id.retired_np);
        tv2=(ImageView)view.findViewById(R.id.self_pro);
        tv3=(ImageView)view.findViewById(R.id.salary);
        tv7=(ImageView)view.findViewById(R.id.salaryprof);
        tv4=(ImageView)view.findViewById(R.id.self);
        tv5=(ImageView)view.findViewById(R.id.retired_pensioner);
        tv6=(ImageView)view.findViewById(R.id.homemaker);
        loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");
        SessionManager.putStringInPreferences(getActivity(),"0","flaggy");

        tv1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sel = "Retired_NP";

                SessionManager.putStringInPreferences(getContext(),"Retired_NP","employment_type");
                if(loantype.equals("Vehicle")) {
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
                        adapter.addFragment(new Retired_NP(), "Retired_NP");
                        adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(80);
                    progress.setText(80+"");
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
                        adapter1.addFragment(new Retired_NP(), "Retired_NP");
                        adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(60);
                    progress.setText(60+"");
                }

            }
        });

        tv2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sel = "Self_Employed_P";

                SessionManager.putStringInPreferences(getContext(),"Self_Employed_P","employment_type");

                if(loantype.equals("Vehicle")) {
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
                        adapter.addFragment(new Self_Employed_P(), "Self_Employed");
                        adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(80);
                    progress.setText(80+"");
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
                        adapter1.addFragment(new Self_Employed_P(), "Self_Employed");
                        adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(60);
                    progress.setText(60+"");
                }
            }
        });

        tv3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sel = "Salaried";
                if(loantype.equals("Vehicle")) {
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                    pb = ((CarLoanActivity)getActivity()).getPb();
                    progress = ((CarLoanActivity)getActivity()).getprogresstv();
                    SessionManager.putStringInPreferences(getContext(),"Salaried","employment_type");
                    //SET EMPLOYEMENT TYPE.

                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < adapter.mFragmentList.size()) {
                        adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                        adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                        adapter.notifyDataSetChanged();



                    }
                        adapter.addFragment(new Salaried(), "Salaried");
                        adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(80);
                    progress.setText(80+"");
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
                        adapter1.addFragment(new Salaried(), "Salaried");
                        adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(60);
                    progress.setText(60+"");
                }

            }
        });

        tv7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                 sel = "SalariedProf";
                if(loantype.equals("Vehicle")) {
                    adapter = ((CarLoanActivity)getActivity()).getCurrAdapter();
                    viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                    pb = ((CarLoanActivity)getActivity()).getPb();
                    progress = ((CarLoanActivity)getActivity()).getprogresstv();
                    SessionManager.putStringInPreferences(getContext(),"SalariedProf","employment_type");
                    //SET EMPLOYEMENT TYPE.

                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < adapter.mFragmentList.size()) {
                        adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                        adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                        adapter.notifyDataSetChanged();



                    }
                        adapter.addFragment(new Salaried_P(), "Salaried");
                        adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(80);
                    progress.setText(80+"");
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
                        adapter1.addFragment(new Salaried_P(), "Salaried");
                        adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(60);
                    progress.setText(60+"");
                }

            }
        });

        tv4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                sel = "Self_Employed";
                SessionManager.putStringInPreferences(getContext(),"Self_Employed","employment_type");
                if(loantype.equals("Vehicle")) {
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
                        adapter.addFragment(new Self_Employed(), "Self_Employed");
                        adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(80);
                    progress.setText(80+"");
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
                        adapter1.addFragment(new Self_Employed(), "Self_Employed");
                        adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(60);
                    progress.setText(60+"");
                }
            }
        });

        tv5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sel = "Retired_P";

                SessionManager.putStringInPreferences(getContext(),"Retired_P","employment_type");

                if(loantype.equals("Vehicle")) {
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
                        adapter.addFragment(new Retired_P(), "Retired_P");
                        adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(80);
                    progress.setText(80+"");
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
                        adapter1.addFragment(new Retired_P(), "Retired_P");
                        adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(60);
                    progress.setText(60+"");
                }
            }
        });


        tv6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                sel = "Homemaker";


                SessionManager.putStringInPreferences(getContext(),"Homemaker","employment_type");
                if(loantype.equals("Vehicle")) {
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
                        adapter.addFragment(new Homemaker(), "Homemaker");
                        adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(80);
                    progress.setText(80+"");
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
                        adapter1.addFragment(new Homemaker(), "Homemaker");
                        adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                    pb.setProgress(60);
                    progress.setText(60+"");
                }

            }
        });



        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("employment_type",sel);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null) {
            try {
                String x = savedInstanceState.getString("employment_type");
                if (x.equals("Retired_NP")) {
                    tv1.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else if (x.equals("Self_Employed_P")) {
                    tv2.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else if (x.equals("Salaried")) {
                    tv3.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else if (x.equals("Self_Employed")) {
                    tv4.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else if (x.equals("Retired_P")) {
                    tv5.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else if (x.equals("Homemaker")) {
                    tv6.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else if (x.equals("SalariedProf")) {
                    tv7.setBackgroundColor(Color.parseColor("#3f8f98"));
                }
            }catch (Exception e){

            }

        }

    }

}
