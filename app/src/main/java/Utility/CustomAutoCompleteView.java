package Utility;

import android.content.Context;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;

import java.util.HashMap;

/**
 * Created by snehil on 1/6/17.
 */

public class CustomAutoCompleteView extends AppCompatAutoCompleteTextView {

    public CustomAutoCompleteView(Context context){
        super(context);


    }

    public CustomAutoCompleteView(Context context, AttributeSet attrs){

        super(context,attrs);

    }

    /*
    public CustomAutoCompleteView(Context context, AttributeSet attrs,int defStyle){

        super(context,attrs,defStyle);

    }*/


    @Override
    protected CharSequence convertSelectionToString(Object selectedItem) {

        HashMap<String, String> hm = (HashMap<String, String>) selectedItem;
        return hm.get("bname");
    }


    /*
    @Override
    protected void performFiltering(CharSequence text, int keyCode) {
        String filtertext="";
        super.performFiltering(text, keyCode);
    }
    */
}
