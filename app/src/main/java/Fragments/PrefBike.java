package Fragments;

import android.graphics.Color;
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
import com.elsapp.els.R;

import Adapter.GridAdapter;
import Utility.SessionManager;

/**
 * Created by Rishi on 6/13/2017.
 */

public class PrefBike extends Fragment {





    public Integer[] thumbs = {
            R.drawable.activa, R.drawable.avenger,
            R.drawable.aviator, R.drawable.passion,
            R.drawable.dio, R.drawable.pleasure,
            R.drawable.splendor, R.drawable.maestro,
            R.drawable.scooty_pep, R.drawable.pulsar,
    };

    String bik;
    CarLoanActivity.ViewPagerAdapter ad;
    ViewPager viewPager;
    GridView gridView;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bike_pref,container,false);

        gridView = (GridView)view.findViewById(R.id.gridview);
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

                bik = String.valueOf(i);

                SessionManager.putStringInPreferences(getContext(),String.valueOf(i),"bike_option");
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
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("employment_type",bik);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null) {
            String x = savedInstanceState.getString("employment_type");
            try {
                int temp = Integer.parseInt(x);
                //gridView.getChildAt(temp).setBackgroundColor(Color.parseColor("#3f8f98"));
            }catch(Exception e){

            }
        }

    }
}
