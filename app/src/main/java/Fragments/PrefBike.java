package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.AdapterView;
import android.widget.GridView;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.R;

import Adapter.GridAdapter;

/**
 * Created by Rishi on 6/13/2017.
 */

public class PrefBike extends Fragment {


    public Integer[] thumbs = {
            R.drawable.car1, R.drawable.car3,
            R.drawable.car4, R.drawable.car2,
            R.drawable.car1, R.drawable.car3,
            R.drawable.car4, R.drawable.car2,
            R.drawable.car1, R.drawable.car3,
            R.drawable.car4, R.drawable.car2,



    };

    CarLoanActivity.ViewPagerAdapter ad;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bike_pref,container,false);

        GridView gridView = (GridView)view.findViewById(R.id.gridview);
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.grid_item_anim);
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation, .2f, .2f);
        gridView.setLayoutAnimation(controller);
        gridView.setAdapter(new GridAdapter(getContext(),thumbs));


        ad=((CarLoanActivity)getActivity()).getCurrAdapter();
        viewPager = ((CarLoanActivity)getActivity()).getViewPager();







        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ad.mFragmentList.add(new VehLoanCost());
                ad.mFragmentTitleList.add("VehLoanCost");
                ad.notifyDataSetChanged();



            }
        });


        return view;
    }
}
