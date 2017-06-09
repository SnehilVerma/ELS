package Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.elsapp.els.R;

/**
 * Created by Phani Teja on 6/9/2017.
 */

public class bank extends BaseAdapter {
    Context context;


    public bank(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return image.length;
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

        ImageView pics;
        if(convertview == null){
            pics = new ImageView(context);
            pics.setLayoutParams(new GridView.LayoutParams(400, 400));
            pics.setScaleType(ImageView.ScaleType.CENTER_CROP);
            pics.setPadding(5, 5, 5, 5);
        }
        else {
            pics = (ImageView) convertview ;
        }
        pics.setImageResource(image[positions]);
        return pics;
    }

    public Integer[] image ={
            R.drawable.b1,R.drawable.b2,
            R.drawable.b3,R.drawable.b4,
            R.drawable.b5

    };
}
