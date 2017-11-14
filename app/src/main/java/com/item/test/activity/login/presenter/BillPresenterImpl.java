package com.item.test.activity.login.presenter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.item.test.activity.base.BaseModelCallBack;
import com.item.test.activity.login.model.ILoginModel;
import com.item.test.activity.login.model.LoginModelImpl;
import com.item.test.activity.login.model.bean.ImageBean;
import com.item.test.activity.login.view.IBills;
import com.item.test.utils.http.impl.BaseResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuzongjie on 2017/11/14.
 */

public class BillPresenterImpl implements IBillPresenter {

    private IBills mView;
    private ILoginModel mModel;

    public BillPresenterImpl(IBills mView) {
        this.mView = mView;
        this.mModel = new LoginModelImpl();
    }

    @Override
    public void requestBill(int page, final int type) {
        if (mView == null) {
            return;
        }
        mModel.getBills(page, new BaseModelCallBack() {
            @Override
            public void onResponse(BaseResponse response) {
                List<ImageBean> imageBeans = new ArrayList<>();
                // 获取解析者
                JsonParser parser = new JsonParser();
                // 获取根节点元素
                JsonElement element = parser.parse(response.getData());
                // 根据文档判断节点属于什么类型的对象
                JsonObject root = element.getAsJsonObject();
                boolean error = root.getAsJsonPrimitive("error").getAsBoolean();
                JsonArray array = root.getAsJsonArray("results");
                for (JsonElement obj : array) {
                    imageBeans.add(new Gson().fromJson(obj, ImageBean.class));
                }
                if (type == 1) {
                    mView.onRefresh(imageBeans);
                } else {
                    mView.onLoadMore(imageBeans);
                }

            }

            @Override
            public void onFailure(int code) {
                mView.onFailureRefresh(code,type);
               // mView.showError(code);
            }
        });
    }
}
