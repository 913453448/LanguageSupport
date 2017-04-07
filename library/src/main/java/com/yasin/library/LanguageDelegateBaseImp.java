package com.yasin.library;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.yasin.library.exception.LanguageException;
import com.yasin.library.widge.LanguageButton;
import com.yasin.library.widge.LanguageEditText;
import com.yasin.library.widge.LanguageSupportable;
import com.yasin.library.widge.LanguageTextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leo on 17/4/6.
 */

public class LanguageDelegateBaseImp extends LanguageDelegate {
    private static final String TAG = "LanguageDelegateBaseImp";
    private List<WeakReference<LanguageSupportable>> mSupports;

    public LanguageDelegateBaseImp(Context context) {
        this.mContext = context;
        mSupports = new ArrayList<>();
    }

    @Override
    public void installViewFactory() {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        if (layoutInflater.getFactory() == null) {
            LayoutInflaterCompat.setFactory(layoutInflater, this);
        } else {
            if (!(LayoutInflaterCompat.getFactory(layoutInflater)
                    instanceof LanguageDelegateBaseImp)) {
                Log.i(TAG, "The Activity's LayoutInflater already has a Factory installed"
                        + " so we can not install LanguageCompat's");
            }
        }
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        if ("TextView".equals(name)) {
            LanguageTextView supportable = new LanguageTextView(context, attrs);
            mSupports.add(new WeakReference<LanguageSupportable>(supportable));
            return supportable;
        } else if ("Button".equals(name)) {
            LanguageButton supportable = new LanguageButton(context, attrs);
            mSupports.add(new WeakReference<LanguageSupportable>(supportable));
            return supportable;
        } else if ("EditText".equals(name)) {
            LanguageEditText supportable = new LanguageEditText(context, attrs);
            mSupports.add(new WeakReference<LanguageSupportable>(supportable));
            return supportable;
        }
        return null;
    }

    @Override
    public void update(String language) throws Exception {
        try {
            for (WeakReference<LanguageSupportable> support : mSupports) {
                LanguageSupportable s = support.get();
                s.change();
            }
        } catch (Exception e) {
            throw new LanguageException(e.getMessage(), e.getCause());
        }
    }
}
