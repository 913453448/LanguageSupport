package com.yasin.library.helper;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.yasin.library.R;

/**
 * Created by leo on 17/4/7.
 */

public class TextHintSupportImp extends TextSupportHelperImp {
    public TextHintSupportImp(TextView textView, AttributeSet attrs, int defStyleAttr) {
        super(textView, attrs, defStyleAttr);
        TypedArray a = textView.getContext().obtainStyledAttributes(attrs, R.styleable.LanguageHelper, defStyleAttr, 0);
        try {
            resourceId = a.getResourceId(R.styleable.LanguageHelper_android_hint, 0);
        } catch (Exception e) {
        } finally {
            a.recycle();
        }
    }

    @Override
    public void apply() {
        int id = checkResourceId(resourceId);
        if (id != INVALID_ID) {
            try {
                textView.setHint(textView.getContext().getResources().getString(id));
            } catch (Exception e) {

            }
        }
    }
}
