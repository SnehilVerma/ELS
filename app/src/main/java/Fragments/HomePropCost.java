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
import android.widget.TextView;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 9/6/17.
 */

public class HomePropCost extends Fragment {
    ViewPager viewPager;
    HomeLoan.ViewPagerAdapter adapter;
    EditText cost;
    CarLoanActivity.ViewPagerAdapter adapter1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_home_propcost, container, false);
        final String loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");
        cost = (EditText) view.findViewById(R.id.cost);
        Button b1 = (Button) view.findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    final String cos= cost.getText().toString();
                    SessionManager.putStringInPreferences(getContext(),cos,"cost_of_entity");
                    Log.d("cost:",cos+" rs");
                    int flag = 0;
                    adapter = ((HomeLoan) getActivity()).getCurrAdapter();
                    viewPager = ((HomeLoan) getActivity()).getViewPager();
                    for (int y = 0; y < adapter.mFragmentTitleList.size(); y++) {
                        if (adapter.mFragmentTitleList.get(y).equals("Select_Category")) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        adapter.addFragment(new Select_Category(), "Select_Category");
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getContext(), "Already added next fragment", Toast.LENGTH_SHORT).show();
                    }
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

        TextView t1 = (TextView) view.findViewById(R.id.prev);
        TextView t2 = (TextView) view.findViewById(R.id.next);
        final ViewPager viewPager = ((HomeLoan)getActivity()).getViewPager();
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });
        return view;

    }
}
