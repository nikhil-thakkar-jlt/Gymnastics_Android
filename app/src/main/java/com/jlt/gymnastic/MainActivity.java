package com.jlt.gymnastic;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v13.app.FragmentTabHost;
import android.view.MenuItem;

import com.jlt.gymnastic.fragment.BaseFragment;
import com.jlt.gymnastic.fragment.ContactUsFragment;
import com.jlt.gymnastic.fragment.GuidelinesFragment;
import com.jlt.gymnastic.model.FragmentMetaData;
import com.jlt.gymnastic.util.ActivityCallback;
import com.jlt.gymnastic.util.AndroidUtils;
import com.jlt.gymnastic.util.FragmentCallback;

import static com.jlt.gymnastic.R.*;


public class MainActivity extends Activity implements ActivityCallback {

    private FragmentCallback mCallback;
    private FragmentTabHost mTabHost;
    private final String CONTACTUS_TAB = "Contact Us";
    private final String GUIDELINES_TAB = "Guidelines";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        //Create the tabs and link them to the associated fragments
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getFragmentManager(), id.realtabcontent);

        Resources res = getResources();
        //Set the theme color to each individual tab
        int tabItemColor = res.getColor(color.themecolor);

        mTabHost.addTab(mTabHost.newTabSpec(CONTACTUS_TAB).setIndicator(CONTACTUS_TAB, res.getDrawable(drawable.tab_contactus_selector)), ContactUsFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(GUIDELINES_TAB).setIndicator(GUIDELINES_TAB, res.getDrawable(drawable.tab_guidelines_selector)), GuidelinesFragment.class, null);


        mTabHost.getTabWidget().getChildAt(0).setBackgroundColor(tabItemColor);
        mTabHost.getTabWidget().getChildAt(1).setBackgroundColor(tabItemColor);
//        mTabHost.getTabWidget().getChildAt(2).setBackgroundColor(tabItemColor);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (mCallback != null) {
                    mCallback.onUpNavigationBtnClicked();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Fragment replaceFragment(FragmentManager fragmentManager, FragmentMetaData metaData) {
        BaseFragment fragment = AndroidUtils.getFragment(metaData.tag);

        if (fragment != null) {
            if (!(fragment instanceof FragmentCallback)) {
                throw new IllegalStateException(
                        "Fragment must implement the callbacks.");
            }
            mCallback = fragment;
            fragment.setArguments(metaData.bundle);
            FragmentTransaction transaction = fragmentManager
                    .beginTransaction();
            if (metaData.animate) {
                if (metaData.enterAnim == 0) {
                    int rightIn = animator.slide_right_in;
                    int rightOut = animator.slide_right_out;
                    int leftIn = animator.slide_left_in;
                    int leftOut = animator.slide_left_out;
                    transaction.setCustomAnimations(rightIn, leftOut, leftIn,
                            rightOut);
                } else {
                    transaction.setCustomAnimations(metaData.enterAnim,
                            metaData.exitAnim);
                }

            }

            transaction.replace(metaData.containerId, fragment);

            if (metaData.addtoBackStack) {
                transaction.addToBackStack(metaData.tag.toString());
            }
            transaction.commit();
        }
        return fragment;
    }

    @Override
    public void enableActionBarUpNavigation(boolean enable) {
        //This might crash in lollipop as ActionBar is replaced by ToolBar
        getActionBar().setDisplayHomeAsUpEnabled(enable);
    }

}
