package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.CarLoanActivity.ViewPagerAdapter;
import com.elsapp.els.R;

import Utility.SessionManager;

import static com.elsapp.els.R.id.im1;

/**
 * Created by Rishi on 6/9/2017.
 */

public class VehSelect extends Fragment {


    ViewPagerAdapter ad;
    ViewPager viewPager;
    int tflag=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.fragment_veh_type, container, false);
        final SessionManager sessionManager=new SessionManager();

        ImageButton ib1=(ImageButton)view.findViewById(im1);
        ImageButton ib2=(ImageButton)view.findViewById(R.id.im2);

        ad=((CarLoanActivity)getActivity()).getCurrAdapter();
        viewPager = ((CarLoanActivity)getActivity()).getViewPager();


        ib1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                int flag=0;
                tflag=1;

                for(String x : ad.mFragmentTitleList){
                    if(x.equals("BikeType")){
                        flag=1;
                        break;
                    }
                    else if(x.equals(("CarType"))){
                        ad.mFragmentList.remove(viewPager.getCurrentItem()+1);
                        ad.mFragmentTitleList.remove("CarType");


                    }

                }
                if(flag==0){

                sessionManager.putStringInPreferences(getActivity(),"Bike","vehicle_type");
                Log.d("VehSelect:","Bike");
                ad.mFragmentList.add(new BikeType());
                ad.mFragmentTitleList.add("BikeType");
                ad.notifyDataSetChanged();}
                else{

                    Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                }

            }
        });


        ib2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                int flag=0;
                tflag=2;

                for(String x : ad.mFragmentTitleList){
                    if(x.equals("CarType")){
                        flag=1;
                        break;
                    }

                    else if(x.equals(("BikeType"))){
                        ad.mFragmentList.remove(viewPager.getCurrentItem()+1);
                        ad.mFragmentTitleList.remove("BikeType");


                    }

                }
                if(flag==0) {

                    sessionManager.putStringInPreferences(getActivity(),"Car","vehicle_type");
                    Log.d("VehSelect:","Car");
                    ad.mFragmentList.add(new CarType());
                    ad.mFragmentTitleList.add("CarType");
                    ad.notifyDataSetChanged();
                }
                else{

                    Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                }

            }
        });



        return view;
    }

}
