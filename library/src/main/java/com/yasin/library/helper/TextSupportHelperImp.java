package com.yasin.library.helper;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.yasin.library.R;

/**
 * Created by leo on 17/4/7.
 */

public class TextSupportHelperImp extends TextSupportHelper {
    /**
     * TextView的string的资源id
     */
    protected int resourceId;
    /**
     * 当前的TextView
     */
    protected TextView textView;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public TextSupportHelperImp(TextView textView, AttributeSet attrs, int defStyleAttr) {
        this.textView = textView;
        //获取自定义属性
//        <?xml version="1.0" encoding="utf-8"?>
//        <resources>
//        <declare-styleable name="LanguageHelper">
//        <attr name="android:text" />
//        <attr name="android:hint" />
//        </declare-styleable>
//        </resources
        TypedArray a = textView.getContext().obtainStyledAttributes(attrs, R.styleable.LanguageHelper, defStyleAttr, 0);
        try {
            //获取到text的资源路径
            resourceId = a.getResourceId(R.styleable.LanguageHelper_android_text, 0);
        } catch (Exception e) {
        } finally {
            a.recycle();
        }
    }

    @Override
    public void apply() {
        //判断当前资源路径是否有效
        //因为我们在xml中可能是直接设置的文字，就无法国际化了
        int id = checkResourceId(resourceId);
        if (id != INVALID_ID) {
            try {
                textView.setText(textView.getContext().getResources().getString(id));
            } catch (Exception e) {

            }
        }
    }
}
