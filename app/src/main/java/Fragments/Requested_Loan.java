package Fragments;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.Eligibility_Result;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.LoanSelec;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by snehil on 14/6/17.
 */

public class Requested_Loan extends Fragment {

    int count=0;
    int breakflag=0;
    int checkflag=0;

    String cost;
    String gross;
    String net_salary;
    String existing_emi;

    String coap_gross;
    String coap_existing_emi;
    String coap_net_salary;

    float eligible_loan_amount;

    CarLoanActivity.ViewPagerAdapter adapter1;
    HomeLoan.ViewPagerAdapter adapter;
    ViewPager viewPager;


    ProgressBar pb;
    TextView progress;


    EditText et;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_requested_loan,container,false);


        et=(EditText)view.findViewById(R.id.loan);


        final String loan_type=SessionManager.getStringFromPreferences(getContext(),"loantype");
        String city=SessionManager.getStringFromPreferences(getContext(),"city");
        String vehicle_type=SessionManager.getStringFromPreferences(getContext(),"vehicle_type");
        String car_condition=SessionManager.getStringFromPreferences(getContext(),"car_type");


        cost=SessionManager.getStringFromPreferences(getContext(),"cost_of_entity");
        gross=SessionManager.getStringFromPreferences(getContext(),"gross_salary");
        net_salary=SessionManager.getStringFromPreferences(getContext(),"net_salary");
        existing_emi=SessionManager.getStringFromPreferences(getContext(),"existing_emi");


        coap_gross=SessionManager.getStringFromPreferences(getContext(),"coap_gross_salary");
        coap_net_salary=SessionManager.getStringFromPreferences(getContext(),"coap_net_salary");
        coap_existing_emi=SessionManager.getStringFromPreferences(getContext(),"coap_existing_emi");




        Toast.makeText(getContext(),loan_type+ "  "+ city+ "   "+vehicle_type+ "  "+cost+" "+ car_condition+'\n'
                +gross+'\n'+ net_salary+'\n'+ existing_emi,Toast.LENGTH_LONG).show();



        if(loan_type.equals("Home")){
            //TODO: to check another extra condition in home loans.
            checkflag=1;

        };


        et.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if((keyEvent.getAction()==KeyEvent.ACTION_DOWN) && (i== KeyEvent.KEYCODE_ENTER) ){
                    String loan=et.getText().toString();
                    Float val=Float.parseFloat(loan);

                    if(val>99999999){       //TODO: change this value

                        Toast.makeText(getContext(),"Loan amount should not exceed Rs. 999999.99",Toast.LENGTH_SHORT).show();
                        return true;

                    }else {
                        final Dialog dialog = new Dialog(getContext());
                        dialog.setContentView(R.layout.custom_dialog);
                        TextView tv = (TextView) dialog.findViewById(R.id.amount);
                        String loan2 = et.getText().toString();
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










        Button calc_eligibility=(Button)view.findViewById(R.id.calculate);
        calc_eligibility.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if(loan_type.equals("Vehicle")){
                    pb = ((CarLoanActivity)getActivity()).getPb();
                    progress = ((CarLoanActivity)getActivity()).getprogresstv();
                }
                else{
                    pb = ((HomeLoan)getActivity()).getPb();
                    progress = ((HomeLoan)getActivity()).getprogresstv();
                }
                pb.setProgress(100);
                progress.setText(String.valueOf(100));
                SessionManager.putStringInPreferences(getActivity(),et.getText().toString(),"rla");
                if(!et.getText().toString().equals("")) {
                    exec_process();
                }
                else{
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(getActivity());

                    dlgAlert.setMessage("Please enter the requested loan amount");
                    dlgAlert.setTitle("Error Message");
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }
            }
        });







        return view;
    }




    //PROCESS TO CHECK ELGIBILITY
    public void exec_process() {

        //String requested_loan_amount=SessionManager.getStringFromPreferences(getContext(),"requested_loan_amount");

//        String cost_of_entity=SessionManager.getStringFromPreferences(getContext(),"cost_of_entity");
            String loan = et.getText().toString();
            Float val = Float.parseFloat(loan);


            //float rla=Float.parseFloat(requested_loan_amount);
            float rla = val;
            float coe = Float.parseFloat(cost);


            if(checkflag==0) {
                if (rla > 0.9 * coe) {        //CHECK RLA AND COE CONDITION
                    breakflag = 1;
                    exitprocess();

                } else {

                    float pemi = (float) rla / 60;      //PROJECTED EMI
                    float inc = Float.parseFloat(gross);         //ANY INCOME SOURCE


                    String emp_type = SessionManager.getStringFromPreferences(getContext(), "employment_type");

                    float emi = Float.parseFloat(existing_emi);       //EXISTING EMI IF ANY.


                    if (emp_type.equals("Salaried")) {
                        //String income=SessionManager.getStringFromPreferences(getContext(),"income");
                        //inc = Float.parseFloat(income);

                    } else if (emp_type.equals("Self_Employed") || emp_type.equals("Self_Employed_P")) {
//                String income=SessionManager.getStringFromPreferences(getContext(),"income");
                        //               inc = Float.parseFloat(income);


                    } else if (emp_type.equals("Retired_P")) {
//                String income= SessionManager.getStringFromPreferences(getContext(),"income");
                        //               inc = Float.parseFloat(income);


                    } else if (emp_type.equals("Retired_NP") || emp_type.equals("Homemaker")) {
//                String income=SessionManager.getStringFromPreferences(getContext(),"income");
                        //               inc = Float.parseFloat(income);
                    } else {

                        Toast.makeText(getContext(), "Something is wrong in e_type", Toast.LENGTH_SHORT).show();
                        exitprocess();

                    }


                    float net_inc = inc - (emi + pemi);


                    // TODO: Eligible loan not to be showed.

                    if (net_inc >= 0.4 * inc) {

                        launchCongrats();

                    } else {

                        breakflag = 2;
                        //Eligible Loan Amount=GTI * 5 *12

                        exitprocess();
                        //Toast.makeText(getContext(),"hurray!",Toast.LENGTH_SHORT).show();


                    }


                }

            }
        else if (checkflag == 1) {               // TODO:HOME LOAN

            Log.d("loantype", "HOME");

            // String h_loan = et.getText().toString();
            //Float h_rla = Float.parseFloat(h_loan);

            float inc = Float.parseFloat(gross);         //ANY INCOME SOURCE
            float coap_inc = Float.parseFloat(coap_gross);

            String emp_type = SessionManager.getStringFromPreferences(getContext(), "employment_type");

            float emi = Float.parseFloat(existing_emi);       //EXISTING EMI IF ANY.
            float coap_emi = Float.parseFloat(coap_existing_emi);

            float gti = (inc + coap_inc);   // GROSS TOTAL OF APPLICANT AND COAPPLICANT.
            float net_emi = (emi + coap_emi);   //NET EMI OF APP. AND COAPP.

            float net_total_inc = gti - (net_emi);      // NET TOTAL INCOME.

            eligible_loan_amount = gti * 5 * 12;       //ELIGIBLE LOAN AMOUNT.

            if (rla > eligible_loan_amount) {

                //AUKAT SE ZAADA MAANG RAHA.

                homeloanexit();

            } else {


                homeLaunchCongrats();


            }


            }
        }





    public void homeLaunchCongrats(){

        Toast.makeText(getContext(),"congrats",Toast.LENGTH_SHORT).show();

        String loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");
        SessionManager.putStringInPreferences(getActivity(),String.valueOf(eligible_loan_amount),"eligible_loan_amount");
        if (loantype.equals("Home")) {

            adapter = ((HomeLoan) getActivity()).getCurrAdapter();
            viewPager = ((HomeLoan) getActivity()).getViewPager();
            int index = (viewPager.getCurrentItem()) + 1;
            if (index < adapter.mFragmentList.size()) {
                adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                adapter.notifyDataSetChanged();



            }
            adapter.addFragment(new Summary(), "Summary");
            adapter.notifyDataSetChanged();
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
        } else {
            adapter1 = ((CarLoanActivity) getActivity()).getCurrAdapter();
            viewPager = ((CarLoanActivity) getActivity()).getViewPager();
            int index = (viewPager.getCurrentItem()) + 1;
            if (index < adapter1.mFragmentList.size()) {
                adapter1.mFragmentList.subList(index, adapter1.mFragmentList.size()).clear();
                adapter1.mFragmentTitleList.subList(index, adapter1.mFragmentTitleList.size()).clear();
                adapter1.notifyDataSetChanged();



            }
            adapter1.addFragment(new Summary(), "Summary");
            adapter1.notifyDataSetChanged();
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
        }
        /*Intent i=new Intent(getActivity(),Eligibility_Result.class);
        i.putExtra("eligible_loan_amount",String.valueOf(eligible_loan_amount));   //TODO send the eligible loan to be displayed.
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);*/



    }


    public void homeloanexit(){

        Toast.makeText(getContext(),"home_shame",Toast.LENGTH_SHORT).show();

        final Dialog dialog=new Dialog(getContext());
        dialog.setContentView(R.layout.custom_home_eligible);
        Button lb=(Button)dialog.findViewById(R.id.b2);
        Button rb=(Button)dialog.findViewById(R.id.b2);
        TextView tv=(TextView)dialog.findViewById(R.id.tv1);
        tv.setText(String.valueOf(eligible_loan_amount));

        rb.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                et.setText("");
                dialog.dismiss();


            }
        });

        lb.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                float coe = Float.parseFloat(cost);

                if(eligible_loan_amount<=0.8*coe){


                    Intent i=new Intent(getActivity(), Eligibility_Result.class);
                    //i.putExtra("message","Sorry you are not eligible");
                    i.putExtra("message","Eligible!!!");
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);


                }else if(eligible_loan_amount>0.8*coe){

                    Intent i=new Intent(getActivity(), Eligibility_Result.class);
                    i.putExtra("message","Sorry you are not eligible");
                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);






                }

            }
        });




    }


    // LAUNCH FAILURE SCREEN
    public void exitprocess(){

        Toast.makeText(getContext(),"shame",Toast.LENGTH_SHORT).show();



        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.custom_eligibile_dialog);

        Button lb=(Button)dialog.findViewById(R.id.b2);
        Button rb=(Button)dialog.findViewById(R.id.b2);
        TextView tv=(TextView)dialog.findViewById(R.id.tv1);

        if(breakflag==1){
         tv.setText("Cannot furnish more than 90 percent\n of cost as loan");
        }else if(breakflag==2) {
            tv.setText(String.valueOf(eligible_loan_amount));
        }

        lb.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                et.setText("");
                dialog.dismiss();

            }
        });

        rb.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();
                Intent i=new Intent(getActivity(), LoanSelec.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });



        dialog.show();




    }

    //LAUNCH CONGRATS SCREEN
    public void launchCongrats(){

        Toast.makeText(getContext(),"congrats",Toast.LENGTH_SHORT).show();
        String loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");
        SessionManager.putStringInPreferences(getActivity(),String.valueOf(eligible_loan_amount),"eligible_loan_amount");
        if (loantype.equals("Home")) {

            adapter = ((HomeLoan) getActivity()).getCurrAdapter();
            viewPager = ((HomeLoan) getActivity()).getViewPager();
            int index = (viewPager.getCurrentItem()) + 1;
            if (index < adapter.mFragmentList.size()) {
                adapter.mFragmentList.subList(index, adapter.mFragmentList.size()).clear();
                adapter.mFragmentTitleList.subList(index, adapter.mFragmentTitleList.size()).clear();
                adapter.notifyDataSetChanged();



            }
            adapter.addFragment(new Summary(), "Summary");
            adapter.notifyDataSetChanged();
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
        } else {
            adapter1 = ((CarLoanActivity) getActivity()).getCurrAdapter();
            viewPager = ((CarLoanActivity) getActivity()).getViewPager();
            int index = (viewPager.getCurrentItem()) + 1;
            if (index < adapter1.mFragmentList.size()) {
                adapter1.mFragmentList.subList(index, adapter1.mFragmentList.size()).clear();
                adapter1.mFragmentTitleList.subList(index, adapter1.mFragmentTitleList.size()).clear();
                adapter1.notifyDataSetChanged();



            }
            adapter1.addFragment(new Summary(), "Summary");
            adapter1.notifyDataSetChanged();
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
        }

        /*Intent i=new Intent(getActivity(),Eligibility_Result.class);

        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);*/

    }




}
