package com.rachel.world.data.touch;


import com.rachel.world.data.extra.Pel;
import com.rachel.world.view.widget.CanvasView;

public class DrawLineTouch extends DrawTouch {
	
	public DrawLineTouch()
	{
		super();
	}
	
	@Override
	public void move()
	{
		super.move();
		
		newPel=new Pel();
		
		movePoint.set(curPoint);
		
		(newPel.path).moveTo(downPoint.x, downPoint.y);
		(newPel.path).lineTo(movePoint.x, movePoint.y);
		(newPel.path).lineTo(movePoint.x, movePoint.y+1);
		
		CanvasView.setSelectedPel(selectedPel = newPel);
	}
	
	@Override
	public void up()
	{
		newPel.closure=false;
		super.up();
	}	
}
