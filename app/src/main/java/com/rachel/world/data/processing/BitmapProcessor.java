package com.rachel.world.data.processing;

import android.graphics.Bitmap;

//图片处理接口
public interface BitmapProcessor
{
	abstract Bitmap createProcessedBitmap(Bitmap originalBitmap);
}
