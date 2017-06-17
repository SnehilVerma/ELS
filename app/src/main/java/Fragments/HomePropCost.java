package Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 9/6/17.
 */

public class HomePropCost extends Fragment {
    ViewPager viewPager;
    HomeLoan.ViewPagerAdapter ad;
    EditText cost;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_home_propcost, container, false);
        final String loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");
        cost = (EditText) view.findViewById(R.id.cost);

        final ProgressBar pb = ((HomeLoan)getActivity()).getPb();
        final TextView progress = ((HomeLoan)getActivity()).getprogresstv();
        ad = ((HomeLoan)getActivity()).getCurrAdapter();
        viewPager = ((HomeLoan)getActivity()).getViewPager();




        Button b1 = (Button) view.findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String cos=cost.getText().toString();
                SessionManager.putStringInPreferences(getContext(),cos,"cost_of_entity");
                Log.d("cost:",cos+" rs");

                int index=(viewPager.getCurrentItem())+1;
                if(index<ad.mFragmentList.size()) {

                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();

                }

                ad.mFragmentList.add(new Select_Category());
                ad.mFragmentTitleList.add("Select_Category");
                ad.notifyDataSetChanged();




                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                pb.setProgress(50);

                progress.setText(String.valueOf(50));



            }
        });
        cost.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if((i== KeyEvent.KEYCODE_ENTER)){
                    String loan=cost.getText().toString();
                    Float val=Float.parseFloat(loan);

                    if(val>999999.99){

                        Toast.makeText(getContext(),"Cost of vehicle should not exceed 999999.99",Toast.LENGTH_SHORT).show();
                        return true;
                    }else {
                        final Dialog dialog = new Dialog(getContext());
                        dialog.setContentView(R.layout.custom_dialog);
                        TextView tv = (TextView) dialog.findViewById(R.id.amount);
                        String loan2 = cost.getText().toString();
                        tv.setText(loan2);
                        dialog.show();
                        return true;
                    }

                }

                if(i==KeyEvent.KEYCODE_BACK && keyEvent.getAction()==KeyEvent.ACTION_UP){
                    Toast.makeText(getContext(),"Back Pressed",Toast.LENGTH_SHORT).show();
                    return true;
                }

                return false;
            }

        });




        return view;

    }
}
