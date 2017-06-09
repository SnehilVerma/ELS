package Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;=
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.elsapp.els.R;

/**
 * Created by snehil on 9/6/17.
 */

public class GridAdapter extends BaseAdapter {
    private Context context;
    //public Integer thumbs;

    public GridAdapter (Context c){

        context=c;
    }

    public int getCount(){
        return thumbs.length;

    }

    public Object getItem(int position){
        return null;
    }

    public long getItemId(int position){

        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 5, 5, 5);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(thumbs[position]);
        return imageView;


    }

    public Integer[] thumbs = {
            R.drawable.car1, R.drawable.car3,
            R.drawable.car4, R.drawable.car2,
            R.drawable.car1, R.drawable.car3,
            R.drawable.car4, R.drawable.car2,
            R.drawable.car1, R.drawable.car3,
            R.drawable.car4, R.drawable.car2,



    };
}
