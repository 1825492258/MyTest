package com.item.test.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.item.test.R;
import com.item.test.activity.login.model.bean.Bills;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BillAdapter extends BaseAdapter {
    private Context context;
    private List<Bills> mData;

    public BillAdapter(Context context, List<Bills> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.adapter_bills, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mName.setText(mData.get(position).getPayment());
        holder.mTime.setText(mData.get(position).getCreateTime());
        holder.mMoney.setText("收入".equals(mData.get(position).getType()) ? "+" : "-" + mData.get(position).getAmount() + "元");
        holder.mMoney.setTextColor(ContextCompat.getColor(context, "收入".equals(mData.get(position).getType())
                ? R.color.text_3385ff : R.color.text_383));
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.item_detail_name)
        TextView mName; // 名称
        @BindView(R.id.item_detail_time)
        TextView mTime; // 时间
        @BindView(R.id.item_detail_money)
        TextView mMoney; // 多少钱

        private ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
