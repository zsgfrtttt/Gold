package com.csz.gold.shadow;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class ShaowApi17 implements Shadow {

    @Override
    public void initialize() {
        RoundDrawableWithShadow.sRoundRectHelper = new RoundDrawableWithShadow.RoundRectHelper() {
            @Override
            public void drawRoundRect(Canvas canvas, RectF bounds, float cornerRadius, Paint paint) {
                canvas.drawRoundRect(bounds, cornerRadius, cornerRadius, paint);
            }
        };
    }
}
