package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.elsapp.els.R;

/**
 * Created by sibby on 9/6/17.
 */

public class Retired_NP extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_retirednonpens, container, false);

        EditText mincome = (EditText) view.findViewById(R.id.mincome);
        EditText emi = (EditText) view.findViewById(R.id.emi);

        TextView t1 = (TextView) view.findViewById(R.id.prev);
        TextView t2 = (TextView) view.findViewById(R.id.next);
        Button b1 = (Button) view.findViewById(R.id.button);
        //final ViewPager viewPager = ((HomeLoan)getActivity()).getViewPager();
       /* t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
            }
        });*/
        return view;

    }
}
