package Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import java.util.ArrayList;
import java.util.List;

import Utility.SessionManager;

@RequiresApi(api = Build.VERSION_CODES.N)
public class CoAPP extends Fragment {
    CarLoanActivity.ViewPagerAdapter adapter1;
    HomeLoan.ViewPagerAdapter adapter;
    ViewPager viewPager;
    EditText Name,Phone,Age;
    ProgressBar pb;
    TextView progress;

    int flag;



    public CoAPP() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        flag = 0;
        final View x = inflater.inflate(R.layout.fragment_co_ap, container, false);
        final String loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");
        //EditText relationship = (EditText) x.findViewById(R.id.relationship);
        ImageView father = (ImageView) x.findViewById(R.id.father);
        ImageView mother = (ImageView) x.findViewById(R.id.mother);
        ImageView spouse = (ImageView) x.findViewById(R.id.spouse);
        ImageView children = (ImageView) x.findViewById(R.id.children);
        adapter = ((HomeLoan) getActivity()).getCurrAdapter();
        viewPager = ((HomeLoan) getActivity()).getViewPager();
        Button b1 = (Button) x.findViewById(R.id.button);


        father.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionManager.putStringInPreferences(getActivity(),"Father","relation");
                        //pb = ((HomeLoan)getActivity()).getPb();
                        //progress = ((HomeLoan)getActivity()).getprogresstv();
                        int index = (viewPager.getCurrentItem()) + 1;
                        if (index < adapter.mFragmentList.size()) {
                            adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                            adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                            adapter.notifyDataSetChanged();


                        }
                        adapter.addFragment(new CoApp_Cat(), "CoApp_Cat");
                        SessionManager.putStringInPreferences(getActivity(), "1", "flaggy");
                        adapter.notifyDataSetChanged();
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
//                pb.setProgress(80);
                    //              progress.setText(80+"");
            }
        });
        mother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionManager.putStringInPreferences(getActivity(),"mother","relation");
                    //pb = ((HomeLoan)getActivity()).getPb();
                    //progress = ((HomeLoan)getActivity()).getprogresstv();
                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < adapter.mFragmentList.size()) {
                        adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                        adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                        adapter.notifyDataSetChanged();


                    }
                    adapter.addFragment(new CoApp_Cat(), "CoApp_Cat");
                    SessionManager.putStringInPreferences(getActivity(), "1", "flaggy");
                    adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
//                pb.setProgress(80);
                    //              progress.setText(80+"");
                }

        });
        spouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionManager.putStringInPreferences(getActivity(),"Spouse","relation");

                    //pb = ((HomeLoan)getActivity()).getPb();
                    //progress = ((HomeLoan)getActivity()).getprogresstv();
                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < adapter.mFragmentList.size()) {
                        adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                        adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                        adapter.notifyDataSetChanged();


                    }
                    adapter.addFragment(new CoApp_Cat(), "CoApp_Cat");
                    SessionManager.putStringInPreferences(getActivity(), "1", "flaggy");
                    adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
//                pb.setProgress(80);
                    //              progress.setText(80+"");
            }
        });
        children.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionManager.putStringInPreferences(getActivity(),"Children","relation");
                    //pb = ((HomeLoan)getActivity()).getPb();
                    //progress = ((HomeLoan)getActivity()).getprogresstv();
                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < adapter.mFragmentList.size()) {
                        adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                        adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                        adapter.notifyDataSetChanged();


                    }
                    adapter.addFragment(new CoApp_Cat(), "CoApp_Cat");
                    SessionManager.putStringInPreferences(getActivity(), "1", "flaggy");
                    adapter.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
//                pb.setProgress(80);
                    //              progress.setText(80+"");
            }
        });

        return x;
    }

    }







