package Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Models.QEC_Model;

/**
 * Created by sibby on 12/6/17.
 */

public class QEC_adapter extends PagerAdapter {
    private Context context;

    public QEC_adapter(Context context) {
        this.context=context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        QEC_Model customPagerEnum = QEC_Model.values()[position];
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) inflater.inflate(customPagerEnum.getLayoutResId(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return QEC_Model.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        QEC_Model customPagerEnum = QEC_Model.values()[position];
        return context.getString(customPagerEnum.getTitleResId());
    }

}
