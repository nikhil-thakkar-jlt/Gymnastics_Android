package com.jlt.gymnastic.util;

import android.app.Fragment;
import android.app.FragmentManager;

import com.jlt.gymnastic.model.FragmentMetaData;

/**
 * Created by Sneha on 26/11/2014.
 */
public interface ActivityCallback {
    void enableActionBarUpNavigation(boolean enable);

    Fragment replaceFragment(FragmentManager fragmentManager, FragmentMetaData metaData);
}
