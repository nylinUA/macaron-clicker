package com.example.macaronclicker;

import android.view.MotionEvent;
import android.view.View;

public class MyPressListener implements View.OnTouchListener {


    public boolean onTouch(View v, MotionEvent event){
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // touch down code
                v.setVisibility(View.INVISIBLE);
                v.performClick();

                break;

            case MotionEvent.ACTION_MOVE:
                // touch move code
                break;

            case MotionEvent.ACTION_UP:
                v.setVisibility(View.VISIBLE);
                break;
        }
        return true;
    }
}
