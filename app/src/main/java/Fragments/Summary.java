package Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.elsapp.els.Eligibility_Result;
import com.elsapp.els.R;

import Utility.SessionManager;

/**
 * Created by sibby on 20/6/17.
 */

public class Summary extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        String loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");
        View view;
        if(loantype.equals("Home")) {
            view = inflater.inflate(R.layout.overall_qec_home, container, false);
            TextView loan_type = (TextView) view.findViewById(R.id.loantype);
            TextView proploc = (TextView) view.findViewById(R.id.proploc);
            TextView purpose = (TextView) view.findViewById(R.id.purpose);
            TextView costprop = (TextView) view.findViewById(R.id.costprop);
            TextView incometype = (TextView) view.findViewById(R.id.incometype);
            TextView gmincome = (TextView) view.findViewById(R.id.gmincome);
            TextView emi = (TextView) view.findViewById(R.id.emi);
            TextView coappincome = (TextView) view.findViewById(R.id.incometypecoapp);
            TextView relation = (TextView) view.findViewById(R.id.coapp);
            TextView coappgmincome = (TextView) view.findViewById(R.id.gmincomecoapp);
            TextView coappemi = (TextView) view.findViewById(R.id.emicoapp);
            TextView city = (TextView) view.findViewById(R.id.city);
            TextView gender = (TextView) view.findViewById(R.id.gender);
            TextView dob = (TextView) view.findViewById(R.id.dob);
            TextView rla = (TextView) view.findViewById(R.id.rla);

            ScrollView sv = (ScrollView) view.findViewById(R.id.sv);
            WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int height = size.y;
            sv.setMinimumHeight(3*height/4);

            loan_type.setText(loantype);
            city.setText(SessionManager.getStringFromPreferences(getActivity(),"city"));
            gender.setText(SessionManager.getStringFromPreferences(getActivity(),"gender"));
            dob.setText(SessionManager.getStringFromPreferences(getActivity(),"DOB"));
            proploc.setText(SessionManager.getStringFromPreferences(getActivity(),"property_location"));
            purpose.setText(SessionManager.getStringFromPreferences(getActivity(),"homepurpose"));
            costprop.setText(SessionManager.getStringFromPreferences(getActivity(),"cost_of_entity"));
            incometype.setText(SessionManager.getStringFromPreferences(getActivity(),"incometype"));
            gmincome.setText(SessionManager.getStringFromPreferences(getActivity(),"gross_salary"));
            emi.setText(SessionManager.getStringFromPreferences(getActivity(),"existing_emi"));
            rla.setText(SessionManager.getStringFromPreferences(getActivity(),"rla"));
            if(SessionManager.getStringFromPreferences(getActivity(),"coapp").equals("Yes")) {
                coappincome.setText(SessionManager.getStringFromPreferences(getActivity(),"incometypecoapp"));
                coappgmincome.setText(SessionManager.getStringFromPreferences(getActivity(), "coap_gross_salary"));
                coappemi.setText(SessionManager.getStringFromPreferences(getActivity(), "coap_existing_emi"));
                relation.setText(SessionManager.getStringFromPreferences(getActivity(),"relation"));
            }
            else{
                coappincome.setText("-");
                coappgmincome.setText("-");
                coappemi.setText("-");
                relation.setText("-");
            }



        }
        else{
            view = inflater.inflate(R.layout.overall_qec_vehicle, container, false);
            TextView city = (TextView) view.findViewById(R.id.city);
            TextView gender = (TextView) view.findViewById(R.id.gender);
            TextView dob = (TextView) view.findViewById(R.id.dob);
            TextView loan_type = (TextView) view.findViewById(R.id.loantype);
            TextView incometype = (TextView) view.findViewById(R.id.incometype);

            TextView rla = (TextView) view.findViewById(R.id.rla);
            TextView vehselect = (TextView) view.findViewById(R.id.vehtype);
            TextView dom = (TextView) view.findViewById(R.id.dom);
            TextView newold = (TextView) view.findViewById(R.id.newold);
            TextView vehpref = (TextView) view.findViewById(R.id.prefveh);
            TextView vehcost = (TextView) view.findViewById(R.id.vehcost);
            TextView gmincome = (TextView) view.findViewById(R.id.gmincome);
            TextView emi = (TextView) view.findViewById(R.id.emi);

            ScrollView sv = (ScrollView) view.findViewById(R.id.sv);
            WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int height = size.y;
            sv.setMinimumHeight(3*height/4);


            dom.setText(SessionManager.getStringFromPreferences(getActivity(),"dom"));
            loan_type.setText(loantype);
            city.setText(SessionManager.getStringFromPreferences(getContext(),"city"));
            gender.setText(SessionManager.getStringFromPreferences(getActivity(),"gender"));
            dob.setText(SessionManager.getStringFromPreferences(getActivity(),"DOB"));
            vehselect.setText(SessionManager.getStringFromPreferences(getActivity(),"vehicle_type"));
            incometype.setText(SessionManager.getStringFromPreferences(getActivity(),"incometype"));
            if(vehselect.getText().equals("Car")) {
                newold.setText(SessionManager.getStringFromPreferences(getActivity(), "car_type"));
            }
            else{
                newold.setText(SessionManager.getStringFromPreferences(getActivity(),"bike_type"));
            }
            if(vehselect.getText().equals("Car")) {
                vehpref.setText(SessionManager.getStringFromPreferences(getActivity(), "car_option"));
            }
            else{
                vehpref.setText(SessionManager.getStringFromPreferences(getActivity(),"bike_option"));
            }
            //dom.setText(SessionManager.getStringFromPreferences(getActivity(),"DOB"));
            vehcost.setText(SessionManager.getStringFromPreferences(getActivity(),"cost_of_entity"));
            gmincome.setText(SessionManager.getStringFromPreferences(getActivity(),"gross_salary"));
            emi.setText(SessionManager.getStringFromPreferences(getActivity(),"existing_emi"));
            rla.setText(SessionManager.getStringFromPreferences(getActivity(),"rla"));
        }
        Button done = (Button) view.findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),Eligibility_Result.class);
                //i.putExtra("eligible_loan_amount",String.valueOf(eligible_loan_amount));   //TODO send the eligible loan to be displayed.
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        return view;

    }
}
