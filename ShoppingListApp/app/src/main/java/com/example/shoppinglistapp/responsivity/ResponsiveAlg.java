package com.example.shoppinglistapp.responsivity;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class ResponsiveAlg {
    public static void responsive(WindowManager windowmanager, View view, double width_precision,double height_precision){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        if(width_precision != 0) {
            lp.width = width - (int) (width * width_precision);
        }
        if(height_precision != 0) {
            lp.height = height - (int) (height * height_precision);
        }
        view.setLayoutParams(lp);
    }
}
