package com.rachel.world;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class TextView  extends View {
    //反锯齿
    Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path=new Path();
    PathMeasure pathMeasure;

    public TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * layout整个结束之后，尺寸有变化才会被调用
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        path.reset();
        path.addRect(getWidth()/2-150,getHeight()/2-300,getWidth()/2+150,getHeight()/2,Path.Direction.CCW);
        //cw:clockwork顺时针 ccw:c clockwork
        path.addCircle(getWidth()/2,getHeight()/2,150,Path.Direction.CCW);
        pathMeasure=new PathMeasure(path,false);
        pathMeasure.getLength();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.setFillType(Path.FillType.WINDING);
        canvas.drawPath(path,paint);
//        canvas.drawLine(100,100,200,200,paint);
//        canvas.drawCircle(getWidth()/2,getHeight()/2,200,paint);
//        canvas.drawCircle(getWidth()/2,getHeight()/2,Utils.dp2px(150),paint);
    }

}
