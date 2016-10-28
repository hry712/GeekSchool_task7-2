package com.jikexuyuan.imageviewer;

import android.app.Activity;
import android.os.Bundle;

public class ViewImageActivity extends Activity {

    public static final String ACTION = "android.intent.action.VIEW";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);
    }
}
