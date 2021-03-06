package Fragments;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import java.util.ArrayList;
import java.util.Arrays;

import Utility.SessionManager;

/**
 * Created by sibby on 9/6/17.
 */

public class HomePropLoc extends Fragment {


    ImageView delhi;
    ImageView mumbai;
    ImageView others;

    //private CarLoanActivity.ViewPagerAdapter ad;
    private HomeLoan.ViewPagerAdapter ad2;
    private ViewPager viewPager;
    ArrayList<String> city_names;

    String hl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_home_proploc, container, false);

        mumbai = (ImageView) view.findViewById(R.id.mumbai);
        delhi= (ImageView) view.findViewById(R.id.delhi);
        others=(ImageView)view.findViewById(R.id.others);
        final ProgressBar pb = ((HomeLoan)getActivity()).getPb();
        final TextView progress = ((HomeLoan)getActivity()).getprogresstv();

        city_names =new ArrayList<>(Arrays.asList("Kanpur","Lucknow","Bengaluru","Patna","Surat","Kota","Jaipur","Pune","Panaji"));




        //Button b1=(Button)view.findViewById(R.id.b1);


        final SessionManager sessionManager=new SessionManager();



        ad2 = ((HomeLoan)getActivity()).getCurrAdapter();
        viewPager = ((HomeLoan)getActivity()).getViewPager();


        final Dialog dialog=new Dialog(getContext());
        dialog.setContentView(R.layout.custom_city_dialog);
        dialog.setTitle("Choose a city");
        ListView cities=(ListView)dialog.findViewById(R.id.List);
        final AutoCompleteTextView city = (AutoCompleteTextView) dialog.findViewById(R.id.cityedit);
        ArrayAdapter<String> adapterone = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line, city_names);
        city.setDropDownHeight(0);
        //final City_Adapter adapter=new City_Adapter(getContext(),R.layout.name_view,city_names);
        cities.setAdapter(adapterone);
        city.setAdapter(adapterone);
        //final City_Adapter adapter=new City_Adapter(getContext(),R.layout.name_view,city_names);


        cities.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dialog.dismiss();
                String city=adapterView.getAdapter().getItem(i).toString();
                Toast.makeText(getContext(),city,Toast.LENGTH_SHORT).show();
                SessionManager.putStringInPreferences(getContext(),city,"property_location");




                hl = "Others";


                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad2.mFragmentList.size()) {

                        ad2.mFragmentList.subList(index, ad2.mFragmentList.size()).clear();
                        ad2.mFragmentTitleList.subList(index, ad2.mFragmentTitleList.size()).clear();
                        ad2.notifyDataSetChanged();

                    }


                    ad2.addFragment(new HomeLoanPurpose(), "HomeLoanPurpose");
                    ad2.notifyDataSetChanged();
                    Log.d("1", SessionManager.getStringFromPreferences(getContext(),"property_location"));



                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                int p = Integer.parseInt(progress.getText().toString());
                pb.setProgress(30);

                progress.setText(String.valueOf(30));



            }
        });




        mumbai.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                SessionManager.putStringInPreferences(getContext(), "Mumbai", "property_location");





                hl = "Mumbai";

                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad2.mFragmentList.size()) {

                        ad2.mFragmentList.subList(index, ad2.mFragmentList.size()).clear();
                        ad2.mFragmentTitleList.subList(index, ad2.mFragmentTitleList.size()).clear();
                        ad2.notifyDataSetChanged();

                    }


                    ad2.addFragment(new HomeLoanPurpose(), "HomeLoanPurpose");
                    ad2.notifyDataSetChanged();
                    Log.d("1", SessionManager.getStringFromPreferences(getContext(),"property_location")+"");



                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                int p = Integer.parseInt(progress.getText().toString());
                pb.setProgress(30);

                progress.setText(String.valueOf(30));

            }
        });

        delhi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                SessionManager.putStringInPreferences(getContext(), "Delhi", "property_location");


                hl = "Delhi";
                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad2.mFragmentList.size()) {

                    ad2.mFragmentList.subList(index, ad2.mFragmentList.size()).clear();
                    ad2.mFragmentTitleList.subList(index, ad2.mFragmentTitleList.size()).clear();
                    ad2.notifyDataSetChanged();

                }


                ad2.addFragment(new HomeLoanPurpose(), "HomeLoanPurpose");
                ad2.notifyDataSetChanged();
                Log.d("1", SessionManager.getStringFromPreferences(getContext(), "property_location"));





                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);


                int p = Integer.parseInt(progress.getText().toString());
                pb.setProgress(30);

                progress.setText(String.valueOf(30));



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
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("property_location",hl);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null) {
            String x = savedInstanceState.getString("property_location");
            Drawable xyz = getResources().getDrawable(R.drawable.buttonstyle);
            try {
                if (x.equals("Mumbai")) {
                    mumbai.setBackground(xyz);
                } else if (x.equals("Delhi")) {
                    delhi.setBackground(xyz);
                } else {
                    others.setBackground(xyz);
                }
            }catch (Exception e){

            }
        }

    }

}
