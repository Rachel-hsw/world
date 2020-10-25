package com.noahark.moments.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.noahark.moments.R;
import com.noahark.moments.ui.widget.TextButton;
import com.noahark.moments.utils.ToastUtils;
import com.noahark.moments.utils.TopTitleUtils;

public class MeMottoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_motto);
        TextButton textView = new TextButton(this);
        textView.setText("保存");
        textView.setTextSize(16);
        textView.setTextColor(getColor(R.color.color_1897F2));
        textView.setClickable(false);
        new TopTitleUtils(this)
                .setTitle("个性签名")
                .addRightView(textView)
                .setRightViewVisiable(View.VISIBLE)
                .setRight(v -> {
                    ToastUtils.get().showText("保存成功");
                });
    }

    public void onCloseMeMottoBtn(View view)
    {
        finish();
    }
}
