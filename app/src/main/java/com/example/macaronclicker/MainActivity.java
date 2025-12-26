package com.example.macaronclicker;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    private ImageView macaron;
    private ImageView macaronSmall;
    private TextView clicksView;
    private TextView autoClickerView;
    private int numClicks;
    private boolean autoClickerOn = false;
    private ColorThemes colorTheme = ColorThemes.RASPBERRY;
    private Timer timer;
    private TimerTask task;
    private int timerPeriod;
    private boolean macaronSelect = false;

    private ImageView selectMacaron1;
    private ImageView selectMacaron2;
    private ImageView selectMacaron3;
    private ImageView selectMacaron4;
    private ImageView gray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        numClicks = 0;
        clicksView = findViewById(R.id.clicks);

        macaron = findViewById(R.id.macaron);
        macaronSmall = findViewById(R.id.macaron_small);
        selectMacaron1 = findViewById(R.id.select_macaron_1);
        selectMacaron2 = findViewById(R.id.select_macaron_2);
        selectMacaron3 = findViewById(R.id.select_macaron_3);
        selectMacaron4 = findViewById(R.id.select_macaron_4);
        gray = findViewById(R.id.gray_window);


        //"Animation" for macaron to get smaller on touch
        MyPressListener myPressListener = new MyPressListener();
        macaron.setOnTouchListener(myPressListener);

        //increment macaron count on click
        macaron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementClickCount();
            }
        });



        // Long click to change macaron color
        macaron.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                macaronSelect = true;
                macaron.setVisibility(View.INVISIBLE);
                selectMacaron1.setVisibility(View.VISIBLE);
                selectMacaron2.setVisibility(View.VISIBLE);
                selectMacaron3.setVisibility(View.VISIBLE);
                selectMacaron4.setVisibility(View.VISIBLE);
                gray.setVisibility(View.VISIBLE);
                return true;
            }
        });

        selectMacaron1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (macaronSelect) {
                    colorTheme = ColorThemes.RASPBERRY;
                    changeMacaronColour();
                    hideSelectMacarons();
                }
            }
        });

        selectMacaron2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (macaronSelect) {
                    colorTheme = ColorThemes.UBE;
                    changeMacaronColour();
                    hideSelectMacarons();
                }
            }
        });

        selectMacaron3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (macaronSelect) {
                    colorTheme = ColorThemes.PISTACHIO;
                    changeMacaronColour();
                    hideSelectMacarons();
                }
            }
        });

        selectMacaron4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (macaronSelect) {
                    colorTheme = ColorThemes.LEMON;
                    changeMacaronColour();
                    hideSelectMacarons();
                }
            }
        });





        //Auto Clicker
        timer = new Timer();

        autoClickerView = findViewById(R.id.auto_clicker);
        autoClickerView.setTextColor(Color.parseColor(colorTheme.get()));
        autoClickerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (autoClickerOn){
                    task.cancel();
                    timer.cancel();
                    autoClickerOn = false;
                    autoClickerView.setText("AutoClicker");
                }
                else{
                    timer = new Timer();
                    task = new TimerTask() {
                        @Override
                        public void run() {
                            incrementClickCount();
                        }
                    };
                    timer.schedule(task, 0, 2000);
                    autoClickerOn = true;
                    autoClickerView.setText("0.33 per second");
                    autoClickerView.setTextColor(Color.parseColor(colorTheme.get()));
                }
            }
        });

    }










    public void incrementClickCount(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                numClicks += 1;
                clicksView.setText(String.valueOf(numClicks));
            }
        });

    }


    public void hideSelectMacarons(){
        selectMacaron1.setVisibility(View.INVISIBLE);
        selectMacaron2.setVisibility(View.INVISIBLE);
        selectMacaron3.setVisibility(View.INVISIBLE);
        selectMacaron4.setVisibility(View.INVISIBLE);
        macaron.setVisibility(View.VISIBLE);
        gray.setVisibility(View.GONE);
}

    public void changeMacaronColour(){
        macaron.setImageResource(colorTheme.getMacaronPic());
        macaronSmall.setImageResource(colorTheme.getMacaronPicSmall());
        autoClickerView.setTextColor(Color.parseColor(colorTheme.get()));

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}