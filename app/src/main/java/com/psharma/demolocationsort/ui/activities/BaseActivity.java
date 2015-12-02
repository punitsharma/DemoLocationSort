package com.psharma.demolocationsort.ui.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.psharma.demolocationsort.R;

/**
 * Created by Punit Sharma on 9/3/2015.
 * MobiquityInc
 */
public class BaseActivity extends ListActivity {

    private MaterialDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initProgressDialog();
    }

    private void initProgressDialog() {
        if (progressDialog != null)
            return;

        MaterialDialog.Builder builder = new MaterialDialog.Builder(this);
        builder.content(R.string.loading);
        builder.progress(true, 0);
        builder.theme(Theme.LIGHT);
        progressDialog = builder.build();
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
    }

    public void showProgresDialog() {
        if (progressDialog != null && !progressDialog.isShowing())
            progressDialog.show();
    }

    public void dismissProgresDialog() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

}
