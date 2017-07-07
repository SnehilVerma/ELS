package Fragments;


import android.graphics.Color;
import android.media.Image;
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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by snehil on 9/6/17.
 */

public class Gender extends Fragment {
    HomeLoan.ViewPagerAdapter ad2;
    CarLoanActivity.ViewPagerAdapter ad;
    private ProgressBar pb;
    ImageView male;
    ImageView female;
    ImageView others;
    private TextView progress;
    String genderone;

    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_gender, container, false);


        male = (ImageView) view.findViewById(R.id.male);
        female = (ImageView) view.findViewById(R.id.female);
        others=(ImageView) view.findViewById(R.id.others);
        final SessionManager sessionManager=new SessionManager();



        if(sessionManager.getStringFromPreferences(getActivity(),"gender").equals("Male")){
            male.setBackgroundColor(Color.parseColor("#3f8f98"));
        }
        else if(sessionManager.getStringFromPreferences(getActivity(),"gender").equals("Female")){
            female.setBackgroundColor(Color.parseColor("#3f8f98"));
        }
        else if(sessionManager.getStringFromPreferences(getActivity(),"gender").equals("Others")){
            others.setBackgroundColor(Color.parseColor("#3f8f98"));
        }


        final String type=SessionManager.getStringFromPreferences(getContext(),"loantype");



        if(type.equals("Vehicle")) {
            ad = ((CarLoanActivity) getActivity()).getCurrAdapter();
            viewPager = ((CarLoanActivity) getActivity()).getViewPager();
        }
        else if(type.equals("Home")){
            ad2 = ((HomeLoan)getActivity()).getCurrAdapter();
            viewPager = ((HomeLoan)getActivity()).getViewPager();

        }



        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genderone = "Male";

                SessionManager.putStringInPreferences(getActivity(),"Male","gender");

                if (type.equals("Vehicle")) {

                    pb = ((CarLoanActivity)getActivity()).getPb();
                    progress = ((CarLoanActivity)getActivity()).getprogresstv();


                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad.mFragmentList.size()) {
                        ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                        ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                        ad.notifyDataSetChanged();


                    }


                    ad.addFragment(new DOB(), "DOB");
                    ad.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    int p = Integer.parseInt(progress.getText().toString());
                    pb.setProgress(15);

                    progress.setText(String.valueOf(15));
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                } else if (type.equals("Home")) {

                    progress = ((HomeLoan)getActivity()).getprogresstv();
                    pb = ((HomeLoan)getActivity()).getPb();


                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad2.mFragmentList.size()) {
                        ad2.mFragmentList.subList(index, ad2.mFragmentList.size()).clear();
                        ad2.mFragmentTitleList.subList(index, ad2.mFragmentTitleList.size()).clear();
                        ad2.notifyDataSetChanged();


                    }


                    ad2.addFragment(new DOB(), "DOB");
                    ad2.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    int p = Integer.parseInt(progress.getText().toString());
                    pb.setProgress(15);

                    progress.setText(String.valueOf(15));
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);


                }

                /*
                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {
                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();




                }


                ad.addFragment(new DOB(), "DOB");
                ad.notifyDataSetChanged();
                Log.d("1", SessionManager.getStringFromPreferences(getContext(),"gender").toString());

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);


                pb.setProgress(15);

                progress.setText(String.valueOf(15));
                */

            }
        });


        female.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                genderone = "Female";
                SessionManager.putStringInPreferences(getActivity(),"Female","gender");

                if (type.equals("Vehicle")) {

                    pb = ((CarLoanActivity)getActivity()).getPb();
                    progress = ((CarLoanActivity)getActivity()).getprogresstv();


                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad.mFragmentList.size()) {
                        ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                        ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                        ad.notifyDataSetChanged();


                    }


                    ad.addFragment(new DOB(), "DOB");
                    ad.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    int p = Integer.parseInt(progress.getText().toString());
                    pb.setProgress(15);

                    progress.setText(String.valueOf(15));
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                } else if (type.equals("Home")) {

                    progress = ((HomeLoan)getActivity()).getprogresstv();
                    pb = ((HomeLoan)getActivity()).getPb();


                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad2.mFragmentList.size()) {
                        ad2.mFragmentList.subList(index, ad2.mFragmentList.size()).clear();
                        ad2.mFragmentTitleList.subList(index, ad2.mFragmentTitleList.size()).clear();
                        ad2.notifyDataSetChanged();


                    }


                    ad2.addFragment(new DOB(), "DOB");
                    ad2.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    int p = Integer.parseInt(progress.getText().toString());
                    pb.setProgress(15);

                    progress.setText(String.valueOf(15));
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);


                }

            }
        });


        others.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                genderone = "Others";

                SessionManager.putStringInPreferences(getActivity(),"Others","gender");
                if (type.equals("Vehicle")) {

                    pb = ((CarLoanActivity)getActivity()).getPb();
                    progress = ((CarLoanActivity)getActivity()).getprogresstv();


                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad.mFragmentList.size()) {
                        ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                        ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                        ad.notifyDataSetChanged();


                    }


                    ad.addFragment(new DOB(), "DOB");
                    ad.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    int p = Integer.parseInt(progress.getText().toString());
                    pb.setProgress(15);

                    progress.setText(String.valueOf(15));
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                } else if (type.equals("Home")) {

                    progress = ((HomeLoan)getActivity()).getprogresstv();
                    pb = ((HomeLoan)getActivity()).getPb();


                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad2.mFragmentList.size()) {
                        ad2.mFragmentList.subList(index, ad2.mFragmentList.size()).clear();
                        ad2.mFragmentTitleList.subList(index, ad2.mFragmentTitleList.size()).clear();
                        ad2.notifyDataSetChanged();


                    }


                    ad2.addFragment(new DOB(), "DOB");
                    ad2.notifyDataSetChanged();
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    int p = Integer.parseInt(progress.getText().toString());
                    pb.setProgress(15);

                    progress.setText(String.valueOf(15));
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);


                }


            }


        });


        return view;

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("gender",genderone);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null) {
            String x = savedInstanceState.getString("gender");
            try {
                if (x.equals("Male")) {
                    male.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else if (x.equals("Female")) {
                    female.setBackgroundColor(Color.parseColor("#3f8f98"));
                } else {
                    others.setBackgroundColor(Color.parseColor("#3f8f98"));
                }
            }
            catch(Exception e){

            }
        }

    }


}
