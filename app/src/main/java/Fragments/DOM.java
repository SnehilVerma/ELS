package Fragments;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.elsapp.els.R;

/**
 * Created by Rishi on 6/13/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class DOM extends Fragment {

    EditText dom;

    Calendar myCalender = Calendar.getInstance();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dom,container,false);

        dom = (EditText) view.findViewById(R.id.monthtxt);
        


        return view;
    }
}
