package com.jlt.gymnastic.util;


import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.view.Gravity;
import android.widget.Toast;

import com.jlt.gymnastic.ApplicationClass;
import com.jlt.gymnastic.R;
import com.jlt.gymnastic.fragment.BaseFragment;

public class AndroidUtils {

    private static boolean isTablet;
    public static int ORIENTATION_FLAG;
    public static String screenDensity;
    public static float scaleFactor;

    public static void init(Context context) {

        isTablet = context.getResources().getBoolean(R.bool.isTablet);

        float density = context.getResources().getDisplayMetrics().density;
        if (density >= 4.0) {
            screenDensity = "xxxhdpi";
            scaleFactor = 4;
        } else if (density >= 3.0) {
            screenDensity = "xxhdpi";
            scaleFactor = 3;
        } else if (density >= 2.0) {
            screenDensity = "xhdpi";
            scaleFactor = 2;
        } else if (density >= 1.5) {
            screenDensity = "hdpi";
            scaleFactor = 1.5f;
        } else if (density >= 1.0) {
            screenDensity = "mdpi";
            scaleFactor = 1f;
        } else {
            screenDensity = "ldpi";
            scaleFactor = .75f;
        }

        setOrientation();
    }

    private static void setOrientation() {

        if (isTablet) {
            ORIENTATION_FLAG = ActivityInfo.SCREEN_ORIENTATION_USER;
        } else {
            ORIENTATION_FLAG = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        }
    }

    public static boolean isTablet() {
        return isTablet;
    }

    public static boolean isICS() {
        return (Build.VERSION.SDK_INT == 14);
    }

    public static boolean isJellyBean() {
        return (Build.VERSION.SDK_INT == 16);
    }

    public static enum FragmentTag {
    }

    public static BaseFragment getFragment(FragmentTag fragmentTag) {
        BaseFragment fragment = null;
        switch (fragmentTag) {

            default:
                break;
        }
        return fragment;
    }

    public static void showToast(String message) {
        Toast toast = Toast.makeText(ApplicationClass.getContext(), message,
                Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

}
