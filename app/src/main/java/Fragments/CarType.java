package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.CarLoanActivity.ViewPagerAdapter;
import com.elsapp.els.R;

/**
 * Created by snehil on 8/6/17.
 */

public class CarType extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_car_type, container, false);


        ImageButton im1=(ImageButton) view.findViewById(R.id.im1);
        ImageButton im2=(ImageButton)view.findViewById(R.id.im2);

        final ViewPagerAdapter ad=((CarLoanActivity)getActivity()).getCurrAdapter();


        im1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //SessionManager.putStringInPreferences(getContext(),"1","pos");

                ad.addFragment(new DOB(), "DOB");
                ad.notifyDataSetChanged();




            }
        });

        im2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //ad.addFragment(new Gender(),"Gender");

                ad.notifyDataSetChanged();

            }
        });

        return view;

    }

}
