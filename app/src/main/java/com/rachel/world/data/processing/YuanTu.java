package com.rachel.world.data.processing;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

//底片效果
public class YuanTu implements BitmapProcessor {
    @Override
    public Bitmap createProcessedBitmap(Bitmap originalBitmap) {
        Bitmap processedBitmap = originalBitmap.copy(Config.ARGB_8888, true);

        return processedBitmap;
    }
}
