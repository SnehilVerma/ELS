package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.elsapp.els.R;

import java.util.ArrayList;

/**
 * Created by snehil on 16/6/17.
 */

public class City_Adapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<String> city_names;

    public City_Adapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource=resource;
        this.city_names= objects;
    }

    @Override
    public String getItem(int position) {
        return city_names.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutInflater inflater = LayoutInflater.from(context);
        row = inflater.inflate(resource, parent, false);

        TextView text = (TextView) row.findViewById(R.id.text);
        text.setText(city_names.get(position));




        return row;
    }



}
