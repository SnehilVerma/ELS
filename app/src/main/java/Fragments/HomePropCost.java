package Fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 9/6/17.
 */

public class HomePropCost extends Fragment implements TextView.OnEditorActionListener {
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




        cost.setOnEditorActionListener(this);
        Button b1 = (Button) view.findViewById(R.id.b1);
        /*cost.setOnKeyListener(new View.OnKeyListener() {
        Button b1 = (Button) view.findViewById(R.id.b2);
        cost.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if((keyEvent.getAction()==KeyEvent.ACTION_DOWN) && (i== KeyEvent.KEYCODE_ENTER)){
                    String loan=cost.getText().toString();
                    Float val=Float.parseFloat(loan);

                    if(val>999999999){

                        Toast.makeText(getContext(),"Cost of home should not exceed 999999.99",Toast.LENGTH_SHORT).show();
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

        });*/
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {

                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();

                }
                if((!cost.getText().toString().equals(""))&&(Long.parseLong(cost.getText().toString())<10000000)) {

                    final String cos = cost.getText().toString();
                    SessionManager.putStringInPreferences(getContext(), cos, "cost_of_entity");
                    Log.d("cost:", cos + " rs");

                    ad.mFragmentList.add(new Select_Category());
                    ad.mFragmentTitleList.add("Select_Category");
                    ad.notifyDataSetChanged();


                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    pb.setProgress(50);

                    progress.setText(String.valueOf(50));
                }
                else if(cost.getText().toString().equals("")){
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());

                    dlgAlert.setMessage("Please enter the cost of the property");
                    dlgAlert.setTitle("Error Message");
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();

                }
                else{

                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());

                    dlgAlert.setMessage("cost of property cannot be greater than ₹9999999");
                    dlgAlert.setTitle("Error Message");
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }


            }
        });




        return view;

    }
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            //Handle go key click
            if((Long.parseLong(v.getText().toString())<10000000)) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.custom_dialog);
                TextView tv = (TextView) dialog.findViewById(R.id.amount);
                String loan2 = cost.getText().toString();
                tv.setText(loan2);
                dialog.show();
            }
            else{
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
            return true;
        }
        return false;
    }
}
