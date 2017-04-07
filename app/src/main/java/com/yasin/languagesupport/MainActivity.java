package com.yasin.languagesupport;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.yasin.library.LanguageManage;
import com.yasin.library.LanguageSubject;
import com.yasin.library.util.LANGUAGE;
import com.yasin.library.util.LanguageSpUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_name);
        setContentView(R.layout.activity_main);
    }

    public void change(View view) {
        String language = LanguageSpUtil.getLanguage(this);
        LANGUAGE lan;
        if(TextUtils.isEmpty(language)){
            language= LANGUAGE.ZH.toString();
        }
        if(LANGUAGE.EN.toString().equals(language)){
            lan=LANGUAGE.ZH;
        }else{
            lan=LANGUAGE.EN;
        }
        LanguageManage.getInstance(this).change(lan, new LanguageSubject.IChangeSuccessCallBack() {
            @Override
            public void success() {
                Toast.makeText(getApplicationContext(),getString(R.string.change_succ),Toast.LENGTH_SHORT).show();
                setTitle(R.string.app_name);
//                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
            @Override
            public void erro() {

            }
        });
    }
}
