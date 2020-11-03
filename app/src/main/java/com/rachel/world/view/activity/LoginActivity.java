package com.rachel.world.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.noahark.moments.Constans;
import com.noahark.moments.R;
import com.noahark.moments.ui.widget.TextButton;
import com.noahark.moments.utils.ToastUtils;
import com.noahark.moments.utils.TopTitleUtils;

public class LoginActivity extends Activity {
    EditText mUsernameEditText;
    EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUsernameEditText = findViewById(R.id.edittext_login_username);
        mPasswordEditText = findViewById(R.id.edittext_login_password);
        TextButton textView = new TextButton(this);
        textView.setText("验证码登录");
        textView.setTextSize(16);
        textView.setTextColor(getColor(R.color.color_1897F2));
        textView.setClickable(false);
        new TopTitleUtils(this)
                .setTitle("密码登录")
                .addRightView(textView)
                .setRightViewVisiable(View.VISIBLE)
                .setRight(v -> {
                    ToastUtils.get().showText("跳转验证码界面");
                });
        initView();
        initData();
    }

    public void initView() {

    }

    public void initData() {

    }


    public void onLoginBtn(View view) {
        if (mUsernameEditText.getText().toString().equals("Rachel") && mPasswordEditText.getText().toString().equals("wsdhd666")) {
            Intent intent = new Intent();
            intent.setClass(this, CommunityActivity.class);
            Constans.hasLogined = true;
            startActivity(intent);
            finish();
            overridePendingTransition(R.anim.push_in, R.anim.push_out);
        } else {
            ToastUtils.get().showText("密码错误");
        }
    }

    public void onEnterRegisterBtn(View view) {
        Intent intent = new Intent();
        intent.setClass(this, RegisterActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.push_in, R.anim.push_out);
    }

    public void onUsernameEditClearBtn(View view) {
        mUsernameEditText.setText("");
    }

    public void onPasswordEditClearBtn(View view) {
        mPasswordEditText.setText("");
    }
}
