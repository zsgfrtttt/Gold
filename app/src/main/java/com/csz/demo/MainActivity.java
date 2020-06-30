package com.csz.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.csz.gold.shadow.Gold;

public class MainActivity extends AppCompatActivity {

    private ImageView ivTop,ivBot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivTop = findViewById(R.id.iv_top);
        ivBot = findViewById(R.id.iv_bot);

        float radius = dp2px(this,4);
        float shadow = dp2px(this,12);

        Gold.with(ivTop).colorInt(Color.BLUE).radius(radius).shadowSize(shadow).apply();
        Gold.with(ivBot).colorInt(Color.BLUE).radius(radius).shadowSize(shadow).apply();
    }

    public static float dp2px(Context context, int dp){
        return context.getResources().getDisplayMetrics().density * dp +  0.5f;
    }
}