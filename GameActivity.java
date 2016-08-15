package com.example.vibhor.clickergame;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    TextView tv_time,tv_clicks;
    Button b_click, b_start;

    CountDownTimer timer;
    int time = 30;

    int clicks=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tv_time = (TextView) findViewById(R.id.tv_time);
        tv_clicks = (TextView) findViewById(R.id.tv_clicks);
        b_click = (Button) findViewById(R.id.b_click);
        b_start = (Button) findViewById(R.id.b_start);

        b_start.setEnabled(true);
        b_click.setEnabled(false);

        timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
             time--;
             tv_time.setText("Time:" + time) ;
            }

            @Override
            public void onFinish() {
                b_start.setEnabled(true);
                b_click.setEnabled(false);
                tv_time.setText("Time: 0") ;

            }
        };
        b_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
             clicks++;
              tv_clicks.setText("Clicks:" + clicks);
            }
        });

        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
               timer.start();
                b_start.setEnabled(false);
                b_click.setEnabled(true);
                clicks= 0;
                time = 30;
                tv_time.setText("Time:" + time) ;
                tv_clicks.setText("Clicks:" + time);
            }
        });
    }
}
