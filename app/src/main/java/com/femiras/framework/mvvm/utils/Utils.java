package com.femiras.framework.mvvm.utils;

import android.content.res.Resources;

public class Utils {
    public static int pxToDp(int px) {
        return (int)(px / Resources.getSystem().getDisplayMetrics().density);
    }
}
