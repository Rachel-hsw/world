package com.rachel.world;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class AvatarView extends View {
    private static  final  float WIDTH=Utils.dp2px(300);

    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    public AvatarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    {
        bitmap=getAvatar((int) WIDTH);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,Utils.dp2px(50),Utils.dp2px(50),paint);
    }
    Bitmap getAvatar(int width){
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background,options);
        options.inJustDecodeBounds=false;
        options.inDensity=options.outWidth;
        options.inTargetDensity=width;
        return  BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background,options);
    }
}
