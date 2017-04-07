package com.yasin.library;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;

import com.yasin.library.util.LANGUAGE;
import com.yasin.library.util.LanguageSpUtil;

import java.util.Locale;

/**
 * Created by leo on 17/4/6.
 */

public class LanguageManage extends LanguageSubject {
    private static final String TAG = "LanguageManage";
    private static LanguageManage instance;
    private Context context;

    private LanguageManage(Context context) {
        this.context = context;
    }

    public static synchronized LanguageManage getInstance(Context context) {
        if (instance == null) {
            instance = new LanguageManage(context);
        }
        return instance;
    }

    public void change(LANGUAGE language, IChangeSuccessCallBack callBack) {
        try {
            // 应用用户选择语言
            if (language == LANGUAGE.ZH) {
                change(language, Locale.CHINESE);
                if(callBack!=null)callBack.success();
            } else if (language == LANGUAGE.EN) {
                change(language, Locale.ENGLISH);
                if(callBack!=null)callBack.success();
            } else {
                if (callBack != null) callBack.erro();
                Log.e(TAG, "Language: " + language.toString() + " is not supported!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (callBack != null) callBack.erro();
        }
    }

    private void change(LANGUAGE language, Locale locale) throws Exception {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        config.locale = locale;
        resources.updateConfiguration(config, dm);
        notifyChangeLanguage(language.toString());
        LanguageSpUtil.saveLanguage(context, language);
    }
}
