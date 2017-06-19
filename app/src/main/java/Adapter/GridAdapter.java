package Adapter;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by snehil on 9/6/17.
 */

public class GridAdapter extends BaseAdapter {
    private Context context;
    public Integer[] thumbs;

    public GridAdapter(Context context, Integer[] thumbs) {
        this.context = context;
        this.thumbs = thumbs;
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
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(width/3, width/3));
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

}
