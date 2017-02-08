package com.hamnya.alarmnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class myReceiver extends BroadcastReceiver {
    private NotificationManager notificationManager;
    public myReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        //notification 구현
        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("im ticker");
        builder.setContentTitle("im title");
        builder.setContentText("im text");

        builder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
        //builder.setContentIntent();
        builder.setAutoCancel(true);

        notificationManager.notify(111, builder.build());
        Log.d("RECEIVER", "im up!");
    }
}
