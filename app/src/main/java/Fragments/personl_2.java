package Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.elsapp.els.R;


public class personl_2 extends Fragment {
    EditText gender,number,mail;
    Spinner religion,soi,caste;
    private String[] arrrel,arrsoi,arrcas;
    LinearLayout castlin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final  View x =inflater.inflate(R.layout.fragment_personal1, container, false);
        gender = (EditText) x.findViewById(R.id.gen);
        religion =(Spinner) x.findViewById(R.id.rel);
        castlin =(LinearLayout) x.findViewById(R.id.caslin) ;
        number = (EditText) x.findViewById(R.id.mob);
        mail= (EditText) x.findViewById(R.id.mail);
        soi = (Spinner) x.findViewById(R.id.soi);
        caste = (Spinner) x.findViewById(R.id.caste);

        this.arrrel = new String[]{
                "Hindu","Muslim","Cristian","Sikh","Buddhist","Zoroastrian","Jain","No Religion"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,arrrel);
        religion.setAdapter(adapter);
        this.arrsoi = new String[]{
                "Salaried", "Retired Pensioner","Retired non-Pensioner", "Self-Employed","Businessman","Homemaker"
        };
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,arrsoi);
        soi.setAdapter(adapter1);
        this.arrcas = new String[]{
                "General","SC","ST","OBC"
        };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,arrcas);
        caste.setAdapter(adapter2);


        religion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0||i==4){
                    castlin.setVisibility(View.VISIBLE);
                }else{
                    castlin.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return x;
    }



}
