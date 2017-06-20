package Fragments;

import android.app.DatePickerDialog;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.elsapp.els.CarLoanActivity;
import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import Utility.SessionManager;

//import android.icu.text.SimpleDateFormat;
//import android.icu.util.Calendar;


@RequiresApi(api = Build.VERSION_CODES.N)
public class DOB extends Fragment {
    EditText text;
    ViewPager viewPager;
    private CarLoanActivity.ViewPagerAdapter ad;
    private HomeLoan.ViewPagerAdapter ad2;
    Calendar myCalendar = Calendar.getInstance();
    ProgressBar pb;
    TextView progress ;



    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub

            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            updateLabel();
        }

    };







    public DOB() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View y = inflater.inflate(R.layout.fragment_dob, container, false);
        Button b1 = (Button) y.findViewById(R.id.button);
        text = (EditText) y.findViewById(R.id.editText);


        final String type=SessionManager.getStringFromPreferences(getContext(),"loantype");



        if(type.equals("Vehicle")) {
            ad = ((CarLoanActivity) getActivity()).getCurrAdapter();
            viewPager = ((CarLoanActivity) getActivity()).getViewPager();
            pb = ((CarLoanActivity)getActivity()).getPb();
            progress = ((CarLoanActivity)getActivity()).getprogresstv();

        }
        else if(type.equals("Home")){
            ad2 = ((HomeLoan)getActivity()).getCurrAdapter();
            viewPager = ((HomeLoan)getActivity()).getViewPager();
            progress = ((HomeLoan)getActivity()).getprogresstv();
            pb = ((HomeLoan)getActivity()).getPb();

        }




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text.getText().toString().equals("")) {


                    if (type.equals("Vehicle")) {

                        //SESSION MANAGER
                        SessionManager.putStringInPreferences(getContext(), text.getText().toString(), "DOB");

                        int index = (viewPager.getCurrentItem()) + 1;
                        if (index < ad.mFragmentList.size()) {
                            ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                            ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                            ad.notifyDataSetChanged();


                        }


                        ad.addFragment(new VehSelect(), "VehSelect");
                        ad.notifyDataSetChanged();
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                        int p = Integer.parseInt(progress.getText().toString());
                        pb.setProgress(20);

                        progress.setText(String.valueOf(20));
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

                    } else if (type.equals("Home")) {


                        SessionManager.putStringInPreferences(getContext(), text.getText().toString(), "DOB");

                        int index = (viewPager.getCurrentItem()) + 1;
                        if (index < ad2.mFragmentList.size()) {
                            ad2.mFragmentList.subList(index, ad2.mFragmentList.size()).clear();
                            ad2.mFragmentTitleList.subList(index, ad2.mFragmentTitleList.size()).clear();
                            ad2.notifyDataSetChanged();


                        }


                        ad2.addFragment(new HomePropLoc(), "HomePropLoc");
                        ad2.notifyDataSetChanged();
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                        int p = Integer.parseInt(progress.getText().toString());
                        pb.setProgress(20);

                        progress.setText(String.valueOf(20));
                        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);


                    }
                }else{
                    Toast.makeText(getContext(),"Please select your DOB",Toast.LENGTH_SHORT).show();

                }
            }
        });



        text.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                DatePickerDialog dialog;
                dialog=new DatePickerDialog(getActivity(),date , myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis()-(long)5.676e+11-(long)3.456e+8);
                dialog.show();
            }
        });


        // Inflate the layout for this fragment
        return y;
    }

        @RequiresApi(api = Build.VERSION_CODES.N)
        private void updateLabel() {

            String myFormat = "yyyy-MM-dd"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            text.setText(sdf.format(myCalendar.getTime()));
        }
    }





