package com.rachel.world.data.processing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.rachel.world.R;
import com.rachel.world.view.activity.MainActivity;

//底片效果
public class Star extends MergeHandler implements BitmapProcessor
{
	@Override
	public Bitmap createProcessedBitmap(Bitmap originalBitmap)
	{
		Bitmap mergeBitmap = BitmapFactory.decodeResource(MainActivity.getContext().getResources(),
				R.drawable.pro_star);
		Bitmap processedBitmap = merge(mergeBitmap, originalBitmap, 0, 0, encreaseLight(-46),
				encreaseLight(47));
	    
	    return processedBitmap;
	}
}
