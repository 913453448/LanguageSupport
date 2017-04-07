package com.yasin.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leo on 17/4/6.
 */

public abstract class LanguageSubject {
    private List<LanguageObserver> observers;

    public synchronized void attach(LanguageObserver observer) {
        if (observers == null) {
            observers = new ArrayList<>();
        }
        observers.add(observer);
    }

    public synchronized void dettach(LanguageObserver observer) {
        if (observers == null || observers.size() == 0 || !observers.contains(observer)) return;
        observers.remove(observer);
    }

    protected void notifyChangeLanguage(String language) throws Exception {
        if (observers == null || observers.size() == 0) return;
        for (LanguageObserver observer :
                observers) {
            observer.update(language);
        }
    }

    public interface IChangeSuccessCallBack {
        void success();

        void erro();
    }
}
