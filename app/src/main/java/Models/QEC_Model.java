package Models;

import com.elsapp.els.R;

/**
 * Created by sibby on 12/6/17.
 */

public enum QEC_Model {
    SLIDE1(1,R.layout.homeloan_slide1),
    SLIDE2(2,R.layout.homeloan_slide2),
    SLIDE3(3,R.layout.homeloan_slide3),
    SLIDE4(4,R.layout.homeloan_slide4),
    SLIDE5(5,R.layout.homeloan_slide5),
    SLIDE6(6,R.layout.homeloan_slide6);

    private int mTitleResId;
    private int mLayoutResId;

    QEC_Model(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
