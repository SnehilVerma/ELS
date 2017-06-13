package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.CarLoanActivity.ViewPagerAdapter;
import com.elsapp.els.R;

/**
 * Created by sibby on 12/6/17.
 */

public class VehLoanCost extends Fragment{

    ViewPager viewPager;
    ViewPagerAdapter ad;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_vehicle_vehcost, container, false);

        EditText cost = (EditText) view.findViewById(R.id.cost);

        TextView t1 = (TextView) view.findViewById(R.id.prev);
        TextView t2 = (TextView) view.findViewById(R.id.next);


        viewPager = ((CarLoanActivity)getActivity()).getViewPager();
        ad=((CarLoanActivity)getActivity()).getCurrAdapter();


        String cos=cost.getText().toString();
        //use it somewhere

        cost.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.mFragmentList.add(new Select_Category());
                ad.mFragmentTitleList.add("Select_Category");
                ad.notifyDataSetChanged();
            }
        });




        return view;

    }
}
