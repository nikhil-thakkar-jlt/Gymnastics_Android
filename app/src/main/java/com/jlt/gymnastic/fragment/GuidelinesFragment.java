package com.jlt.gymnastic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ScrollView;

import com.jlt.gymnastic.R;

public class GuidelinesFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_webview, container, false);

        getActivity().setTitle(getString(R.string.tab_guidelines));

        WebView browser = (WebView) layout.findViewById(R.id.webView);
        browser.setBackgroundColor(0x00000000);
        browser.loadUrl("file:///android_asset/html/guidelines.html");
        browser.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
        return layout;
    }
}
