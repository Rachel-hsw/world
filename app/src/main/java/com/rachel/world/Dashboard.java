package com.rachel.world;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class Dashboard extends View {
    private  static  final  int ANGLE=120;
    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private static final float RADIUS=Utils.dp2px(150);
    private static  final  float LENGTH=Utils.dp2px(100);
    Path dash=new Path();
    PathDashPathEffect effect;
    public Dashboard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 只写大括号，会在super之后执行
     */
    {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.dp2px(2));
        dash.addRect(0,0,Utils.dp2px(2),Utils.dp2px(10),Path.Direction.CW);
        Path arc=new Path();
        arc.addArc(getWidth()/2-RADIUS,getHeight()/2-RADIUS,getWidth()/2+RADIUS,getHeight()/2+RADIUS,
                90+ANGLE/2,360-ANGLE);
        PathMeasure pathMeasure=new PathMeasure(arc,false);
        effect=new PathDashPathEffect(dash, (pathMeasure.getLength()-Utils.dp2px(2))/20,0,PathDashPathEffect.Style.ROTATE);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画表盘
        canvas.drawArc(getWidth()/2-RADIUS,getHeight()/2-RADIUS,getWidth()/2+RADIUS,getHeight()/2+RADIUS,
                90+ANGLE/2,360-ANGLE,false,paint);
        //画刻度
        paint.setPathEffect(effect);
        canvas.drawArc(getWidth()/2-RADIUS,getHeight()/2-RADIUS,getWidth()/2+RADIUS,getHeight()/2+RADIUS,
                90+ANGLE/2,360-ANGLE,false,paint);
        //画指针
        canvas.drawLine(getWidth()/2,getHeight()/2,
                (float) Math.cos(Math.toRadians(getAngleFromMark(5))*LENGTH)+getWidth()/2,
                (float) Math.sin(Math.toRadians(getAngleFromMark(5))*LENGTH)+getWidth()/2,paint);

    }

    int getAngleFromMark(int mark ){
        return (int) (90+ANGLE/2+(360-(float)ANGLE)/20*mark);
    }
}
