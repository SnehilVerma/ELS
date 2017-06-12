package Adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.elsapp.els.QEC_Model;

/**
 * Created by Rishi on 6/12/2017.
 */

public class QEC_adapter extends PagerAdapter {

    private int layout;

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }
    public QEC_adapter(int layout) {

        this.layout = layout;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }


}
