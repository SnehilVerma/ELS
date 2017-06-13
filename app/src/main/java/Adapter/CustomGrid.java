package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.elsapp.els.R;

/**
 * Created by Rishi on 6/8/2017.
 */

public class CustomGrid extends BaseAdapter {
    Context context;
    String[] strings;
    int[] ints;

    public CustomGrid(Context context, String[] strings, int[] ints) {
        this.context = context;
        this.strings = strings;
        this.ints = ints;
    }

    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){

            view = new View(context);
            view = inflater.inflate(R.layout.grid_single,null);
            TextView textView = (TextView) view.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)view.findViewById(R.id.grid_image);
            textView.setText(strings[position]);
            imageView.setImageResource(ints[position]);

        }
        else{
            view = (View)convertView;
        }

        return view;
    }
}
