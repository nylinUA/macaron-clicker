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
    private TextView clicksView;
    private TextView autoClickerView;
    private int numClicks;
    private Boolean autoClickerOn = false;
    private ColorThemes colorTheme = ColorThemes.RASPBERRY;
    private Timer timer;
    private TimerTask task;
    private int timerPeriod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        numClicks = 0;
        clicksView = findViewById(R.id.clicks);

        macaron = findViewById(R.id.macaron);
        MyPressListener myPressListener = new MyPressListener();
        macaron.setOnTouchListener(myPressListener);
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
                    
                return false;
            }
        });

        timer = new Timer();

        autoClickerView = findViewById(R.id.auto_clicker);
        autoClickerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (autoClickerOn){
                    task.cancel();
                    timer.cancel();
                    autoClickerOn = false;
                    autoClickerView.setText("AutoClicker");
                    autoClickerView.setTextColor(Color.parseColor("#1f2326"));
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

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}