package com.jlt.gymnastic.fragment;

import android.app.Activity;
import android.app.Fragment;

import com.jlt.gymnastic.ApplicationClass;
import com.jlt.gymnastic.util.ActivityCallback;
import com.jlt.gymnastic.util.FragmentCallback;

public class BaseFragment extends Fragment implements FragmentCallback {

    protected Activity activity;
    protected ApplicationClass applicationContext;
    protected final String TAG;
    protected ActivityCallback mCallback;

    public BaseFragment() {
        super();
        TAG = hashCode() + "";
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
        mCallback = (ActivityCallback) activity;
        applicationContext = (ApplicationClass) activity
                .getApplicationContext();
    }

    @Override
    public void onUpNavigationBtnClicked() {

    }

    @Override
    public void onDestroy() {
        mCallback = null;
        super.onDestroy();
    }
}
