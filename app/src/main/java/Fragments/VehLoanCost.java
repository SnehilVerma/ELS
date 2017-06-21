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
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.CarLoanActivity.ViewPagerAdapter;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 12/6/17.
 */

public class VehLoanCost extends Fragment{

    ViewPager viewPager;
    ViewPagerAdapter ad;
    EditText cost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.fragment_vehicle_vehcost, container, false);

        final ProgressBar pb = ((CarLoanActivity)getActivity()).getPb();
        final TextView progress = ((CarLoanActivity)getActivity()).getprogresstv();
        cost = (EditText) view.findViewById(R.id.cost);
        final SessionManager sessionManager=new SessionManager();

        TextView t1 = (TextView) view.findViewById(R.id.prev);
        TextView t2 = (TextView) view.findViewById(R.id.next);
        Button b1=(Button)view.findViewById(R.id.b2);


        viewPager = ((CarLoanActivity)getActivity()).getViewPager();
        ad=((CarLoanActivity)getActivity()).getCurrAdapter();



        //use it somewhere


        /*
        cost.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        */


        cost.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if((keyEvent.getAction()==KeyEvent.ACTION_DOWN) && (i== KeyEvent.KEYCODE_ENTER) ){
                    String loan=cost.getText().toString();
                    Float val=Float.parseFloat(loan);

                    if(val>999999999){

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






        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((!cost.getText().toString().equals(""))&&(Integer.parseInt(cost.getText().toString())<10000000)) {

                    final String cos = cost.getText().toString();
                    SessionManager.putStringInPreferences(getContext(), cos, "cost_of_entity");
                    Log.d("cost:", cos + " rs");

                    int index = (viewPager.getCurrentItem()) + 1;
                    if (index < ad.mFragmentList.size()) {

                        ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                        ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                        ad.notifyDataSetChanged();

                    }

                    ad.mFragmentList.add(new Select_Category());
                    ad.mFragmentTitleList.add("Select_Category");
                    ad.notifyDataSetChanged();


                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    pb.setProgress(70);

                    progress.setText(String.valueOf(70));
                }


            }
        });




        return view;

    }
}
