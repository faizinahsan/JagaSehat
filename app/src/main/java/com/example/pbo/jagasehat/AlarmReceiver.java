package com.example.pbo.jagasehat;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static android.support.v4.content.WakefulBroadcastReceiver.startWakefulService;

/**
 * Created by M FaizinAhsan on 7/2/2018.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "ALARM!! ALARM!!", Toast.LENGTH_SHORT).show();
        //This will send a notification message and show notification in notification tray
        ComponentName comp = new ComponentName(context.getPackageName(),
                AlarmNotificationService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
    }
}
