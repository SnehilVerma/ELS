package Fragments;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import java.util.Calendar;
import java.text.SimpleDateFormat;

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
    ImageView yes,no;
    TextView progress;
    String what;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_co_app_opt, container, false);
        loantype = SessionManager.getStringFromPreferences(getContext(),"loantype");
        yes = (ImageView) view.findViewById(R.id.yes);
        no = (ImageView) view.findViewById(R.id.no);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                what = "Yes";
                SessionManager.putStringInPreferences(getActivity(), "Yes", "coapp");
                if (loantype.equals("Home")) {
                    adapter1 = ((HomeLoan) getActivity()).getCurrAdapter();
                    viewPager = ((HomeLoan) getActivity()).getViewPager();
                    pb = ((HomeLoan) getActivity()).getPb();
                    progress = ((HomeLoan) getActivity()).getprogresstv();


                    int index = (viewPager.getCurrentItem()) + 1;

                    if (index < adapter1.mFragmentList.size()) {
                        adapter1.mFragmentList.subList(index, adapter1.mFragmentList.size()).clear();
                        adapter1.mFragmentTitleList.subList(index, adapter1.mFragmentTitleList.size()).clear();
                        adapter1.notifyDataSetChanged();


                    }

                    adapter1.addFragment(new CoAPP(), "CoApp");
                    adapter1.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

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
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                what = "No";
                SessionManager.putStringInPreferences(getActivity(),"No","coapp");
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
        });

        return view;

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("coapp",what);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null) {
            String x = savedInstanceState.getString("coapp");
            Drawable xyz = getResources().getDrawable(R.drawable.buttonstyle);
            try {

                if (x.equals("Yes")) {
                    yes.setBackground(xyz);
                } else if (x.equals("No")) {
                    no.setBackground(xyz);
                }
            }catch (Exception e){

            }
        }

    }
}
