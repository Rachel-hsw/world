package com.noahark.moments.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.noahark.moments.R;
import com.noahark.moments.ui.base.BaseActivity;
import com.noahark.moments.ui.widget.TextButton;
import com.noahark.moments.utils.ToastUtils;
import com.noahark.moments.utils.TopTitleUtils;

public class MeSexActivity extends BaseActivity {

    private String sex = "M";
    private ImageView maleCheckedImgVi;
    private ImageView femaleCheckedImgVi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_sex);
        TextButton textView = new TextButton(this);
        textView.setText("保存");
        textView.setTextSize(16);
        textView.setTextColor(getColor(R.color.color_1897F2));
        textView.setClickable(false);
        new TopTitleUtils(this)
                .setTitle("性别")
                .addRightView(textView)
                .setRightViewVisiable(View.VISIBLE)
                .setRight(v -> {
                    ToastUtils.get().showText("保存成功");
                });
        maleCheckedImgVi = (ImageView)findViewById(R.id.sex_male_imgvi);
        femaleCheckedImgVi = (ImageView)findViewById(R.id.sex_female_imgvi);
    }

    @Override
    protected int layoutResId() {
        return 0;
    }

    public void onCloseMeSexBtn(View view)
    {
        finish();
    }

    public void onCheckMaleRadiobtn(View view)
    {
        sex="M";
        maleCheckedImgVi.setVisibility(View.VISIBLE);
        femaleCheckedImgVi.setVisibility(View.INVISIBLE);
    }

    public void onCheckFemaleRadiobtn(View view)
    {
        sex="F";
        maleCheckedImgVi.setVisibility(View.INVISIBLE);
        femaleCheckedImgVi.setVisibility(View.VISIBLE);
    }
}
