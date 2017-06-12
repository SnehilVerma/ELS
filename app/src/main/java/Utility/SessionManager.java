package Utility;

import android.content.Context;
import android.content.SharedPreferences;


public class SessionManager {


        public static String putStringInPreferences(Context context, String value, String key)
        {
        SharedPreferences sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
            return value;
        }


        public static String getStringFromPreferences(Context context, String key)
        {
        SharedPreferences sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        String temp = sharedPreferences.getString(key,null);
        return temp;
    }


}
