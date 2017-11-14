package com.item.test.activity.login.view;

import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.item.test.R;
import com.item.test.activity.base.BaseActivity;
import com.item.test.activity.login.model.bean.ImageBean;
import com.item.test.activity.login.presenter.BillPresenterImpl;
import com.item.test.activity.login.presenter.IBillPresenter;
import com.item.test.adapter.ImageBeanAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class BillsActivity extends BaseActivity implements IBills {
    @BindView(R.id.bar_tool)
    Toolbar toolbar;
    @BindView(R.id.listView)
    ListView mListView;
    @BindView(R.id.refreshLayout)
    RefreshLayout mRefreshLayout;

    //private BillAdapter mAdapter;
    private List<ImageBean> mData = new ArrayList<>();
    private ImageBeanAdapter mAdapter; // 适配器
    private int page; // 页号
    private IBillPresenter mPresenter;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_bills;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter = new BillPresenterImpl(this);
        mAdapter = new ImageBeanAdapter(this, mData);
        mListView.setAdapter(mAdapter);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                // 下拉刷新
                page = 1;
                mData.clear();
                mPresenter.requestBill(page, 1);
            }
        });
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                // 上拉加载
                page++;
                mPresenter.requestBill(page, 2);
            }
        });
        mRefreshLayout.autoRefresh(500);
    }

    /**
     * 弹窗
     */
    @Override
    public void showLoading() {

    }

    /**
     * 隐藏弹窗
     */
    @Override
    public void dismissLoading() {

    }

    /**
     * 返回报错
     *
     * @param code 错误码
     */
    @Override
    public void showError(int code) {

    }

    /**
     * 刷新或者加载时报错了
     *
     * @param code 错误码
     * @param type 类型 1为下拉  2为上拉
     */
    @Override
    public void onFailureRefresh(int code, int type) {
        if (type == 1) {
            mRefreshLayout.finishRefresh(500);
            mRefreshLayout.setLoadmoreFinished(false);
        } else {
            mRefreshLayout.finishLoadmore();
        }
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 刷新返回
     *
     * @param list 返回的数据
     */
    @Override
    public void onRefresh(List<ImageBean> list) {
        mData.addAll(list);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh();
        mRefreshLayout.setLoadmoreFinished(false);
    }

    /**
     * 加载更多的返回
     *
     * @param list 返回的数据
     */
    @Override
    public void onLoadMore(List<ImageBean> list) {
        mData.addAll(list);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
        if (list.size() < 10) { // 数据全部加在完毕
            mRefreshLayout.setLoadmoreFinished(true); // 将不会再次触发加载更多事件
        }
    }
}
