package com.yasin.library.widge;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.yasin.library.helper.TextSupportHelper;
import com.yasin.library.helper.TextSupportHelperImp;

/**
 * Created by leo on 17/4/7.
 */

public class LanguageButton extends Button implements LanguageSupportable {
    private TextSupportHelper textSupportHelper;

    public LanguageButton(Context context, AttributeSet attrs) {
        super(context,attrs);
        initViews(attrs,0);
    }

    public LanguageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(attrs,defStyleAttr);
    }
    private void initViews(AttributeSet attrs, int defStyleAttr) {
        textSupportHelper = new TextSupportHelperImp(this, attrs, defStyleAttr);
    }

    @Override
    public void change() {
        textSupportHelper.apply();
    }
}
