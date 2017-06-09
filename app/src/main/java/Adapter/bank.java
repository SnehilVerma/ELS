package Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.elsapp.els.R;

/**
 * Created by Phani Teja on 6/9/2017.
 */

public class bank extends BaseAdapter {
    Context context;
    String[] string;
    int[] ints;

    public bank(Context context, String[] string, int[] ints) {
        this.context = context;
        this.string = string;
        this.ints = ints;
    }

    @Override
    public int getCount() {
        return string.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int positions, View convertview, ViewGroup viewGroup) {

        View view;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertview == null){
            view = new View(context);
            view=inflater.inflate(R.layout.bank,null);
            TextView texts = (TextView) view.findViewById(R.id.gridtext);
            ImageView image = (ImageView) view.findViewById(R.id.gridimg);
            texts.setText(string[positions]);
            image.setImageResource(ints[positions]);
        }
        else {
            view = convertview;
        }
        return view;
    }
}
