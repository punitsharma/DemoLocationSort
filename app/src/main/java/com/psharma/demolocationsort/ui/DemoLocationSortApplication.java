package com.psharma.demolocationsort.ui;

import android.app.Application;
import android.util.Log;

import com.psharma.demolocationsort.api.servicemanager.ApiManager;

/**
 * Created by punitsharma on 12/2/15.
 */
public class DemoLocationSortApplication extends Application {

    private String CI_baseUrl="http://staging.couponapitest.com/task.txt";

    @Override
    public void onCreate() {
        if (ApiManager.getInstance() == null) {
            ApiManager.demoInitializer(CI_baseUrl, getApplicationContext());

            Log.e("Application", "initialise");
        }
        super.onCreate();

    }
}
