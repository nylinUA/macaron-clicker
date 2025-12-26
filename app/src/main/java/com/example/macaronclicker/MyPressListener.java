package com.example.macaronclicker;

import android.view.MotionEvent;
import android.view.View;

public class MyPressListener implements View.OnTouchListener {


    public boolean onTouch(View v, MotionEvent event){
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // touch down code
                v.setAlpha(0);
                //v.performClick();

                break;

            case MotionEvent.ACTION_MOVE:
                // touch move code
                break;

            case MotionEvent.ACTION_UP:
                v.setAlpha(1);

                break;
        }
        return false;
    }
}
