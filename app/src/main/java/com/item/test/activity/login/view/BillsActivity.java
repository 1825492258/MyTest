package com.item.test.activity.login.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.item.test.R;
import com.item.test.activity.base.BaseActivity;

public class BillsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_bills);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_bills;
    }
}
