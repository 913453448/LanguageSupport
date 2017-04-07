package com.yasin.library.widge;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.yasin.library.helper.TextSupportHelper;
import com.yasin.library.helper.TextSupportHelperImp;

/**
 * Created by leo on 17/4/6.
 */

public class LanguageTextView extends TextView implements LanguageSupportable {
    private TextSupportHelper textSupportHelper;

    public LanguageTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(attrs, 0);
    }

    public LanguageTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(attrs, defStyleAttr);
    }

    private void initViews(AttributeSet attrs, int defStyleAttr) {
        textSupportHelper = new TextSupportHelperImp(this, attrs, defStyleAttr);
    }

    @Override
    public void change() {
        textSupportHelper.apply();
    }
}
