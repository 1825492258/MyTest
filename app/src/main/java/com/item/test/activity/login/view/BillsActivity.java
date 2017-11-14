package com.item.test.activity.login.view;

import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.item.test.R;
import com.item.test.activity.base.BaseActivity;
import com.item.test.adapter.BillAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;


import butterknife.BindView;

public class BillsActivity extends BaseActivity {
    @BindView(R.id.bar_tool)
    Toolbar toolbar;
    @BindView(R.id.listView)
    ListView mListView;
    @BindView(R.id.refreshLayout)
    RefreshLayout mRefreshLayout;

    private BillAdapter mAdapter;
    private int page; // 页号

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_bills;
    }

    @Override
    protected void initData() {
        super.initData();
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                // 下拉刷新
            }
        });
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                // 上拉加载

            }
        });
        mRefreshLayout.autoRefresh(500);
    }
}
