package com.yasin.languagesupport;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;

import com.yasin.library.LanguageDelegate;

/**
 * Created by leo on 17/4/6.
 */

public class BaseActivity extends AppCompatActivity{
    private LanguageDelegate mDelegate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(getLayoutInflater(),getLanguageDelegate());
        super.onCreate(savedInstanceState);
        ActivityManager.addActivity(this);
    }
    private LayoutInflaterFactory getLanguageDelegate() {
        return mDelegate=LanguageDelegate.create(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDelegate.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDelegate.onDestory();
        ActivityManager.remove(this);
    }

}
