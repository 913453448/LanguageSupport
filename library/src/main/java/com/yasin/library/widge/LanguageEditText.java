package com.yasin.library.widge;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.yasin.library.helper.TextHintSupportImp;
import com.yasin.library.helper.TextSupportHelper;
import com.yasin.library.helper.TextSupportHelperImp;

/**
 * Created by leo on 17/4/6.
 */

public class LanguageEditText extends EditText implements LanguageSupportable {
    private TextHintSupportImp hintSupportHelper;
    private TextSupportHelper textSupportHelper;

    public LanguageEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(attrs, 0);
    }

    public LanguageEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(attrs, defStyleAttr);
    }

    private void initViews(AttributeSet attrs, int defStyleAttr) {
        hintSupportHelper = new TextHintSupportImp(this, attrs, defStyleAttr);
        textSupportHelper=new TextSupportHelperImp(this,attrs,defStyleAttr);
    }

    @Override
    public void change() {
        hintSupportHelper.apply();
        textSupportHelper.apply();
    }
}
