package com.item.test.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.item.test.R;
import com.item.test.activity.login.model.bean.ImageBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wuzongjie on 2017/11/14.
 */

public class ImageBeanAdapter extends BaseAdapter{

    private Context context;
    private List<ImageBean> mData;

    public ImageBeanAdapter(Context context, List<ImageBean> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData == null ?0 : mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = View.inflate(context,R.layout.adapter_image_bean,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder)view.getTag();
        }
        holder.mDesc.setText(mData.get(i).getDesc());
        Glide.with(context)
                .load(mData.get(i).getUrl())
                .transition(new DrawableTransitionOptions().crossFade(500))
                .into(holder.mImage);
        return view;
    }
    static class ViewHolder{
        @BindView(R.id.siv_img)
        ImageView mImage;
        @BindView(R.id.siv_desc)
        TextView mDesc;
        private ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
