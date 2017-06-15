package Fragments;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import java.util.Locale;

import Utility.SessionManager;

@RequiresApi(api = Build.VERSION_CODES.N)
public class CoAPP extends Fragment {
    CarLoanActivity.ViewPagerAdapter adapter1;
    HomeLoan.ViewPagerAdapter adapter;
    ViewPager viewPager;
    EditText Name,Phone,Age;
    Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener dates = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            calendar.set(Calendar.YEAR, i);
            calendar.set(Calendar.MONTH, i1);
            calendar.set(Calendar.DAY_OF_MONTH, i2);
            mylabel();

        }
    };




    public CoAPP() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View x = inflater.inflate(R.layout.fragment_co_ap, container, false);
        final String loantype = SessionManager.getStringFromPreferences(getActivity(),"loantype");
        EditText relationship = (EditText) x.findViewById(R.id.relationship);
        Button b1 = (Button) x.findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(loantype.equals("HomeLoan")){
                        int flag = 0;
                        adapter = ((HomeLoan)getActivity()).getCurrAdapter();
                        viewPager = ((HomeLoan)getActivity()).getViewPager();
                        for(int y = 0;y<adapter.mFragmentTitleList.size();y++) {
                            if(adapter.mFragmentTitleList.get(y).equals("CoApp_Cat")){
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0) {
                            adapter.addFragment(new CoApp_Cat(), "CoApp_Cat");
                            SessionManager.putStringInPreferences(getActivity(),"1","flaggy");
                            adapter.notifyDataSetChanged();
                        }
                        else{
                            Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        int flag = 0;
                        adapter1 = ((CarLoanActivity)getActivity()).getCurrAdapter();
                        viewPager = ((CarLoanActivity)getActivity()).getViewPager();
                        for(int y = 0;y<adapter1.mFragmentTitleList.size();y++) {
                            if(adapter1.mFragmentTitleList.get(y).equals("CoApp_Cat")){
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0) {
                            adapter1.addFragment(new CoApp_Cat(), "CoApp_Cat");
                            SessionManager.putStringInPreferences(getActivity(),"1","flaggy");
                            adapter1.notifyDataSetChanged();
                        }
                        else{
                            Toast.makeText(getContext(),"Already added next fragment",Toast.LENGTH_SHORT).show();
                        }
                    }
            }
        });

        return x;
    }

    private void mylabel() {

        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        Age.setText(sdf.format(calendar.getTime()));
    }
    }







