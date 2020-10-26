package com.rachel.world.data.touch;


import android.graphics.PointF;

import com.rachel.world.data.extra.Pel;
import com.rachel.world.view.widget.CanvasView;


public class DrawFreehandTouch extends DrawTouch {
    private PointF lastPoint;

    public DrawFreehandTouch() {
        super();
        lastPoint = new PointF();
    }

    @Override
    public void down1() {
        super.down1();
        lastPoint.set(downPoint);

        newPel = new Pel();
        (newPel.path).moveTo(lastPoint.x, lastPoint.y);
    }

    @Override
    public void move() {
        super.move();

        movePoint.set(curPoint);

        (newPel.path).quadTo(lastPoint.x, lastPoint.y, (lastPoint.x + movePoint.x) / 2, (lastPoint.y + movePoint.y) / 2);
        lastPoint.set(movePoint);

        CanvasView.setSelectedPel(selectedPel = newPel);
    }

    @Override
    public void up() {
        newPel.closure = true;
        super.up();
    }
}
