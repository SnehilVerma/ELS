package Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.elsapp.els.R;

public class Additional_two extends Fragment {


    LinearLayout ptype,atype;
    RelativeLayout lImmovable,lmovable;
    Spinner snature,smovable,simmovable;
    String[] arrspin1,arrspin2,arrspin3;
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_additional_two, container, false);
        arrspin1 = new String[]{
                  "Immovable Asset","Movable Asset"
        };
        arrspin2 = new String[]{
            "Land","residential Property","Commercial Property"
        };
        arrspin3 = new String[]{
            "Bank Deposits","Any other Investments"
        };
        lImmovable = (RelativeLayout)view.findViewById(R.id.limmovable);
        lmovable = (RelativeLayout)view.findViewById(R.id.lmovable);
        ptype = (LinearLayout)view.findViewById(R.id.ptype);
        atype = (LinearLayout)view.findViewById(R.id.atype);

        snature = (Spinner)view.findViewById(R.id.snature);
        adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,arrspin1);
        snature.setAdapter(adapter);
        simmovable = (Spinner)view.findViewById(R.id.simmovable);
        adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,arrspin2);
        simmovable.setAdapter(adapter);
        smovable = (Spinner)view.findViewById(R.id.smovable);
        adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_dropdown_item,arrspin3);
        smovable.setAdapter(adapter);

        /*snature.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    lImmovable.setVisibility(view.VISIBLE);
                }
                else{
                    lmovable.setVisibility(view.VISIBLE);
                }
            }
        });*/
        snature.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    lImmovable.setVisibility(view.VISIBLE);
                    lmovable.setVisibility(view.GONE);
                    ptype.setVisibility(view.GONE);
                    atype.setVisibility(view.GONE);
                }
                else{
                    lmovable.setVisibility(view.VISIBLE);
                    lImmovable.setVisibility(view.GONE);
                    ptype.setVisibility(view.GONE);
                    atype.setVisibility(view.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

       /* simmovable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ptype.setVisibility(view.VISIBLE);
            }
        });*/

       simmovable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               ptype.setVisibility(view.VISIBLE);
               atype.setVisibility(view.GONE);
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

       /* smovable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                atype.setVisibility(view.VISIBLE);
            }
        });*/


       smovable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               atype.setVisibility(view.VISIBLE);
               ptype.setVisibility(view.GONE);
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        return view;
    }
}