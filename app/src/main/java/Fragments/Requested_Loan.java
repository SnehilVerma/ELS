package Fragments;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

    String cost;
    String gross;
    String net_salary;
    String existing_emi;
    ProgressBar pb;
    TextView progress;

    EditText et;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_requested_loan,container,false);


        et=(EditText)view.findViewById(R.id.loan);
        et.setText("00.00");
        //et.setFocusable(false);
        //et.setKeyListener(null);

        final String loan_type=SessionManager.getStringFromPreferences(getContext(),"loantype");
        String city=SessionManager.getStringFromPreferences(getContext(),"city");
        String vehicle_type=SessionManager.getStringFromPreferences(getContext(),"vehicle_type");
        String car_condition=SessionManager.getStringFromPreferences(getContext(),"car_type");
        cost=SessionManager.getStringFromPreferences(getContext(),"cost_of_entity");
        gross=SessionManager.getStringFromPreferences(getContext(),"gross_salary");
        net_salary=SessionManager.getStringFromPreferences(getContext(),"net_salary");
        existing_emi=SessionManager.getStringFromPreferences(getContext(),"existing_emi");


        Toast.makeText(getContext(),loan_type+ "  "+ city+ "   "+vehicle_type+ "  "+cost+" "+ car_condition+'\n'
                +gross+'\n'+ net_salary+'\n'+ existing_emi,Toast.LENGTH_LONG).show();

        //view.setFocusableInTouchMode(true);
        //view.requestFocus();




        et.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if((keyEvent.getAction()==KeyEvent.ACTION_DOWN) && (i== KeyEvent.KEYCODE_ENTER) ){
                    String loan=et.getText().toString();
                    Float val=Float.parseFloat(loan);

                    if(val>999999.99){

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

                if(loan_type.equals("CarLoanActivity")){
                    pb = ((CarLoanActivity)getActivity()).getPb();
                    progress = ((CarLoanActivity)getActivity()).getprogresstv();
                }
                else{
                    pb = ((HomeLoan)getActivity()).getPb();
                    progress = ((HomeLoan)getActivity()).getprogresstv();
                }
                pb.setProgress(100);
                progress.setText(String.valueOf(100));
                exec_process();
            }
        });







        return view;
    }




    //PROCESS TO CHECK ELGIBILITY
    public void exec_process(){

        //String requested_loan_amount=SessionManager.getStringFromPreferences(getContext(),"requested_loan_amount");

//        String cost_of_entity=SessionManager.getStringFromPreferences(getContext(),"cost_of_entity");
            String loan = et.getText().toString();
            Float val = Float.parseFloat(loan);


            //float rla=Float.parseFloat(requested_loan_amount);
            float rla = val;
            float coe = Float.parseFloat(cost);
            if (rla > 0.9 * coe) {        //CHECK RLA AND COE CONDITION
                breakflag = 1;
                exitprocess();

            } else {

                float pemi = (float) rla / 60;      //PROJECTED EMI
                float inc = Float.parseFloat(net_salary);         //ANY INCOME SOURCE

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
                if (net_inc < 0.4 * inc) {

                    breakflag = 2;
                    exitprocess();

                } else {

                    //Toast.makeText(getContext(),"hurray!",Toast.LENGTH_SHORT).show();
                    launchCongrats();


                }


            }



    }


    // LAUNCH FAILURE SCREEN
    public void exitprocess(){

        Toast.makeText(getContext(),"shame",Toast.LENGTH_SHORT).show();

        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.custom_eligibile_dialog);

        Button lb=(Button)dialog.findViewById(R.id.b1);
        Button rb=(Button)dialog.findViewById(R.id.b2);

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


//        Intent i=new Intent(getContext(),Failure_Result.class);
 //       i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
  //      startActivity(i);

    }

    //LAUNCH CONGRATS SCREEN
    public void launchCongrats(){

        Toast.makeText(getContext(),"congrats",Toast.LENGTH_SHORT).show();

        Intent i=new Intent(getActivity(),Eligibility_Result.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

    }




}
