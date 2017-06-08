package Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.elsapp.els.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by snehil on 8/6/17.
 */

public class SwipeAdapter extends BaseAdapter {

    private List<String> data;
    private Context context;

    public SwipeAdapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // normally use a viewholder
            v = inflater.inflate(R.layout.swipe_card, parent, false);
        }

        ImageView imageView = (ImageView) v.findViewById(R.id.offer_image);
        Picasso.with(context).load(R.drawable.logo).fit().centerCrop().into(imageView);
        TextView textView = (TextView) v.findViewById(R.id.sample_text);
        String item = (String)getItem(position);
        textView.setText(item);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Layer type: ", Integer.toString(v.getLayerType()));
                Log.i("Hardware Accel type:", Integer.toString(View.LAYER_TYPE_HARDWARE));
            }
        });
        return v;
    }
}
