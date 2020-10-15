package com.rachel.world.data.processing;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.rachel.world.R;
import com.rachel.world.view.activity.MainActivity;

//底片效果
public class Flower extends MergeHandler implements BitmapProcessor
{
	@Override
	public Bitmap createProcessedBitmap(Bitmap originalBitmap)
	{
		Bitmap frameFlower = BitmapFactory.decodeResource(MainActivity.getContext().getResources(),
				R.drawable.pro_flower);
		Bitmap processedBitmap = merge(frameFlower, originalBitmap, 0, 0, encreaseLight(-9),encreaseLight(0));

		return processedBitmap;
	}
}
