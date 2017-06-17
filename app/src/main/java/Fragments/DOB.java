package Fragments;

import android.app.DatePickerDialog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import android.icu.text.SimpleDateFormat;
//import android.icu.util.Calendar;
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

import com.elsapp.els.HomeLoan;
import com.elsapp.els.R;

import java.util.Locale;

import Utility.SessionManager;


@RequiresApi(api = Build.VERSION_CODES.N)
public class DOB extends Fragment {
    EditText text;
    ViewPager viewPager;
    HomeLoan.ViewPagerAdapter ad;
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
        ad = ((HomeLoan)getActivity()).getCurrAdapter();
        viewPager = ((HomeLoan)getActivity()).getViewPager();
        text = (EditText) y.findViewById(R.id.editText);
        pb = ((HomeLoan)getActivity()).getPb();

        progress = ((HomeLoan)getActivity()).getprogresstv();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //SESSION MANAGER
                SessionManager.putStringInPreferences(getContext(),text.getText().toString(),"DOB");

                int index = (viewPager.getCurrentItem()) + 1;
                if (index < ad.mFragmentList.size()) {
                    ad.mFragmentList.subList(index, ad.mFragmentList.size()).clear();
                    ad.mFragmentTitleList.subList(index, ad.mFragmentTitleList.size()).clear();
                    ad.notifyDataSetChanged();



                }


                ad.addFragment(new HomePropLoc(), "HomePropLoc");
                ad.notifyDataSetChanged();
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                int p = Integer.parseInt(progress.getText().toString());
                pb.setProgress(20);

                progress.setText(String.valueOf(20));
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
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                dialog.show();
            }
        });


        // Inflate the layout for this fragment
        return y;
    }

        @RequiresApi(api = Build.VERSION_CODES.N)
        private void updateLabel() {

            String myFormat = "MM/dd/yy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            text.setText(sdf.format(myCalendar.getTime()));
        }
    }





