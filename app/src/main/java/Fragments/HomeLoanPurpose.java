package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

/**
 * Created by Rishi on 6/12/2017.
 */

public class HomeLoanPurpose extends Fragment {
    ViewPager viewPager;
    HomeLoan.ViewPagerAdapter ad;

    Button construct,repair,identified,tranfer;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home_loanpurpose,container,false);

        construct = (Button) view.findViewById(R.id.construct);
        tranfer = (Button) view.findViewById(R.id.transfer);
        repair = (Button) view.findViewById(R.id.renovate);
        identified = (Button) view.findViewById(R.id.identified);
        Button b1 = (Button) view.findViewById(R.id.button);
        ad = ((HomeLoan)getActivity()).getCurrAdapter();
        viewPager = ((HomeLoan)getActivity()).getViewPager();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {
                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();

                    //sessionManager.putStringInPreferences(getActivity(),text.toString(),"city");


                }


                ad.addFragment(new HomePropCost(), "HomePropCost");
                ad.notifyDataSetChanged();
            }
        });





        return view;
    }
}
