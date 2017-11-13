package com.item.test.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.item.test.R;
import com.item.test.utils.common.StatusBarUtil;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by wuzongjie on 2017/11/13.
 * BaseActivity
 */

public abstract class BaseActivity extends AppCompatActivity {
    public final static List<BaseActivity> BASE_ACTIVITIES = new LinkedList<>();

    private TextView title;
    private LinearLayout back;

    /**
     * 设置标题
     * @param msg 标题
     */
    protected void setTitle(String msg){
        if(title !=null){
            title.setText(msg);
        }
    }

    /**
     * 点击左侧返回  结束当前应用
     */
    protected void setLeftBack(){
        if(back !=null){
            back.setVisibility(View.VISIBLE);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置状态栏为透明
        StatusBarUtil.immersive(this);
        synchronized (BASE_ACTIVITIES) {
            BASE_ACTIVITIES.add(this);
        }
        // 得到界面的ID并设置到Activity界面中
        setContentView(getContentLayoutId());
        initView();
        initListener();
        initData();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.bar_tool);
        if(toolbar !=null){
            setSupportActionBar(toolbar);
        }
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        back = (LinearLayout)findViewById(R.id.bar_left_layout);
        title = (TextView)findViewById(R.id.bar_title);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (BASE_ACTIVITIES) {
            BASE_ACTIVITIES.remove(this);
        }
    }

    /**
     * 得到当前界面的资源文件Id
     *
     * @return 资源文件Id
     */
    protected abstract int getContentLayoutId();

    /**
     * 初始化控件
     */
    protected void initView() {
        ButterKnife.bind(this);
    }

    /**
     * 初始化监听器
     */
    protected void initListener() {
    }

    /**
     * 初始化数据
     */
    protected void initData() {
    }

    /**
     * 结束所有的Activity，退出时使用
     */
    public void killAll() {
        // 复制了一份mActivities 集合
        List<BaseActivity> copy;
        synchronized (BASE_ACTIVITIES) {
            copy = new LinkedList<>(BASE_ACTIVITIES);
        }
        for (BaseActivity activity : copy) {
            activity.finish();
        }
        // 杀死当前的进程
        //android.os.Process.killProcess(android.os.Process.myPid());
    }
}
