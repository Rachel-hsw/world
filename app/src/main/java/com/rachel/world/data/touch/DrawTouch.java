package com.rachel.world.data.touch;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

import com.rachel.world.data.extra.Pel;
import com.rachel.world.data.step.DrawpelStep;
import com.rachel.world.view.activity.MainActivity;
import com.rachel.world.view.widget.CanvasView;


/**
 * 画图元触摸类
 */
public class DrawTouch extends Touch {

    protected PointF downPoint;
    protected PointF movePoint;
    protected Pel newPel;
    protected static Paint paint;

    static {
        // 第一个对象创建时构造初始画笔
        paint = new Paint(Paint.DITHER_FLAG);
        paint.setColor(Color.parseColor("#FF000000"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(3);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStrokeJoin(Paint.Join.ROUND);

    }

    protected DrawTouch() {
        super();

        downPoint = new PointF();
        movePoint = new PointF();
    }




    @Override
    public void down1() {
        super.down1();
        downPoint.set(curPoint);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void up() {
        //轻敲屏幕不算
        if (!isNeedToOpenTools()) {
            //敲定该图元的路径，区域，画笔,名称
            (newPel.region).setPath(newPel.path, clipRegion);
            (newPel.paint).set(paint);

            /*更新操作*/

            //1.将新画好的图元存入图元链表中
            pelList.add(newPel);

            //2.包装好当前步骤 内的操作
            //将该“步”压入undo栈
            undoStack.push(new DrawpelStep(newPel));

            //3.更新重绘位图
            //刚才画的图元失去焦点
            CanvasView.setSelectedPel(selectedPel = null);
            updateSavedBitmap();//重绘位图
        }
    }

    public boolean isNeedToOpenTools() {
        if (dis < 10f) {
            dis = 0;
            MainActivity.openTools();
            control = true;

            return true;
        } else {
            dis = 0;
            return false;
        }
    }

    //获得当前画笔
    public static Paint getCurPaint() {
        return paint;
    }

}
