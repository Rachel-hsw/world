package com.noahark.moments.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.noahark.moments.R;
import com.noahark.moments.ui.base.BaseActivity;
import com.noahark.moments.ui.widget.TextButton;
import com.noahark.moments.utils.ToastUtils;
import com.noahark.moments.utils.TopTitleUtils;

public class MeNicknameActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_nickname);
        TextButton textView = new TextButton(this);
        textView.setText("保存");
        textView.setTextSize(16);
        textView.setTextColor(getColor(R.color.color_1897F2));
        textView.setClickable(false);
        new TopTitleUtils(this)
                .setTitle("昵称")
                .addRightView(textView)
                .setRightViewVisiable(View.VISIBLE)
                .setRight(v -> {
                    ToastUtils.get().showText("保存成功");
                });
    }

    @Override
    protected int layoutResId() {
        return 0;
    }

    public void onCloseMeNicknameBtn(View view) {
        finish();
    }
}
