package com.yasin.languagesupport;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leo on 17/4/7.
 */

public class ActivityManager {
    private static List<Activity>activities;
    public static void addActivity(Activity activity){
        if(activities==null)activities=new ArrayList<>();
        activities.add(activity);
    }
    public static void finishAll(){
        if(activities==null)return;
        for (Activity a:
             activities) {
            a.finish();
        }
    }
    public static void remove(Activity activity){
        if(activities==null)return;
        activities.remove(activity);
    }
}
