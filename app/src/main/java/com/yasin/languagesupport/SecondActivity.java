package com.yasin.languagesupport;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.Locale;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_name);
        setContentView(R.layout.activity_second);
    }
    public void change(View view) {
        Resources resources =getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        config.locale = Locale.CHINESE;
        resources.updateConfiguration(config, dm);
        ActivityManager.finishAll();
        startActivity(new Intent(SecondActivity.this,MainActivity.class));

    /*
        LanguageManage.getInstance(this).change(lan, new LanguageSubject.IChangeSuccessCallBack() {
            @Override
            public void success() {
                Toast.makeText(getApplicationContext(),getString(R.string.change_succ),Toast.LENGTH_SHORT).show();
                setTitle(R.string.app_name);
                ActivityManager.finishAll();
                startActivity(new Intent(SecondActivity.this,MainActivity.class));
            }
            @Override
            public void erro() {

            }
        });*/
    }
}
