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

import android.widget.AdapterView.OnItemClickListener;

import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;

import com.elsapp.els.CarLoanActivity.ViewPagerAdapter;
import com.elsapp.els.R;

import Adapter.GridAdapter;
import Utility.SessionManager;

/**
 * Created by Rishi on 6/13/2017.
 */

public class PrefBike extends Fragment {





    public Integer[] thumbs = {
            R.drawable.motorcycle, R.drawable.car3,
            R.drawable.car4, R.drawable.motorcycle,
            R.drawable.motorcycle, R.drawable.car3,
            R.drawable.car4, R.drawable.motorcycle,
            R.drawable.motorcycle, R.drawable.car3,
            R.drawable.car4, R.drawable.motorcycle,



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
        final ProgressBar pb = ((CarLoanActivity)getActivity()).getPb();
        final TextView progress = ((CarLoanActivity)getActivity()).getprogresstv();
        gridView.setAdapter(new GridAdapter(getContext(),thumbs));


        ad=((CarLoanActivity)getActivity()).getCurrAdapter();
        viewPager = ((CarLoanActivity)getActivity()).getViewPager();









        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                SessionManager.putStringInPreferences(getContext(),String.valueOf(i),"bike_option");
                Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                ad.mFragmentList.add(new VehLoanCost());
                ad.mFragmentTitleList.add("VehLoanCost");
                ad.notifyDataSetChanged();



                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                pb.setProgress(40);

                progress.setText(String.valueOf(40));



            }
        });


        return view;
    }
}
