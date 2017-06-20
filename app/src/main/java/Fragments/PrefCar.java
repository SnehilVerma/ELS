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
 * Created by snehil on 9/6/17.
 */

public class PrefCar extends Fragment {

    public Integer[] thumbs = {
            R.drawable.car1, R.drawable.car3,
            R.drawable.car4, R.drawable.car2,
            R.drawable.car1, R.drawable.car3,
            R.drawable.car4, R.drawable.car2,
            R.drawable.car1, R.drawable.car3,
            R.drawable.car4, R.drawable.car2,



};

    ViewPagerAdapter ad;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {



        final View view=inflater.inflate(R.layout.fragment_car_pref, container, false);
        final ProgressBar pb = ((CarLoanActivity)getActivity()).getPb();
        final TextView progress = ((CarLoanActivity)getActivity()).getprogresstv();
        GridView gridView=(GridView)view.findViewById(R.id.gridview);
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.grid_item_anim);
        GridLayoutAnimationController controller = new GridLayoutAnimationController(animation, .2f, .2f);
        gridView.setLayoutAnimation(controller);
        gridView.setAdapter(new GridAdapter(getContext(),thumbs));


        ad=((CarLoanActivity)getActivity()).getCurrAdapter();
        viewPager = ((CarLoanActivity)getActivity()).getViewPager();







        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                SessionManager.putStringInPreferences(getContext(),String.valueOf(i),"car_option");
                Toast.makeText(getContext(),i+"",Toast.LENGTH_SHORT).show();
                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {

                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();

                }
                ad.mFragmentList.add(new VehLoanCost());
                ad.mFragmentTitleList.add("VehLoanCost");
                ad.notifyDataSetChanged();


                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                pb.setProgress(50);

                progress.setText(String.valueOf(50));



            }
        });

        return view;

    }
}
