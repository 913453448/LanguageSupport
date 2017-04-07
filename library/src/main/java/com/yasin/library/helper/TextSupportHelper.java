package com.yasin.library.helper;

/**
 * Created by leo on 17/4/7.
 */

public abstract class  TextSupportHelper {
    protected static final String SYSTEM_ID_PREFIX = "1";
    public static final int INVALID_ID = 0;

    final static public int checkResourceId(int resId) {
        String hexResId = Integer.toHexString(resId);
        return hexResId.startsWith(SYSTEM_ID_PREFIX) ? INVALID_ID : resId;
    }
    public abstract void apply();
}
