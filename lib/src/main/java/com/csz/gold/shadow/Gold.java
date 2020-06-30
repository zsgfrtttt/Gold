package com.csz.gold.shadow;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;

import androidx.annotation.ColorInt;

public class Gold {

    public static Request with(View view) {
        Request request = new Request();
        request.view = view;
        request.resources = view.getResources();
        return request;
    }

    public static class Request {
        View view;
        Resources resources;
        ColorStateList colorStateList = ColorStateList.valueOf(Color.WHITE);
        float radius;
        float shadowSize;
        float maxShadowSize;
        int shadowStartColor = Integer.MIN_VALUE;
        int shadowEndColor = Integer.MIN_VALUE;

        public Request colorInt(@ColorInt int color) {
            this.colorStateList = ColorStateList.valueOf(color);
            return this;
        }

        public Request radius(float radius) {
            if (radius < 0) {
                radius = 0;
            }
            this.radius = radius;
            return this;
        }

        public Request shadowSize(float shadowSize) {
            if (shadowSize < 0) {
                shadowSize = 0;
            }
            this.shadowSize = shadowSize;
            return this;
        }

        public Request maxShadowSize(float maxShadowSize) {
            if (maxShadowSize < 0) {
                maxShadowSize = 0;
            }
            this.maxShadowSize = maxShadowSize;
            return this;
        }

        public Request shadowColor(@ColorInt int shadowStartColor, @ColorInt int shadowEndColor) {
            this.shadowStartColor = shadowStartColor;
            this.shadowEndColor = shadowEndColor;
            return this;
        }

        private boolean defineShadowColor() {
            if (shadowStartColor != Integer.MIN_VALUE && shadowEndColor != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        }

        public void apply() {
            if (Build.VERSION.SDK_INT >= 21 && !defineShadowColor()) {
                final RoundDrawable background = new RoundDrawable(colorStateList, radius);
                view.setBackground(background);
                view.setClipToOutline(true);
                view.setElevation(shadowSize);
            } else {
                if (maxShadowSize == 0f) {
                    maxShadowSize = shadowSize;
                }
                RoundDrawableWithShadow shadow = new RoundDrawableWithShadow(resources, colorStateList, radius, shadowSize, maxShadowSize);
                if (defineShadowColor()) {
                    shadow.setShadowColor(shadowStartColor, shadowEndColor);
                }
                view.setBackground(shadow);
            }
        }

    }
}
