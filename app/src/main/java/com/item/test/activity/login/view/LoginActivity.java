package com.item.test.activity.login.view;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.item.test.R;
import com.item.test.activity.base.BaseActivity;
import com.item.test.activity.login.presenter.ILoginPresenter;
import com.item.test.activity.login.presenter.LoginPresenterImpl;
import com.item.test.utils.common.StatusBarUtil;
import com.item.test.utils.common.ToashUtils;
import com.item.test.utils.dialog.LoadDialog;

import butterknife.BindView;

/**
 * 登录的界面
 */
public class LoginActivity extends BaseActivity implements ILoginView, View.OnClickListener {
    @BindView(R.id.bar_tool)
    Toolbar toolbar;
    @BindView(R.id.edt_login_phone)
    EditText edtPhone; // 填写的手机号码
    @BindView(R.id.edt_login_code)
    EditText edtCode; // 填写的Code
    @BindView(R.id.btn_login_code)
    Button btnCode; // 获取验证码按钮
    @BindView(R.id.btn_login)
    Button btnLogin; // 点击登录
    private ILoginPresenter mPresenter;

    private LoadDialog mDialog; // 弹窗
    /**
     * 倒计时
     */
    private CountDownTimer mCountDownTime = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long l) {
            // 开始计时
            btnCode.setEnabled(false);
            btnCode.setText(1 / 1000 + "");
        }

        @Override
        public void onFinish() {
            // 倒计时结束了
            btnCode.setEnabled(true);
            btnCode.setText(getResources().getString(R.string.get_code));
            cancel();
        }
    };

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initListener() {
        super.initListener();
        btnCode.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        edtCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (edtCode.length() > 2 && edtPhone.length() >= 11) {
                    btnLogin.setEnabled(true);
                } else {
                    btnLogin.setEnabled(false);
                }
            }
        });
        edtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                boolean legal = ToashUtils.checkMobile(edtPhone.getText().toString());
                btnCode.setEnabled(legal);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCountDownTime.cancel();
    }

    @Override
    protected void initData() {
        super.initData();
        StatusBarUtil.setPaddingSmart(this, toolbar);
        btnCode.setEnabled(false);
        btnLogin.setEnabled(false);
        mPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void showLoading() {
        if(mDialog == null){
            mDialog = new LoadDialog(this);
        }
        mDialog.show();
    }

    @Override
    public void dismissLoading() {
        if(mDialog != null && mDialog.isShowing()){
            mDialog.dismiss();
        }
    }

    /**
     * 网络请求报错了
     * @param code 错误码
     */
    @Override
    public void showError(int code) {
        ToashUtils.showToast(getResources().getString(R.string.get_error));
    }

    /**
     * 获取验证码成功
     *
     * @param code code
     */
    @Override
    public void getSuccessCode(String code) {
        edtCode.setText(code);
        mCountDownTime.start();
    }

    @Override
    public void getErrorToast(String message) {
        ToashUtils.showToast(message);
    }

    /**
     * 登录成功
     * 这里我跳转到账单界面
     */
    @Override
    public void getSuccessLogin() {
        startActivity(new Intent(this, BillsActivity.class));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_code: // 点击获取验证码
                mPresenter.requestCode(edtPhone.getText().toString().trim());
                break;
            case R.id.btn_login: // 点击登录
                mPresenter.requestLogin(edtPhone.getText().toString().trim(),
                        edtCode.getText().toString().trim());
                break;
        }
    }
}
