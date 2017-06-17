package Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import java.util.ArrayList;
import java.util.Arrays;

import Adapter.City_Adapter;
import Utility.SessionManager;

/**
 * Created by sibby on 9/6/17.
 */

public class City extends Fragment {

    ImageView delhi;
    ImageView mumbai;
    ImageView others;

    private CarLoanActivity.ViewPagerAdapter ad;
    private HomeLoan.ViewPagerAdapter ad2;
    private ViewPager viewPager;
    ArrayList<String> city_names;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_city, container, false);
        mumbai = (ImageView) view.findViewById(R.id.mumbai);
        delhi= (ImageView) view.findViewById(R.id.delhi);
        others=(ImageView)view.findViewById(R.id.others);

        city_names =new ArrayList<>(Arrays.asList("Kanpur","Lucknow","Bengaluru","Patna","Surat","Kota","Jaipur","Pune","Panaji"));




        Button b1=(Button)view.findViewById(R.id.b1);


        final SessionManager sessionManager=new SessionManager();


        final String type=SessionManager.getStringFromPreferences(getContext(),"loantype");
        if(type.equals("Vehicle")) {
            ad = ((CarLoanActivity) getActivity()).getCurrAdapter();
            viewPager = ((CarLoanActivity) getActivity()).getViewPager();
        }
        else if(type.equals("Home")){
            ad2 = ((HomeLoan)getActivity()).getCurrAdapter();
            viewPager = ((HomeLoan)getActivity()).getViewPager();

        }



        final Dialog dialog=new Dialog(getContext());
        dialog.setContentView(R.layout.custom_city_dialog);
        dialog.setTitle("Choose a city");
        ListView cities=(ListView)dialog.findViewById(R.id.List);
        final City_Adapter adapter=new City_Adapter(getContext(),R.layout.name_view,city_names);
        cities.setAdapter(adapter);


        cities.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dialog.dismiss();
                String city=city_names.get(i);
                Toast.makeText(getContext(),city,Toast.LENGTH_SHORT).show();
                SessionManager.putStringInPreferences(getContext(),city,"city");


                if(type.equals("Vehicle")) {

                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad.mFragmentList.size()) {
                        ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                        ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                        ad.notifyDataSetChanged();
                    }



                    ad.addFragment(new VehSelect(), "VehSelect");
                    ad.notifyDataSetChanged();
                    Log.d("1", SessionManager.getStringFromPreferences(getContext(),"city"));


                }
                else {




                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad2.mFragmentList.size()) {

                        ad2.mFragmentList.subList(index, ad2.mFragmentList.size()).clear();
                        ad2.mFragmentTitleList.subList(index, ad2.mFragmentTitleList.size()).clear();
                        ad2.notifyDataSetChanged();

                    }


                    ad2.addFragment(new Gender(), "Gender");
                    ad2.notifyDataSetChanged();
                    Log.d("1", SessionManager.getStringFromPreferences(getContext(),"city"));

                }

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);




            }
        });




        mumbai.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                SessionManager.putStringInPreferences(getContext(),"Mumbai","city");


                if(type.equals("Vehicle")) {

                        int index = (viewPager.getCurrentItem()) + 1;
                        if (index < ad.mFragmentList.size()) {
                            ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                            ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                            ad.notifyDataSetChanged();
                        }



                        ad.addFragment(new VehSelect(), "VehSelect");
                        ad.notifyDataSetChanged();
                        Log.d("1", SessionManager.getStringFromPreferences(getContext(),"city"));


                }
                else {




                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad2.mFragmentList.size()) {

                        ad2.mFragmentList.subList(index, ad2.mFragmentList.size()).clear();
                        ad2.mFragmentTitleList.subList(index, ad2.mFragmentTitleList.size()).clear();
                        ad2.notifyDataSetChanged();

                    }


                    ad2.addFragment(new Gender(), "Gender");
                    ad2.notifyDataSetChanged();
                    Log.d("1", SessionManager.getStringFromPreferences(getContext(),"city"));

                }

                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);



            }
        });

        delhi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                SessionManager.putStringInPreferences(getContext(),"Delhi","city");

                if(type.equals("Vehicle")) {

                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad.mFragmentList.size()) {
                        ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                        ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                        ad.notifyDataSetChanged();
                    }



                        ad.addFragment(new VehSelect(), "VehSelect");
                        ad.notifyDataSetChanged();
                        Log.d("1", SessionManager.getStringFromPreferences(getContext(),"city"));

                    }

                else {




                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad2.mFragmentList.size()) {

                        ad2.mFragmentList.subList(index, ad2.mFragmentList.size()).clear();
                        ad2.mFragmentTitleList.subList(index, ad2.mFragmentTitleList.size()).clear();
                        ad2.notifyDataSetChanged();

                    }


                    ad2.addFragment(new Gender(), "Gender");
                    ad2.notifyDataSetChanged();
                    Log.d("1", SessionManager.getStringFromPreferences(getContext(),"city"));




                }
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);





            }
        });


        others.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();





            }
        });













        return view;

    }










}
