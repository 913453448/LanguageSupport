package com.yasin.library;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.LayoutInflaterFactory;

/**
 * Created by leo on 17/4/6.
 */

public abstract class LanguageDelegate implements LanguageObserver, LayoutInflaterFactory {
    protected Context mContext;
    public static LanguageDelegate create(Activity activity) {
        return new LanguageDelegateBaseImp(activity);
    }

    public abstract void installViewFactory();

    public void onResume() {
        if(mContext==null)return;
        LanguageManage.getInstance(mContext).attach(this);
    }

    public void onDestory() {
        if(mContext==null)return;
        LanguageManage.getInstance(mContext).dettach(this);
    }
}
