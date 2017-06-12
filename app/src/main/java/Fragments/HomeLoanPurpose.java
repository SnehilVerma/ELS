package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.elsapp.els.R;

/**
 * Created by Rishi on 6/12/2017.
 */

public class HomeLoanPurpose extends Fragment {

    Button construct,repair,identified,tranfer;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home_loanpurpose,container,false);

        construct = (Button) view.findViewById(R.id.construct);
        tranfer = (Button) view.findViewById(R.id.transfer);
        repair = (Button) view.findViewById(R.id.renovate);
        identified = (Button) view.findViewById(R.id.identified);





        return view;
    }
}
