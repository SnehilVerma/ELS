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
        final Spinner spinner = (Spinner) x.findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("None Selected");
        list.add("Father");
        list.add("Mother");
        list.add("Spouse");
        list.add("Children");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0) {
                    SessionManager.putStringInPreferences(getActivity(), parent.getItemAtPosition(position).toString(), "relation");
                    spinner.setSelection(position);
                    flag = 1;
                }
                else{
                    flag = 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button b1 = (Button) x.findViewById(R.id.button);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(flag == 1) {
                    if (loantype.equals("Home")) {


                        //pb = ((HomeLoan)getActivity()).getPb();
                        //progress = ((HomeLoan)getActivity()).getprogresstv();

                        adapter = ((HomeLoan) getActivity()).getCurrAdapter();
                        viewPager = ((HomeLoan) getActivity()).getViewPager();
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
                    } else {
                        adapter1 = ((CarLoanActivity) getActivity()).getCurrAdapter();
                        viewPager = ((CarLoanActivity) getActivity()).getViewPager();
                        pb = ((CarLoanActivity) getActivity()).getPb();
                        progress = ((CarLoanActivity) getActivity()).getprogresstv();
                        int index = (viewPager.getCurrentItem()) + 1;
                        if (index < adapter1.mFragmentList.size()) {
                            adapter1.mFragmentList.subList(index, adapter1.mFragmentList.size()).clear();
                            adapter1.mFragmentTitleList.subList(index, adapter1.mFragmentTitleList.size()).clear();
                            adapter1.notifyDataSetChanged();


                        }
                        adapter1.addFragment(new CoApp_Cat(), "CoApp_Cat");
                        SessionManager.putStringInPreferences(getActivity(), "1", "flaggy");
                        adapter1.notifyDataSetChanged();
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    }
//                pb.setProgress(80);
                    //              progress.setText(80+"");
                }
                else{
                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < adapter.mFragmentList.size()) {
                        adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                        adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                        adapter.notifyDataSetChanged();


                    }
                }
            }
        });

        return x;
    }

    }







