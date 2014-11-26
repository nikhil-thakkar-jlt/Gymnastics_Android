package com.jlt.gymnastic;

import android.app.Application;

/**
 * Created by Sneha on 26/11/2014.
 */
public class ApplicationClass extends Application {

    private static ApplicationClass mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static ApplicationClass getContext() {
        return mContext;
    }
}
