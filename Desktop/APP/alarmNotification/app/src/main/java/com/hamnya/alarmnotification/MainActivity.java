package com.hamnya.alarmnotification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
    1. push button.
    2. after 5 min.
    3. get notification message.

    소스 원본 출처:http://veryeasyandroid.blogspot.kr/2016/02/service.html
 */
public class MainActivity extends AppCompatActivity {
    private Button startBtn, cancelBtn;
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

        startBtn = (Button)findViewById(R.id.start_btn);
        cancelBtn = (Button)findViewById(R.id.cancel_btn);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAlarm();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAlarm();
            }
        });

}
    public void startAlarm(){
        Intent receiverIntent = new Intent(MainActivity.this, myReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, receiverIntent, 0);
//        long period = 1000 * 5;
        long after = 1000 * 5 * 60; // 5min
        long t = SystemClock.elapsedRealtime();
        alarmManager.set(AlarmManager.ELAPSED_REALTIME, t+after, pendingIntent); // just one time
//        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, t+after, perioid, pendingIntent);
    }

    private void cancelAlarm(){

        Intent myIntent = new Intent(MainActivity.this, myReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent, 0);
        alarmManager.cancel(pendingIntent);
    }
}