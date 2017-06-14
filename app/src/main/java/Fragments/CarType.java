package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.CarLoanActivity.ViewPagerAdapter;
import com.elsapp.els.R;

/**
 * Created by snehil on 8/6/17.
 */

public class CarType extends Fragment {


    ViewPagerAdapter ad;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_car_type, container, false);



        ImageButton im1=(ImageButton) view.findViewById(R.id.im1);
        ImageButton im2=(ImageButton)view.findViewById(R.id.im2);

        ad=((CarLoanActivity)getActivity()).getCurrAdapter();
        viewPager = ((CarLoanActivity)getActivity()).getViewPager();




        im1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                //TESTING
                int flag=0;

                for(String x : ad.mFragmentTitleList){
                    if(x.equals("PrefCar")){
                        flag=1;
                        break;
                    }

                    else if(x.equals("DOM")){

                        ad.mFragmentList.remove(viewPager.getCurrentItem()+1);
                        ad.mFragmentTitleList.remove("DOM");

                    }


                }
                if(flag==0) {


                    ad.mFragmentList.add(new PrefCar());
                    ad.mFragmentTitleList.add("PrefCar");
                    ad.notifyDataSetChanged();

                }
                else{
                    Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                }



                //ad.addFragment(new Gender(), "Gender");
                //ad.notifyDataSetChanged();


            }
        });

        im2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                //ad.mFragmentList.remove(viewPager.getCurrentItem()+1);
                //ad.mFragmentTitleList.remove("DOB");


                int flag=0;

                for(String x : ad.mFragmentTitleList){
                    if(x.equals("DOM")){
                        flag=1;
                        break;
                    }
                    else if(x.equals("PrefCar")){
                        ad.mFragmentList.remove(viewPager.getCurrentItem()+1);
                        ad.mFragmentTitleList.remove("PrefCar");

                    }

                }
                if(flag==0) {


                    ad.mFragmentList.add(new DOM());
                    ad.mFragmentTitleList.add("DOM");
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
