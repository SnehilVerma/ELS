package Fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.elsapp.els.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiresApi(api = Build.VERSION_CODES.N)
public class personal_3 extends Fragment {
    String[] arrqual,arriden;
    Spinner qual,iden;
    EditText panc,liscense,passport,adhaar,votes;
    Button submit,submit1,submit2,submit3;
    Calendar mycalender = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub

            mycalender.set(java.util.Calendar.YEAR, year);
            mycalender.set(java.util.Calendar.MONTH, monthOfYear);
            mycalender.set(java.util.Calendar.DAY_OF_MONTH, dayOfMonth);

        }

    };
    /*String s = "abcde1234f";
    Pattern pattern =  Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");*/




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final  View x = inflater.inflate(R.layout.fragment_personal_3, container, false);
        qual = (Spinner) x.findViewById(R.id.qual);
        iden = (Spinner) x.findViewById(R.id.iden);
        panc =(EditText) x.findViewById(R.id.pan);
        submit = (Button) x.findViewById(R.id.sub);
        submit1 = (Button) x.findViewById(R.id.sub1);
        submit2 = (Button) x.findViewById(R.id.sub2);
        submit3 = (Button) x.findViewById(R.id.sub3);
        liscense =(EditText)x.findViewById(R.id.lics);
        passport = (EditText)x.findViewById(R.id.pas);
        adhaar = (EditText) x.findViewById(R.id.adhaar);
        votes = (EditText) x.findViewById(R.id.vote);
        this.arrqual = new String[]{
               "None Selected" ,"10th","12th","Graduate","Post Graduate","Doctarate","Others"

        };
        this.arriden = new String []{
               "None Selected", "Voter Card","Driving License","Passport Number", "Adhaar Card No."
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,arrqual);
        qual.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,arriden);
        iden.setAdapter(adapter1);
        iden.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){
                    votes.setVisibility(View.VISIBLE);
                    adhaar.setVisibility(View.INVISIBLE);
                    passport.setVisibility(View.INVISIBLE);
                    liscense.setVisibility(View.INVISIBLE);
                }

                if(i==2){
                    liscense.setVisibility(View.VISIBLE);
                    passport.setVisibility(View.INVISIBLE);
                    adhaar.setVisibility(View.INVISIBLE);
                    votes.setVisibility(View.INVISIBLE);

                }else if(i==3){
                    liscense.setVisibility(View.INVISIBLE);
                    passport.setVisibility(View.VISIBLE);
                    adhaar.setVisibility(View.INVISIBLE);
                    votes.setVisibility(View.INVISIBLE);
                }else if(i==4){
                    passport.setVisibility(View.INVISIBLE);
                    liscense.setVisibility(View.INVISIBLE);
                    adhaar.setVisibility(View.VISIBLE);
                    submit1.setVisibility(View.VISIBLE);
                    submit2.setVisibility(View.INVISIBLE);
                    submit3.setVisibility(View.INVISIBLE);
                    votes.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        panc.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                submit.setVisibility(View.VISIBLE);


            }

            @Override
            public void afterTextChanged(final Editable editable) {
                final String s = editable.toString();
                if(panc.getText().toString().equals("")){
                    panc.setError("Pan Card ID is required!!");
                }


                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                         // get your editext value here
                        Pattern pattern = Pattern.compile("[a-z]{5}[0-9]{4}[a-z]{1}");
                        Matcher matcher = pattern.matcher(s);
                        if(matcher.matches()){
                            panc.setText(editable.toString());
                        }
                        else {
                            Toast.makeText(getActivity(),"Invalid Pan ID",Toast.LENGTH_SHORT).show();
                        }

                    }

                });



            }
        });

        liscense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog;
                dialog = new DatePickerDialog(getActivity(), date, mycalender
                        .get(java.util.Calendar.YEAR), mycalender.get(java.util.Calendar.MONTH),
                        mycalender.get(java.util.Calendar.DAY_OF_MONTH));
                /*SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
                String currDate = sdf.format(mycalender.getTime());*/
                dialog.getDatePicker().setMinDate(System.currentTimeMillis());
                dialog.show();
                submit1.setVisibility(View.VISIBLE);
                submit2.setVisibility(View.INVISIBLE);
                submit3.setVisibility(View.INVISIBLE);
            }
        });

        passport.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                submit1.setVisibility(View.INVISIBLE);
                submit3.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                submit2.setVisibility(View.VISIBLE);


            }

            @Override
            public void afterTextChanged(final Editable editable) {
                final String p = editable.toString();
                submit2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Pattern pattern = Pattern.compile("[a-z]{1}[-]{1}[0-9]{18}");
                        Matcher matcher = pattern.matcher(p);//[a-z]{5}[0-9]{4}[a-z]{1}
                        if(matcher.matches()){
                            passport.setText(editable.toString());

                        }
                        else{
                            Toast.makeText(getActivity(),"Invalid Passport Number",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        votes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                submit1.setVisibility(View.INVISIBLE);
                submit2.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                submit3.setVisibility(View.VISIBLE);


            }

            @Override
            public void afterTextChanged(final Editable editable) {
                final String v = editable.toString();
                submit3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Pattern pattern = Pattern.compile("[a-z]{3}/[0-9]{6}/1[0-9]{1}");
                        /*Pattern patterns = Pattern.compile("[a-z]{2}[/]{1}[0-9]{3}[/]{1}[0-9]{7}");*/
                        Matcher matcher = pattern.matcher(v);
                        if(matcher.matches()){
                            votes.setText(editable.toString());
                        }
                        else{
                            Toast.makeText(getActivity(),"Invalid Voter ID",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });




        return x;
    }





}
