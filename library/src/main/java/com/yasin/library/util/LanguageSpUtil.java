package com.yasin.library.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by leo on 17/4/7.
 */

public class LanguageSpUtil {
    private static SharedPreferences sp;
    private static String FILE_NAME="SP_LANGUAGE";
    private static String LANGUAGE="LANGUAGE";

    private synchronized static void init(Context context) {
        if(sp==null){
            sp=context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        }
    }

    public synchronized static void saveLanguage(Context context,LANGUAGE language) {
        init(context);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(LANGUAGE,language.toString());
        editor.commit();
    }
    public static String getLanguage(Context context){
        init(context);
        return sp.getString(LANGUAGE,null);
    }
}
