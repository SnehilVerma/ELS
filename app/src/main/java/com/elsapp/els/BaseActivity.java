package com.elsapp.els;

/**
 * Created by snehil on 22/12/16.
 */

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity  {

    private ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Loading...");
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }




}

