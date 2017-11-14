package com.item.test;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.item.test.activity.base.BaseActivity;
import com.item.test.activity.login.view.BillsActivity;
import com.item.test.activity.login.view.LoginActivity;
import com.item.test.loading.LoadActivity;
import com.item.test.utils.common.StatusBarUtil;

import butterknife.BindView;

/**
 * 用来写安卓艺术探究的demo
 * j
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.bar_tool)
    Toolbar toolbar;
    @BindView(R.id.btn_main_one)
    Button btnOne; // 去登录界面
    @BindView(R.id.btn_main_two)
    Button btnTwo;
    @BindView(R.id.btn_main_three)
    Button btnThree;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initListener() {
        super.initListener();
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        super.initData();
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_main_one: // 去登录界面
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btn_main_two:
                startActivity(new Intent(this, BillsActivity.class));
                break;
            case R.id.btn_main_three:
                startActivity(new Intent(this, LoadActivity.class));
                break;
        }
    }
}
